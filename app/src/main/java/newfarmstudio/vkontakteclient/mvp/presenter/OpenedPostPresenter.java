package newfarmstudio.vkontakteclient.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.common.manager.MyFragmentManager;
import newfarmstudio.vkontakteclient.common.utils.VkListHelper;
import newfarmstudio.vkontakteclient.consts.ApiConstants;
import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.model.view.NewsItemFooterViewModel;
import newfarmstudio.vkontakteclient.model.view.OpenedPostHeaderViewModel;
import newfarmstudio.vkontakteclient.model.view.OpenedPostRepostHeaderViewModel;
import newfarmstudio.vkontakteclient.mvp.view.OpenedPostView;
import newfarmstudio.vkontakteclient.rest.api.WallApi;
import newfarmstudio.vkontakteclient.rest.model.request.WallGetByIdRequestModel;
import newfarmstudio.vkontakteclient.ui.fragment.MyPostsFragment;

/**
 * Created by Альберт on 13.03.2018.
 */

@InjectViewState
public class OpenedPostPresenter extends BaseFeedPresenter<OpenedPostView> {

    private int id;

    @Inject
    WallApi mWallApi;

    @Inject
    MyFragmentManager mFragmentManager;

    public OpenedPostPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.getById(new WallGetByIdRequestModel(getSenderId(), id).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(wallItem -> {
                    NewsItemFooterViewModel newsItemFooterViewModel = new NewsItemFooterViewModel(wallItem);
                    getViewState().setFooter(newsItemFooterViewModel);
                })
                .observeOn(Schedulers.io())
                .doOnNext(this::saveToDb)
                .flatMap(wallItem -> {
                    List<BaseViewModel> list = new ArrayList<>();
                    List<BaseViewModel> forwardedList = new ArrayList<>();
                    list.add(new OpenedPostHeaderViewModel(wallItem));
                    list.addAll(VkListHelper.getAttachmentVkItems(wallItem.getAttachments()));
                    if (wallItem.haveSharedRepost()) {
                        forwardedList.add(new OpenedPostRepostHeaderViewModel(wallItem.getSharedRepost()));
                        forwardedList.addAll(VkListHelper.getAttachmentVkItems(wallItem.getSharedRepost().getAttachments()));
                    }
                    return Observable.fromIterable(list).concatWith(Observable.fromIterable(forwardedList));
                });
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(wallItem -> {
                    NewsItemFooterViewModel newsItemFooterViewModel = new NewsItemFooterViewModel(wallItem);
                    getViewState().setFooter(newsItemFooterViewModel);
                })
                .observeOn(Schedulers.io())
                .flatMap(wallItem -> {
                    List<BaseViewModel> list = new ArrayList<>();
                    List<BaseViewModel> forwardedList = new ArrayList<>();
                    list.add(new OpenedPostHeaderViewModel(wallItem));
                    list.addAll(VkListHelper.getAttachmentVkItems(wallItem.getAttachments()));
                    if (wallItem.haveSharedRepost()) {
                        forwardedList.add(new OpenedPostRepostHeaderViewModel(wallItem.getSharedRepost()));
                        forwardedList.addAll(VkListHelper.getAttachmentVkItems(wallItem.getSharedRepost().getAttachments()));
                    }
                    return Observable.fromIterable(list).concatWith(Observable.fromIterable(forwardedList));
                });
    }

    private Callable<WallItem> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            WallItem wallItem = realm.where(WallItem.class).equalTo("id", id).findFirst();
            return realm.copyFromRealm(wallItem);
        };
    }

    public void setId(int id) {
        this.id = id;
    }

    private int getSenderId() {
        if (mFragmentManager.getFragmentStack().get(mFragmentManager.getFragmentStack().size() - 2) instanceof MyPostsFragment)
            return ApiConstants.MY_USER_ID;
        else
            return ApiConstants.MY_GROUP_ID;
    }
}

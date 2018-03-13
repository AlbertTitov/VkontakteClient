package newfarmstudio.vkontakteclient.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.realm.Realm;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.common.utils.VkListHelper;
import newfarmstudio.vkontakteclient.model.CommentItem;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.model.view.CommentFooterViewModel;
import newfarmstudio.vkontakteclient.model.view.OpenedPostHeaderViewModel;
import newfarmstudio.vkontakteclient.mvp.view.BaseFeedView;

/**
 * Created by Альберт on 13.03.2018.
 */

@InjectViewState
public class OpenedCommentPresenter extends BaseFeedPresenter<BaseFeedView> {

    int id;

    public OpenedCommentPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return createObservable();
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return createObservable();
    }

    private Observable<BaseViewModel> createObservable() {

        return Observable.fromCallable(getListFromRealmCallable())
                .retry(2)
                .flatMap(commentItem -> {
                    List<BaseViewModel> list = new ArrayList<>();
                    List<BaseViewModel> forwardedList = new ArrayList<>();

                    list.add(new OpenedPostHeaderViewModel(commentItem));
                    list.addAll(VkListHelper.getAttachmentVkItems(commentItem.getAttachments()));
                    list.add(new CommentFooterViewModel(commentItem));

                    return Observable.fromIterable(list).concatWith(Observable.fromIterable(forwardedList));
                });
    }

    public Callable<CommentItem> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            CommentItem commentItem = realm.where(CommentItem.class).equalTo("id", id).findFirst();
            return realm.copyFromRealm(commentItem);
        };
    }

    public void setId(int id) {
        this.id = id;
    }
}

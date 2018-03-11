package newfarmstudio.vkontakteclient.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.consts.ApiConstants;
import newfarmstudio.vkontakteclient.model.Member;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.model.view.MemberViewModel;
import newfarmstudio.vkontakteclient.mvp.view.BaseFeedView;
import newfarmstudio.vkontakteclient.rest.api.GroupsApi;
import newfarmstudio.vkontakteclient.rest.model.request.GroupsGetMembersRequestModel;

/**
 * Created by Альберт on 11.03.2018.
 */

@InjectViewState
public class MembersPresenter extends BaseFeedPresenter<BaseFeedView> {

    @Inject
    GroupsApi groupsApi;

    public MembersPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return groupsApi.getMembers(new GroupsGetMembersRequestModel(
                ApiConstants.MY_GROUP_ID, count, offset).toMap())
                .flatMap(baseItemResponseFull -> {

                    return Observable.fromIterable(baseItemResponseFull.response.getItems());
                })
                .doOnNext(member -> saveToDb(member))
                .map(member -> new MemberViewModel(member));
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .map(member -> new MemberViewModel(member));
    }

    public Callable<List<Member>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {Member.ID};
            Sort[] sortOrder = {Sort.ASCENDING};

            Realm realm = Realm.getDefaultInstance();
            RealmResults<Member> results = realm.where(Member.class)
                    .sort(sortFields, sortOrder).findAll();
            return realm.copyFromRealm(results);
        };
    }
}

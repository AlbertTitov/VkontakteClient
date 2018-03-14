package newfarmstudio.vkontakteclient.ui.view.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.manager.MyFragmentManager;
import newfarmstudio.vkontakteclient.common.utils.Utils;
import newfarmstudio.vkontakteclient.common.utils.VkListHelper;
import newfarmstudio.vkontakteclient.model.Place;
import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.model.countable.Likes;
import newfarmstudio.vkontakteclient.model.view.NewsItemFooterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.CommentCounterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.LikeCounterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.RepostCounterViewModel;
import newfarmstudio.vkontakteclient.rest.api.LikeEventOnSubscribe;
import newfarmstudio.vkontakteclient.rest.api.WallApi;
import newfarmstudio.vkontakteclient.rest.model.request.WallGetByIdRequestModel;
import newfarmstudio.vkontakteclient.ui.activity.BaseActivity;
import newfarmstudio.vkontakteclient.ui.fragment.CommentsFragment;

/**
 * Created by Альберт on 09.03.2018.
 */

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel> {

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.tv_likes_count)
    TextView tvLikesCount;

    @BindView(R.id.tv_likes_icon)
    TextView tvLikesIcon;

    @BindView(R.id.tv_comments_count)
    TextView tvCommentsCount;

    @BindView(R.id.tv_comments_icon)
    TextView tvCommentsIcon;

    @BindView(R.id.tv_reposts_count)
    TextView tvRepostsCount;

    @BindView(R.id.tv_reposts_icon)
    TextView tvRepostsIcon;

    @BindView(R.id.rl_likes)
    View rlLikes;

    @BindView(R.id.rl_comments)
    View rlComments;

    private static final String POST = "post";
    private Resources mResources;
    private Context mContext;

    @Inject
    Typeface mGoogleFontTypeface;

    @Inject
    MyFragmentManager mFragmentManager;

    @Inject
    WallApi mWallApi;

    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        MyApplication.getApplicationComponent().inject(this);
        mContext = itemView.getContext();
        mResources = mContext.getResources();

        tvLikesIcon.setTypeface(mGoogleFontTypeface);
        tvCommentsIcon.setTypeface(mGoogleFontTypeface);
        tvRepostsIcon.setTypeface(mGoogleFontTypeface);
    }

    @Override
    public void bindViewHolder(NewsItemFooterViewModel item) {
        tvDate.setText(Utils.parseDate(item.getDateLong(), mContext));

        bindLikes(item.getLikes());
        bindComments(item.getComments());
        bindReposts(item.getReposts());

        rlComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentManager.addFragment((BaseActivity) view.getContext(),
                        CommentsFragment.newInstance(new Place(String.valueOf(item.getOwnerId()), String.valueOf(item.getId()))),
                        R.id.main_wrapper);
            }
        });

        rlLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like(item);
            }
        });
    }

    @Override
    public void unbindViewHolder() {
        tvDate.setText(null);
        tvLikesCount.setText(null);
        tvCommentsCount.setText(null);
        tvRepostsCount.setText(null);

    }

    private void bindLikes(LikeCounterViewModel likes) {
        tvLikesCount.setText(String.valueOf(likes.getCount()));
        tvLikesCount.setTextColor(mResources.getColor(likes.getTextColor()));
        tvLikesIcon.setTextColor(mResources.getColor(likes.getIconColor()));
    }

    private void bindComments(CommentCounterViewModel comments) {
        tvCommentsCount.setText(String.valueOf(comments.getCount()));
        tvCommentsCount.setTextColor(mResources.getColor(comments.getTextColor()));
        tvCommentsIcon.setTextColor(mResources.getColor(comments.getIconColor()));
    }

    private void bindReposts(RepostCounterViewModel reposts) {
        tvRepostsCount.setText(String.valueOf(reposts.getCount()));
        tvRepostsCount.setTextColor(mResources.getColor(reposts.getTextColor()));
        tvRepostsIcon.setTextColor(mResources.getColor(reposts.getIconColor()));
    }

    public WallItem getWallItemFromRealm(int postId) {
        Realm realm = Realm.getDefaultInstance();
        WallItem wallItem = realm.where(WallItem.class)
                .equalTo("id", postId)
                .findFirst();
        return realm.copyFromRealm(wallItem);
    }

    public void saveToDb(RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            realm1.copyToRealmOrUpdate(item);
        });
    }

    public Observable<LikeCounterViewModel> likeObservable(int ownerId, int postId, Likes likes) {
        return Observable.create(new LikeEventOnSubscribe(POST, ownerId, postId, likes))
                .observeOn(Schedulers.io())
                .flatMap(count -> {

                    return mWallApi.getById(new WallGetByIdRequestModel(ownerId, postId).toMap());
                })
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .doOnNext(this::saveToDb)
                .map(wallItem -> new LikeCounterViewModel(wallItem.getLikes()));
    }

    public void like(NewsItemFooterViewModel item) {
        WallItem wallItem = getWallItemFromRealm(item.getId());
        likeObservable(wallItem.getOwnerId(), wallItem.getId(), wallItem.getLikes())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(likes -> {
                    item.setLikes(likes);
                    bindLikes(likes);
                }, error -> {
                    error.printStackTrace();
                });

    }
}

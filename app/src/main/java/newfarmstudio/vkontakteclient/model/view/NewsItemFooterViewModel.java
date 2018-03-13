package newfarmstudio.vkontakteclient.model.view;

import android.view.View;

import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.model.view.counter.CommentCounterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.LikeCounterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.RepostCounterViewModel;
import newfarmstudio.vkontakteclient.ui.view.holder.BaseViewHolder;
import newfarmstudio.vkontakteclient.ui.view.holder.NewsItemFooterHolder;

/**
 * Created by Альберт on 09.03.2018.
 */

public class NewsItemFooterViewModel extends BaseViewModel {

    private int mId;
    private int ownerId;
    private long mDateLong;

    private LikeCounterViewModel mLikes;
    private CommentCounterViewModel mComments;
    private RepostCounterViewModel mReposts;

    public NewsItemFooterViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.ownerId = wallItem.getOwnerId();
        this.mDateLong = wallItem.getDate();
        this.mLikes = new LikeCounterViewModel(wallItem.getLikes());
        this.mComments = new CommentCounterViewModel(wallItem.getComments());
        this.mReposts = new RepostCounterViewModel(wallItem.getReposts());
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemFooter;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemFooterHolder(view);
    }

    public int getId() {
        return mId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public LikeCounterViewModel getLikes() {
        return mLikes;
    }

    public CommentCounterViewModel getComments() {
        return mComments;
    }

    public RepostCounterViewModel getReposts() {
        return mReposts;
    }

    public long getDateLong() {
        return mDateLong;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setLikes(LikeCounterViewModel mLikes) {
        this.mLikes = mLikes;
    }

    public void setComments(CommentCounterViewModel mComments) {
        this.mComments = mComments;
    }

    public void setReposts(RepostCounterViewModel mReposts) {
        this.mReposts = mReposts;
    }

    public void setDateLong(long mDateLong) {
        this.mDateLong = mDateLong;
    }

    @Override
    public boolean isItemDecorator() {
        return true;
    }
}

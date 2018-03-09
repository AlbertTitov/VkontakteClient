package newfarmstudio.vkontakteclient.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.utils.Utils;
import newfarmstudio.vkontakteclient.model.view.NewsItemFooterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.CommentCounterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.LikeCounterViewModel;
import newfarmstudio.vkontakteclient.model.view.counter.RepostCounterViewModel;

/**
 * Created by Альберт on 09.03.2018.
 */

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel> {

    private TextView tvDate;
    private TextView tvLikesCount;
    private TextView tvLikesIcon;
    private TextView tvCommentsCount;
    private TextView tvCommentsIcon;
    private TextView tvRepostsCount;
    private TextView tvRepostsIcon;
    private Resources mResources;
    private Context mContext;

    @Inject
    Typeface mGoogleFontTypeface;

    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        MyApplication.getsApplicationComponent().inject(this);
        mContext = itemView.getContext();
        mResources = mContext.getResources();

        tvDate = itemView.findViewById(R.id.tv_date);
        tvLikesCount = itemView.findViewById(R.id.tv_likes_count);
        tvLikesIcon = itemView.findViewById(R.id.tv_likes_icon);
        tvCommentsCount = itemView.findViewById(R.id.tv_comments_count);
        tvCommentsIcon = itemView.findViewById(R.id.tv_comments_icon);
        tvRepostsCount = itemView.findViewById(R.id.tv_reposts_count);
        tvRepostsIcon = itemView.findViewById(R.id.tv_reposts_icon);

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
}

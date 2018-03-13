package newfarmstudio.vkontakteclient.model.view;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.model.Topic;
import newfarmstudio.vkontakteclient.ui.view.holder.BaseViewHolder;

/**
 * Created by Альберт on 11.03.2018.
 */

public class TopicViewModel extends BaseViewModel {

    private int mId;
    private int mGroupId;
    private String mTitle;
    private String mCommentsCount;

    public TopicViewModel() {
    }

    public TopicViewModel(Topic topic) {
        this.mId = topic.getId();
        this.mGroupId = topic.getGroupId();
        this.mTitle = topic.getTitle();
        this.mCommentsCount = topic.getComments() + " сообщений";
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.Topic;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new TopicViewHolder(view);
    }

    public int getId() {
        return mId;
    }

    public int getGroupId() {
        return mGroupId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCommentsCount() {
        return mCommentsCount;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setGroupId(int mGroupId) {
        this.mGroupId = mGroupId;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setCommentsCount(String mCommentsCount) {
        this.mCommentsCount = mCommentsCount;
    }

    public static class TopicViewHolder extends BaseViewHolder<TopicViewModel> {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_comments_count)
        TextView tvCommentsCount;

        public TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindViewHolder(TopicViewModel topicViewModel) {
            tvTitle.setText(topicViewModel.getTitle());
            tvCommentsCount.setText(topicViewModel.getCommentsCount());
        }

        @Override
        public void unbindViewHolder() {
            tvTitle.setText(null);
            tvCommentsCount.setText(null);
        }
    }
}

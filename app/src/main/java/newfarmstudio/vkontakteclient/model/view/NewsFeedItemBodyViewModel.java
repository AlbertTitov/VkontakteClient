package newfarmstudio.vkontakteclient.model.view;

import android.view.View;

import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.ui.holder.BaseViewHolder;
import newfarmstudio.vkontakteclient.ui.holder.NewsItemBodyHolder;

/**
 * Created by Альберт on 07.03.2018.
 */

public class NewsFeedItemBodyViewModel extends BaseViewModel {

    private int mId;
    private String mText;
    private String mAttachmentString;
    private boolean mIsRepost;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost) {
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentsString();

        } else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentsString();
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

    public String getmAttachmentString() {
        return mAttachmentString;
    }
}

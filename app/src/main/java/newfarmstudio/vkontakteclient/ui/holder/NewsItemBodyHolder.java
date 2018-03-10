package newfarmstudio.vkontakteclient.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.model.view.NewsItemBodyViewModel;

/**
 * Created by Альберт on 07.03.2018.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    private TextView mText;
    private TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);
        mText = itemView.findViewById(R.id.tv_text);
        tvAttachments = itemView.findViewById(R.id.tv_attachments);

        if (tvAttachments != null) {
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel newsFeedItemBody) {
        mText.setText(newsFeedItemBody.getText());
        tvAttachments.setText(newsFeedItemBody.getmAttachmentString());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
        tvAttachments.setText(null);
    }
}

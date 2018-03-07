package newfarmstudio.vkontakteclient.ui.holder;

import android.view.View;
import android.widget.TextView;

import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.model.view.NewsFeedItemBodyViewModel;

/**
 * Created by Альберт on 07.03.2018.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView mText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        mText = itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBody) {
        mText.setText(newsFeedItemBody.getText());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
    }
}

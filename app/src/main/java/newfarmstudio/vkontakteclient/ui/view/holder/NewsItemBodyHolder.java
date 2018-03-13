package newfarmstudio.vkontakteclient.ui.view.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.manager.MyFragmentManager;
import newfarmstudio.vkontakteclient.common.utils.UIHelper;
import newfarmstudio.vkontakteclient.model.view.NewsItemBodyViewModel;
import newfarmstudio.vkontakteclient.ui.activity.BaseActivity;
import newfarmstudio.vkontakteclient.ui.fragment.OpenedPostFragment;

/**
 * Created by Альберт on 07.03.2018.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    @BindView(R.id.tv_text)
    TextView mText;

    @BindView(R.id.tv_attachments)
    TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;

    @Inject
    MyFragmentManager mFragmentManager;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        MyApplication.getApplicationComponent().inject(this);

        if (tvAttachments != null) {
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        mText.setText(item.getText());
        tvAttachments.setText(item.getAttachmentString());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentManager.addFragment((BaseActivity) v.getContext(), OpenedPostFragment.newInstance(item.getId()), R.id.main_wrapper);
            }
        });

        UIHelper.getInstance().setUpTextViewWithVisibility(mText, item.getText());
        UIHelper.getInstance().setUpTextViewWithVisibility(tvAttachments, item.getAttachmentString());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
        tvAttachments.setText(null);
        itemView.setOnClickListener(null);
    }
}

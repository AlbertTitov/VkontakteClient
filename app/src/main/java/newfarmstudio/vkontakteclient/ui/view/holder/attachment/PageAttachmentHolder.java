package newfarmstudio.vkontakteclient.ui.view.holder.attachment;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.utils.Utils;
import newfarmstudio.vkontakteclient.model.view.attachment.PageAttachmentViewModel;
import newfarmstudio.vkontakteclient.ui.view.holder.BaseViewHolder;

public class PageAttachmentHolder extends BaseViewHolder<PageAttachmentViewModel> {
    @BindView(R.id.tv_title)
    public TextView title;

    public PageAttachmentHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(PageAttachmentViewModel pageAttachmentViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(pageAttachmentViewModel.getmUrl(), view.getContext());
            }
        });
        title.setText(pageAttachmentViewModel.getTitle());
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
    }
}

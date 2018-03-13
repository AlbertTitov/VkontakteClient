package newfarmstudio.vkontakteclient.ui.view.holder.attachment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.utils.Utils;
import newfarmstudio.vkontakteclient.model.view.attachment.LinkExternalViewModel;
import newfarmstudio.vkontakteclient.ui.view.holder.BaseViewHolder;


public class LinkExternalAttachmentHolder extends BaseViewHolder<LinkExternalViewModel> {

    @BindView(R.id.iv_attachment_picture)
    public ImageView image;

    @BindView(R.id.tv_title)
    public TextView title;

    @BindView(R.id.tv_attachment_url)
    public TextView url;

    public LinkExternalAttachmentHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(LinkExternalViewModel linkExternalViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(linkExternalViewModel.getUrl(), view.getContext());
            }
        });
        title.setText(linkExternalViewModel.getTitle());
        url.setText(linkExternalViewModel.getUrl());

        Glide.with(itemView.getContext()).load(linkExternalViewModel.getImageUrl()).into(image);
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
        title.setText(null);
        image.setImageBitmap(null);
    }
}


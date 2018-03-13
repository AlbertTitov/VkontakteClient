package newfarmstudio.vkontakteclient.ui.view.holder.attachment;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.manager.MyFragmentManager;
import newfarmstudio.vkontakteclient.model.view.attachment.ImageAttachmentViewModel;
import newfarmstudio.vkontakteclient.ui.activity.BaseActivity;
import newfarmstudio.vkontakteclient.ui.fragment.ImageFragment;
import newfarmstudio.vkontakteclient.ui.view.holder.BaseViewHolder;

/**
 * Created by Альберт on 13.03.2018.
 */

public class ImageAttachmentHolder extends BaseViewHolder<ImageAttachmentViewModel> {

    @BindView(R.id.iv_attachment_image)
    public ImageView image;

    @Inject
    MyFragmentManager mFragmentManager;

    public ImageAttachmentHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ImageAttachmentViewModel imageAttachmentViewModel) {

        if (imageAttachmentViewModel.needClick) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragmentManager.addFragment((BaseActivity) itemView.getContext(),
                            ImageFragment.newInstance(imageAttachmentViewModel.getPhotoUrl()), R.id.main_wrapper);
                }
            });
        }

        Glide.with(itemView.getContext()).load(imageAttachmentViewModel.getPhotoUrl()).into(image);
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        image.setImageBitmap(null);
    }
}

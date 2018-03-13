package newfarmstudio.vkontakteclient.model.view.attachment;

import android.view.View;

import newfarmstudio.vkontakteclient.model.attachment.Photo;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.ui.view.holder.attachment.ImageAttachmentHolder;

/**
 * Created by Альберт on 13.03.2018.
 */

public class ImageAttachmentViewModel extends BaseViewModel {

    private String mPhotoUrl;
    public boolean needClick = true;

    public ImageAttachmentViewModel(String url) {
        mPhotoUrl = url;
        needClick = false;
    }

    public ImageAttachmentViewModel(Photo photo) {
        mPhotoUrl = photo.getPhoto604();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentImage;
    }

    @Override
    protected ImageAttachmentHolder onCreateViewHolder(View view) {
        return new ImageAttachmentHolder(view);
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }
}

package newfarmstudio.vkontakteclient.model.view;

import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.utils.UIHelper;
import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.ui.view.holder.BaseViewHolder;

/**
 * Created by Альберт on 13.03.2018.
 */

public class OpenedPostHeaderViewModel extends BaseViewModel {

    private int mId;

    private String mProfileName;
    private String mProfilePhoto;

    private String mText;

    public OpenedPostHeaderViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mProfileName = wallItem.getSenderName();
        this.mProfilePhoto = wallItem.getSenderPhoto();
        this.mText = wallItem.getText();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.OpenedPostHeader;
    }

    @Override
    public OpenedPostHeaderHolder onCreateViewHolder(View view) {
        return new OpenedPostHeaderHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getProfileName() {
        return mProfileName;
    }

    public String getProfilePhoto() {
        return mProfilePhoto;
    }

    public String getText() {
        return mText;
    }

    static class OpenedPostHeaderHolder extends BaseViewHolder<OpenedPostHeaderViewModel> {

        @BindView(R.id.civ_profile_image)
        CircleImageView profilePhoto;

        @BindView(R.id.tv_profile_name)
        TextView profileName;

        @BindView(R.id.tv_text)
        public TextView text;

        OpenedPostHeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindViewHolder(OpenedPostHeaderViewModel openedPostHeaderViewModel) {
            Glide.with(itemView.getContext()).load(openedPostHeaderViewModel.getProfilePhoto()).into(profilePhoto);
            profileName.setText(openedPostHeaderViewModel.getProfileName());
            UIHelper.getInstance().setUpTextViewWithVisibility(text, openedPostHeaderViewModel.getText());
        }

        @Override
        public void unbindViewHolder() {
            profilePhoto.setImageBitmap(null);
            profileName.setText(null);
            text.setText(null);
        }
    }
}

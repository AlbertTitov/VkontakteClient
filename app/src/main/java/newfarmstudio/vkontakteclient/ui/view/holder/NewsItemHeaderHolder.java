package newfarmstudio.vkontakteclient.ui.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.model.view.NewsItemHeaderViewModel;

/**
 * Created by Альберт on 07.03.2018.
 */

public class NewsItemHeaderHolder extends BaseViewHolder<NewsItemHeaderViewModel> {

    @BindView(R.id.civ_profile_image)
    CircleImageView civProfileImage;

    @BindView(R.id.tv_profile_name)
    TextView tvName;

    @BindView(R.id.iv_reposted_icon)
    ImageView isRepostedIcon;

    @BindView(R.id.tv_reposted_profile_name)
    TextView tvRepostedProfileName;


    public NewsItemHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(NewsItemHeaderViewModel item) {
        Context context = itemView.getContext();

        Glide.with(context)
                .load(item.getProfilePhoto())
                .into(civProfileImage);
        tvName.setText(item.getProfileName());

        if(item.isRepost()) {
            isRepostedIcon.setVisibility(View.VISIBLE);
            tvRepostedProfileName.setText(item.getRepostProfileName());

        } else {
            isRepostedIcon.setVisibility(View.GONE);
            tvRepostedProfileName.setText(null);
        }
    }

    @Override
    public void unbindViewHolder() {
        civProfileImage.setImageBitmap(null);
        tvName.setText(null);
        tvRepostedProfileName.setText(null);
    }
}

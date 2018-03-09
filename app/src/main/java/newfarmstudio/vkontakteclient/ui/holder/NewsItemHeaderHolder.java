package newfarmstudio.vkontakteclient.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.model.view.NewsItemHeaderViewModel;

/**
 * Created by Альберт on 07.03.2018.
 */

public class NewsItemHeaderHolder extends BaseViewHolder<NewsItemHeaderViewModel> {

    private CircleImageView civProfileImage;
    private TextView tvName;

    private ImageView isRepostedIcon;
    private TextView tvRepostedProfileName;


    public NewsItemHeaderHolder(View itemView) {
        super(itemView);

        civProfileImage = itemView.findViewById(R.id.civ_profile_image);
        tvName = itemView.findViewById(R.id.tv_profile_name);
        isRepostedIcon = itemView.findViewById(R.id.iv_reposted_icon);
        tvRepostedProfileName = itemView.findViewById(R.id.tv_reposted_profile_name);
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

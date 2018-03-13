package newfarmstudio.vkontakteclient.ui.fragment;

import android.os.Bundle;

import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.consts.ApiConstants;

/**
 * Created by Альберт on 11.03.2018.
 */

public class MyPostsFragment extends NewsFeedFragment {

    public MyPostsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setOwnerId(ApiConstants.MY_USER_ID);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_my_posts;
    }
}

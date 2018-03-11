package newfarmstudio.vkontakteclient.ui.fragment;

import android.os.Bundle;

import newfarmstudio.vkontakteclient.R;

/**
 * Created by Альберт on 11.03.2018.
 */

public class MyPostsFragment extends NewsFeedFragment {

    private static final int MY_USER_ID = 9319111;

    public MyPostsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setOwnerId(MY_USER_ID);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_my_posts;
    }
}

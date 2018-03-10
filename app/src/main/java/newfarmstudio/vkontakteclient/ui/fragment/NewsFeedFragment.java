package newfarmstudio.vkontakteclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.mvp.presenter.BaseFeedPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.NewsFeedPresenter;
import newfarmstudio.vkontakteclient.rest.api.WallApi;

/**
 * A simple {@link Fragment} subclass.
 */

public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    @InjectPresenter
    NewsFeedPresenter mPresenter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}



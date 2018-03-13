package newfarmstudio.vkontakteclient.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.model.view.NewsItemFooterViewModel;
import newfarmstudio.vkontakteclient.mvp.presenter.BaseFeedPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.OpenedPostPresenter;
import newfarmstudio.vkontakteclient.mvp.view.OpenedPostView;
import newfarmstudio.vkontakteclient.ui.view.holder.NewsItemFooterHolder;

/**
 * Created by Альберт on 13.03.2018.
 */


public class OpenedPostFragment extends BaseFeedFragment implements OpenedPostView{

    @BindView(R.id.rv_footer)
    View mFooter;

    @InjectPresenter
    OpenedPostPresenter mPresenter;

    int id;

    public static OpenedPostFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id", id);
        OpenedPostFragment openedPostFragment = new OpenedPostFragment();
        openedPostFragment.setArguments(args);
        return openedPostFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);

        setWithEndlessList(false);

        if (getArguments() != null) {
            this.id = getArguments().getInt("id");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        mPresenter.setId(id);
        return mPresenter;
    }

    @Override
    public void setFooter(NewsItemFooterViewModel viewModel) {
        mFooter.setVisibility(View.VISIBLE);
        new NewsItemFooterHolder(mFooter).bindViewHolder(viewModel);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_opened_post;
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_opened_wall_item;
    }
}
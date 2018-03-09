package newfarmstudio.vkontakteclient.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.BaseAdapter;

/**
 * Created by Альберт on 09.03.2018.
 */

public abstract class BaseFeedFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    BaseAdapter mBaseAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView recyclerView) {
        mBaseAdapter = new BaseAdapter();
        recyclerView.setAdapter(mBaseAdapter);
    }
}

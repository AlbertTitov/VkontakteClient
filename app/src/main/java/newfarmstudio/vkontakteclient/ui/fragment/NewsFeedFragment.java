package newfarmstudio.vkontakteclient.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import newfarmstudio.vkontakteclient.MyApplication;
import newfarmstudio.vkontakteclient.R;
import newfarmstudio.vkontakteclient.common.utils.VkListHelper;
import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.model.view.NewsFeedItemBodyViewModel;
import newfarmstudio.vkontakteclient.model.view.NewsItemFooterViewModel;
import newfarmstudio.vkontakteclient.model.view.NewsItemHeaderViewModel;
import newfarmstudio.vkontakteclient.rest.api.WallApi;
import newfarmstudio.vkontakteclient.rest.model.request.WallGetRequestModel;
import newfarmstudio.vkontakteclient.rest.model.response.WallGetResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */

public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {

                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem wallItem : wallItems) {
                    list.add(new NewsItemHeaderViewModel(wallItem));
                    list.add(new NewsFeedItemBodyViewModel(wallItem));
                    list.add(new NewsItemFooterViewModel(wallItem));
                }


                mBaseAdapter.addItems(list);

                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}



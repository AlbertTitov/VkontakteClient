package newfarmstudio.vkontakteclient.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import newfarmstudio.vkontakteclient.R;

/**
 * Created by Альберт on 13.03.2018.
 */

public class ImageFragment extends BaseFragment {

    @BindView(R.id.webview)
    WebView webView;

    public static ImageFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_webview;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_image;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setBackgroundColor(getResources().getColor(R.color.colorDefaultWhite));

        webView.loadUrl(getArguments().getString("url"));
    }
}

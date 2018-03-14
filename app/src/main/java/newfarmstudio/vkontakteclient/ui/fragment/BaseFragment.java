package newfarmstudio.vkontakteclient.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import newfarmstudio.vkontakteclient.ui.activity.BaseActivity;

/**
 * Created by Альберт on 05.03.2018.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    private String mToolbarTitle;

    @LayoutRes
    protected abstract int getMainContentLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getMainContentLayout(), container, false);
    }

    public String createToolbarTitle(Context context) {
        return context.getString(onCreateToolbarTitle());
    }

    @StringRes
    public abstract int onCreateToolbarTitle();

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    public boolean needFab() {return false;}
}

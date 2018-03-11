package newfarmstudio.vkontakteclient.mvp.view;

import com.arellomobile.mvp.MvpView;

import newfarmstudio.vkontakteclient.model.Profile;
import newfarmstudio.vkontakteclient.ui.fragment.BaseFragment;

/**
 * Created by Альберт on 05.03.2018.
 */

public interface MainView extends MvpView {

    void startSignIn();
    void signedId();
    void showCurrentUser(Profile profile);
    void showFragmentFromDrawer(BaseFragment baseFragment);
}

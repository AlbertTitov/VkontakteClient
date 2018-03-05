package newfarmstudio.vkontakteclient.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import newfarmstudio.vkontakteclient.CurrentUser;
import newfarmstudio.vkontakteclient.mvp.view.MainView;

/**
 * Created by Альберт on 05.03.2018.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedId();
        }
    }

}

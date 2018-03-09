package newfarmstudio.vkontakteclient.mvp.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import newfarmstudio.vkontakteclient.model.view.BaseViewModel;

/**
 * Created by Альберт on 09.03.2018.
 */

public interface BaseFeedView extends MvpView {

    void showRefreshing();
    void hideRefreshing();

    void showListProgress();
    void hideListProgress();

    void showError(String message);

    void setItems(List<BaseViewModel> items);
    void addItems(List<BaseViewModel> items);
}

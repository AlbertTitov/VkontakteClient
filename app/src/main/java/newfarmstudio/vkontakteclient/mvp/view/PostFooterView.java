package newfarmstudio.vkontakteclient.mvp.view;

import com.arellomobile.mvp.MvpView;

import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.model.view.counter.LikeCounterViewModel;

/**
 * Created by Альберт on 13.03.2018.
 */

public interface PostFooterView extends MvpView {
    void like(LikeCounterViewModel likes);
    void openComments(WallItem wallItem);
}

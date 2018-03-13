package newfarmstudio.vkontakteclient.mvp.view;

import newfarmstudio.vkontakteclient.model.view.NewsItemFooterViewModel;

/**
 * Created by Альберт on 13.03.2018.
 */

public interface OpenedPostView extends BaseFeedView {

    void setFooter(NewsItemFooterViewModel viewModel);
}

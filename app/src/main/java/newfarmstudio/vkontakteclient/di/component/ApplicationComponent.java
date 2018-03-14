package newfarmstudio.vkontakteclient.di.component;

import javax.inject.Singleton;

import dagger.Component;
import newfarmstudio.vkontakteclient.common.manager.NetworkManager;
import newfarmstudio.vkontakteclient.di.module.ApplicationModule;
import newfarmstudio.vkontakteclient.di.module.ManagerModule;
import newfarmstudio.vkontakteclient.di.module.RestModule;
import newfarmstudio.vkontakteclient.model.view.CommentBodyViewModel;
import newfarmstudio.vkontakteclient.model.view.CommentFooterViewModel;
import newfarmstudio.vkontakteclient.model.view.TopicViewModel;
import newfarmstudio.vkontakteclient.mvp.presenter.BoardPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.CommentsPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.InfoPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.MainPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.MembersPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.NewsFeedPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.OpenedCommentPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.OpenedPostPresenter;
import newfarmstudio.vkontakteclient.mvp.presenter.TopicCommentsPresenter;
import newfarmstudio.vkontakteclient.ui.activity.BaseActivity;
import newfarmstudio.vkontakteclient.ui.activity.MainActivity;
import newfarmstudio.vkontakteclient.ui.fragment.CommentsFragment;
import newfarmstudio.vkontakteclient.ui.fragment.NewsFeedFragment;
import newfarmstudio.vkontakteclient.ui.fragment.OpenedCommentFragment;
import newfarmstudio.vkontakteclient.ui.fragment.OpenedPostFragment;
import newfarmstudio.vkontakteclient.ui.fragment.TopicCommentsFragment;
import newfarmstudio.vkontakteclient.ui.view.holder.NewsItemBodyHolder;
import newfarmstudio.vkontakteclient.ui.view.holder.NewsItemFooterHolder;
import newfarmstudio.vkontakteclient.ui.view.holder.attachment.ImageAttachmentHolder;
import newfarmstudio.vkontakteclient.ui.view.holder.attachment.VideoAttachmentHolder;

/**
 * Created by Альберт on 06.03.2018.
 */
@Singleton
@Component (modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);

    //fragments
    void inject(NewsFeedFragment newsFeedFragment);
    void inject(OpenedPostFragment openedPostFragment);
    void inject(CommentsFragment openedPostFragment);
    void inject(OpenedCommentFragment openedPostFragment);
    void inject(TopicCommentsFragment openedPostFragment);

    //holders
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
    void inject(ImageAttachmentHolder holder);
    void inject(VideoAttachmentHolder holder);
    void inject(CommentBodyViewModel.CommentBodyViewHolder holder);
    void inject(CommentFooterViewModel.CommentFooterHolder holder);
    void inject(TopicViewModel.TopicViewHolder holder);

    //presenters
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);
    void inject(BoardPresenter presenter);
    void inject(InfoPresenter presenter);
    void inject(OpenedPostPresenter presenter);
    void inject(CommentsPresenter presenter);
    void inject(OpenedCommentPresenter presenter);
    void inject(TopicCommentsPresenter presenter);

    //managers
    void inject(NetworkManager networkManager);
}

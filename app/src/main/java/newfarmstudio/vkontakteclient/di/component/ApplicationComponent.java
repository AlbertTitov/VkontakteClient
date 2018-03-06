package newfarmstudio.vkontakteclient.di.component;

import javax.inject.Singleton;

import dagger.Component;
import newfarmstudio.vkontakteclient.di.module.ApplicationModule;
import newfarmstudio.vkontakteclient.di.module.ManagerModule;
import newfarmstudio.vkontakteclient.di.module.RestModule;
import newfarmstudio.vkontakteclient.ui.activity.BaseActivity;
import newfarmstudio.vkontakteclient.ui.activity.MainActivity;
import newfarmstudio.vkontakteclient.ui.fragment.NewsFeedFragment;

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
}

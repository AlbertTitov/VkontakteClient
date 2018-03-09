package newfarmstudio.vkontakteclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import newfarmstudio.vkontakteclient.common.manager.MyFragmentManager;
import newfarmstudio.vkontakteclient.common.manager.NetworkManager;

/**
 * Created by Альберт on 06.03.2018.
 */

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }

    @Singleton
    @Provides
    NetworkManager provideNetworkManager() {return new NetworkManager();}
}

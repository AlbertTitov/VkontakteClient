package newfarmstudio.vkontakteclient;

import android.app.Application;

import com.vk.sdk.VKSdk;

import newfarmstudio.vkontakteclient.di.component.ApplicationComponent;
import newfarmstudio.vkontakteclient.di.component.DaggerApplicationComponent;
import newfarmstudio.vkontakteclient.di.module.ApplicationModule;
import newfarmstudio.vkontakteclient.di.module.ManagerModule;
import newfarmstudio.vkontakteclient.di.module.RestModule;

/**
 * Created by Альберт on 05.03.2018.
 */

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .managerModule(new ManagerModule())
                .restModule(new RestModule())
                .build();
    }

    public static ApplicationComponent getsApplicationComponent() {
        return sApplicationComponent;
    }
}

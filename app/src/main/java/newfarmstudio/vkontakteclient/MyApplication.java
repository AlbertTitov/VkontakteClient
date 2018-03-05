package newfarmstudio.vkontakteclient;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Альберт on 05.03.2018.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);
    }
}

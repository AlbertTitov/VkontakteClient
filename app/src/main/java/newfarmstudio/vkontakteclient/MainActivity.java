package newfarmstudio.vkontakteclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.util.Arrays;

import newfarmstudio.vkontakteclient.consts.ApiConstants;
import newfarmstudio.vkontakteclient.mvp.presenter.MainPresenter;
import newfarmstudio.vkontakteclient.mvp.view.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView{

    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter.checkAuth();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
            // Пользователь успешно авторизовался
                mainPresenter.checkAuth();
            }

            @Override
            public void onError(VKError error) {
            // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedId() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(), Toast.LENGTH_LONG).show();
    }
}

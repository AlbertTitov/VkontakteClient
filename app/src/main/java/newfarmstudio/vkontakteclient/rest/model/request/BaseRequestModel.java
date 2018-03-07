package newfarmstudio.vkontakteclient.rest.model.request;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.HashMap;
import java.util.Map;

import newfarmstudio.vkontakteclient.CurrentUser;
import newfarmstudio.vkontakteclient.consts.ApiConstants;

/**
 * Created by Альберт on 07.03.2018.
 */

public abstract class BaseRequestModel {

    @SerializedName(VKApiConst.VERSION)
    Double version = ApiConstants.DEFAULT_VERSION;

    @SerializedName(VKApiConst.ACCESS_TOKEN)
    String accessToken = CurrentUser.getAccessToken();

    public Double getVersion() {
        return version;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();

        map.put(VKApiConst.VERSION, String.valueOf(getVersion()));
        if (accessToken != null) {
            map.put(VKApiConst.ACCESS_TOKEN, accessToken);
        }
        onMapCreate(map);
        return map;
    }

    public abstract void onMapCreate(Map<String, String> map);
}

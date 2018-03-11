package newfarmstudio.vkontakteclient.rest.model.request;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.Map;

import newfarmstudio.vkontakteclient.consts.ApiConstants;

/**
 * Created by Альберт on 11.03.2018.
 */

public class UsersGetRequestModel extends BaseRequestModel {

    @SerializedName(VKApiConst.USER_IDS)
    String userIds;

    @SerializedName(VKApiConst.FIELDS)
    String fields = ApiConstants.DEFAULT_USER_FIELDS;

    public UsersGetRequestModel(String userIds) {
        this.userIds = userIds;
    }

    @Override
    public void onMapCreate(Map<String, String> map) {
        map.put(VKApiConst.USER_ID, getUserIds());
        map.put(VKApiConst.FIELDS, getFields());
    }

    public String getUserIds() {
        return userIds;
    }

    public String getFields() {
        return fields;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}

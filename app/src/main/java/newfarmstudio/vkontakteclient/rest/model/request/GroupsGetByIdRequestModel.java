package newfarmstudio.vkontakteclient.rest.model.request;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.Map;

import newfarmstudio.vkontakteclient.consts.ApiConstants;

/**
 * Created by Альберт on 11.03.2018.
 */

public class GroupsGetByIdRequestModel extends BaseRequestModel {

    @SerializedName(VKApiConst.GROUP_ID)
    private int groupId;

    @SerializedName(VKApiConst.FIELDS)
    private String fields = ApiConstants.DEFAULT_GROUP_FIELDS;

    public GroupsGetByIdRequestModel(int groupId) {
        this.groupId = Math.abs(groupId);
    }

    @Override
    public void onMapCreate(Map<String, String> map) {

        map.put(VKApiConst.GROUP_ID, String.valueOf(getGroupId()));
        map.put(VKApiConst.FIELDS, getFields());
    }

    public int getGroupId() {
        return groupId;
    }

    public String getFields() {
        return fields;
    }

    public void setGroupId(int groupId) {
        this.groupId = Math.abs(groupId);
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}

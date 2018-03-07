package newfarmstudio.vkontakteclient.rest.model.request;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.Map;

import newfarmstudio.vkontakteclient.consts.ApiConstants;

/**
 * Created by Альберт on 07.03.2018.
 */

public class WallGetRequestModel extends BaseRequestModel {

    @SerializedName(VKApiConst.OWNER_ID)
    int ownerId;

    @SerializedName(VKApiConst.COUNT)
    int count = ApiConstants.DEFAULT_COUNT;

    @SerializedName(VKApiConst.OFFSET)
    int offset;

    @SerializedName(VKApiConst.EXTENDED)
    int extended;

    public WallGetRequestModel(int ownerId) {
        this.ownerId = ownerId;
    }

    public WallGetRequestModel(int ownerId, int count, int offset) {
        this.ownerId = ownerId;
        this.count = count;
        this.offset = offset;
    }

    @Override
    public void onMapCreate(Map<String, String> map) {
        map.put(VKApiConst.OWNER_ID, String.valueOf(getOwnerId()));
        map.put(VKApiConst.COUNT, String.valueOf(getCount()));
        map.put(VKApiConst.OFFSET, String.valueOf(getOffset()));
        map.put(VKApiConst.EXTENDED, String.valueOf(getExtended()));
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getCount() {
        return count;
    }

    public int getOffset() {
        return offset;
    }

    public int getExtended() {
        return extended;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setExtended(int extended) {
        this.extended = extended;
    }
}

package newfarmstudio.vkontakteclient.rest.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import newfarmstudio.vkontakteclient.model.Group;
import newfarmstudio.vkontakteclient.model.Member;
import newfarmstudio.vkontakteclient.rest.model.response.BaseItemResponse;
import newfarmstudio.vkontakteclient.rest.model.response.Full;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Альберт on 11.03.2018.
 */

public interface GroupsApi {

    @GET(ApiMethods.GROUPS_GET_MEMBERS)
    Observable <Full<BaseItemResponse<Member>>> getMembers(@QueryMap Map<String, String> map);

    @GET(ApiMethods.GROUPS_GET_BY_ID)
    Observable <Full<List<Group>>> getById(@QueryMap Map<String, String> map);
}

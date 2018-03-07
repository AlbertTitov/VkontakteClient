package newfarmstudio.vkontakteclient.rest.api;

import java.util.Map;
import newfarmstudio.vkontakteclient.rest.model.response.WallGetResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Альберт on 06.03.2018.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}

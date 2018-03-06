package newfarmstudio.vkontakteclient.rest.api;

import newfarmstudio.vkontakteclient.rest.model.response.BaseItemResponse;
import newfarmstudio.vkontakteclient.rest.model.response.Full;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Альберт on 06.03.2018.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("owner_id") String ownerId,
                                     @Query("access_token") String accessToken,
                                     @Query("extended") Integer extended,
                                     @Query("v") String version);
}

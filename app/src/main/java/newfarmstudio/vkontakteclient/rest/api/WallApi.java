package newfarmstudio.vkontakteclient.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import newfarmstudio.vkontakteclient.rest.model.response.GetWallByIdResponse;
import newfarmstudio.vkontakteclient.rest.model.response.WallGetResponse;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Альберт on 06.03.2018.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Observable<WallGetResponse> get(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_BY_ID)
    Observable<GetWallByIdResponse> getById(@QueryMap Map<String, String> map);
}

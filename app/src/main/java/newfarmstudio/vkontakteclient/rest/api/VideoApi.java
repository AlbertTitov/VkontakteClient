package newfarmstudio.vkontakteclient.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import newfarmstudio.vkontakteclient.rest.model.response.Full;
import newfarmstudio.vkontakteclient.rest.model.response.VideosResponse;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Альберт on 13.03.2018.
 */

public interface VideoApi {

    @GET(ApiMethods.VIDEO_GET)
    Observable<Full<VideosResponse>> get(@QueryMap Map<String, String> map);
}

package newfarmstudio.vkontakteclient.rest.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import newfarmstudio.vkontakteclient.model.Profile;
import newfarmstudio.vkontakteclient.rest.model.response.Full;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Альберт on 11.03.2018.
 */

public interface UsersApi {

    @GET(ApiMethods.USERS_GET)
    Observable<Full<List<Profile>>> get(@QueryMap Map<String, String> map);
}

package newfarmstudio.vkontakteclient.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import newfarmstudio.vkontakteclient.model.CommentItem;
import newfarmstudio.vkontakteclient.model.Topic;
import newfarmstudio.vkontakteclient.rest.model.response.BaseItemResponse;
import newfarmstudio.vkontakteclient.rest.model.response.Full;
import newfarmstudio.vkontakteclient.rest.model.response.ItemWithSendersResponse;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Альберт on 11.03.2018.
 */

public interface BoardApi {

    @GET(ApiMethods.BOARD_GET_TOPICS)
    Observable<Full<BaseItemResponse<Topic>>> getTopics(@QueryMap Map<String, String> map);

    @GET(ApiMethods.BOARD_GET_COMMENTS)
    Observable<Full<ItemWithSendersResponse<CommentItem>>> getComments(@QueryMap Map<String, String> map);
}

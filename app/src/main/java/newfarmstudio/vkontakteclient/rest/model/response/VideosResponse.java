package newfarmstudio.vkontakteclient.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import newfarmstudio.vkontakteclient.model.attachment.video.Video;

/**
 * Created by Альберт on 13.03.2018.
 */

public class VideosResponse {

    public int count;

    @SerializedName("items")
    @Expose
    public List<Video> items;


}

package newfarmstudio.vkontakteclient.model.attachment.doc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import newfarmstudio.vkontakteclient.model.attachment.video.Video;

/**
 * Created by Альберт on 13.03.2018.
 */

public class Preview extends RealmObject {

    @SerializedName("photo")
    @Expose
    public PhotoPreview photo;

    @SerializedName("video")
    @Expose
    public Video video;

    public PhotoPreview getPhoto() {
        return photo;
    }

    public Video getVideo() {
        return video;
    }

    public void setPhoto(PhotoPreview photo) {
        this.photo = photo;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}

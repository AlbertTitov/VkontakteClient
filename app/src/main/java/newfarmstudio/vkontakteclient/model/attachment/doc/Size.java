package newfarmstudio.vkontakteclient.model.attachment.doc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Альберт on 13.03.2018.
 */

public class Size extends RealmObject  {

    @SerializedName("src")
    @Expose
    public String src;

    @SerializedName("width")
    @Expose
    public int width;

    @SerializedName("height")
    @Expose
    public int height;

    @SerializedName("type")
    @Expose
    public String type;

    public String getSrc() {
        return src;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package newfarmstudio.vkontakteclient.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Альберт on 06.03.2018.
 */

public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;


}

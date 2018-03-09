package newfarmstudio.vkontakteclient.model;

import com.vk.sdk.api.model.Identifiable;

/**
 * Created by Альберт on 07.03.2018.
 */

public interface Owner extends Identifiable {

    String getFullName();
    String getPhoto();
}

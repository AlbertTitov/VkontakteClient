package newfarmstudio.vkontakteclient.rest.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Альберт on 06.03.2018.
 */

public class BaseItemResponse<T> {

    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}

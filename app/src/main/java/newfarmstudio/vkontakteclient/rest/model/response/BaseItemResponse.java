package newfarmstudio.vkontakteclient.rest.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Альберт on 06.03.2018.
 */

public class BaseItemResponse<T> {

    private Integer count;
    private List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}

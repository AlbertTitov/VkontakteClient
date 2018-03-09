package newfarmstudio.vkontakteclient.common.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by Альберт on 09.03.2018.
 */

public class MyLinearLayoutManager extends LinearLayoutManager {

    public MyLinearLayoutManager(Context context) {
        super(context);
    }

    public MyLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MyLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean isOnNextPagePosition() {
        int visibleItemCount = getChildCount();
        int totalItemCount = getItemCount();
        int pastVisibleItems = findFirstVisibleItemPosition();
        return (pastVisibleItems + visibleItemCount) >= totalItemCount / 2;
    }
}

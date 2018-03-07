package newfarmstudio.vkontakteclient.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;

/**
 * Created by Альберт on 07.03.2018.
 */

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unbindViewHolder();
}

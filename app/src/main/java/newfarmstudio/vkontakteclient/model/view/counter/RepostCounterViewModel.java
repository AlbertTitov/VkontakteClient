package newfarmstudio.vkontakteclient.model.view.counter;

import newfarmstudio.vkontakteclient.model.Reposts;

/**
 * Created by Альберт on 09.03.2018.
 */

public class RepostCounterViewModel extends CounterViewModel {

    private Reposts mReposts;


    public RepostCounterViewModel(Reposts reposts) {
        super(reposts != null ? reposts.getCount() : 0);
        this.mReposts = reposts;

        if (mReposts != null && mReposts.getUserReposted() == 1) {
            setAccentColor();
        }
    }

    public Reposts getReposts() {
        return mReposts;
    }
}

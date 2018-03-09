package newfarmstudio.vkontakteclient.model.view.counter;

import newfarmstudio.vkontakteclient.model.Likes;

/**
 * Created by Альберт on 09.03.2018.
 */

public class LikeCounterViewModel extends CounterViewModel {

    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());
        this.mLikes = likes;

        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }

    public Likes getLikes() {
        return mLikes;
    }
}

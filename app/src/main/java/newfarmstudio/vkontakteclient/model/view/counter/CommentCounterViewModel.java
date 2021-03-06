package newfarmstudio.vkontakteclient.model.view.counter;

import newfarmstudio.vkontakteclient.model.countable.Comments;

/**
 * Created by Альберт on 09.03.2018.
 */

public class CommentCounterViewModel extends CounterViewModel {

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments != null ? comments.getCount() : 0);
        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}

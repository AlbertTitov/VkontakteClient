package newfarmstudio.vkontakteclient.model.view.counter;

import newfarmstudio.vkontakteclient.model.Comments;

/**
 * Created by Альберт on 09.03.2018.
 */

public class CommentCounterViewModel extends CounterViewModel {

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());
        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}

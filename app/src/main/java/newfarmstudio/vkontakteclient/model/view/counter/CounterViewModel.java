package newfarmstudio.vkontakteclient.model.view.counter;

import newfarmstudio.vkontakteclient.R;

/**
 * Created by Альберт on 09.03.2018.
 */

public class CounterViewModel {

    protected int mCount;
    protected int mIconColor = R.color.colorIconDis;
    protected int mTextColor = R.color.colorIconDis;

    public CounterViewModel(int count) {
        this.mCount = count;
        if (mCount > 0) {
            setDefaultColor();

        } else {
            setDisabledColor();
        }
    }

    private void setDefaultColor() {
        mIconColor = R.color.colorIcon;
        mTextColor = R.color.colorIcon;
    }

    private void setDisabledColor() {
        mIconColor = R.color.colorIconDis;
        mTextColor = R.color.colorIconDis;
    }

    protected void setAccentColor() {
        mIconColor = R.color.colorAccent;
        mTextColor = R.color.colorAccent;
    }

    public int getCount() {
        return mCount;
    }

    public int getIconColor() {
        return mIconColor;
    }

    public int getTextColor() {
        return mTextColor;
    }


}

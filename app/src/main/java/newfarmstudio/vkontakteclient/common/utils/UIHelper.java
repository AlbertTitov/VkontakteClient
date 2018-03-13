package newfarmstudio.vkontakteclient.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import newfarmstudio.vkontakteclient.R;

/**
 * Created by Альберт on 13.03.2018.
 */

public class UIHelper {

    private static UIHelper ourInstance = new UIHelper();

    private Resources resources;
    private Context context;

    public static UIHelper getInstance() {return ourInstance;}

    public void setUpTextViewWithVisibility(TextView textView, String s) {
        textView.setText(s);

        if (s.length() != 0) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    public void setUpTextViewWithMessage(TextView textView, String s, String messageIfEmpty) {
        String s1;
        int color;
        Resources res = textView.getResources();

        if (s.length() != 0) {
            textView.setVisibility(View.VISIBLE);
            color = android.R.color.primary_text_light;
            s1 = s;

        } else {
            s1 = "Поделился";
            color = R.color.colorIcon;
        }

        textView.setText(s1);
        textView.setTextColor(res.getColor(color));
    }
}

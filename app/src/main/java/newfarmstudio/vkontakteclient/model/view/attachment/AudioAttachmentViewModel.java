package newfarmstudio.vkontakteclient.model.view.attachment;

import android.view.View;

import newfarmstudio.vkontakteclient.common.utils.Utils;
import newfarmstudio.vkontakteclient.model.attachment.Audio;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.ui.view.holder.attachment.AudioAttachmentHolder;

/**
 * Created by Альберт on 13.03.2018.
 */

public class AudioAttachmentViewModel extends BaseViewModel {

    private String mTitle;
    private String mArtist;

    private String mDuration;


    public AudioAttachmentViewModel(Audio audio) {
        if (audio.getTitle().equals("")) {
            mTitle = "Title";
        } else {
            mTitle = audio.getTitle();
        }

        if (audio.getArtist().equals("")) {
            mArtist = "Various Artist";
        } else {
            mArtist = audio.getArtist();
        }

        mDuration = Utils.parseDuration(audio.getDuration());
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentAudio;
    }

    @Override
    public AudioAttachmentHolder onCreateViewHolder(View view) {
        return new AudioAttachmentHolder(view);
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getDuration() {
        return mDuration;
    }
}

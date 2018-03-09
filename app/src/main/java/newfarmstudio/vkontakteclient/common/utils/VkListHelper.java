package newfarmstudio.vkontakteclient.common.utils;

import java.util.List;

import newfarmstudio.vkontakteclient.model.Owner;
import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.rest.model.response.ItemWithSendersResponse;

/**
 * Created by Альберт on 07.03.2018.
 */

public class VkListHelper {

    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response) {
        List<WallItem> wallItems = response.getItems();

        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());

            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            wallItem.setAttachmentsString(Utils.convertAttachmentsToFontIcons(wallItem.getAttachments()));

            if (wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());

                wallItem.getSharedRepost().setAttachmentsString(Utils.convertAttachmentsToFontIcons(wallItem.getSharedRepost().getAttachments()));
            }
        }
        return wallItems;
    }
}

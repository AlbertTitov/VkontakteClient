package newfarmstudio.vkontakteclient.common.utils;

import com.vk.sdk.api.model.VKAttachments;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import newfarmstudio.vkontakteclient.model.CommentItem;
import newfarmstudio.vkontakteclient.model.Owner;
import newfarmstudio.vkontakteclient.model.WallItem;
import newfarmstudio.vkontakteclient.model.attachment.ApiAttachment;
import newfarmstudio.vkontakteclient.model.view.BaseViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.AudioAttachmentViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.DocAttachmentViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.DocImageAttachmentViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.ImageAttachmentViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.LinkAttachmentViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.LinkExternalViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.PageAttachmentViewModel;
import newfarmstudio.vkontakteclient.model.view.attachment.VideoAttachmentViewModel;
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

    public static List<BaseViewModel> getAttachmentVkItems(List<ApiAttachment> attachments) {

        List<BaseViewModel> attachmentVkItems = new ArrayList<>();
        for (ApiAttachment attachment : attachments) {

            switch (attachment.getType()) {
                case VKAttachments.TYPE_PHOTO:
                    attachmentVkItems.add(new ImageAttachmentViewModel(attachment.getPhoto()));
                    break;

                case VKAttachments.TYPE_AUDIO:
                    attachmentVkItems.add(new AudioAttachmentViewModel(attachment.getAudio()));
                    break;

                case VKAttachments.TYPE_VIDEO:
                    attachmentVkItems.add(new VideoAttachmentViewModel(attachment.getVideo()));
                    break;

                case VKAttachments.TYPE_DOC:
                    if (attachment.getDoc().getPreview() != null) {
                        attachmentVkItems.add(new DocImageAttachmentViewModel(attachment.getDoc()));

                    } else {
                        attachmentVkItems.add(new DocAttachmentViewModel(attachment.getDoc()));
                    }
                    break;

                case VKAttachments.TYPE_LINK:
                    if (attachment.getLink().getIsExternal() == 1) {
                        attachmentVkItems.add(new LinkExternalViewModel(attachment.getLink()));

                    } else {
                        attachmentVkItems.add(new LinkAttachmentViewModel(attachment.getLink()));
                    }
                    break;

                case "page":
                    attachmentVkItems.add(new PageAttachmentViewModel(attachment.getPage()));
                    break;

                default:
                    throw new NoSuchElementException("Attachment type " + attachment.getType() + " is not supported.");
            }
        }
        return attachmentVkItems;
    }

    public static List<CommentItem> getCommentsList(ItemWithSendersResponse<CommentItem> response) {
        return getCommentsList(response, false);
    }

    public static List<CommentItem> getCommentsList(ItemWithSendersResponse<CommentItem> response, boolean isFromTopic) {
        List<CommentItem> commentItems = response.getItems();

        for (CommentItem commentItem : commentItems) {
            Owner sender = response.getSender(commentItem.getFromId());
            commentItem.setSenderName(sender.getFullName());
            commentItem.setSenderPhoto(sender.getPhoto());

            commentItem.setIsFromTopic(isFromTopic);
            commentItem.setAttachmentsString(Utils.convertAttachmentsToFontIcons(commentItem.getAttachments()));
        }
        return commentItems;
    }
}

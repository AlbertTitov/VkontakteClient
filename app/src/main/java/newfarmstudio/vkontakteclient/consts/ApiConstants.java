package newfarmstudio.vkontakteclient.consts;

import com.vk.sdk.VKScope;

/**
 * Created by Альберт on 05.03.2018.
 */

public class ApiConstants {
    public static final String[] DEFAULT_LOGIN_SCOPE = {VKScope.EMAIL, VKScope.AUDIO, VKScope.DIRECT,
            VKScope.VIDEO, VKScope.MESSAGES, VKScope.PHOTOS, VKScope.WALL, VKScope.STATS,
            VKScope.GROUPS, VKScope.PAGES, VKScope.DOCS};

    public static final Double DEFAULT_VERSION = 5.73;
    public static final int DEFAULT_COUNT = 10;
    public static final String DEFAULT_USER_FIELDS = "photo_100";
    public static final String DEFAULT_MEMBER_FIELDS = "name,photo_100";
    public static final int MY_GROUP_ID = -86529522;
    public static final int MY_USER_ID = 9319111;
    public static final String DEFAULT_GROUP_FIELDS = "status,description,site,links,contacts";
    public static final String VIDEOS = "videos";
    public static final String POSTS = "posts";
    public static final String EXTENDED = "extended";

    public static final String OWNER_ID = "owner_id";
    public static final String POST_ID = "post_id";
    public static final String COUNT = "count";
    public static final String OFFSET = "offset";
    public static final String NEED_LIKES = "need_likes";

    public static final String GROUP_ID = "group_id";
    public static final String TOPIC_ID = "topic_id";


}

package newfarmstudio.vkontakteclient;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

/**
 * Created by Альберт on 05.03.2018.
 */

public class CurrentUser {
    public static String getAccessToken() {
        if (VKAccessToken.currentToken() == null) {
            return null;
        }
        return VKAccessToken.currentToken().accessToken;
    }

    public static String getId() {
        if (VKAccessToken.currentToken() == null) {
            return null;
        }
        return VKAccessToken.currentToken().userId;
    }

    public static boolean isAuthorized() {
        return VKSdk.isLoggedIn() && VKAccessToken.currentToken() != null
                && !VKAccessToken.currentToken().isExpired();
    }
}

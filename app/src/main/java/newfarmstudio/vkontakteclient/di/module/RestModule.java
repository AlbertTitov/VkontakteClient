package newfarmstudio.vkontakteclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import newfarmstudio.vkontakteclient.rest.RestClient;
import newfarmstudio.vkontakteclient.rest.api.GroupsApi;
import newfarmstudio.vkontakteclient.rest.api.UsersApi;
import newfarmstudio.vkontakteclient.rest.api.WallApi;

/**
 * Created by Альберт on 06.03.2018.
 */

@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi() {
        return mRestClient.createService(WallApi.class);
    }

    @Singleton
    @Provides
    public UsersApi provideUsersApi() {return mRestClient.createService(UsersApi.class);}

    @Singleton
    @Provides
    public GroupsApi provideGroupsApi() {return mRestClient.createService(GroupsApi.class);}
}

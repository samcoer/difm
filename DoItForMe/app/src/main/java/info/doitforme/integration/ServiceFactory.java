package info.doitforme.integration;

import retrofit.RestAdapter;

/**
 * Created by bhatt on 6/10/2015.
 */
public class ServiceFactory {
    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setEndpoint("http://web-difm.rhcloud.com/difm/service")
            .build();

    public static Object getService(Class service){
        return restAdapter.create(service);
    }
}

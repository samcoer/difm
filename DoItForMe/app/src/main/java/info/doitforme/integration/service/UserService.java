package info.doitforme.integration.service;

import info.doitforme.integration.bo.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by bhatt on 6/10/2015.
 */
public interface UserService{
    @GET("/user/{id}")
    void get(@Path("id") Long id, Callback<User> cb);

    @POST("/user")
    void create(@Body User user, Callback<User> cb);
}


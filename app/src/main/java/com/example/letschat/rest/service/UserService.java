package com.example.letschat.rest.service;
import com.example.letschat.rest.serializers.user.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface UserService  {

    @POST("/user/signUp")
    @FormUrlEncoded
    Call<User> signUp(@Field("authorName") String authorName,
                        @Field("userName") String userName,
                        @Field("password") String password);

    @POST("/user/login")
    @FormUrlEncoded
    Call<User> login(@Field("userName") String userName,
                        @Field("password") String password);
}

package com.example.letschat.rest;

import android.content.Context;

import com.example.letschat.AuthActivity;
import com.example.letschat.rest.Interceptors.RequestCookieInterceptor;
import com.example.letschat.rest.Interceptors.ResponseCookieInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://mystoryblogs.herokuapp.com";

    public static Retrofit getRetrofitInstance(Context context) {
        // from https://medium.com/@dileepsattawan/how-to-handle-cookies-with-retrofit-in-android-8b1812178949
        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new RequestCookieInterceptor(context));
        builder.addInterceptor(new ResponseCookieInterceptor(context));
        client = builder.build();
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}

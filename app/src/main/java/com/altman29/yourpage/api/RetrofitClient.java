package com.altman29.yourpage.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Csy on 1/25/21.
 * e-mail:altman29@foxmail.com
 * Desc:
 */
public class RetrofitClient {
    private static final String BASE_URL = "https://api.github.com/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
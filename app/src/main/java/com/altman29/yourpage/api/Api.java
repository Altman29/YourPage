package com.altman29.yourpage.api;

import com.altman29.yourpage.entity.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Csy on 1/25/21.
 * e-mail:altman29@foxmail.com
 * Desc: api
 */
public interface Api {
    @GET("users/{userId}")
    Call<User> getUser(@Path("userId") String userId);
}

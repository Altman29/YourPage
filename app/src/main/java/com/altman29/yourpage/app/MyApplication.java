package com.altman29.yourpage.app;

import android.app.Application;

import com.altman29.yourpage.api.Api;
import com.altman29.yourpage.api.RetrofitClient;
import com.altman29.yourpage.database.UserDatabase;

/**
 * Created by Csy on 1/25/21.
 * e-mail:altman29@foxmail.com
 * Desc: application 统一管理dao/retrofit对象
 */
public class MyApplication extends Application {
    private static UserDatabase userDatabase;
    private static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        userDatabase = UserDatabase.getInstance(this);
        api = RetrofitClient.getInstance().getApi();
    }

    public static UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public  static Api getApi() {
        return api;
    }
}

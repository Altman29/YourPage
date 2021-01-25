package com.altman29.yourpage.repository;

import android.os.AsyncTask;

import com.altman29.yourpage.api.Api;
import com.altman29.yourpage.database.UserDao;
import com.altman29.yourpage.entity.User;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Csy on 1/25/21.
 * e-mail:altman29@foxmail.com
 * Desc:
 */
public class UserRepository {
    private  String TAG = this.getClass().getName();
    private UserDao userDao;
    private Api api;

    public UserRepository(UserDao userDao, Api api) {
        this.userDao = userDao;
        this.api = api;
    }

    public LiveData<User> getUser(final  String name){
        refresh(name);
        return  userDao.getUserByName(name);
    }

    public void refresh(String name) {
        api.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!=null){
                    //存储到数据库中
                    insertUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }

    public void insertUser(User body) {
        //开启工作线程，插入数据到数据库
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(body);
            }
        });
    }
}

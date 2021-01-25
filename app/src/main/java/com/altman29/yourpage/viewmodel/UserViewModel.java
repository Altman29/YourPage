package com.altman29.yourpage.viewmodel;

import android.app.Application;

import com.altman29.yourpage.app.MyApplication;
import com.altman29.yourpage.database.UserDao;
import com.altman29.yourpage.database.UserDatabase;
import com.altman29.yourpage.entity.User;
import com.altman29.yourpage.repository.UserRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Created by Csy on 1/25/21.
 * e-mail:altman29@foxmail.com
 * Desc:
 */
public class UserViewModel  extends AndroidViewModel {
    private LiveData<User> user;
    private UserRepository userRepository;
    private  String userName = "MichaelYe";

    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase database = MyApplication.getUserDatabase();
        UserDao userDao = database.userDao();
        userRepository = new UserRepository(userDao,MyApplication.getApi());
        user = userRepository.getUser(userName);
    }

    public LiveData<User> getUser() {
        return user;
    }
    public void  refresh(){
        userRepository.refresh(userName);
    }
}

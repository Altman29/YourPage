package com.altman29.yourpage.database;

import android.content.Context;

import com.altman29.yourpage.entity.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Csy on 1/22/21.
 * e-mail:altman29@foxmail.com
 * Desc: db
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "user_db";
    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getInstance(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class,
                    DATABASE_NAME)
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();
}

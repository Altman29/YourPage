package com.altman29.yourpage.database;

import com.altman29.yourpage.entity.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by Csy on 1/22/21.
 * e-mail:altman29@foxmail.com
 * Desc: Dao by room
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteStudent(User user);

    @Query("SELECT * FROM user WHERE name=:name")
    LiveData<User> getUserByName(String name);
}
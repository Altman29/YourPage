package com.altman29.yourpage.entity;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Csy on 1/22/21.
 * e-mail:altman29@foxmail.com
 * Desc: User entity
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "avator", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar_url")
    public String avatar;

    @ColumnInfo(name = "followers", typeAffinity = ColumnInfo.INTEGER)
    public int followers;

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    public int following;

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    public String blog;

    @ColumnInfo(name = "company", typeAffinity = ColumnInfo.TEXT)
    public String company;

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    public String bio;

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    public String location;

    @ColumnInfo(name = "htmlUrl", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("html_url")
    public String htmlUrl;

    public User(int id, String name, String avatar, int followers, int following, String blog, String company, String bio, String location, String htmlUrl) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.followers = followers;
        this.following = following;
        this.blog = blog;
        this.company = company;
        this.bio = bio;
        this.location = location;
        this.htmlUrl = htmlUrl;
    }
}
package com.wezom.moxysample.ui.data.database.model;

import com.wezom.moxysample.ui.api.model.User;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by usik.a on 09.12.2016.
 */

public class UserModel extends RealmObject {

    @PrimaryKey
    public Integer userId;
    public Integer id;
    public String title;
    public String body;

    public UserModel() {
    }

    public UserModel(User user) {
        this.userId = user.getUserId();
        this.id = user.getId();
        this.title = user.getTitle();
        this.body = user.getBody();
    }
}

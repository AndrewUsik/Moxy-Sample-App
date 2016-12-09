package com.wezom.moxysample.ui.data.database;

import com.wezom.moxysample.ui.api.model.User;
import com.wezom.moxysample.ui.data.database.model.UserModel;

/**
 * Created by usik.a on 09.12.2016.
 */

public class DBConverter {


    public static User convertToUser(UserModel model) {
        User user = new User();
        user.setId(model.id);
        user.setUserId(model.userId);
        user.setBody(model.body);
        user.setTitle(model.title);

        return user;
    }
}

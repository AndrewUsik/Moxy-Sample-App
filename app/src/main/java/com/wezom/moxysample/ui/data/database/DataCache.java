package com.wezom.moxysample.ui.data.database;

import com.wezom.moxysample.ui.api.model.User;

/**
 * Created by usik.a on 09.12.2016.
 */

public interface DataCache {

    void clear();

    void saveUser(User user);

    User getUser(int userId);

}

package com.wezom.moxysample.ui.data.database;

import com.wezom.moxysample.ui.api.model.User;

/**
 * Created by usik.a on 09.12.2016.
 */

public class MemoryCache implements DataCache {
    DBManager dbManager;

    public MemoryCache(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void clear() {
        dbManager.clear();
    }

    @Override
    public void saveUser(User user) {
        dbManager.saveUser(user);
    }

    @Override
    public User getUser(int userId) {
      return dbManager.getUser(userId);

    }
}

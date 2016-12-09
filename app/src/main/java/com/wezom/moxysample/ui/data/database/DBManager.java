package com.wezom.moxysample.ui.data.database;

import com.wezom.moxysample.ui.api.model.User;
import com.wezom.moxysample.ui.data.database.model.UserModel;

import io.realm.Realm;


/**
 * Created by usik.a on 09.12.2016.
 */

public class DBManager {
    private Realm realm;

    public DBManager(Realm realm) {
        this.realm = realm;
    }

    public void clear() {
        realm.executeTransaction(realm -> realm.deleteAll());
    }

    public void saveUser(User user) {
        realm.executeTransaction(realm -> realm.copyToRealmOrUpdate(new UserModel(user)));
    }

    public User getUser(int userId) {
        UserModel result = realm.where(UserModel.class)
                .equalTo("userId", userId)
                .findFirst();

        if (result == null) {
            return null;
        }

        return DBConverter.convertToUser(result);


    }
}

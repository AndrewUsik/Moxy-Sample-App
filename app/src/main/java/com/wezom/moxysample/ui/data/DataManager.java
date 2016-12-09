package com.wezom.moxysample.ui.data;

import com.wezom.moxysample.ui.api.ApiManager;
import com.wezom.moxysample.ui.api.model.User;
import com.wezom.moxysample.ui.data.database.DataCache;
import com.wezom.moxysample.ui.utils.RxUtils;

import io.reactivex.Observable;

/**
 * Created by usik.a on 09.12.2016.
 */

public class DataManager {

    private ApiManager apiManager;
    private DataCache dataCache;

    public DataManager(ApiManager apiManager, DataCache dataCache) {
        this.apiManager = apiManager;
        this.dataCache = dataCache;
    }

    public Observable<User> getUser(int id, boolean update) {
        User user = dataCache.getUser(id);
        if (!(user == null || update)) {
            return Observable.just(user);
        }

        return apiManager.getUser(id)
                .compose(RxUtils.applyIOToMainThreadSchedulers())
                .doOnNext(user1 -> dataCache.saveUser(user1));
    }
}

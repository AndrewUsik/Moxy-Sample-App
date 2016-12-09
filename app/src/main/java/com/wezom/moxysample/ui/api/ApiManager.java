package com.wezom.moxysample.ui.api;

import com.wezom.moxysample.ui.api.model.User;
import com.wezom.moxysample.ui.utils.RxUtils;

import io.reactivex.Observable;

/**
 * Created by usik.a on 09.12.2016.
 */

public class ApiManager {

    ApiService apiService;

    public ApiManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<User> getUser(int id) {
        return apiService.getUsers(id)
                .compose(RxUtils.applyIOToMainThreadSchedulers());
    }
}

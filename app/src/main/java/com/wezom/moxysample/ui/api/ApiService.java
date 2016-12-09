package com.wezom.moxysample.ui.api;

import com.wezom.moxysample.ui.api.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by usik.a on 09.12.2016.
 */

public interface ApiService {

    @GET("/posts/{id}")
    Observable<User> getUsers(@Path("id") int id);
}

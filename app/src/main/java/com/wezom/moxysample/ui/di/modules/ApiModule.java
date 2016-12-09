package com.wezom.moxysample.ui.di.modules;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wezom.moxysample.ui.api.ApiManager;
import com.wezom.moxysample.ui.api.ApiService;
import com.wezom.moxysample.ui.utils.Constants;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class ApiModule {

    private static final int DISK_CACHE_SIZE = 10 * 1024 * 1024;

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public ApiManager provideApiManager(ApiService service) {
        return new ApiManager(service);
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Context context) {
        return createOkHttpClient(context);
    }

    private static OkHttpClient createOkHttpClient(Context context) {
        File cacheDir = new File(context.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }
}

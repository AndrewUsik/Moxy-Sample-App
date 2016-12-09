package com.wezom.moxysample.ui.di.modules;

import android.content.Context;

import com.wezom.moxysample.ui.api.ApiManager;
import com.wezom.moxysample.ui.application.MoxySampleApplication;
import com.wezom.moxysample.ui.data.DataManager;
import com.wezom.moxysample.ui.data.database.DBManager;
import com.wezom.moxysample.ui.data.database.DataCache;
import com.wezom.moxysample.ui.data.database.MemoryCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by usik.a on 09.12.2016.
 */

@Module(includes = {ApiModule.class})
public class DataModule {

    @Provides
    @Singleton
    public DataCache provideMemoryCache(DBManager databaseManager) {
        return new MemoryCache(databaseManager);
    }

    @Provides
    @Singleton
    public DBManager provideDatabaseManager() {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .inMemory()
                .build();
        Realm instance = Realm.getInstance(config);
        return new DBManager(instance);
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(ApiManager apiManager,
                                          DataCache memoryCache) {
        return new DataManager(apiManager, memoryCache);
    }

}

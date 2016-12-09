package com.wezom.moxysample.ui.application;

import android.app.Application;

import com.wezom.moxysample.ui.di.component.ApplicationComponent;
import com.wezom.moxysample.ui.di.component.DaggerApplicationComponent;
import com.wezom.moxysample.ui.di.modules.BusModule;
import com.wezom.moxysample.ui.di.modules.ContextModule;
import com.wezom.moxysample.ui.di.modules.DataModule;

import io.realm.Realm;
import timber.log.Timber;


public class MoxySampleApplication extends Application {
    private static ApplicationComponent mApplicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        Realm.init(this);
        createApplicationComponent();
        Timber.plant(new Timber.DebugTree());
        super.onCreate();
    }

    private void createApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .busModule(new BusModule())
                .dataModule(new DataModule())
                .build();
    }
}

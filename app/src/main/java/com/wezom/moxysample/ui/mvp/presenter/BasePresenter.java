package com.wezom.moxysample.ui.mvp.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.wezom.moxysample.ui.application.MoxySampleApplication;
import com.wezom.moxysample.ui.di.component.ApplicationComponent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;



public class BasePresenter <View extends MvpView> extends MvpPresenter<View> {
    CompositeDisposable disposables = new CompositeDisposable();

    protected void unsubscribeOnDestroy(@NonNull Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    ApplicationComponent getAppComponent() {
        return MoxySampleApplication.getApplicationComponent();
    }
}
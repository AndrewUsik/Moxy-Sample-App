package com.wezom.moxysample.ui.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.wezom.moxysample.ui.data.DataManager;
import com.wezom.moxysample.ui.mvp.view.TestFragmentView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * Created: Zorin A.
 * Date: 17.11.2016.
 */
@InjectViewState
public class TestFragmentPresenter extends BasePresenter<TestFragmentView> {
    @Inject
    Context context;
    @Inject
    EventBus bus;
    @Inject
    DataManager dataManager;


    public TestFragmentPresenter() {
        getAppComponent().inject(this);
    }

    public void onClick() {
        getViewState().showMessage("Test Fragment clicked!");
    }

    public void showMessage(String message) {
        getViewState().showMessage(message);
    }

    public void getUser() {
        Disposable disposable = dataManager.getUser(1, false)
                .subscribe(user -> {
                            getViewState().showMessage("User id : " + user.getUserId());
                        },
                        throwable -> {
                            Timber.e("Get User Error %s", throwable);
                            getViewState().showMessage("Server Error!");
                        });
        unsubscribeOnDestroy(disposable);
    }
}

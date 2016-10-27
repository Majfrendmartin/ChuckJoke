package com.wildeastcoders.chuckjoke;

import android.app.Application;

import com.wildeastcoders.chuckjoke.injectior.component.AppComponent;
import com.wildeastcoders.chuckjoke.injectior.component.DaggerAppComponent;
import com.wildeastcoders.chuckjoke.injectior.module.AppModule;

/**
 * Created by Majfrendmartin on 2016-10-25.
 */

public class ChuckJokeApplication extends Application {

    public static final String INJECTION_LOG_TAG = "INJECTION_LOG_TAG";

    private static ChuckJokeApplication instance = new ChuckJokeApplication();
    private AppComponent appComponent;

    public static ChuckJokeApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        return appComponent;
    }
}

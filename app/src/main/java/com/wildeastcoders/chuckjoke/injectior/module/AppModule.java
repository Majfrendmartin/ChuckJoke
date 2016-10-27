package com.wildeastcoders.chuckjoke.injectior.module;

import android.content.Context;
import android.util.Log;

import com.wildeastcoders.chuckjoke.ChuckJokeApplication;
import com.wildeastcoders.chuckjoke.injectior.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

import static com.wildeastcoders.chuckjoke.ChuckJokeApplication.INJECTION_LOG_TAG;

/**
 * Created by Majfrendmartin on 2016-10-25.
 */
@Module
public class AppModule {
    private final ChuckJokeApplication application;

    public AppModule(ChuckJokeApplication application) {
        this.application = application;
    }

    @Provides
    @PerApplication
    public Context provideContext() {
        Log.d(INJECTION_LOG_TAG, "Context Injection");
        return application;
    }
}

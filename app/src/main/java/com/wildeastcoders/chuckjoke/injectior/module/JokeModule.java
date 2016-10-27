package com.wildeastcoders.chuckjoke.injectior.module;

import android.util.Log;

import com.wildeastcoders.chuckjoke.injectior.scope.PerActivity;
import com.wildeastcoders.chuckjoke.injectior.scope.PerApplication;
import com.wildeastcoders.chuckjoke.presenter.JokePresenter;
import com.wildeastcoders.chuckjoke.repositoty.Repository;
import com.wildeastcoders.chuckjoke.usecase.FetchJokeUsecase;

import dagger.Module;
import dagger.Provides;

import static com.wildeastcoders.chuckjoke.ChuckJokeApplication.INJECTION_LOG_TAG;

/**
 * Created by Majfrendmartin on 2016-10-25.
 */
@Module
public class JokeModule {

    @Provides
    @PerActivity
    public FetchJokeUsecase provideGetJokeUsecase(Repository repository) {
        Log.d(INJECTION_LOG_TAG, "FetchJokeUsecase Injection");
        return new FetchJokeUsecase(repository);
    }

    @Provides
    @PerActivity
    public JokePresenter provideJokePresenter(FetchJokeUsecase fetchJokeUsecase) {
        Log.d(INJECTION_LOG_TAG, "JokePresenter Injection");
        return new JokePresenter(fetchJokeUsecase);
    }
}

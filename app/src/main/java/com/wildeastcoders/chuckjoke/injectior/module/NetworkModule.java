package com.wildeastcoders.chuckjoke.injectior.module;

import android.util.Log;

import com.wildeastcoders.chuckjoke.injectior.scope.PerApplication;
import com.wildeastcoders.chuckjoke.repository.Repository;
import com.wildeastcoders.chuckjoke.repository.RepositoryImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wildeastcoders.chuckjoke.ChuckJokeApplication.INJECTION_LOG_TAG;

/**
 * Created by Majfrendmartin on 2016-10-26.
 */

@Module
public class NetworkModule {

    public static final String BASE_URL = "http://api.icndb.com/";

    @Provides
    @PerApplication
    Retrofit provideRetrofit() {
        Log.d(INJECTION_LOG_TAG, "Retrofit Injection");
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @PerApplication
    Repository provideRepository(Retrofit retrofit) {
        Log.d(INJECTION_LOG_TAG, "Repository Injection");
        return new RepositoryImpl(retrofit);
    }



}

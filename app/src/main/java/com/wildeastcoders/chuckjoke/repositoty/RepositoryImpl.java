package com.wildeastcoders.chuckjoke.repositoty;

import com.wildeastcoders.chuckjoke.model.Joke;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Majfrendmartin on 2016-10-26.
 */

public class RepositoryImpl implements Repository {

    private final IcndbApi icndbApi;

    public RepositoryImpl(Retrofit retrofit) {
        icndbApi = retrofit.create(IcndbApi.class);
    }

    @Override
    public Observable<ResponseWrapper<Joke>> getJoke(String firstName, String lastName) {
        return icndbApi.generateJoke(firstName, lastName);
    }
}

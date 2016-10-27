package com.wildeastcoders.chuckjoke.usecase;

import com.wildeastcoders.chuckjoke.model.Joke;
import com.wildeastcoders.chuckjoke.repositoty.IcndbApi;
import com.wildeastcoders.chuckjoke.repositoty.Repository;
import com.wildeastcoders.chuckjoke.repositoty.ResponseWrapper;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Majfrendmartin on 2016-10-24.
 */

public class FetchJokeUsecase implements Usecase<Joke> {

    private final Repository repository;

    private String firstName;
    private String lastName;

    public FetchJokeUsecase(final Repository repository) {
        this.repository = repository;
    }

    public void init(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Observable<Joke> execute() {
        return repository.getJoke(firstName, lastName)
                .map(new Func1<ResponseWrapper<Joke>, Joke>() {
                    @Override
                    public Joke call(ResponseWrapper<Joke> jokeResponseWrapper) {
                        return jokeResponseWrapper.getValue();
                    }
                });
    }
}

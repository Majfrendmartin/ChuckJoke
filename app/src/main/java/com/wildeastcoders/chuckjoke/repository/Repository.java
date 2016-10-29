package com.wildeastcoders.chuckjoke.repository;

import com.wildeastcoders.chuckjoke.model.Joke;

import rx.Observable;

/**
 * Created by Majfrendmartin on 2016-10-24.
 */

public interface Repository {
    Observable<ResponseWrapper<Joke>> getJoke(String firstName, String lastName);
}

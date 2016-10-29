package com.wildeastcoders.chuckjoke.repository;

import com.wildeastcoders.chuckjoke.model.Joke;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Majfrendmartin on 2016-10-25.
 */

public interface IcndbApi {
    @GET("jokes/random?")
    Observable<ResponseWrapper<Joke>> generateJoke(@Query("firstName") String firstName, @Query("lastName") String lastName);
}

package com.wildeastcoders.chuckjoke.usecase;

import rx.Observable;

/**
 * Created by Majfrendmartin on 2016-10-24.
 */

public interface Usecase<T> {
    Observable<T> execute();
}

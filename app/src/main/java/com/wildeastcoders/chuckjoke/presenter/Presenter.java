package com.wildeastcoders.chuckjoke.presenter;

import com.wildeastcoders.chuckjoke.view.View;

/**
 * Created by Majfrendmartin on 2016-10-24.
 */

public interface Presenter<T extends View> {

    void onCreate();

    void onStart();

    void onStop();

    void onPause();

    void attachView(T view);

}

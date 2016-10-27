package com.wildeastcoders.chuckjoke.view;

import com.wildeastcoders.chuckjoke.model.Joke;

/**
 * Created by Majfrendmartin on 2016-10-24.
 */

public interface JokeView extends View {
    void showJoke(Joke joke);
    void showLoading();
    void showError(String message);
}

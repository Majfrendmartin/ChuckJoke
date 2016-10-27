package com.wildeastcoders.chuckjoke.presenter;

import android.text.TextUtils;

import com.wildeastcoders.chuckjoke.model.Joke;
import com.wildeastcoders.chuckjoke.usecase.FetchJokeUsecase;
import com.wildeastcoders.chuckjoke.view.JokeView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Majfrendmartin on 2016-10-24.
 */

public class JokePresenter implements Presenter<JokeView> {

    private Subscription getJokeSubscription;
    private JokeView jokeView;
    private FetchJokeUsecase fetchJokeUsecase;

    public JokePresenter(FetchJokeUsecase fetchJokeUsecase) {
        this.fetchJokeUsecase = fetchJokeUsecase;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (getJokeSubscription != null && !getJokeSubscription.isUnsubscribed()) {
            getJokeSubscription.unsubscribe();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(JokeView jokeView) {
        this.jokeView = jokeView;
    }

    public void onGenerateJokeButtonClicked(String name, String surname) {
        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(surname)) {
            name = "Chuck";
            surname = "Norris";
        }
        jokeView.showLoading();
        fetchJokeUsecase.init(name, surname);
        getJokeSubscription = fetchJokeUsecase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, Joke>() {
                    @Override
                    public Joke call(Throwable throwable) {
                        jokeView.showError(throwable.getMessage());
                        return null;
                    }
                })
                .subscribe(new Action1<Joke>() {
                    @Override
                    public void call(Joke joke) {
                        if (jokeView != null && joke != null) {
                            jokeView.showJoke(joke);
                        }
                    }
                });
    }
}

package com.wildeastcoders.chuckjoke.usecase;

import com.wildeastcoders.chuckjoke.model.Joke;
import com.wildeastcoders.chuckjoke.repository.Repository;
import com.wildeastcoders.chuckjoke.repository.ResponseWrapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Majfrendmartin on 2016-10-29.
 */
public class FetchJokeUsecaseTest {

    public static final String JOKE_JOKE = "JOKE JOKE";
    public static final String TYPE = "SUCCESS";
    @Mock
    private Repository repository;
    private FetchJokeUsecase fetchJokeUsecase;
    public static final String FIRST_NAME = "FN";
    public static final String LAST_NAME = "LN";
    private Observable<ResponseWrapper<Joke>> jokeMock;
    private Joke joke;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        fetchJokeUsecase = new FetchJokeUsecase(repository);
        final ResponseWrapper<Joke> responseWrapper = new ResponseWrapper<>();
        joke = new Joke();
        joke.setId(1);
        joke.setJoke(JOKE_JOKE);
        responseWrapper.setType(TYPE);
        responseWrapper.setValue(joke);
        jokeMock = Observable.just(responseWrapper);
        when(repository.getJoke(FIRST_NAME, LAST_NAME)).thenReturn(jokeMock);
    }

    @Test
    public void init() throws Exception {
        fetchJokeUsecase.init(FIRST_NAME, LAST_NAME);
        assertEquals("Name equal", FIRST_NAME, fetchJokeUsecase.firstName);
        assertEquals("LastName equal", LAST_NAME, fetchJokeUsecase.lastName);
    }

    @Test
    public void execute() throws Exception {
        fetchJokeUsecase.init(FIRST_NAME, LAST_NAME);
        final Observable<Joke> observable = fetchJokeUsecase.execute();
        verify(repository).getJoke(FIRST_NAME, LAST_NAME);
        assertNotNull(observable);
        final TestSubscriber<Joke> jokeTestSubscriber = new TestSubscriber<>();
        observable.subscribe(jokeTestSubscriber);
        jokeTestSubscriber.assertNoErrors();
        final List<Joke> onNextEvents = jokeTestSubscriber.getOnNextEvents();
        assertEquals(1, onNextEvents.size());
        assertEquals(joke, onNextEvents.get(0));
    }

}
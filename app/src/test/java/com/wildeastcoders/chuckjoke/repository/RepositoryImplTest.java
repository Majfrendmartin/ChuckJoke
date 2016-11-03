package com.wildeastcoders.chuckjoke.repository;

import com.wildeastcoders.chuckjoke.model.Joke;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Majfrendmartin on 2016-10-30.
 */
public class RepositoryImplTest {

    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String SUCCESS = "SUCCESS";
    public static final String JOKE = "JOKE_JOKE";

    @Mock
    IcndbApi icndbApi;

    @Mock
    Retrofit retrofit;

    private Joke joke;
    private ResponseWrapper<Joke> responseWrapper;
    private Repository repository;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        responseWrapper = new ResponseWrapper<>();
        responseWrapper.setType(SUCCESS);
        joke = new Joke();
        joke.setJoke(JOKE);
        joke.setId(1);
        responseWrapper.setValue(joke);
        when(icndbApi.generateJoke(FIRST_NAME, LAST_NAME)).thenReturn(Observable.just(responseWrapper));
        when(retrofit.create(IcndbApi.class)).thenReturn(icndbApi);
        repository = new RepositoryImpl(retrofit);
    }

    @Test
    public void getJoke() throws Exception {
        final Observable<ResponseWrapper<Joke>> observable = repository.getJoke(FIRST_NAME, LAST_NAME);
        final TestSubscriber<ResponseWrapper<Joke>> responseWrapperTestSubscriber = new TestSubscriber<>();
        observable.subscribe(responseWrapperTestSubscriber);
        final List<ResponseWrapper<Joke>> list = responseWrapperTestSubscriber.getOnNextEvents();
        assertEquals(1, list.size());
        assertEquals(responseWrapper, list.get(0));
    }

}
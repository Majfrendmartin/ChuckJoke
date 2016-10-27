package com.wildeastcoders.chuckjoke.injectior.component;

import com.wildeastcoders.chuckjoke.MainActivity;
import com.wildeastcoders.chuckjoke.injectior.module.JokeModule;
import com.wildeastcoders.chuckjoke.injectior.scope.PerActivity;

import dagger.Component;

/**
 * Created by Majfrendmartin on 2016-10-27.
 */

@PerActivity
@Component(
        dependencies = AppComponent.class,
        modules = JokeModule.class
)
public interface JokeComponent {
    void inject(MainActivity mainActivity);
}

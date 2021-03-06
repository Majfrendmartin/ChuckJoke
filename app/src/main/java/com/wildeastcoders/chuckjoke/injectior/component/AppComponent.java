package com.wildeastcoders.chuckjoke.injectior.component;

import com.wildeastcoders.chuckjoke.injectior.module.AppModule;
import com.wildeastcoders.chuckjoke.injectior.module.NetworkModule;
import com.wildeastcoders.chuckjoke.injectior.scope.PerApplication;
import com.wildeastcoders.chuckjoke.repository.Repository;

import dagger.Component;

/**
 * Created by Majfrendmartin on 2016-10-25.
 */

@PerApplication
@Component(modules = {
        AppModule.class,
//        JokeModule.class,
        NetworkModule.class
})
public interface AppComponent {
    Repository repository();
}

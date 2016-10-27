package com.wildeastcoders.chuckjoke.injectior.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Majfrendmartin on 2016-10-26.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}

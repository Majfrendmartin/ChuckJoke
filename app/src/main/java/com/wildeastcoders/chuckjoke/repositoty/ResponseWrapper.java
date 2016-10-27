package com.wildeastcoders.chuckjoke.repositoty;

/**
 * Created by Majfrendmartin on 2016-10-25.
 */

public class ResponseWrapper<T> {
    private T value;
    private String type;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

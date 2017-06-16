package com.camhub.antiochschool.helper;

/**
 * Created by darith on 6/16/17.
 */
public class Pair<T, E> {
    private T key;
    private E value;

    public Pair(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }
    public E getValue() {
        return value;
    }
}

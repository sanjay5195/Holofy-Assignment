package com.devsan.holofyassignment.dagger;

public interface BaseComponent<T> {

    void inject(T t);
}

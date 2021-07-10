package com.devsan.holofyassignment.data;

public interface DataResponseListener<T> {

    void onSuccess(T t);

    void onFailure(String message);
}

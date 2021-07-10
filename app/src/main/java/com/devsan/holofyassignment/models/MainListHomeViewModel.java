package com.devsan.holofyassignment.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devsan.holofyassignment.data.DataResponseListener;
import com.devsan.holofyassignment.data.MainListRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainListHomeViewModel extends ViewModel {

    private MainListRepository listRepository;

    public MutableLiveData<ArrayList<MediaVO>> dataList = new MutableLiveData<>();

    public MutableLiveData<String> messageError = new MutableLiveData<>();

    @Inject
    public MainListHomeViewModel(MainListRepository listRepository) {
        this.listRepository = listRepository;
        dataList.setValue(new ArrayList<>());
    }

    public void getMediaList() {

        listRepository.getMediaList(new DataResponseListener<ArrayList<MediaVO>>() {
            @Override
            public void onSuccess(ArrayList<MediaVO> mediaVOS) {

                dataList.setValue(mediaVOS);
            }

            @Override
            public void onFailure(String message) {

                messageError.setValue(message);
            }
        });
    }
}

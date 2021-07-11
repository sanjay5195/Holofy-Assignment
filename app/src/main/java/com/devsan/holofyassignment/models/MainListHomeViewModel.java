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

    // progress bucket we can use in future for show loader while fetching data from server
    public MutableLiveData<Integer> progressBucket = new MutableLiveData<>();

    @Inject
    public MainListHomeViewModel(MainListRepository listRepository) {
        this.listRepository = listRepository;
        dataList.setValue(new ArrayList<>());
        progressBucket.setValue(0);
    }

    public void getMediaList() {

        progressBucket.setValue(progressBucket.getValue() + 1);
        listRepository.getMediaList(new DataResponseListener<ArrayList<MediaVO>>() {
            @Override
            public void onSuccess(ArrayList<MediaVO> mediaVOS) {

                progressBucket.setValue(progressBucket.getValue() - 1);
                dataList.setValue(mediaVOS);
            }

            @Override
            public void onFailure(String message) {

                progressBucket.setValue(progressBucket.getValue() - 1);
                messageError.setValue(message);
            }
        });
    }
}

package com.devsan.holofyassignment.data;

import com.devsan.holofyassignment.models.MediaVO;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainListRepository {

    private LocalMainListDataSource localMainListDataSource;

    @Inject
    public MainListRepository(LocalMainListDataSource localMainListDataSource) {
        this.localMainListDataSource = localMainListDataSource;
    }

    public void getMediaList(DataResponseListener<ArrayList<MediaVO>> listener) {
        localMainListDataSource.getMediaList(listener);
    }
}

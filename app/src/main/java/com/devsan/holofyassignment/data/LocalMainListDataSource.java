package com.devsan.holofyassignment.data;

import android.webkit.JavascriptInterface;

import com.devsan.holofyassignment.models.MediaVO;
import com.devsan.holofyassignment.util.DBError;

import java.util.ArrayList;

import javax.inject.Inject;

public class LocalMainListDataSource {

    @Inject
    public LocalMainListDataSource() {
    }

    public void getMediaList(DataResponseListener<ArrayList<MediaVO>> listener) {

        ArrayList<MediaVO> mediaVOS = makeVideoList();

        if(!mediaVOS.isEmpty()) {

            listener.onSuccess(mediaVOS);
        } else {

            listener.onFailure(DBError.EMPTY_LIST.getName());
        }
    }

    private ArrayList<MediaVO> makeVideoList() {

        ArrayList<MediaVO> mediaVOS = new ArrayList<>();

        mediaVOS.add(new MediaVO("Sending Data to a New Activity with Intent Extras",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png",
                "Description for media object #1"));

        mediaVOS.add( new MediaVO("MVVM and LiveData",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/MVVM+and+LiveData+for+youtube.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/mvvm+and+livedata.png",
                "Description for media object #3"));

        return mediaVOS;
    }
}

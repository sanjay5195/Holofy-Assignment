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
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "https://upload.wikimedia.org/wikipedia/commons/e/e4/Elephants_Dream_s5_proog.jpg",
                "Description for media object #1"));

        mediaVOS.add( new MediaVO("MVVM and LiveData",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/MVVM+and+LiveData+for+youtube.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/mvvm+and+livedata.png",
                "Description for media object #3 It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."));

        mediaVOS.add(new MediaVO("Sending Data to a New Activity with Intent Extras",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png",
                "Description for media object #1"));

        return mediaVOS;
    }
}

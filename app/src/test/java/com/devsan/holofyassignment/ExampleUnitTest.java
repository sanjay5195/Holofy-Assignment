package com.devsan.holofyassignment;

import com.devsan.holofyassignment.data.DataResponseListener;
import com.devsan.holofyassignment.data.LocalMainListDataSource;
import com.devsan.holofyassignment.models.MediaVO;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.OptionalInt.empty;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test public void checkVideoList() {

        LocalMainListDataSource dataSource = new LocalMainListDataSource();
        dataSource.getMediaList(new DataResponseListener<ArrayList<MediaVO>>() {
            @Override
            public void onSuccess(ArrayList<MediaVO> mediaVOS) {
                assertFalse(mediaVOS.isEmpty());
            }

            @Override
            public void onFailure(String message) {
                System.out.print("Listener failed with : " + message);
            }
        });
    }
}
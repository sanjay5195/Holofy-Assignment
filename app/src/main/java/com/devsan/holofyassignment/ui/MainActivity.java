package com.devsan.holofyassignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.devsan.holofyassignment.R;
import com.devsan.holofyassignment.adapter.VideoPlayerRecyclerAdapter;
import com.devsan.holofyassignment.models.MediaVO;
import com.devsan.holofyassignment.util.Resources;
import com.devsan.holofyassignment.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "image_url";
    public static final String EXTRA_SEEK = "seek";
    public static final String EXTRA_TRANSITION_NAME = "transition_name";

    private VideoPlayerRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);

        final ArrayList<MediaVO> mediaObjects = new ArrayList<MediaVO>(Arrays.asList(Resources.MEDIA_OBJECTS));
        mRecyclerView.setMediaObjects(mediaObjects);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjects, initGlide(),
                new VideoPlayerRecyclerAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int pos,
                                            MediaVO mediaObject,
                                            LinearLayout linearLayout) {

                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtra(EXTRA_ITEM, mediaObject);
                        intent.putExtra(EXTRA_SEEK, mRecyclerView.seekPosition);
                        intent.putExtra(EXTRA_TRANSITION_NAME, ViewCompat.getTransitionName(linearLayout));

                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                MainActivity.this,
                                linearLayout,
                                ViewCompat.getTransitionName(linearLayout));

                        startActivity(intent, options.toBundle());
                    }
                });
        mRecyclerView.setAdapter(adapter);
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if (mRecyclerView != null)
            mRecyclerView.releasePlayer();
        super.onDestroy();
    }
}
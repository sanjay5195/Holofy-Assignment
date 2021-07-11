package com.devsan.holofyassignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.devsan.holofyassignment.R;
import com.devsan.holofyassignment.adapter.VideoPlayerRecyclerAdapter;
import com.devsan.holofyassignment.dagger.DaggerMainListComponent;
import com.devsan.holofyassignment.dagger.MainListComponent;
import com.devsan.holofyassignment.dagger.MainListModule;
import com.devsan.holofyassignment.databinding.ActivityMainBinding;
import com.devsan.holofyassignment.models.MainListHomeViewModel;
import com.devsan.holofyassignment.models.MediaVO;
import com.devsan.holofyassignment.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "image_url";
    public static final String EXTRA_SEEK = "seek";
    public static final String EXTRA_TRANSITION_NAME = "transition_name";

    @Inject
    MainListHomeViewModel viewModel;

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        MainListComponent mainListComponent = DaggerMainListComponent.builder()
                .mainListModule(new MainListModule(this))
                .build();
        mainListComponent.inject(this);

        observViewModel();
        viewModel.getMediaList();
    }

    private void observViewModel() {

        viewModel.messageError.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                if (s != null && !s.isEmpty()) {

                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.dataList.observe(this, new Observer<ArrayList<MediaVO>>() {
            @Override
            public void onChanged(ArrayList<MediaVO> mediaVOS) {

                if (!mediaVOS.isEmpty()) {
                    initRecyclerView();
                }
            }
        });
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        activityMainBinding.recyclerView.addItemDecoration(itemDecorator);

        final ArrayList<MediaVO> mediaObjects = viewModel.dataList.getValue();
        activityMainBinding.recyclerView.setMediaObjects(mediaObjects);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjects, initGlide(),
                new VideoPlayerRecyclerAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int pos,
                                            MediaVO mediaObject,
                                            LinearLayout linearLayout) {

                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtra(EXTRA_ITEM, mediaObject);
                        intent.putExtra(EXTRA_SEEK, activityMainBinding.recyclerView.seekPosition);
                        intent.putExtra(EXTRA_TRANSITION_NAME, ViewCompat.getTransitionName(linearLayout));

                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                MainActivity.this,
                                linearLayout,
                                ViewCompat.getTransitionName(linearLayout));

                        startActivity(intent, options.toBundle());
                    }
                });
        activityMainBinding.recyclerView.setAdapter(adapter);
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
        if (activityMainBinding.recyclerView != null)
            activityMainBinding.recyclerView.releasePlayer();
        super.onDestroy();
    }
}
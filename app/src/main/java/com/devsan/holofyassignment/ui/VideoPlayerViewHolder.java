package com.devsan.holofyassignment.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devsan.holofyassignment.R;
import com.devsan.holofyassignment.models.MediaVO;


public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {

    FrameLayout media_container;
    public LinearLayout linearLayoutContainer;
    TextView  textViewTitle, textViewSubTitle;
    ImageView thumbnail, volumeControl;
    ProgressBar progressBar;
    View parent;
    RequestManager requestManager;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewSubTitle = itemView.findViewById(R.id.textViewSubTitle);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_control);
    }

    public void onBind(MediaVO mediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        textViewTitle.setText(mediaObject.getTitle());
        textViewSubTitle.setText(mediaObject.getDescription());
        this.requestManager
                .load(mediaObject.getThumbnail())
                .into(thumbnail);
    }

}















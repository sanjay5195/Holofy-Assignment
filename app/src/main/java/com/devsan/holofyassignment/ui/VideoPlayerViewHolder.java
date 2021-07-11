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
import com.devsan.holofyassignment.databinding.ItemLayoutVideoBinding;
import com.devsan.holofyassignment.models.MediaVO;


public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {

    RequestManager requestManager;
    View parent;
    public ItemLayoutVideoBinding itemLayoutVideoBinding;

    public VideoPlayerViewHolder(@NonNull ItemLayoutVideoBinding videoBinding) {
        super(videoBinding.getRoot());
        parent = videoBinding.getRoot();
        itemLayoutVideoBinding = videoBinding;
    }

    public void onBind(MediaVO mediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        itemLayoutVideoBinding.textViewTitle.setText(mediaObject.getTitle());
        itemLayoutVideoBinding.textViewSubTitle.setText(mediaObject.getDescription());
        this.requestManager
                .load(mediaObject.getThumbnail())
                .into(itemLayoutVideoBinding.thumbnail);
    }

}















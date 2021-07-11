package com.devsan.holofyassignment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devsan.holofyassignment.R;
import com.devsan.holofyassignment.databinding.ItemLayoutVideoBinding;
import com.devsan.holofyassignment.models.MediaVO;
import com.devsan.holofyassignment.ui.VideoPlayerViewHolder;

import java.util.ArrayList;


public class VideoPlayerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MediaVO> mediaObjects;
    private RequestManager requestManager;

    private ItemClickListener itemClickListener;

    public VideoPlayerRecyclerAdapter(ArrayList<MediaVO> mediaObjects,
                                      RequestManager requestManager,
                                      ItemClickListener itemClickListener) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemLayoutVideoBinding itemLayoutVideoBinding = DataBindingUtil
                .inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_layout_video, viewGroup, false);
        return new VideoPlayerViewHolder(itemLayoutVideoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        ((VideoPlayerViewHolder)viewHolder).onBind(mediaObjects.get(i), requestManager);

        final MediaVO mediaObject = mediaObjects.get(i);
        ((VideoPlayerViewHolder)viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListener.onItemClick(viewHolder.getAdapterPosition(),
                        mediaObject, ((VideoPlayerViewHolder)viewHolder).itemLayoutVideoBinding.linearLayoutContainer);
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }

    public interface ItemClickListener {
        void onItemClick(int pos, MediaVO mediaObject, LinearLayout linearlayout);
    }

}















package com.devsan.holofyassignment.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaVO implements Parcelable {

    private String title;
    private String thumbnail;
    private String description;
    private String mediaUrl;

    public MediaVO() {

    }

    public MediaVO(String title, String url, String thumbnail, String subTitle) {

        this.title = title;
        this.mediaUrl = url;
        this.thumbnail = thumbnail;
        this.description = subTitle;

    }

    protected MediaVO(Parcel in) {
        title = in.readString();
        thumbnail = in.readString();
        description = in.readString();
        mediaUrl = in.readString();
    }

    public static final Creator<MediaVO> CREATOR = new Creator<MediaVO>() {
        @Override
        public MediaVO createFromParcel(Parcel in) {
            return new MediaVO(in);
        }

        @Override
        public MediaVO[] newArray(int size) {
            return new MediaVO[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(description);
        dest.writeString(mediaUrl);
    }
}

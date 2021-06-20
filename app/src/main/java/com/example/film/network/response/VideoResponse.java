package com.example.film.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoResponse {
    @SerializedName("items")
    private ArrayList<Item>  item;

    public VideoResponse(ArrayList<Item> item) {
        this.item = item;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public class Item {
        @SerializedName("id")
        private String id;
        @SerializedName("snippet")
        private Snippet snippet;

        public Item(String id, Snippet snippet) {
            this.id = id;
            this.snippet = snippet;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Snippet getSnippet() {
            return snippet;
        }

        public void setSnippet(Snippet snippet) {
            this.snippet = snippet;
        }
    }

    public class Snippet {
        @SerializedName("publishedAt")
        private String publishedAt;
        @SerializedName("channelId")
        private String channelId;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("thumbnails")
        private Thumbnails thumbnails;
        @SerializedName("resourceId")
        private resourceId resourceId;

        public Snippet(String publishedAt, String channelId, String title,
                       String description, Thumbnails thumbnails, VideoResponse.resourceId resourceId) {
            this.publishedAt = publishedAt;
            this.channelId = channelId;
            this.title = title;
            this.description = description;
            this.thumbnails = thumbnails;
            this.resourceId = resourceId;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }

        public void setThumbnails(Thumbnails thumbnails) {
            this.thumbnails = thumbnails;
        }

        public VideoResponse.resourceId getResourceId() {
            return resourceId;
        }

        public void setResourceId(VideoResponse.resourceId resourceId) {
            this.resourceId = resourceId;
        }
    }

    public class Thumbnails {
        @SerializedName("medium")
        private Img medium;
        @SerializedName("high")
        private Img high;
        @SerializedName("standard")
        private Img standard;

        public Img getMedium() {
            return medium;
        }

        public void setMedium(Img medium) {
            this.medium = medium;
        }

        public Img getHigh() {
            return high;
        }

        public void setHigh(Img high) {
            this.high = high;
        }

        public Img getStandard() {
            return standard;
        }

        public void setStandard(Img standard) {
            this.standard = standard;
        }

        public Thumbnails(Img medium, Img high, Img standard) {
            this.medium = medium;
            this.high = high;
            this.standard = standard;
        }
    }

    public class Img {
        @SerializedName("url")
        private String url;
        @SerializedName("width")
        private int width;
        @SerializedName("height")
        private int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Img(String url, int width, int height) {
            this.url = url;
            this.width = width;
            this.height = height;
        }
    }

    public class resourceId {
        @SerializedName("videoId")
        private String videoId;

        public resourceId(String videoId) {
            this.videoId = videoId;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }
    }
}

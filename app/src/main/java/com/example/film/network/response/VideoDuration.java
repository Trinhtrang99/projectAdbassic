package com.example.film.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoDuration {
    @SerializedName("items")
    private ArrayList<Items> item;

    public ArrayList<Items> getItem() {
        return item;
    }

    public void setItem(ArrayList<Items> item) {
        this.item = item;
    }

    public VideoDuration(ArrayList<Items> item) {
        this.item = item;
    }

    public class Items {
        @SerializedName("kind")
        private String kind;
        @SerializedName("etag")
        private String etag;
        @SerializedName("id")
        private String id;
        @SerializedName("contentDetails")
        private ContentDetails contentDetails;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getEtag() {
            return etag;
        }

        public void setEtag(String etag) {
            this.etag = etag;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ContentDetails getContentDetails() {
            return contentDetails;
        }

        public void setContentDetails(ContentDetails contentDetails) {
            this.contentDetails = contentDetails;
        }
    }

    public class ContentDetails {
        @SerializedName("duration")
        private String duration;
        @SerializedName("licensedContent")
        private String licensedContent;
        @SerializedName("caption")
        private String caption;
        @SerializedName("definition")
        private String definition;
        @SerializedName("contentRating")
        private String contentRating;
        @SerializedName("projection")
        private String projection;
        @SerializedName("dimension")
        private String dimension;

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLicensedContent() {
            return licensedContent;
        }

        public void setLicensedContent(String licensedContent) {
            this.licensedContent = licensedContent;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getDefinition() {
            return definition;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public String getContentRating() {
            return contentRating;
        }

        public void setContentRating(String contentRating) {
            this.contentRating = contentRating;
        }

        public String getProjection() {
            return projection;
        }

        public void setProjection(String projection) {
            this.projection = projection;
        }

        public String getDimension() {
            return dimension;
        }

        public void setDimension(String dimension) {
            this.dimension = dimension;
        }


    }


}

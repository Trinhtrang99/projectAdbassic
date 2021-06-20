package com.example.film.network;

import com.example.film.network.response.VideoDescription;
import com.example.film.network.response.VideoDuration;
import com.example.film.network.response.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("playlistItems")
    Call<VideoResponse> getVideo(@Query("part") String part, @Query("playlistId") String playlistId,
                                 @Query("key") String key, @Query("maxResults") String maxResults);

    @GET("videos")
    Call<VideoDuration> getDuration(@Query("id") String id, @Query("key") String key);

    @GET("videos")
    Call<VideoDescription> getDescription(@Query("part") String part, @Query("id") String id, @Query("key") String key);

      //  https://www.googleapis.com/youtube/v3/videos?
    // part=statistics&
    // id=9bZkp7q19f0
    // &key=AIzaSyCFi6Ctl4thP43H3PkOYJyV9ipOYDiSPAY
}

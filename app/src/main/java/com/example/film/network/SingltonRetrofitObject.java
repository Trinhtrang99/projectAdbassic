package com.example.film.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingltonRetrofitObject {
    private static SingltonRetrofitObject mInstance;
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    private static Retrofit retrofit;

    public SingltonRetrofitObject() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public synchronized SingltonRetrofitObject getmInstance() {
        if (mInstance == null) {
            mInstance = new SingltonRetrofitObject();
        }
        return mInstance;
    }

    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }
}

package com.example.film.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.film.R;
import com.example.film.databinding.LinefilmBinding;
import com.example.film.network.SingltonRetrofitObject;
import com.example.film.network.response.VideoDescription;
import com.example.film.network.response.VideoDuration;
import com.example.film.network.response.VideoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.film.Util.Util.API_KEY;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private ArrayList<VideoResponse.Item> list;
    private Context context;

    public FilmAdapter(ArrayList<VideoResponse.Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinefilmBinding v = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.linefilm, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {
        if (list.get(position).getSnippet().getThumbnails() != null) {
            Glide.with(context).load(list.get(position).getSnippet().getThumbnails().getStandard().getUrl()).into(holder.binding.imgFilm);
        }
        holder.binding.txtNamefile.setText(list.get(position).getSnippet().getTitle());
      //  getDuration(list.get(position).getSnippet().getResourceId().getVideoId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinefilmBinding binding;

        public ViewHolder(@NonNull LinefilmBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }

    private void getDuration(String id) {
        Call<VideoDuration> videoDurationCall = new SingltonRetrofitObject().getmInstance().getApi()
                .getDuration(id, API_KEY);
        videoDurationCall.enqueue(new Callback<VideoDuration>() {
            @Override
            public void onResponse(Call<VideoDuration> call, Response<VideoDuration> response) {

            }

            @Override
            public void onFailure(Call<VideoDuration> call, Throwable t) {

            }
        });
    }

    private void getDescription(String id) {
        Call<VideoDescription> videoDescriptionCall = new SingltonRetrofitObject().getmInstance().getApi()
                .getDescription("statistics", id, API_KEY);
        videoDescriptionCall.enqueue(new Callback<VideoDescription>() {
            @Override
            public void onResponse(Call<VideoDescription> call, Response<VideoDescription> response) {
                Log.d("kmfg", "ok");
            }

            @Override
            public void onFailure(Call<VideoDescription> call, Throwable t) {

            }
        });
    }
}

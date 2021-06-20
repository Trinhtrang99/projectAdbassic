package com.example.film.mainfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.film.R;
import com.example.film.SqlHelper.SqlHelper;
import com.example.film.adapter.FilmAdapter;
import com.example.film.databinding.FragmenthomeBinding;
import com.example.film.network.SingltonRetrofitObject;
import com.example.film.network.response.VideoDescription;
import com.example.film.network.response.VideoDuration;
import com.example.film.network.response.VideoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.film.Util.Util.API_KEY;

public class homeFragment extends Fragment {
    private FragmenthomeBinding binding;
    private ArrayList<VideoResponse.Item> list;
    private SqlHelper sqlHelper;
    private FilmAdapter adapter;

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragmenthome, container, false);
        getData();
        getList();
        for (int i = 0; i < list.size(); i++) {
            //  getDuration(list.get(i).getSnippet().getResourceId().getVideoId());
            //       Log.d("trangtranf",getDuration(list.get(i).getSnippet().getResourceId().getVideoId()).get(0).getId() );
        }
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        sqlHelper = new SqlHelper(getContext());

    }

    public void getList() {
        Call<VideoResponse> videoResponseCall = new SingltonRetrofitObject().getmInstance().getApi()
                .getVideo("snippet", "PLxu-S05deEMb_Vic6Jspjlc0n27GtwN_-",
                        "AIzaSyCFi6Ctl4thP43H3PkOYJyV9ipOYDiSPAY", "50");
        videoResponseCall.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                list.addAll(response.body().getItem());
                SetAdapter(list);
        //   sqlHelper.InsertFilmToAllFilm();
//                for (int i = 0; i < list.size(); i++) {
//                    Log.d("kmfg", "----------------------------" + i);
//                    getDuration(list.get(i).getSnippet().getResourceId().getVideoId());
//                    getDescription(list.get(i).getSnippet().getResourceId().getVideoId());
//                }
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {

            }
        });

    }

    private void SetAdapter(ArrayList<VideoResponse.Item> list) {
        adapter = new FilmAdapter(list, getContext());
        binding.rc.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        binding.rc.setLayoutManager(layoutManager1);
    }

    private void getData() {

        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://i.ytimg.com/vi/qFXd0gCycZ4/maxresdefault.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/cAa0wO1-1ls/maxresdefault.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/MOb-QsIAOLU/maxresdefault.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/qlhO7yLqYP0/maxresdefault.jpg");


        for (int i = 0; i < mangquangcao.size(); i++) {

            ImageView imageView = new ImageView(getActivity());
            Glide.with(getActivity()).load(mangquangcao.get(i)).into(imageView);

            //cho image tu can full
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            binding.Viewflipper.addView(imageView);
        }
        binding.Viewflipper.setFlipInterval(5000);
        binding.Viewflipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_right);
        binding.Viewflipper.setInAnimation(animation_slide_in);
        binding.Viewflipper.setOutAnimation(animation_slide_out);
    }

    private ArrayList<VideoDuration.Items> getDuration(String id) {
        ArrayList<VideoDuration.Items> listduration = new ArrayList<>();
        Call<VideoDuration> videoDurationCall = new SingltonRetrofitObject().getmInstance().getApi()
                .getDuration(id, API_KEY);
        videoDurationCall.enqueue(new Callback<VideoDuration>() {
            @Override
            public void onResponse(Call<VideoDuration> call, Response<VideoDuration> response) {
                listduration.addAll(response.body().getItem());
                Log.d("kmfgdu", listduration.size() + "");
            }

            @Override
            public void onFailure(Call<VideoDuration> call, Throwable t) {

            }
        });
        return listduration;
    }

    private ArrayList<VideoDescription.Items> getDescription(String id) {
        ArrayList<VideoDescription.Items> listdescrip = new ArrayList<>();
        Call<VideoDescription> videoDescriptionCall = new SingltonRetrofitObject().getmInstance().getApi()
                .getDescription("statistics", id, API_KEY);
        videoDescriptionCall.enqueue(new Callback<VideoDescription>() {
            @Override
            public void onResponse(Call<VideoDescription> call, Response<VideoDescription> response) {
                listdescrip.addAll(response.body().getItems());
                Log.d("kmfgdes", listdescrip.size() + "");
            }

            @Override
            public void onFailure(Call<VideoDescription> call, Throwable t) {

            }
        });
        return listdescrip;
    }

    private void addSql() {
        for (int i = 0; i < list.size(); i++) {
            Log.d("kmfg", "----------------------------");
            Log.d("KMFGduration", getDuration(list.get(i).getSnippet().getResourceId().getVideoId()).get(0).getId() + i);
            Log.d("KMFGdescription", getDescription(list.get(i).getSnippet().getResourceId().getVideoId()).get(0).getId() + i);
            Log.d("kmfglist", list.get(i).getId() + "");
            Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
        }
    }
}

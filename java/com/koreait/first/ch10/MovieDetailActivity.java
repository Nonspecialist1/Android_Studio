package com.koreait.first.ch10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.koreait.first.R;
import com.koreait.first.ch10.searchmoviemodel.ActorVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView tvMovieNm;
    private TextView tvMovieNmEn;
    private TextView tvShowTm;
    private RecyclerView rvActorList;
    private ActorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvMovieNm = findViewById(R.id.tvMovieNm);
        tvMovieNmEn = findViewById(R.id.tvMovieNmEn);
        tvShowTm = findViewById(R.id.tvShowTm);
        rvActorList = findViewById(R.id.rvActorList);
        // movieCd값을 MovieListActivity에서 전달 받는다.
        Intent intent = getIntent();
        String movieCd = intent.getStringExtra("movieCd");
        // Log.i("myLog", "detail - movieCd : " + movieCd);
        getData(movieCd);
        adapter = new ActorAdapter();
        rvActorList.findViewById(R.id.rvActorList);
        rvActorList.setAdapter(adapter);

    }
    private void getData(String movieCd){
        Retrofit rf = new Retrofit.Builder().baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                        .addConverterFactory(GsonConverterFactory.create()).build();

        KobisService service = rf.create(KobisService.class);
        final String KEY = "9d14acffe5158a1bc611c0ae1de942a7";
        Call<MovieInfoResultBodyVO> call = service.searchMovieInfo(KEY, movieCd);

        call.enqueue(new Callback<MovieInfoResultBodyVO>() {
            @Override
            public void onResponse(Call<MovieInfoResultBodyVO> call, Response<MovieInfoResultBodyVO> res) {
                if(res.isSuccessful()){
                    MovieInfoResultBodyVO vo = res.body();
                    MovieInfoVO movie = vo.getMovieInfoResult().getMovieInfo();

                    tvMovieNm.setText(movie.getMovieNm());
                    tvMovieNmEn.setText(movie.getMovieNmEn());
                    tvShowTm.setText(movie.getShowTm());
                    adapter.setList(movie.getActors());
                    adapter.notifyDataSetChanged();
                } else { Log.i("myLog", "통신 실패"); }
            }
            @Override
            public void onFailure(Call<MovieInfoResultBodyVO> call, Throwable t) {
                Log.i("myLog", "주소값 실패");
            }
        });


    }

}

class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyViewHolder> {
    private List<ActorVO> list;
    public void setList(List<ActorVO> list){ this.list = list; }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_actor, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(list.get(position));
    }
    @Override
    public int getItemCount() { return list == null ? 0 : list.size(); }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPeopleNm;
        TextView tvPeopleNmEn;
        TextView tvCast;
        TextView tvCastEn;

        public MyViewHolder(View v){
            super(v);
            tvPeopleNm = v.findViewById(R.id.tvPeopleNm);
            tvPeopleNmEn = v.findViewById(R.id.tvPeopleNmEn);
            tvCast = v.findViewById(R.id.tvCast);
            tvCastEn = v.findViewById(R.id.tvCastEn);
        }
        public void setItem(ActorVO vo){
            tvPeopleNm.setText(vo.getPeopleNm());
            tvPeopleNmEn.setText(vo.getPeopleNmEn());
            tvCast.setText(vo.getCast());
            tvCastEn.setText(vo.getCastEn());
        }
    }


}
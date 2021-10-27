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
import com.koreait.first.ch10.searchmoviemodel.MovieListResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieListResultVO;
import com.koreait.first.ch10.searchmoviemodel.MovieVO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private MovieListAdapter adapter;

    private final String KEY = "9d14acffe5158a1bc611c0ae1de942a7";
    private final String ITEM_PER_PAGE = "20";
    private int curPage = 1;

    private KobisService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Retrofit rf = new Retrofit.Builder().baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/").
                addConverterFactory(GsonConverterFactory.create()).build();
        service = rf.create(KobisService.class);

        rvList = findViewById(R.id.rvList);
        rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView rView, int newState) {
                super.onScrollStateChanged(rView, newState);
                if(!rView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE){
                    Log.i("myLog", "스크롤 끝 !");
                    getList();
                }
            }
        });

        adapter = new MovieListAdapter();
        rvList.setAdapter(adapter);
        getList();
    }
    private void getList(){
        Call<MovieListResultBodyVO> call = service.searchMovieList(KEY, ITEM_PER_PAGE, curPage++);

        call.enqueue(new Callback<MovieListResultBodyVO>() {
            @Override
            public void onResponse(Call<MovieListResultBodyVO> call, Response<MovieListResultBodyVO> res) {
                if(res.isSuccessful()){
                    MovieListResultBodyVO vo = res.body();
                    MovieListResultVO resultVO = vo.getMovieListResult();
                    List<MovieVO> list = resultVO.getMovieList();
                    //adapter에 하나씩 넣어준다
                    for(MovieVO movie : list){
                        adapter.addItem(movie);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    // 쿼리스트링이나 baseurl 끝부분이 잘못된 경우의 가능성
                }
            }
            @Override
            public void onFailure(Call<MovieListResultBodyVO> call, Throwable t) {
                //주소값 자체가 잘못되었을 가능성
            }
        });

    }

}

    /*
    public void addItem(List<MovieVO> vo) {
        list.add(vo);
        // for (MovieVO a : vo) {list = vo; }
    }
    */
class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private List<MovieVO> list = new ArrayList();
    public void addItem(MovieVO vo){ list.add(vo); } // 영화목록 다음 페이지도 불러오기위해 add 매소드 사용
    // public void setList(List<MovieVO> list){ this.list = list; }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final MovieVO obj = list.get(position); // 클로저 때문에 final 부여
        holder.setItem(obj);
        // MovieVO obj = list.get(position) get 매소드가 MovieVO 타입을 반환하므로 최상위 부모인 obj로 받을 수 있다.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieCd = obj.getMovieCd();

                Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
                intent.putExtra("movieCd", movieCd);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMovieNm;
        private TextView tvMovieNmEn;
        private TextView tvRepNationNm;
        private TextView tvRepGenreNm;

        public MyViewHolder(View v){
            super(v);
            tvMovieNm = v.findViewById(R.id.tvMovieNm);
            tvMovieNmEn = v.findViewById(R.id.tvMovieNmEn);
            tvRepNationNm = v.findViewById(R.id.tvRepNationNm);
            tvRepGenreNm = v.findViewById(R.id.tvRepGenreNm);
        }
        public void setItem(MovieVO vo){
            tvMovieNm.setText(vo.getMovieNm());
            tvMovieNmEn.setText(vo.getMovieNmEn());
            tvRepNationNm.setText(vo.getRepNationNm());
            tvRepGenreNm.setText(vo.getRepGenreNm());
        }
    }

}
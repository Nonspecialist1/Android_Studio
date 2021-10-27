package com.koreait.first.ch10;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.koreait.first.R;
import com.koreait.first.ch10.boxofficemodel.BoxOfficeResultBodyVO;
import com.koreait.first.ch10.boxofficemodel.BoxOfficeResultVO;
import com.koreait.first.ch10.boxofficemodel.BoxOfficeVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeeklyBoxOfficeActivity extends AppCompatActivity {
    private KobisBoxOfficeAdapter adapter;
    private RecyclerView rvList;

    private DatePicker dpTargetDt;
    private Retrofit rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_boxoffice);

        adapter = new KobisBoxOfficeAdapter();

        dpTargetDt = findViewById(R.id.dpTargetDt);
        rvList = findViewById(R.id.rvList);
        rvList.setAdapter(adapter);

        rf = new Retrofit.Builder().baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void network(String targetDt) {
        KobisService service = rf.create(KobisService.class);
        final String KEY = "9d14acffe5158a1bc611c0ae1de942a7";
        Call<BoxOfficeResultBodyVO> call = service.searchWeeklyBoxOfficeList(KEY, targetDt);

        call.enqueue(new Callback<BoxOfficeResultBodyVO>() {
            @Override
            public void onResponse(Call<BoxOfficeResultBodyVO> call, Response<BoxOfficeResultBodyVO> res) {
                if(res.isSuccessful()){
                    BoxOfficeResultBodyVO vo = res.body();
                    BoxOfficeResultVO resultVO = vo.getBoxOfficeResult();
                    List<BoxOfficeVO> list = resultVO.getWeeklyBoxOfficeList();

                    adapter.setList(list);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<BoxOfficeResultBodyVO> call, Throwable t) {

            }
        });
    }

    public void clkSearch(View v){
        int day = dpTargetDt.getDayOfMonth();
        int mon = dpTargetDt.getMonth() + 1;
        int year = dpTargetDt.getYear();

        String date = String.format("%s%02d%02d", year, mon, day);
        network(date);
        Log.i("myLog", date);
    }
}
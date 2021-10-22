package com.koreait.first.ch10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.koreait.first.R;
import com.koreait.first.Utils;

import java.util.List;

public class KobisBoxOfficeAdapter extends RecyclerView.Adapter<KobisBoxOfficeAdapter.MyViewHolder> {
    private List<BoxOfficeVO> list;
    public void setList(List<BoxOfficeVO> list){ this.list = list; }

    @NonNull
    @Override
    public KobisBoxOfficeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_daily_boxoffice, parent, false);
        return new KobisBoxOfficeAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KobisBoxOfficeAdapter.MyViewHolder holder, int position) {
        // DailyBoxOfficeVO vo = list.get(position);
        holder.setItem(list.get(position));
    }

    @Override
    public int getItemCount() { return list == null ? 0 : list.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvAudienceCnt;

        public MyViewHolder(View v){
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvAudienceCnt = v.findViewById(R.id.tvAudienceCnt);
        }
        public void setItem(BoxOfficeVO vo){
            tvTitle.setText(vo.getMovieNm());
            //TO-DO 관객수 설정
            /*
              int NumCnt = Integer.parseInt(vo.getAudiCnt());
              String NumCnt1 = NumberFormat.getInstance().format(NumCnt);
            */
            String NumComma = Utils.getNumberComma(vo.getAudiCnt());
            tvAudienceCnt.setText(NumComma + "명");

        }
    }

}

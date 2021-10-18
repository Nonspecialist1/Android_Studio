package com.koreait.first;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.LinkedList;
import java.util.List;

public class WriteActivity extends AppCompatActivity {

    private EditText etMsg;
    private Button btnSend;
    private RecyclerView rvList; // view 영역

    private List<String> msgList; // data
    private SimpleTextAdapter sta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        etMsg = findViewById(R.id.etMsg);
        btnSend = findViewById(R.id.btnSend);
        rvList = findViewById(R.id.rvList);

        msgList = new LinkedList<>();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvList.setLayoutManager(llm); // LinearLayout은 기본적으로 orientation이 vertical 위아래서 아래로 뷰단 형성

        sta = new SimpleTextAdapter(msgList);
        rvList.setAdapter(sta);

        /*
        // 1. 클래스 활용
        View.OnClickListener event2 = new MyOnClickListener(){
            btnSend.setOnClickListener(event2)
        }
        // 2. 변수 할당 필요
        View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
        btnSend.setOnClickListener(event);
        */
        // 3. 인터페이스는 객체화 불가능, 간단하게 implements 하는 것임 (가장 많이 사용하는 방법)
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //콜백 매소드
                String msg = etMsg.getText().toString();
                Log.i("myLog", msg);
                etMsg.setText("");
                msgList.add(msg);
                // sta.notifyDataSetChanged();
            }
        });

    }

    public void refresh(View v){
        sta.notifyDataSetChanged();
    }

}
/* 0. 클래스 먼저 만들기
class MyOnClickListener implements View.OnClickListener {
      @Override
      public void onClick(View v) {
          Log.i("myLog", "1111111");
      }
}
 */

class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.MyViewHolder> {

    private List<String> list;

    SimpleTextAdapter(List<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textview, parent, false);
        return new SimpleTextAdapter.MyViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i("myLog", "position : " + position);
        String str = list.get(position);
        holder.tvMsg.setText(str);
    }

    @Override
    public int getItemCount() {
        Log.i("myLog", "getItemCount : " + list.size());
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMsg;

        public MyViewHolder(View v){
            super(v);
            tvMsg = v.findViewById(R.id.tvMsg);
        }
    }

}




package com.koreait.first.ch07;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.koreait.first.R;
import com.koreait.first.Utils;

public class BookPersonActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private PersonAdapter adapter;

    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_person);

        adapter = new PersonAdapter();
        rvList = findViewById(R.id.rvList);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);
        // adapter.notifyDataSetChanged();
        /*
        Person p = new Person("홍길동 슈퍼맨", 20);
        adapter.addItem(p);
        adapter.addItem(p);
        adapter.addItem(p);
        adapter.notifyDataSetChanged();
        p.setName("원더우면"): // 값이 바뀌고 notifyDataSetChanged()했으므로 전부 원더우먼이 된다
        adapter.notifyDataSetChanged(); // notify는 이전 내용 다 지우고 새로 작성됨 -> 전부 원더우먼20살

        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        */

    }

    public void clkReg(View v){
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        int a = Utils.parseStringToInt(age);
        if(a == 0){
            Toast.makeText(this, "문제가 발생하였습니다.", Toast.LENGTH_LONG).show();
            return;
        } else {
            adapter.addItem(new Person(name, a));
            adapter.notifyDataSetChanged();
            etName.setText("");
            etAge.setText("");
        }
    }



}
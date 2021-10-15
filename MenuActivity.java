package com.koreait.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void moveToActivity(View v){
        int id = v.getId();
        Class c = null;
        //분기
        if(id == R.id.menuBtn1){
            c = MainActivity.class;
        } else if(id == R.id.menuBtn2){
            c = LinearActivity.class;
        } else if(id == R.id.menuBtn3){
            c = ConstraintActivity.class;
        }
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
    // 참고용, id 값으로 구분하지않을 때
    public void moveToActivityWithText(View v){
        TextView tv = (TextView)v;
        String text = (String)tv.getText();
        Log.i("myLog", text);
        // 분기
        Class c = null;
        switch (text){
            case "메인":
                c = MainActivity.class;
                break;
            case "리니어 레이아웃":
                c = LinearActivity.class;
                break;
            case "제약 레이아웃":
                c = ConstraintActivity.class;
                break;
        }
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
    public void call(View v){
        //네이버 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1111-2222"));
        startActivity(intent);
    }


}
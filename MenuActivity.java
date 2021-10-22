package com.koreait.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.koreait.first.ch07.BookPersonActivity;
import com.koreait.first.ch10.DailyOfficeActivity;
import com.koreait.first.ch10.WeeklyBoxOfficeActivity;
import com.koreait.first.picsum.PicsumActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    public void moveToActivity(View v){
        int id = v.getId();
        // Log.i("myLog", String.valueOf(id));
        Class c = null;
        //분기
        if(id == R.id.menuBtn1){
            c = MainActivity.class;
        } else if(id == R.id.menuBtn2){
            c = LinearActivity.class;
        } else if(id == R.id.menuBtn3){
            c = ConstraintActivity.class;
        } else if(id == R.id.menuBtn4){
            c = WriteActivity.class;
        } else if(id == R.id.menuBtn5){
            c = BookPersonActivity.class;
        } else if(id == R.id.menuBtn6){
            c = ImageViewActivity.class;
        } else if(id == R.id.menuBtn7){
            c = PicsumActivity.class;
        } else if(id == R.id.menuBtn8){
            c = DailyOfficeActivity.class;
        } else if(id == R.id.menuBtn9){
            c = WeeklyBoxOfficeActivity.class;
        }

        if(c == null){
            Snackbar.make(v, "준비중입니다.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
    // 참고용, id 값으로 구분하지않을 때
    /*
    public void moveToActivityWithText(View v){
        TextView tv = (TextView)v;
        String text = (String)tv.getText();

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
    */
    public void call(View v){
        //네이버 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:000-0000-0000"));
        startActivity(intent);
    }


}
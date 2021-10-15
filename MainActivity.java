package com.koreait.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
MVC 패턴 , 기능별로 분리해서 관리하는 것
M : Model (Data) - 클래스 안에 맴버필드랑 setter, getter만 있는애들
V : View (화면, xml) - 디자이너가 보는 파일
C : Controller (Logic, java)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 순서가 중요, super.~가 먼저 와야한다, this.로 하면 재귀호출(자기가 자신을 호출)로 무한루프에 빠짐
        setContentView(R.layout.activity_main); // 내가 원하는 xml 파일을 기입, R에 빨간줄 뜨면 에러찾기 힘듦
    }
    // 이벤트 연결(event binding) 버튼 클릭시 실행될 매소드 연결
    public void clkBtn(View v){
        // v.getText(); 는 View 객체가 getText() 매소드를 갖지 않으므로 에러
        Button btn = (Button)v;
        String btnText = (String)btn.getText();
        /*
        .. 두번 사용가능한 이유 - 체인기법, makeText 매소드가 Toast 주소값을 리턴함으로 주소값.show()인 것
        Toast toast = Toast.makeText(this, btnText + "를 클릭했어요.", Toast.LENGTH_LONG);
        toast.show();
        */
        Toast.makeText(this, btnText + "를 클릭했어요.", Toast.LENGTH_LONG).show();
    }
    public void ddd(View v){
        if(v instanceof TextView){ //v에 담겨있는 객체 주소값을 TextView 타입으로 저장할 수 있으면 true 없으면 false를 리턴하는 것
            TextView tv = (TextView)v;
            String val = (String)tv.getText();
            int inVal = Integer.parseInt(val);
            String parseStr = String.valueOf(++inVal);
            tv.setText(parseStr);
        }

        // CharSequence cs = tv.getText();
        // Toast.makeText(this, cs, Toast.LENGTH_LONG).show();

        // String str = (String) cs;
        // Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

}
package com.kitesoft.ex12toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onClick속성이 부여된 View가 클릭되면 자동으로
    //실행되는 메소드
    public void clickBtn(View v){

        //## 아래 1. 실습진행 후.... 버튼을 여러번 눌렀을 때 토스트가 밀리는 현상을 관찰한 후....... ###########
        //### 1.2 Toast 객체 생성가 null이 아니면 토스트가 이미 있는 상태여서 새로운 토스트가 대기했다가 보여짐. #########
        // 그래서 기존 토스트가 있으면 캔슬하도록...
//        if(t!=null){
//            t.cancel();
//            t=null;
//        }
        //##################################################################################################################

        //1. 토스트 객체 생성 [ new 키워드 대신에 makeText()메소드를 통해 토스트객체 생성 ]
        t= Toast.makeText( this , "clicked!!", Toast.LENGTH_SHORT);
        //토스트 객체를 만들었으니 화면에 보여주라는 기능메소드 호출!!
        t.show();


        //2. res/values/strings.xml안에 문자열을 작성하고 토스트에서 문자열 읽어와 보여주기
        t= Toast.makeText( this , R.string.text, Toast.LENGTH_SHORT);
        //토스트의 위치 지정 [ xOffset, yOffset : 첫번재 파라미터로 지정한 위치(Gravity.CENTER)에서 몇 픽셀 차이가 나도록 할 지 설정 ]
        t.setGravity(Gravity.CENTER, 0, -100);
        //토스트 보여주기
        t.show();


        //3. 토스트에 문자열이 아닌 원하는 모양의 View 보여주기
        // 빈 문자열을 가진 토스트객체 생성
        t= Toast.makeText(this, "", Toast.LENGTH_SHORT);

        // ### 3.1 Java언어로 View 객체 생성하는 방법  ###############
//        ImageView iv= new ImageView(this);
//        iv.setImageResource(android.R.drawable.ic_lock_silent_mode);
//
//        TextView tv= new TextView(this);
//        tv.setText("음소거");
//
//        LinearLayout layout= new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        layout.addView(iv);
//        layout.addView(tv);
//
//        t.setView(layout);
        //############################################################


        //### 3.2 XML로 View객체 생성하고 적용하기  ################################
        //layout폴더 안에 있는 toast.xml이라는 문서를 읽어서
        //View객체로 만들어(부풀려주는 inflate) 주는 객체를 Context로 부터 얻어오기
        LayoutInflater inflater= getLayoutInflater();
        View view= inflater.inflate(R.layout.toast, null);
        t.setView(view);

        t.setGravity(Gravity.CENTER, 0,0);
        t.show();
        //##########################################################################



    }
}

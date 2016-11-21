package com.semi.sopt_19th_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() { //다른 엑티비티로 전환
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class); //LoginActivity로 전환
                startActivity(intent);
                finish(); //activity 끝냄
            }
        }, 2000);
        /*  value.postDelayed(new Runnable(){내용},시간);
          -> 시간(ms)만큼 딜레이후에  지정한 엑티비티 실행
        {} 내용
         - public void run() 다른 엑티비티로 전환
         - LoginActivity로 전환
         -acticity 끝냄

         */
    }
}

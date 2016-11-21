package com.semi.sopt_19th_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);   // 이 Activity에서 어떤 xml을 보여줄건지 설정합니다.


        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {             // 핸들러가 일정시간 지연뒤 post 합니다.
            @Override
        

            public void run() { //다른 엑티비티로 전환
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class); //LoginActivity로 전환  // 다음에 불러올 class 파일을 지정합니다.

                startActivity(intent);
                finish(); //activity 끝냄
            }
        }, 2000);       // 2000의 단위를 ms로, 2초를 의미합니다.

        /*  value.postDelayed(new Runnable(){내용},시간);
          -> 시간(ms)만큼 딜레이후에  지정한 엑티비티 실행
        {} 내용
         - public void run() 다른 엑티비티로 전환
         - LoginActivity로 전환
         -acticity 끝냄

         */

    }
}

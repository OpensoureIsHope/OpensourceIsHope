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
            public void run() {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);    // 다음에 불러올 class 파일을 지정합니다.
                startActivity(intent);
                finish();
            }
        }, 2000);       // 2000의 단위를 ms로, 2초를 의미합니다.
    }
}

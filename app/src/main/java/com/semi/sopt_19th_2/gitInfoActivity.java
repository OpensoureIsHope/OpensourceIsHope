package com.semi.sopt_19th_2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class gitInfoActivity extends AppCompatActivity {
    int count;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gitInfo); // activity_gitInfo.xml을 가져온다.

        preImgArea = (LinearLayout)findViewById(R.id.preImgBtn);
        nextImgArea = (LinearLayout)findViewById(R.id.nextImgBtn); // 매핑
        myImageView = (ImageView)findViewById(R.id.myImage);
        registerBtn = (Button)findViewById(R.id.registerBtn);

        gitImage
    }
}

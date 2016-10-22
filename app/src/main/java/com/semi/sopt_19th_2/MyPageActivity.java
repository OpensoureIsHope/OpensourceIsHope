package com.semi.sopt_19th_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPageActivity extends AppCompatActivity {

    ImageView myImgView;
    TextView textViewId;
    TextView textViewPwd;
    TextView textViewName;
    TextView textViewMajor;
    TextView textViewPart;
    TextView textViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);


        myImgView = (ImageView)findViewById(R.id.myImage);
        textViewId = (TextView)findViewById(R.id.userId);
        textViewPwd = (TextView)findViewById(R.id.userPwd);
        textViewName = (TextView)findViewById(R.id.userName);
        textViewMajor = (TextView)findViewById(R.id.userMajor);
        textViewPart = (TextView)findViewById(R.id.userPart);
        textViewGender = (TextView)findViewById(R.id.userGender);

        Intent getData = getIntent();
        String id = getData.getExtras().getString("id");
        String pwd = getData.getExtras().getString("pwd");
        String name = getData.getExtras().getString("name");
        String major = getData.getExtras().getString("major");
        String part = getData.getExtras().getString("part");
        String gender = getData.getExtras().getString("gender");
        String img = getData.getExtras().getString("img");

        if(img.equals("0"))
            myImgView.setImageResource(R.drawable.ic__teach_mypage);
        else if(img.equals("0"))
            myImgView.setImageResource(R.drawable.ic_ready_mypage);
        else
            myImgView.setImageResource(R.drawable.ic_hobby_mypage);

        textViewId.setText(id);
        textViewPwd.setText(pwd);
        textViewName.setText(name);
        textViewMajor.setText(major);
        textViewPart.setText(part);
        textViewGender.setText(gender);

    }
}

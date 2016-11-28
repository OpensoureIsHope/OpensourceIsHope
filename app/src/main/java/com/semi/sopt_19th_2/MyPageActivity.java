package com.semi.sopt_19th_2;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.semi.sopt_19th_2.Database.DbOpenHelper;
import com.semi.sopt_19th_2.Database.ItemData;

import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {
    private DbOpenHelper mDbOpenHelper;
    Cursor cursor = null;
    String[] arr = null;
    ImageView myImgView;
    TextView textViewId;
    TextView textViewPwd;
    TextView textViewName;
    TextView textViewMajor;
    TextView textViewPart;
    TextView textViewGender;
    TextView textViewTest;
    ItemData listViewItem = new ItemData();
    private ArrayList<ItemData> itemDatas = null;

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
        textViewTest = (TextView)findViewById(R.id.c);
        mDbOpenHelper = new DbOpenHelper(MyPageActivity.this);
        try {
            mDbOpenHelper.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mDbOpenHelper.DbSelectJoin();


        Intent getData = getIntent(); //imageselectactivity에서 넘겨온 인텐트 객체를 참조하기위해
        String id = getData.getExtras().getString("id"); //받아온 내용 대입.(minhang7)
        String pwd = getData.getExtras().getString("pwd");// (123123)
        String name = getData.getExtras().getString("name");
        String major = getData.getExtras().getString("major");
        String gender = getData.getExtras().getString("gender");
        String img = getData.getExtras().getString("img");       // 넘겨온 인텐트 객체안의 번들 객체의  담아둠

        if(img.equals("0"))
            myImgView.setImageResource(R.drawable.ic__teach_mypage);
        else if(img.equals("1"))// 잘못된 코드 수정 안의변수값 0->1
            myImgView.setImageResource(R.drawable.ic_hobby_mypage); // ready-> hobby
        else
            myImgView.setImageResource(R.drawable.ic_ready_mypage); // hobby -> ready



        textViewId.setText(id);
        textViewPwd.setText(pwd);
        textViewName.setText(name);
        textViewMajor.setText(major);
        textViewGender.setText(gender);
        // 값 변경

    }
}

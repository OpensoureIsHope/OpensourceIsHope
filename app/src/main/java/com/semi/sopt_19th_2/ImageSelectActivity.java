package com.semi.sopt_19th_2;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.semi.sopt_19th_2.Database.DbOpenHelper;

public class ImageSelectActivity extends AppCompatActivity {
    private DbOpenHelper mDbOpenHelper;

    LinearLayout preImgArea;
    LinearLayout nextImgArea; // 버튼같이 사용할 리니어 레이아웃을 매핑할 변수
    ImageView myImageView;// 이미지 바꿀때 필요
    Button registerBtn;

    int imgCount = 0; // 이미지 3개 0,1,2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_select); // activity_image_select.xml을 가져온다.

        preImgArea = (LinearLayout)findViewById(R.id.preImgBtn);
        nextImgArea = (LinearLayout)findViewById(R.id.nextImgBtn); // 매핑
        myImageView = (ImageView)findViewById(R.id.myImage);
        registerBtn = (Button)findViewById(R.id.registerBtn);

        preImgArea.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) { // 이전이미지 리니어레이아웃 누를 때
                if(imgCount > 0 ){ //처음이미지면 작동 x
                    imgCount--; // 이전이미지라 카운트 하나줄임

                    if(imgCount == 0){
                        myImageView.setImageResource(R.drawable.ic__teach_mypage); // 줄인 카운트가 0이면 처음 이미지로
                    }
                    else if(imgCount == 1){
                        myImageView.setImageResource(R.drawable.ic_hobby_mypage); // 줄인 카운트가 1이면 두번째 이미지로
                    }
                    else if(imgCount == 2){
                        myImageView.setImageResource(R.drawable.ic_ready_mypage); // 줄인 카운트가 2이면 세번째 이미지로
                    }

                }
            }
        });

        nextImgArea.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) { // 다음이미지 누를때
                if(imgCount < 3 ){ // 젤끝 이미지면 실행 x

                    imgCount++;
                    if(imgCount == 0){
                        myImageView.setImageResource(R.drawable.ic__teach_mypage);
                    }
                    else if(imgCount == 1){
                        myImageView.setImageResource(R.drawable.ic_hobby_mypage);
                    }
                    else if(imgCount == 2){
                        myImageView.setImageResource(R.drawable.ic_ready_mypage);
                    }

                }
            }
        });

        /**
         * 전 액티비티에서 받아온 정보를 마이페이지에 이미지의 정보와 함께 그대로 넘겨준다.
         */

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //등록 버튼 누름

                AlertDialog.Builder builder = new AlertDialog.Builder(ImageSelectActivity.this); // 알림창 변수 선언 및 생성
                // 여기서 부터는 알림창의 속성 설정
                builder.setMessage("회원 가입을 하시겠습니까?")        // 메세지 설정
                        .setCancelable(true)        // 뒤로 버튼 클릭시 취소 가능 설정
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                            // 확인 버튼 클릭시 설정
                            public void onClick(DialogInterface dialog, int whichButton){

                                Intent getData = getIntent();
                                Intent intent = new Intent(getApplicationContext(),MyPageActivity.class); // 확인을 누르면 myPageActivity page로 넘어간다.

                                intent.putExtra("id",getData.getExtras().getString("id"));  // getData(넘어온 intent객체)의 extra중에 "id"의 내용(minhang7)을 "id'"에 실어서 넘긴다.
                                intent.putExtra("pwd",getData.getExtras().getString("pwd"));
                                intent.putExtra("name",getData.getExtras().getString("name"));
                                intent.putExtra("major",getData.getExtras().getString("major"));
                                intent.putExtra("gender",getData.getExtras().getString("gender"));
                                intent.putExtra("img",String.valueOf(imgCount)); // 이미지 카운트한거 넘김


                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener(){
                            // 취소 버튼 클릭시 설정
                            public void onClick(DialogInterface dialog, int whichButton){
                                dialog.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();    // 알림창 객체 생성
                dialog.show();


            }
        });
    }
}

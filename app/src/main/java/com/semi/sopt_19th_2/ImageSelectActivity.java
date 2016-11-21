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

public class ImageSelectActivity extends AppCompatActivity {

    LinearLayout preImgArea;
    LinearLayout nextImgArea;
    ImageView myImageView;
    Button registerBtn;

    int imgCount = 0; // 이미지 3개 0,1,2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_select); // activity_image_select.xml을 가져온다.

        preImgArea = (LinearLayout)findViewById(R.id.preImgBtn);
        nextImgArea = (LinearLayout)findViewById(R.id.nextImgBtn);
        myImageView = (ImageView)findViewById(R.id.myImage);
        registerBtn = (Button)findViewById(R.id.registerBtn);

        preImgArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 이전버튼을 클릭하면 imgCount가 감소한다.
                if(imgCount > 0 ){
                    imgCount--;
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

        nextImgArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 다음버튼을 클릭하면 imgCount가 증가한다.
                if(imgCount < 3 ){
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
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ImageSelectActivity.this);
                // 여기서 부터는 알림창의 속성 설정
                builder.setMessage("회원 가입을 하시겠습니까?")        // 메세지 설정
                        .setCancelable(true)        // 뒤로 버튼 클릭시 취소 가능 설정
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                            // 확인 버튼 클릭시 설정
                            public void onClick(DialogInterface dialog, int whichButton){
                                Intent getData = getIntent();
                                Intent intent = new Intent(getApplicationContext(),MyPageActivity.class); // 확인을 누르면 myPageActivity page로 넘어간다.

                                intent.putExtra("id",getData.getExtras().getString("id"));
                                intent.putExtra("pwd",getData.getExtras().getString("pwd"));
                                intent.putExtra("name",getData.getExtras().getString("name"));
                                intent.putExtra("major",getData.getExtras().getString("major"));
                                intent.putExtra("part",getData.getExtras().getString("part"));
                                intent.putExtra("gender",getData.getExtras().getString("gender"));
                                intent.putExtra("img",String.valueOf(imgCount));

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

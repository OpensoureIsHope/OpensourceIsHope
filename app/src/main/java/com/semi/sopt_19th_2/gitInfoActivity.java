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
import android.widget.TextView;


public class gitInfoActivity extends AppCompatActivity {
    Button preImg;
    Button nextImg; // 버튼같이 사용할 리니어 레이아웃을 매핑할 변수
    ImageView opensourceImg;
    private TextView gitText;
    int count;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gitinfo); // activity_gitInfo.xml을 가져온다.

        preImg = (Button)findViewById(R.id.BeforeBtn);
        nextImg = (Button)findViewById(R.id.AfterBtn); // 매핑
        opensourceImg = (ImageView)findViewById(R.id.imageView2);
        gitText = (TextView)findViewById(R.id.gitTextView);


        preImg.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) { // 이전이미지 리니어레이아웃 누를 때
                if(count > 0 ){ //처음이미지면 작동 x
                    count--; // 이전이미지라 카운트 하나줄임

                    if(count == 0){
                        opensourceImg.setImageResource(R.drawable.gitinit); // 줄인 카운트가 0이면 처음 이미지로
                        gitText.setText("git init을 수행하면 master 줄기가 생성된다.");
                    }
                    else if(count == 1){
                        opensourceImg.setImageResource(R.drawable.branch); // 줄인 카운트가 1이면 두번째 이미지로
                        gitText.setText("git checkout -b를 선택하면 git branch가 생성되고 이로 인해 test를 수행할 수 있다.");

                    }
                    else if(count == 2){
                        opensourceImg.setImageResource(R.drawable.merge); // 줄인 카운트가 2이면 세번째 이미지로
                        gitText.setText("git merge를 수행하면 branch끼리 merge가 된다.");

                    }

                }
            }
        });

        nextImg.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) { // 다음이미지 누를때
                if(count < 3 ){ // 젤끝 이미지면 실행 x

                    count++;
                    if(count == 0){
                        opensourceImg.setImageResource(R.drawable.gitinit);
                        gitText.setText("git init을 수행하면 master 줄기가 생성된다.");

                    }
                    else if(count == 1){
                        opensourceImg.setImageResource(R.drawable.branch);
                        gitText.setText("git checkout -b를 선택하면 git branch가 생성되고 이로 인해 test를 수행할 수 있다.");

                    }
                    else if(count == 2){
                        opensourceImg.setImageResource(R.drawable.merge);
                        gitText.setText("git merge를 수행하면 branch끼리 merge가 된다.");

                    }

                }
            }
        });





    }
}
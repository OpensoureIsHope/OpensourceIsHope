package com.semi.sopt_19th_2;

import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class infoPageActivity extends AppCompatActivity {

    LinearLayout preInfoArea;
    LinearLayout nextInfoArea;
    ImageView myImageView;
    TextView infoTextView;
    Button moreInfoBtn;

    int imgCount = 0; // 이미지 3개 0,1,2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        preInfoArea = (LinearLayout)findViewById(R.id.preInfoBtn);
        nextInfoArea = (LinearLayout)findViewById(R.id.nextInfoBtn);
        myImageView = (ImageView)findViewById(R.id.myImage);
        moreInfoBtn = (Button)findViewById(R.id.moreInfoBtn);
        infoTextView = (TextView)findViewById(R.id.infoTextView);

        preInfoArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgCount > 0 ){
                    imgCount--;
                    if(imgCount == 0){
                        myImageView.setImageResource(R.drawable.info_a);
                        infoTextView.setText("리처드 매슈 스톨먼(Richard Matthew Stallman, 1953년 3월 16일 ~ )은 자유 소프트웨어 운동의 중심 인물이며, GNU 프로젝트와 자유 소프트웨어 재단의 설립자이다. 그는 이 운동을 지원하기 위해 카피레프트의 개념을 만들었으며, 현재 널리 쓰이고 있는 일반 공중 사용 허가서(GPL) 소프트웨어 라이선스의 개념을 도입했다.\n");
                    }
                    else if(imgCount == 1){
                        myImageView.setImageResource(R.drawable.info_b);
                        infoTextView.setText("리누스 베네딕트 토르발스(1969년 12월 28일 출생)는 스웨덴계 핀란드인으로서 핀란드 헬싱키에서 태어난 소프트웨어 개발자로, 리눅스 커널과 깃을 최초로 개발한 사람으로 잘 알려져 있다. 후에 그는 리눅스 커널 개발 최고 설계자가 되었다. 현재 프로젝트 코디네이터로 활동하고 있다. 저명한 오픈소스 소프트웨어 개발리더들에게 부여되는 명예 타이틀직인 자비로운 종신독재자 중의 한 사람이기도 하다.");                    }
                    else if(imgCount == 2){
                        myImageView.setImageResource(R.drawable.info_c);
                        infoTextView.setText("에릭 레이먼드(Eric Steven Raymond, ESR , 1957년 12월 4일 ~ )는 미국 매사추세츠 주 보스턴에서 태어났다. 인류학자이며 오픈 소스 개발 과정이 어떤 식으로 운영되고 반복되는지 설명한 그의 초기 문서인 성당과 시장의 저자로 잘 알려진 오픈 소스 운동의 대표 인물이다. 해커들이 쓰는 용어를 설명한 자곤 파일(\"신 해커사전\")을 편집했으며, 넷스케이프의 소스 코드 공개, 모질라의 설립에도 큰 영향을 끼쳤다. 그는 현재 태권도 검은 띠의 소유자이다.");
                    }

                }
            }
        });

        nextInfoArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgCount < 3 ){
                    imgCount++;
                    if(imgCount == 0){
                        myImageView.setImageResource(R.drawable.info_a);
                        infoTextView.setText("리처드 매슈 스톨먼(Richard Matthew Stallman, 1953년 3월 16일 ~ )은 자유 소프트웨어 운동의 중심 인물이며, GNU 프로젝트와 자유 소프트웨어 재단의 설립자이다. 그는 이 운동을 지원하기 위해 카피레프트의 개념을 만들었으며, 현재 널리 쓰이고 있는 일반 공중 사용 허가서(GPL) 소프트웨어 라이선스의 개념을 도입했다.\n");
                    }
                    else if(imgCount == 1){
                        myImageView.setImageResource(R.drawable.info_b);
                        infoTextView.setText("리누스 베네딕트 토르발스(1969년 12월 28일 출생)는 스웨덴계 핀란드인으로서 핀란드 헬싱키에서 태어난 소프트웨어 개발자로, 리눅스 커널과 깃을 최초로 개발한 사람으로 잘 알려져 있다. 후에 그는 리눅스 커널 개발 최고 설계자가 되었다. 현재 프로젝트 코디네이터로 활동하고 있다. 저명한 오픈소스 소프트웨어 개발리더들에게 부여되는 명예 타이틀직인 자비로운 종신독재자 중의 한 사람이기도 하다.");
                    }
                    else if(imgCount == 2){
                        myImageView.setImageResource(R.drawable.info_c);
                        infoTextView.setText("에릭 레이먼드(Eric Steven Raymond, ESR , 1957년 12월 4일 ~ )는 미국 매사추세츠 주 보스턴에서 태어났다. 인류학자이며 오픈 소스 개발 과정이 어떤 식으로 운영되고 반복되는지 설명한 그의 초기 문서인 성당과 시장의 저자로 잘 알려진 오픈 소스 운동의 대표 인물이다. 해커들이 쓰는 용어를 설명한 자곤 파일(\"신 해커사전\")을 편집했으며, 넷스케이프의 소스 코드 공개, 모질라의 설립에도 큰 영향을 끼쳤다. 그는 현재 태권도 검은 띠의 소유자이다.");
                    }

                }
            }
        });

        /**
         * 더 알아보기 버튼
         */
        moreInfoBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                if(imgCount==0) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EB%A6%AC%EC%B2%98%EB%93%9C_%EC%8A%A4%ED%86%A8%EB%A8%BC"));
                    startActivity(myIntent);
                }
                else if(imgCount == 1){
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EB%A6%AC%EB%88%84%EC%8A%A4_%ED%86%A0%EB%A5%B4%EB%B0%9C%EC%8A%A4"));
                    startActivity(myIntent);
                }
                else if(imgCount == 2){
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EC%97%90%EB%A6%AD_%EB%A0%88%EC%9D%B4%EB%A8%BC%EB%93%9C"));
                    startActivity(myIntent);
                }
            }
        });

    }
}

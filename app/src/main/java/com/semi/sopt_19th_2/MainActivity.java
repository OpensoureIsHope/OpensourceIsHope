package com.semi.sopt_19th_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editMajor;
    private RadioGroup groupPart;
    private RadioGroup groupGender;
    private Button submitBtn;
    private Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 초기화
         */

        editName = (EditText)findViewById(R.id.editName);
        editMajor = (EditText)findViewById(R.id.editMajor);
        groupPart = (RadioGroup)findViewById(R.id.radioPart);
        groupGender = (RadioGroup)findViewById(R.id.radioGender);
        submitBtn = (Button)findViewById(R.id.submitBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);

        /**
         * submit 버튼에 대한 클릭이벤트 부여
         * 클릭시 입력한 정보를 Toast로 출력해준다
         */

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 먼저, 이름/전공을 입력했는지 체크
                 */
                if(editName.length() == 0 || editMajor.length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"이름, 전공을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                else{
                    String temp;
                    temp = "이름 : " + editName.getText() + "\n";
                    temp += "전공 : " + editMajor.getText() + "\n";

                    RadioButton tempPart = (RadioButton) findViewById(groupPart.getCheckedRadioButtonId());
                    RadioButton tempGender = (RadioButton) findViewById(groupGender.getCheckedRadioButtonId());
                    String part = tempPart.getText().toString();
                    String gender = tempGender.getText().toString();

                    temp += "파트 : " + part + "\n";
                    temp += "성별 : " + gender;


                    Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_SHORT).show();

                }
            }
        });



        /**
         * reset 버튼에 대한 클릭이벤트 부여
         * 초기 상태로 돌린다
         */

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
                editMajor.setText("");
                groupGender.clearCheck();
                groupPart.clearCheck();
            }
        });

    }
}

package com.semi.sopt_19th_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inputIdEdit;
    EditText inputPwdEdit;
    Button loginBtn;
    Button signUpBtn;

    /**
     * 아직 2차세미나!!
     * 서버연동을 모르기때문에
     * 임시로 id, pwd를 넣어준다
     */

    String id = "sopt1234";
    String pwd = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // activity_login.xml을 가져온다.

        inputIdEdit = (EditText)findViewById(R.id.inputIdEdit);
        inputPwdEdit = (EditText)findViewById(R.id.inputPwdEdit);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        signUpBtn = (Button)findViewById(R.id.signUpBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputIdEdit.length() == 0){
                    Toast.makeText(getApplicationContext(),"ID를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(inputPwdEdit.length() == 0){
                    Toast.makeText(getApplicationContext(),"Pwd를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }

                //입력한 id,pwd와 임시로 넣어준 id,pwd가 같을 경우
                String inputId = String.valueOf(inputIdEdit.getText());
                String inputPwd = String.valueOf(inputPwdEdit.getText());

                if(inputId.equals(id) && inputPwd.equals(pwd)){  // id와 pwd가 같은지 확인하는 함수
                    Toast.makeText(getApplicationContext(),"로그인 성공!!!",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(getApplicationContext(),"로그인 실패!!!",Toast.LENGTH_SHORT).show();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

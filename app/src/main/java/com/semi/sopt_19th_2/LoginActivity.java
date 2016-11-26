package com.semi.sopt_19th_2;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.semi.sopt_19th_2.Database.DbOpenHelper;
import com.semi.sopt_19th_2.Database.ItemData;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private DbOpenHelper mDbOpenHelper;
    private ArrayList<ItemData> itemDatas = null;

    EditText inputIdEdit;
    EditText inputPwdEdit;
    Button loginBtn;
    Button signUpBtn;
    Button goGithubBtn;
    /**
     * 아직 2차세미나!!
     * 서버연동을 모르기때문에
     * 임시로 id, pwd를 넣어준다
     */
    String id = "1";
    String pwd = "123123";
/*minhang7, 123123으로 수정*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // activity_login.xml을 가져온다.



//        itemDatas = mDbOpenHelper.DbSelectJoin();

        inputIdEdit = (EditText)findViewById(R.id.inputIdEdit);
        inputPwdEdit = (EditText)findViewById(R.id.inputPwdEdit);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        signUpBtn = (Button)findViewById(R.id.signUpBtn);
        goGithubBtn = (Button)findViewById(R.id.goGitub);
        /*  findViewById로 id부여한 view들을 가져와서 사용할수 있게 한다.*/
        mDbOpenHelper = new DbOpenHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputIdEdit.length() == 0){
                    Toast.makeText(getApplicationContext(),"ID를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }

                /* toast : 안드로이드에서 간단한 메시지를 잠깐 보여줄수 있는 방법.*/

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
        // 사인업 버튼 누르면 회원가입 화면으로 넘어감.

        goGithubBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/OpensoureIsHope/OpensourceIsHope"));
                startActivity(myIntent);
        }
        });
    }
}

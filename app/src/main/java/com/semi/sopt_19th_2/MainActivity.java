package com.semi.sopt_19th_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editId;
    private EditText editPwd;
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
        editId = (EditText)findViewById(R.id.editId);
        editPwd = (EditText)findViewById(R.id.editPwd);
        editName = (EditText)findViewById(R.id.editName);
        editMajor = (EditText)findViewById(R.id.editMajor);
        groupPart = (RadioGroup)findViewById(R.id.radioPart); // 라디오버튼 성별 부분 바운딩
        groupGender = (RadioGroup)findViewById(R.id.radioGender); // 라디오버튼 파트부분 바운딩
        submitBtn = (Button)findViewById(R.id.submitBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);

        /**
         * submit 버튼에 대한 클릭이벤트 부여
         * 클릭시 입력한 정보를 Toast로 출력해준다
         */

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 제출버튼 누름

                /**
                 * id/pwd/이름/전공을 입력했는지 체크
                 */
                if(editId.length() == 0 )
                {
                    Toast.makeText(getApplicationContext(),"Id을 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editPwd.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Pwd을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editName.length() == 0 )
                {
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editMajor.length() == 0) {
                    Toast.makeText(getApplicationContext(), "전공을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 빈칸이 있으면 메세지 출력하고 리스너 종료

                RadioButton tempPart = (RadioButton) findViewById(groupPart.getCheckedRadioButtonId()); // 선택된 라디오 버튼의 ID값을 반환한다.
                RadioButton tempGender = (RadioButton) findViewById(groupGender.getCheckedRadioButtonId()); // 선택된 라디오 버튼의 ID값을 반환한다.
                String part = tempPart.getText().toString(); // 그 ID의 text부분 부분을 가져와서 대입한다.
                String gender = tempGender.getText().toString(); // 그 ID의 text부분 부분을 가져와서 대입한다.

                Intent intent  = new Intent(getApplicationContext(),ImageSelectActivity.class); // 이미지 고르기 부분 activity 으로 전환하는 intent
                intent.putExtra("id",String.valueOf(editId.getText())); // minhang7을 id에 실어서 넘긴거.
                intent.putExtra("pwd",String.valueOf(editPwd.getText()));
                intent.putExtra("name",String.valueOf(editName.getText()));
                intent.putExtra("major",String.valueOf(editMajor.getText()));
                intent.putExtra("part",part);
                intent.putExtra("gender",gender);
                // 각 부분의 텍스트 부분을 가져와서 imageselect 액티비티에 추가로 넘김 "id" ... 에 실어서 보냄
                startActivity(intent);// 전환
                finish();
            }
        });



        /**
         * reset 버튼에 대한 클릭이벤트 부여
         * 초기 상태로 돌린다
         */

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editId.setText("");
                editPwd.setText("");
                editName.setText("");
                editMajor.setText("");
                groupGender.clearCheck();
                groupPart.clearCheck();
            }
        });
        //  리셋버튼 누르면 다초기화

    }
}

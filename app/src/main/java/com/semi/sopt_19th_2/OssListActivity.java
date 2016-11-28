package com.semi.sopt_19th_2;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by 미냉 on 2016-11-26.
 */

public class OssListActivity extends AppCompatActivity {
    ListView listView1;
    OssList_Adapter adapter;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oss_list);

        listView1 = (ListView) findViewById(R.id.listView1);

        adapter = new OssList_Adapter(this);

        Resources res = getResources();
        adapter.addItem(new OssList_ItemData(res.getDrawable(R.drawable.oss),"오픈소스 역사","OSS history"));
        adapter.addItem(new OssList_ItemData(res.getDrawable(R.drawable.oss_people),"인물 사전","Wiki of people who contibute to OSS"));
        adapter.addItem(new OssList_ItemData(res.getDrawable(R.drawable.git),"Git 기능","Functions of Git"));
        adapter.addItem(new OssList_ItemData(res.getDrawable(R.drawable.github),"to GitHub","OpensoureIsHope"));
        adapter.addItem(new OssList_ItemData(res.getDrawable(R.drawable.mypage),"마이페이지","My Page"));



        listView1.setAdapter(adapter);



        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Oss_History.class);
                    startActivity(intent);
                }
                if(position == 1) {
                    Intent intent = new Intent(getApplicationContext(), infoPageActivity.class);
                    startActivity(intent);
                }
                if(position == 2) {
                    Intent intent = new Intent(getApplicationContext(), gitInfoActivity.class);
                    startActivity(intent);
                }
                if(position == 3) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/OpensoureIsHope/OpensourceIsHope"));
                    startActivity(myIntent);
                }
                if(position == 4) {
                    Intent intent = new Intent(getApplicationContext(), ImageSelectActivity.class);
                    startActivity(intent);
                }

            }
        });
        {

        }
    }

}



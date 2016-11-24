package com.semi.sopt_19th_2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 미냉 on 2016-11-24.
 */

public class OssList_ItemView extends LinearLayout {

    private ImageView mIcon;
    private  TextView mText01;
    private  TextView mText02;
    private  TextView mText03;


    public OssList_ItemView(Context context, OssList_ItemData aItem) {
        super(context);

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // => ?
        inflater.inflate(R.layout.activity_oss_list_item, this, true); // xml 에서 데이터 가져온다?
        /*(inflater란, XML에 정의된 Resource(자원) 들을 View의 형태로 반환해 줍니다. 보통 자바 코드에서 View, ViewGroup 을 사용하거나
                 Adpter의 getview() 또는 Dialog, Popup 구현시 배경화면이 될 Layout을 만들어 놓고 View의 형태로 반환 받아 Acitivity에서 실행 하게 됩니다. )*/

        mIcon = (ImageView) findViewById(R.id.iconItem);
        mIcon.setImageDrawable(aItem.getIcon());
        mText01 = (TextView) findViewById(R.id.dataItem01);
        mText01.setText(aItem.getData(0));
        mText02 = (TextView) findViewById(R.id.dataItem02);
        mText02.setText(aItem.getData(1));
        mText03 = (TextView) findViewById(R.id.dataItem03);
        mText03.setText(aItem.getData(2));
    }
        public void setText(int index, String data)
        {
            if(index == 0) mText01.setText(data);
            else if(index ==1) mText02.setText(data);
            else if(index ==2) mText02.setText(data);
            else throw new IllegalArgumentException();
        }

    public void setIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
    }
    public ImageView getIcon()
    {
        return mIcon;
    }




    }


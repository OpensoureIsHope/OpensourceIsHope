package com.semi.sopt_19th_2;

import android.graphics.drawable.Drawable;

/**
 * Created by 미냉 on 2016-11-24.
 */

public class OssList_ItemData {
    private Drawable mIcon;
    private String[] mData;

    public OssList_ItemData(Drawable icon, String[] obj)
    {
        mIcon = icon;
        mData = obj;
    }
    public OssList_ItemData(Drawable icon, String obj01, String obj02)
    {
        mIcon = icon;

        mData = new String[3];
        mData[0] = obj01;
        mData[1] = obj02;
    }
    public OssList_ItemData(Drawable icon, String obj01, String obj02, String obj03)
    {
        mIcon = icon;

        mData = new String[3];
        mData[0] = obj01;
        mData[1] = obj02;
        mData[2] = obj03;
    }

    public String[] getData()
    {
        return mData;
    }

    public String getData(int index)
    {
        if(mData == null || index >= mData.length) return null;
        return mData[index];
    }

    public void setData(String[] obj)
    {
        mData = obj;
    }
    public void setIcon(Drawable icon)
    {
        mIcon = icon;
    }
    public Drawable getIcon()
    {
        return mIcon;
    }


    public String getdata(int i) {
        return mData[i];
    }
}

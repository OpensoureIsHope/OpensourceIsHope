package com.semi.sopt_19th_2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 미냉 on 2016-11-24.
 */


public class OssList_Adapter extends BaseAdapter
{
    private Context mContext;

    private List<OssList_ItemData> mItems = new ArrayList<OssList_ItemData>();

    public OssList_Adapter(Context context)
    {
        mContext = context;
    }

    public int getCount()
    {

        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        OssList_ItemView itemView;

        if(convertView == null)
        {
            itemView = new OssList_ItemView(mContext, mItems.get(position));
        }
        else
        {
            itemView = (OssList_ItemView) convertView;
        }
        itemView.setIcon(mItems.get(position).getIcon());
        itemView.setText(0,mItems.get(position).getdata(0));
        itemView.setText(1,mItems.get(position).getdata(1));
       // itemView.setText(2,mItems.get(position).getdata(2));
        return itemView;
    }
    public void addItem(OssList_ItemData item)
    {
        mItems.add(item);
    }

}

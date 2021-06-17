package com.myexample.listviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> mData;
    OnMyAdapterItemClickListener mListener;

    public MyAdapter(Context c, ArrayList<String> m, OnMyAdapterItemClickListener l){
        context=c;
        mData = m;
        mListener =l;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_listview,viewGroup,false);
        TextView txt = (TextView)v.findViewById(R.id.item_listview_textview);
        txt.setText(mData.get(position));
        Button b=(Button)v.findViewById(R.id.btn) ;
//        ImageView img = (ImageView)v.findViewById(R.id.item_listview_imageview);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int r=Integer.parseInt(mData.get(position));
                mListener.onItemClick(r*r);
            }
        });

        return v;
    }

    interface OnMyAdapterItemClickListener{
        void onItemClick(Integer s);
    }

}

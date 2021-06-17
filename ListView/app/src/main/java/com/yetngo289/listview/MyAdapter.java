package com.yetngo289.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> myData;
    OnMyAdapterItemClickListener myListener;

    public MyAdapter(Context c, ArrayList<String> m, OnMyAdapterItemClickListener l) {
        context = c;
        myData = m;
        myListener = l;
    }
    @Override
    public int getCount() {
        return myData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        TextView txt = (TextView) v.findViewById(R.id.item_listview_textview);
        txt.setText(myData.get(position));
        ImageView img = (ImageView) v.findViewById(R.id.item_listview_imageview);
        if (position % 2 == 0) {
            img.setImageResource(R.drawable.ic_launcher_background);
        } else {
            img.setImageResource(R.drawable.ic_launcher_foreground);
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myListener.onItemClick(myData.get(position));
            }
        });
//        txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
//            }
//        });
        return v;
    }

    interface OnMyAdapterItemClickListener {
        void onItemClick(String s);
    }
}


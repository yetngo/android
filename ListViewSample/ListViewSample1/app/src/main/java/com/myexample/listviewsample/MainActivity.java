package com.myexample.listviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnMyAdapterItemClickListener {
    private ListView listView;
    private ArrayAdapter<String> mAdapter;
    private MyAdapter myCustomAdapter;
    TextView mMainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        mMainTextView = (TextView) findViewById(R.id.activity_main_textview);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, generateData());
        // listView.setAdapter(mAdapter);
        myCustomAdapter = new MyAdapter(this, generateData(), this);
        listView.setAdapter(myCustomAdapter);
    }

    private ArrayList<String> generateData() {
        ArrayList<String> n = new ArrayList<>();
        n.add("1");
        n.add("2");
        n.add("3");
        n.add("4");
        n.add("6");
        n.add("8");
        return n;
    }

    @Override
    public void onItemClick(Integer s) {

        mMainTextView.setText("result :" + s);
    }
}
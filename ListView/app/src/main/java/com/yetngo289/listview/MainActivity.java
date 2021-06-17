package com.yetngo289.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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
        myCustomAdapter = new MyAdapter(this, generateData(), this);
        listView.setAdapter(myCustomAdapter);
    }

    private ArrayList<String> generateData() {
        ArrayList<String> n = new ArrayList<>();
        n.add("Student1");
        n.add("Student2");
        n.add("Student3");
        n.add("Student4");
        n.add("Student5");
        n.add("Student6");
        n.add("Student7");
        n.add("Student8");
        n.add("Student10");
        n.add("Student11");
        n.add("Student11");
        n.add("Student11");
        n.add("Student11");
        n.add("Student11");
        n.add("Student11");
        n.add("Student11");
        n.add("Student11");
        return n;
    }

    @Override
    public void onItemClick(String s) {

        mMainTextView.setText(s);
    }
}
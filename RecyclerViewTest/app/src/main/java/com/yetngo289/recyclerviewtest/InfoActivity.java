package com.yetngo289.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    TextView masp, info;
    String msp, tensp, mota, gia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        masp = findViewById(R.id.tv_infoMsp);
        info = findViewById(R.id.tv_info);
        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("msp") &&
                getIntent().hasExtra("tensp") &&
                getIntent().hasExtra("mota") &&
                getIntent().hasExtra("gia")) {
            msp = getIntent().getStringExtra("msp");
            tensp=getIntent().getStringExtra("tensp");
            mota=getIntent().getStringExtra("mota");
            gia=getIntent().getStringExtra("gia");
        } else {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        masp.setText("Mã sp: "+msp);
        info.setText("Tên sp: "+tensp+"\n"
                    +"Mô tả: "+mota+"\n"
                    +"Giá tiền: "+gia);
    }
}
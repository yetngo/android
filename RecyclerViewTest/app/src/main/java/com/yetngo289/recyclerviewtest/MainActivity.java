package com.yetngo289.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<Product> products;
    EditText msp,tensp,mota,gia;
    Button them;
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        msp=(EditText)findViewById(R.id.edt_msp);
        tensp=(EditText)findViewById(R.id.edt_tensp);
        mota=(EditText)findViewById(R.id.edt_mota);
        gia=(EditText)findViewById(R.id.edt_giatien);
        them=(Button)findViewById(R.id.btn_them);

        myDatabase=new MyDatabase(this);
        products=myDatabase.getProducts();

        myAdapter=new MyAdapter(this,products);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ten: "+msp.getText());
                if (!msp.getText().toString().isEmpty()
                        && !tensp.getText().toString().isEmpty()
                        && !mota.getText().toString().isEmpty()
                        && !gia.getText().toString().isEmpty()) {
                    myDatabase.insertData(msp.getText().toString(),tensp.getText().toString()
                            ,mota.getText().toString(),gia.getText().toString());
//                    Product p=new Product();
//                    p.setMasp(msp.getText().toString());
//                    p.setTensp(tensp.getText().toString());
//                    p.setMota(mota.getText().toString());
//                    p.setGiatien(gia.getText().toString());
//                    products.add(p);
                    products.clear();
                    products.addAll(myDatabase.getProducts());
                    myAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
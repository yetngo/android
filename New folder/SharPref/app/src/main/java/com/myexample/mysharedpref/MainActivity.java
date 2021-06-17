package com.myexample.mysharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText,editCode;
    SharedPreferences pref;

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edt_data);
        editCode = findViewById(R.id.edt_code);
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        myDatabase=new MyDatabase(this);
    }

    public void onSave(View v) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("mydata", editText.getText().toString());
        editor.commit();

        myDatabase.insertData(editText.getText().toString(),editCode.getText().toString());
    }

    public void onView(View v) {
        Toast.makeText(this, pref.getString("mydata", ""), Toast.LENGTH_SHORT).show();

        ArrayList<String> myProducts = myDatabase.getProducts();
        for(int i=0;i<myProducts.size();i++){
            Log.d("PRODUCT",myProducts.get(i));
        }
    }

    public void onClear(View v) {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
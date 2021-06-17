package com.yetngo289.mysharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edt);
        pref=getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    }

    public void onSave(View v){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("mydata",editText.getText().toString());
        editor.commit();
    }

    public void onClear(View v){
        SharedPreferences.Editor editor=pref.edit();
        editor.clear();
        editor.commit();
    }

    public void onView(View v){
        Toast.makeText(this,pref.getString("mydata",""),Toast.LENGTH_SHORT).show();
    }
}
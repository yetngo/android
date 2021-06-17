package com.yetngo289.loginfb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {
    private TextView text;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        text = (TextView) findViewById(R.id.textName);
        Intent i = getIntent();
//        String message = i.getStringExtra("text");
//        text.setText(message);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                editor.clear();
                editor.commit();
                Intent i2 = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(i2);
                finish();
            }
        });
    }

}

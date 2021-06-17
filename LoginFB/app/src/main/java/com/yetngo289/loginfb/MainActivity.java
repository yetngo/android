package com.yetngo289.loginfb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.captaindroid.tvg.Tvg;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtUsername, edtPass;
    private TextView sign,forgot;
    public SharedPreferences pref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pref=getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(pref.getString("username",null)!=null){
            Intent i = new Intent(MainActivity.this,ProfileActivity.class);
//            i.putExtra("text", edtUsername.getText().toString());
            startActivity(i);
            finish();
        }
        setContentView(R.layout.activity_login);
        edtUsername = (EditText) findViewById(R.id.username);
        edtPass = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.login);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtUsername.getText().toString().isEmpty()
                        && !edtPass.getText().toString().isEmpty()) {
//                    SharePref.saveSharedSetting(MainActivity.this, "MyPref", "false");
//                    Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor=pref.edit();
                    editor.putString("username",edtUsername.getText().toString());
                    editor.putString("pass",edtPass.getText().toString());
                    editor.commit();
                    Intent i = new Intent(MainActivity.this,ProfileActivity.class);
//                    i.putExtra("text", edtUsername.getText().toString());
                    startActivity(i);
                    finish();
                } else
                    Toast.makeText(MainActivity.this, "Please input username and password!", Toast.LENGTH_LONG).show();
            }
        });

        sign=findViewById(R.id.sign);
        Tvg.change(sign, Color.parseColor("#800CDD"),  Color.parseColor("#3BA3F2"));
        Tvg.change((TextView) findViewById(R.id.forgot), new int[]{
                Color.parseColor("#F97C3C"),
                Color.parseColor("#FDB54E"),
                Color.parseColor("#64B678"),
                Color.parseColor("#478AEA"),
                Color.parseColor("#8446CC"),
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        edtUsername.setText("");
        edtPass.setText("");

    }
}
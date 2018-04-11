package com.example.abhipc.multipleapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et1, et2;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        bt1 = (Button) findViewById(R.id.button2);
        bt2 = (Button) findViewById(R.id.button3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == bt1) {
                    Toast.makeText(getApplicationContext(), "Create New Account", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Signup.class);
                    startActivity(i);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == bt2) {
                    Intent i1=new Intent(Login.this,Signin.class);
                    startActivity(i1);
                }
            }
        });
    }
}
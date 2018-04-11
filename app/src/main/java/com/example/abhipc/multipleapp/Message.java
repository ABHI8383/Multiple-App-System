package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Message extends AppCompatActivity {

    EditText edittext1,edittext2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        edittext1=(EditText)findViewById(R.id.editText);
        edittext2=(EditText)findViewById(R.id.editText2);
        button1=(Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v==button1){
                    String no=edittext1.getText().toString();
                    String msg=edittext2.getText().toString();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(no,null,msg,pi,null);
                    Toast.makeText(getApplicationContext(), "message sucessful",Toast.LENGTH_LONG).show();
            }
        }
        });

    }
}

package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends Activity {
    EditText edittextto,edittextsubject,edittextmessage;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        edittextto=(EditText)findViewById(R.id.editText);
        edittextsubject=(EditText)findViewById(R.id.editText2);
        edittextmessage=(EditText)findViewById(R.id.editText3);
        send=(Button)findViewById(R.id.button);
        send.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                String to=edittextto.getText().toString();
                String subject=edittextsubject.getText().toString();
                String message=edittextmessage.getText().toString();

                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT,subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email,"Choose an Email client:"));


                Toast.makeText(getApplicationContext(),"email is sent",Toast.LENGTH_LONG).show();
            }
        });
    }
}

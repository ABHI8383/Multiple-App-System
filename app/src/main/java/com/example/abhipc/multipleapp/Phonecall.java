package com.example.abhipc.multipleapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Phonecall extends Activity {
    EditText edittext1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonecall);

        edittext1=(EditText)findViewById(R.id.editText);
        button1=(Button)findViewById(R.id.button);

        button1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String number=edittext1.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                if (ActivityCompat.checkSelfPermission(Phonecall.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;


                }
                startActivity(callIntent);
            }

        });
    }
    }

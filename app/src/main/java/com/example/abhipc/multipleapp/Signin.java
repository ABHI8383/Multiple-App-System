package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Signin extends Activity {
    ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        b1 = (ImageButton) findViewById(R.id.imageButton);
        b2 = (ImageButton) findViewById(R.id.imageButton2);
        b3 = (ImageButton) findViewById(R.id.imageButton3);
        b4 = (ImageButton) findViewById(R.id.imageButton4);
        b5 = (ImageButton) findViewById(R.id.imageButton5);
        b6 = (ImageButton) findViewById(R.id.imageButton6);
        b7 = (ImageButton) findViewById(R.id.imageButton7);
        b8 = (ImageButton) findViewById(R.id.imageButton8);
        b9 = (ImageButton) findViewById(R.id.imageButton9);
        b10=(Button)findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b1) {
                    Intent i11=new Intent(Signin.this,Bluetooth.class);
                    startActivity(i11);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b2) {
                    Intent i12=new Intent(Signin.this,Camera.class);
                    startActivity(i12);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b3) {
                    Intent i13=new Intent(Signin.this,Email.class);
                    startActivity(i13);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b4) {
                    Intent i14=new Intent(Signin.this,Message.class);
                    startActivity(i14);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b5) {
                    Intent i15=new Intent(Signin.this,Phonecall.class);
                    startActivity(i15);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b6) {
                    Intent i16=new Intent(Signin.this,Texttospeech.class);
                    startActivity(i16);
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b7) {
                    Intent i17=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com"));
                    startActivity(i17);
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b8) {
                    Intent i18=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                    startActivity(i18);
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b9) {
                    Intent i19=new Intent(Signin.this,Wifi.class);
                    startActivity(i19);
                }
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == b10) {
                    Intent i20=new Intent(Signin.this,Contact.class);
                    startActivity(i20);
                }
            }
        });


    }
}
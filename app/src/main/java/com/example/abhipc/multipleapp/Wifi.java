package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Wifi extends Activity  {
    Button enable,disable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        enable=(Button)findViewById(R.id.button);
        disable=(Button)findViewById(R.id.button2);
        enable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);

            }
        });
        disable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);

            }
        });
    }
}

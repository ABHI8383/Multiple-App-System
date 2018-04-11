package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Bluetooth extends Activity  {

    private static final int REQUEST_ENABLE_BT=0;
    private static final int REQUEST_DISCOVERABLE_BT=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        final TextView out=(TextView)findViewById(R.id.textView15);

        final Button button1=(Button)findViewById(R.id.button);
        final Button button2=(Button)findViewById(R.id.button2);
        final Button button3=(Button)findViewById(R.id.button3);
        final BluetoothAdapter mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter==null){
            out.append("device not supported");

        }
        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(!mBluetoothAdapter.isEnabled()){
                    Intent enableBIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBIntent,REQUEST_ENABLE_BT);
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(!mBluetoothAdapter.isDiscovering()){
                    //	out.append("making your device discoverable");
                    Context context=getApplicationContext();
                    CharSequence text="MAKING YOUR DEVICE DISCOVERABLE";
                    int duration =Toast.LENGTH_SHORT;
                    Toast toast=Toast.makeText(context, text, duration);
                    toast.show();

                    Intent enableBIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(enableBIntent,REQUEST_DISCOVERABLE_BT);
                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mBluetoothAdapter.disable();
                // out.append("TURN_OFF BLUETOOTH");
                Context context=getApplicationContext();
                CharSequence text="TURNING_OFF BLUETOOTH";
                int duration =Toast.LENGTH_LONG;
                Toast toast=Toast.makeText(context, text, Toast.LENGTH_LONG);
                toast.show();


            }


        });

    }



}



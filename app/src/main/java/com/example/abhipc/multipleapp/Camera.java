package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class Camera extends AppCompatActivity {
    private static final int CAMERA_REQUEST=1888;
    ImageView i1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        i1=(ImageView)findViewById(R.id.imageView);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cintent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cintent,CAMERA_REQUEST);
            }
            protected void onActivityResult(int requestcode,int resultcode,Intent data)
            {
                if(requestcode==CAMERA_REQUEST)
                {
                    Bitmap photo=(Bitmap)data.getExtras().get("data");
                    i1.setImageBitmap(photo);

                }

            }
        });
    }
}

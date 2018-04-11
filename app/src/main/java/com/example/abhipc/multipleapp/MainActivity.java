package com.example.abhipc.multipleapp;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    Button btnstartprogress;
    ProgressDialog progressbar;
    private int progressbarstatus=0;
    private Handler progressbarhandler=new Handler();
    private long filesize=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addlisteneronbuttonclick();
    }
    public void addlisteneronbuttonclick()
    {
        btnstartprogress=(Button)findViewById(R.id.button);
        btnstartprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar=new ProgressDialog(v.getContext());
                progressbar.setCancelable(true);
                progressbar.setMessage("Processing To Enter");
                progressbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressbar.setProgress(0);
                progressbar.setMax(100);
                progressbarstatus=0;
                filesize=0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressbarstatus<100)
                        {
                            progressbarstatus=doOperation();
                            try{
                                Intent a=new  Intent(getApplicationContext(),Login.class);
                                startActivity(a);
                                Thread.sleep(1000);
                            }catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            progressbarhandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressbar.setProgress(progressbarstatus);
                                }
                            });
                        }
                        if(progressbarstatus>=100)
                        {
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            progressbar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }
    public int doOperation()
    {
        while(filesize<=1000)
        {
            filesize++;
            if(filesize==1000)
            {
                return 10;
            }
            else if(filesize==2000)
            {
                return 20;
            }
            else if(filesize==3000)
            {
                return 30;
            }
            else if(filesize==4000)
            {
                return 40;
            }
            else
            {
                return 100;
            }

        }
        return 100;
    }
}

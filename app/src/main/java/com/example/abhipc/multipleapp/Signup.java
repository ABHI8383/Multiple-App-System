package com.example.abhipc.multipleapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.provider.Settings;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {
    EditText et3, et4, et5, et6, et7, et8;
    Button bt4, bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
        et6 = (EditText) findViewById(R.id.editText6);
        et7 = (EditText) findViewById(R.id.editText7);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = et3.getText().toString();
                String username = et4.getText().toString();
                String password = et5.getText().toString();
                String contact = et6.getText().toString();
                String address = et7.getText().toString();
                try {
                    SQLiteDatabase db = openOrCreateDatabase("MyDb.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    db.execSQL("create table if not exists student(_id integer primary key autoincrement,userid text,username text,password text,contact text,address text)");
                    ContentValues value = new ContentValues();
                    value.put("userid", userid);
                    value.put("username", username);
                    value.put("password", password);
                    value.put("contact", contact);
                    value.put("address", address);
                    long l = db.insert("student", null, value);
                    if (l > 0) {
                        Toast.makeText(getApplicationContext(), "Table created", Toast.LENGTH_LONG).show();
                        System.out.println("Table Successfully Created");

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = et3.getText().toString();
                String username = et4.getText().toString();
                String password = et5.getText().toString();
                String contact = et6.getText().toString();
                String address = et7.getText().toString();
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
            }

        });
    }
}






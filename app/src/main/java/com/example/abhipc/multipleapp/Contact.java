package com.example.abhipc.multipleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends Activity  {
    EditText name1,email1,contact1,suggestion1;
    Button  b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        name1=(EditText)findViewById(R.id.editText);
        email1=(EditText)findViewById(R.id.editText2);
        contact1=(EditText)findViewById(R.id.editText3);
        suggestion1=(EditText)findViewById(R.id.editText4);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = name1.getText().toString();
                String emails = email1.getText().toString();
                String contacts = contact1.getText().toString();
                String suggestions = suggestion1.getText().toString();

                try {
                    SQLiteDatabase db = openOrCreateDatabase
                            ("MyDB1.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    db.execSQL("create table if not exists contacts(_id integer primary key autoincrement,name text,email text,contact text,suggestion text)");
                    ContentValues value = new ContentValues();

                    value.put("name", names);
                    value.put("email", emails);
                    value.put("contact", contacts);
                    value.put("suggestion", suggestions);
                    long l = db.insert("contacts", null, value);
                    if (l > 0) {
                        Toast.makeText(getApplicationContext(), "Table successfully created", Toast.LENGTH_LONG).show();
                    }
                    Cursor cur = db.rawQuery("select * from contacts", null);
                    StringBuffer data = new StringBuffer();
                    if (cur.moveToFirst()) {
                        System.out.println("welcome");
                        do {
                            data.append(cur.getString(cur.getColumnIndex
                                    ("name")) + "," + cur.getString(cur.getColumnIndex("email")) + cur.getString(cur.getColumnIndex
                                    ("contact")) + "," + cur.getString(cur.getColumnIndex("suggestion")) + "," + "\n");


                        }
                        while (cur.moveToNext());

                    }
                    Builder b = new Builder(getApplicationContext());
                    b.setMessage(data.toString());
                    b.setCancelable(true);
                    b.show();
                    cur.close();
                    db.close();

                } catch (Exception e) {
                    System.out.println(e);

                }
            }
        });
    }
}

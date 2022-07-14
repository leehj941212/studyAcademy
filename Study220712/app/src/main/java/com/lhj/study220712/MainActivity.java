package com.lhj.study220712;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    Button button;
    Button button2;
    Button button3;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        editText2 = (EditText) findViewById(R.id.editTextTextPersonName3);
        editText3 = (EditText) findViewById(R.id.editTextTextPersonName);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        Sub1 sub1 = new Sub1(this, "db1", null, 1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = sub1.getWritableDatabase();
                sub1.onUpgrade(sqLiteDatabase, 1, 2);
                sqLiteDatabase.close();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = sub1.getWritableDatabase();
                sqLiteDatabase.execSQL("insert into study2 (num,name) values("
                        + editText.getText().toString() + ",'"
                        + editText2.getText().toString() + "')");
                sqLiteDatabase.close();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText3.setText("");

                sqLiteDatabase = sub1.getReadableDatabase();
                Cursor cursor =
                        sqLiteDatabase.rawQuery("select * from study2", null);

                if (cursor.moveToNext()) {
                    editText3.setText(cursor.getInt(0)
                            + cursor.getString(1));

                    while (cursor.moveToNext()) {
                        editText3.setText(editText3.getText()  +"\n"
                                + cursor.getInt(0)
                                + cursor.getString(1));
                    }
                }
                sqLiteDatabase.close();
            }
        });
    }

    static class Sub1 extends SQLiteOpenHelper {

        public Sub1(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table study2(num integer,name varchar(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists study2");
            onCreate(db);
        }
    }

}
package com.lhj.study220713;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    String dateValue;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);

//        dateValue = String.valueOf(datePicker.getYear()) + "-" +
//                String.valueOf(datePicker.getMonth() + 1) + "-" +
//                String.valueOf(datePicker.getDayOfMonth());

        Sub1 sub1 = new Sub1(this, "db2", null, 1);


//        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth()+1,null);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
                dateValue = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;

                sqLiteDatabase = sub1.getReadableDatabase();
                Cursor cursor = sqLiteDatabase.rawQuery
                        ("select contents from study3 where pickdate ='" + dateValue + "'",
                                null);

                if (cursor.moveToNext()) {
                    editText.setText(cursor.getString(0));
                } else {
                    editText.setText("");
                }
                sqLiteDatabase.close();
            }
        });





//        sqLiteDatabase = sub1.getReadableDatabase();
//        Cursor cursor1 = sqLiteDatabase.rawQuery
//                ("select contents from study3 where pickdate ='" + dateValue + "'",
//                        null);
//
//        if (cursor1.moveToNext()) {
//            editText.setText(cursor1.getString(0));
//        } else {
//            editText.setText("");
//        }
//        sqLiteDatabase.close();


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//                @Override
//                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//                    dateValue = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
//
//                    sqLiteDatabase = sub1.getReadableDatabase();
//                    Cursor cursor = sqLiteDatabase.rawQuery
//                            ("select contents from study3 where pickdate ='" + dateValue + "'",
//                                    null);
//
//                    if (cursor.moveToNext()) {
//                        editText.setText(cursor.getString(0));
//                    } else {
//                        editText.setText("");
//                    }
//                    sqLiteDatabase.close();
//                }
//            });
//        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = sub1.getWritableDatabase();
                sub1.onUpgrade(sqLiteDatabase, 1, 2);
                sqLiteDatabase.close();
                Toast.makeText(MainActivity.this, "초기화 되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = sub1.getWritableDatabase();
                sqLiteDatabase.execSQL("delete from study3 " +
                        "where pickdate ='" + dateValue + "'");

                sqLiteDatabase.execSQL("insert into study3 values ('" + dateValue + "','" +
                        editText.getText().toString() + "')");

                sqLiteDatabase.close();
                Toast.makeText(MainActivity.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.updateDate(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth()+1);
            }
        });
    }

    class Sub1 extends SQLiteOpenHelper {
        public Sub1(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table study3 " +
                    "(pickdate date,contents varchar(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists study3");
            onCreate(db);
        }
    }

}
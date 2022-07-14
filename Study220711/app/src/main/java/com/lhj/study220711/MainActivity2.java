package com.lhj.study220711;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Sub2[] sub = {new Sub2(R.drawable.qqq1, "zzz1"), new Sub2(R.drawable.qqq2, "zzz2"),
            new Sub2(R.drawable.qqq3, "zzz3"), new Sub2(R.drawable.qqq1, "zzz4"),
            new Sub2(R.drawable.qqq2, "zzz5"), new Sub2(R.drawable.qqq3, "zzz6"),
            new Sub2(R.drawable.qqq1, "zzz7"), new Sub2(R.drawable.qqq2, "zzz8"),
            new Sub2(R.drawable.qqq3, "zzz9"), new Sub2(R.drawable.qqq1, "zzz10")};

    Sub2[] sub2 = {new Sub2(R.drawable.qqq4, "xxx1"), new Sub2(R.drawable.qqq5, "xxx2"),
            new Sub2(R.drawable.qqq6, "xxx3"), new Sub2(R.drawable.qqq4, "xxx4"),
            new Sub2(R.drawable.qqq5, "xxx5"), new Sub2(R.drawable.qqq6, "xxx6"),
            new Sub2(R.drawable.qqq4, "xxx7"), new Sub2(R.drawable.qqq5, "xxx8"),
            new Sub2(R.drawable.qqq6, "xxx9"), new Sub2(R.drawable.qqq4, "xxx10")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = (ListView) findViewById(R.id.listView2);

        CustomA customA = new CustomA(getApplicationContext(), R.layout.sub_2, sub);
        listView.setAdapter(customA);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View view1 = (View) View.inflate(MainActivity2.this, R.layout.sub_2_2, null);
                ImageView imageView = (ImageView) view1.findViewById(R.id.imageView2);
                TextView textView = (TextView) view1.findViewById(R.id.textView2);

                imageView.setImageResource(sub2[position].getImage1());
                textView.setText(sub2[position].getTxt1());

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);

                builder.setTitle("상세정보");
                builder.setMessage("오늘의 기분");
                builder.setView(view1);
//                builder.setNegativeButton("취소",null);
                builder.setPositiveButton("확인", null);
                builder.show();

            }
        });

    }

    class CustomA extends ArrayAdapter {

        public CustomA(@NonNull Context context, int resource, @NonNull Object[] objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.sub_2, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(sub[position].getImage1());

            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(sub[position].getTxt1());

            return view;
        }
    }
}
package com.lhj.study220707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox5);
        TextView textView = (TextView) findViewById(R.id.textView6);
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton7);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton8);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton9);
        Button button = (Button) findViewById(R.id.button3);
        ImageView imageView = findViewById(R.id.imageView6);
        ImageView imageView2 = findViewById(R.id.imageView3);
        ImageView imageView3 = findViewById(R.id.imageView2);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    radioButton.setVisibility(View.VISIBLE);
                    radioButton2.setVisibility(View.VISIBLE);
                    radioButton3.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    radioButton.setVisibility(View.VISIBLE);
                    radioButton.setVisibility(View.VISIBLE);
                    radioButton.setVisibility(View.VISIBLE);
                } else {
                    radioButton.setVisibility(View.INVISIBLE);
                    radioButton2.setVisibility(View.INVISIBLE);
                    radioButton3.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    radioButton.setVisibility(View.INVISIBLE);
                    radioButton.setVisibility(View.INVISIBLE);
                    radioButton.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton.isChecked()) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                } else if (radioButton2.isChecked()) {
                    imageView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                } else {
                    imageView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
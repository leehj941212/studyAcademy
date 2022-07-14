package com.lhj.study220707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = (Button) findViewById(R.id.button2);
        TextView textView = (TextView) findViewById(R.id.textView2);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName3);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Toast.makeText(getApplicationContext(), editText.getText().toString() ,Toast.LENGTH_SHORT).show();
                textView.setText(editText.getText().toString());

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked() == false)
                Toast.makeText(getApplicationContext(), "aaaaa" ,Toast.LENGTH_SHORT).show();
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "bbbbb" ,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
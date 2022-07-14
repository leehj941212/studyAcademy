package com.lhj.study220707;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        TextView textView = (TextView) findViewById(R.id.textView9);
        TextView textView2 = (TextView) findViewById(R.id.textView10);
        Button button = (Button) findViewById(R.id.button7);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = (View) View.inflate(MainActivity6.this,R.layout.activity_main6_2,null);
                EditText editText = (EditText) view1.findViewById(R.id.editTextTextPersonName4);
                EditText editText2 = (EditText) view1.findViewById(R.id.editTextTextPersonName5);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity6.this);
                builder.setView(view1);
                builder.setTitle("사용자 정보 입력");
                builder.setIcon(R.drawable.qqq);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText(editText.getText());
                        textView2.setText(editText2.getText());
                    }
                });
                builder.setNegativeButton("취소", null);
                builder.show();
            }
        });
    }
}
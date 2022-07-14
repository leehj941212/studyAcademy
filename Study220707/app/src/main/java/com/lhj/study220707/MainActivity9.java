package com.lhj.study220707;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        Button button = (Button) findViewById(R.id.button13);

        Intent intent = getIntent();
        String asdf = intent.getStringExtra("asdf");
        Toast.makeText(this,asdf, Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity8.class);
                intent1.putExtra("cc","dd");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });

    }
}
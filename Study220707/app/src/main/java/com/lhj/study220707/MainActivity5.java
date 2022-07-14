package com.lhj.study220707;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button button = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View view1 = (View) View.inflate(MainActivity5.this, R.layout.activity_main5_2, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
                builder.setView(view1);
                builder.show();
//                builder.setTitle("zxcasd");

//                builder.setMessage("asdzxc");

//                String [] qwera = {"1111","2222","3333"};
//                builder.setItems(qwera, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if (i==0){
//                            Toast.makeText(MainActivity5.this, "111", Toast.LENGTH_SHORT).show();
//                        } else if (i==1){
//                            Toast.makeText(MainActivity5.this, "222", Toast.LENGTH_SHORT).show();
//                        } else if (i==2){
//                            Toast.makeText(MainActivity5.this, "333", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

//                String [] qwera = {"1111","2222","3333"};
//                boolean[] asdfa = {true, false, true};
//                builder.setSingleChoiceItems(qwera,0,null );
//                builder.setMultiChoiceItems(qwera,asdfa,null);


//                builder.setPositiveButton("버튼", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity5.this, "dfg", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("버튼2", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity5.this, "cvb", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setIcon(R.drawable.qqq);
//                builder.show();
            }
        });
    }
}
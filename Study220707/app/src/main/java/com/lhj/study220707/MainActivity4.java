package com.lhj.study220707;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button4);
        registerForContextMenu(button);
        registerForContextMenu(button2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item4) {
            Toast.makeText(this, "123123", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item5) {
            Toast.makeText(this, "qweqwe", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item6) {
            Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v == button){
            menuInflater.inflate(R.menu.menu1,menu);
        } else if (v == button2){
            menuInflater.inflate(R.menu.menu1,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast.makeText(this, "123123", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item2) {
            Toast.makeText(this, "qweqwe", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item3) {
            Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
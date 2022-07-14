package com.lhj.study220714;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.BatteryManager;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(
                this, new String[]{Manifest.permission.READ_CALL_LOG}, MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
//                editText2.setText("123");
            }
        });
    }

    public String getCallHistory() {
        String[] callSet = new String[]{CallLog.Calls.DATE,
                CallLog.Calls.TYPE, CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION};

        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI,
                callSet, null, null, null);

        if (c == null)
            return "통화기록 없음";

        StringBuffer callBuff = new StringBuffer();
        callBuff.append("\n날짜 : 구분 : 전화번호 : 통화시간 \n\n");
        c.moveToFirst();
        do {
            long callDate = c.getLong(0);
            SimpleDateFormat datePattern = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = datePattern.format(new Date(callDate));
            callBuff.append(date_str + ":");
            if (c.getInt(1) == CallLog.Calls.INCOMING_TYPE)
                callBuff.append("착신 :");
            else
                callBuff.append("발신 :");
            callBuff.append(c.getString(2) + ":");
            callBuff.append(c.getString(3) + "초\n");
        } while (c.moveToNext());

        c.close();
        return callBuff.toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int ba = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
//                int ba = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
                editText.setText(ba + "%");
            }
        }
    };

}
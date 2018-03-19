package com.example.a1959freetibet.lab06_2018;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import java.sql.Time;


public class service extends AppCompatActivity {

    TextView textView;
    Button start, stop, reset;
    Handler handler;
    int Secs, Mins, MilliSec;
    long StartTime, MillisecTime, TimeBuff, UpdateTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        textView = (TextView)findViewById(R.id.textView);
        start = (Button)findViewById(R.id.startb);
        stop = (Button)findViewById(R.id.stopb);
        reset = (Button)findViewById(R.id.resetb);

        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimeBuff += MillisecTime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MillisecTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Secs = 0;
                Mins = 0;
                MilliSec = 0;

                textView.setText("00:00:00");
            }
        });
    }

    public Runnable runnable = new Runnable(){
        public void run() {
            MillisecTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = TimeBuff + MillisecTime;
            Secs = (int) (UpdateTime / 1000);
            Mins = Secs/60;
            Secs = Secs%60;
            MilliSec = (int)(UpdateTime % 1000);

            textView.setText("" + Mins + ":"
            + String.format("%02d", Secs) + ":"
            + String.format("%03d", MilliSec));

            handler.postDelayed(this, 0);
        }
    };

    //Method to start the service
    public void startService(View view){
        startService(new Intent(getBaseContext(), MyService.class));
    }

    //Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}

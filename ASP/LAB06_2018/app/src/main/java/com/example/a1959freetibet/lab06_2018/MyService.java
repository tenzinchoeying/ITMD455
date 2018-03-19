package com.example.a1959freetibet.lab06_2018;

import android.app.Service;
import java.util.Timer;
import android.os.Handler;
import java.util.TimerTask;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Tenzin Choeying.
 */

public class MyService extends Service {
    int counter = 0;
    Timer timer = new Timer();
    TimerTask timerTask;
    final Handler handler = new Handler();

    @Override
    public void onCreate(){

    }

    @Override
    public IBinder onBind(Intent arg0) {return null;}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Handler handler = new Handler();
        final Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run(){
                handler.post(() -> {
                    ++counter;
                    Toast.makeText(getApplicationContext(), "Counter:"+counter, Toast.LENGTH_SHORT).show();
                    Log.d("test", "run: ------> "+counter);
                });
            }
        };
        timer.schedule(timerTask, 1000, 3000);
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}

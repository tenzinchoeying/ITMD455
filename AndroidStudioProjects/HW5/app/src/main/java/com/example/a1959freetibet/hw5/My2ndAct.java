package com.example.a1959freetibet.hw5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.os.Handler;

/**
 * Created by 1959freetibet on 2/26/18.
 */
public class My2ndAct extends MainActivity {
    Button myButton;
    int mFlipping = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my2ndact);

        myButton = (Button) findViewById(R.id.back);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(My2ndAct.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipper1);

        flipper.startFlipping();
        mFlipping = 1;
    }
}

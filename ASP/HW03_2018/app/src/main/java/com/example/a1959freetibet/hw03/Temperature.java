package com.example.a1959freetibet.hw03;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Temperature extends AppCompatActivity {
    SeekBar mSeekBar;
    TextView mProgressText;
    TextView mTrackingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        mSeekBar = (SeekBar) findViewById(R.id.seekBarID);
        int p = mSeekBar.getProgress();
        mProgressText = (TextView) findViewById(R.id.FTV);
        mTrackingText = (TextView) findViewById(R.id.FTV);
        final EditText FT = (EditText)
                findViewById(R.id.FT);
        final EditText CT = (EditText)
                findViewById(R.id.CT);
        final TextView coldTV = (TextView)
                findViewById(R.id.coldTV);
        final TextView hotTV = (TextView)
                findViewById(R.id.hotTV);
        final TextView rightTV = (TextView)
                findViewById(R.id.rightTV);
        final ImageView winter = (ImageView)
                findViewById(R.id.winter);
        final ImageView summer = (ImageView)
                findViewById(R.id.summer);
        final ImageView spring = (ImageView)
                findViewById(R.id.spring);


        mSeekBar = (SeekBar) findViewById(R.id.seekBarID);

        mSeekBar.setMax(200);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {

                int currentProgress;
                int ImgRsc;
                currentProgress = seekBar.getProgress();


                if (currentProgress <= 40) {
                    ImgRsc = getResources().getIdentifier("@drawable/winter", "drawable", getPackageName());
                    Drawable res = getResources().getDrawable(ImgRsc);
                    winter.setImageDrawable(res);
                } else if (40 < currentProgress && currentProgress < 90) {
                    ImgRsc = getResources().getIdentifier("@drawable/spring", "drawable", getPackageName());
                    Drawable res = getResources().getDrawable(ImgRsc);
                    spring.setImageDrawable(res);
                } else (currentProgress >= 90){
                    ImgRsc = getResources().getIdentifier("@drawable/summer", "drawable", getPackageName());
                    Drawable res = getResources().getDrawable(ImgRsc);
                    summer.setImageDrawable(res);
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mTrackingText.setText(getString(R.string._0f));

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mTrackingText.setText(getString(R.string.fahrenheit));

            }
        });

    }
}
package com.aniket.spanishnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;
import android.media.SoundPool;


public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    SoundPool SoundPool;
    int sound1,sound2,sound3,sound4,sound5,sound6,sound7,sound8,sound9,sound10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes AudioAttributes = new AudioAttributes.Builder()
                    .setUsage(android.media.AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(android.media.AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            SoundPool = new SoundPool.Builder()
                    .setAudioAttributes(AudioAttributes)
                    .setMaxStreams(10).build();
        }else{
            SoundPool = new SoundPool(10,AudioManager.STREAM_MUSIC,0);
        }

        sound1 = SoundPool.load(this, R.raw.one, 1);
        sound2 = SoundPool.load(this, R.raw.two, 1);
        sound3 = SoundPool.load(this, R.raw.three, 1);
        sound4 = SoundPool.load(this, R.raw.four, 1);
        sound5 = SoundPool.load(this, R.raw.five, 1);
        sound6 = SoundPool.load(this, R.raw.six, 1);
        sound7 = SoundPool.load(this, R.raw.seven, 1);
        sound8 = SoundPool.load(this, R.raw.eight, 1);
        sound9 = SoundPool.load(this, R.raw.nine, 1);
        sound10 = SoundPool.load(this, R.raw.ten, 1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound1,1,1,1,0,1);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound1,1,1,1,0,1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound2,1,1,1,0,1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound3,1,1,1,0,1);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound4,1,1,1,0,1);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound5,1,1,1,0,1);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound6,1,1,1,0,1);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound7,1,1,1,0,1);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound8,1,1,1,0,1);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound9,1,1,1,0,1);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPool.play(sound10,1,1,1,0,1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SoundPool.release();
        SoundPool = null;
    }
}

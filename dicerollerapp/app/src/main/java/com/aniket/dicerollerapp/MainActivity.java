package com.aniket.dicerollerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button rollbtn;
    ImageView img1,img2;
    TextView plonescore,pltwoscore;
    TextView plone,pltwo;
    ImageView reset;
    int flag = 0;//flag 0 for player one and flag 1 for player two
    int dice1,dice2;
    int score1 = 0 ,score2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int imgarr[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
        rollbtn = findViewById(R.id.rollbtn);
        img1 = findViewById(R.id.imgone);
        img2 = findViewById(R.id.imgtwo);
        plone = findViewById(R.id.plone);
        pltwo = findViewById(R.id.pltwo);
        reset = findViewById(R.id.newgame);

        plonescore = findViewById(R.id.plonescore);
        pltwoscore = findViewById(R.id.pltwoscore);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = 0;
                score2 = 0;
                plonescore.setText(String.valueOf(score1));
                pltwoscore.setText(String.valueOf(score2));
                img1.setImageResource(imgarr[0]);
                img2.setImageResource(imgarr[0]);
                pltwo.setBackgroundColor(Color.parseColor("#22017C"));
                plone.setBackgroundColor(Color.parseColor("#18E611"));
                flag = 0;
                rollbtn.setEnabled(true);
                pltwo.setText("player 2");
                plone.setText("player 1");
            }
        });

        rollbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice1 = (int) Math.ceil(Math.random()*6);
                dice2 = (int) Math.ceil(Math.random()*6);
//                Toast.makeText(MainActivity.this,String.valueOf(dice1)+","+String.valueOf(dice2),Toast.LENGTH_LONG).show();
                img1.setImageResource(imgarr[dice1-1]);
                img2.setImageResource(imgarr[dice2-1]);
                if(flag == 0)
                {
                    score1 += dice1+dice2;
                    flag = 1;
                    plonescore.setText(String.valueOf(score1));
                    pltwo.setBackgroundColor(Color.parseColor("#18E611"));
                    plone.setBackgroundColor(Color.parseColor("#22017C"));
                    if(score1 >= 100)
                    {
                        rollbtn.setEnabled(false);
                        plone.setBackgroundColor(Color.parseColor("#E12929"));
                        pltwo.setBackgroundColor(Color.parseColor("#22017C"));
                        plone.setText("winner!!");
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("winner!!");
                        builder.setPositiveButton("Ok",null);

                        AlertDialog alert = builder.create();
                        alert.show();

                    }
                }
                else
                {
                    score2 += dice2+dice1;
                    flag = 0;
                    pltwoscore.setText(String.valueOf(score2));
                    pltwo.setBackgroundColor(Color.parseColor("#22017C"));
                    plone.setBackgroundColor(Color.parseColor("#18E611"));
                    if(score2 >= 100)
                    {
                        rollbtn.setEnabled(false);
                        pltwo.setBackgroundColor(Color.parseColor("#E12929"));
                        plone.setBackgroundColor(Color.parseColor("#22017C"));
                        pltwo.setText("winner!!");
                    }
                }
            }
        });

    }
}

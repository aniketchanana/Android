package com.aniket.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int first = 0,last=0,count=0;
//    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin();
                count++;
                if(count>0){
                    first = last;
                }
                System.out.println("animation over");
            }
        });

    }

    private void spin(){
        int pivotY = imageView.getHeight()/2;
        int pivotX = imageView.getWidth()/2;
        last = (int) (3000 + Math.random()*600);
        System.out.println(last);
        if(last<first)
        {
            last = first+last;
        }
        Animation rotate = new RotateAnimation(first,last,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        imageView.startAnimation(rotate);
    }
}

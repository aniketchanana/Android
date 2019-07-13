package com.aniket.discolight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    SeekBar seek;
    Switch start;
    int blinkInterval;
    boolean isOn = false;
    boolean btnenabled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.btn);
        seek = findViewById(R.id.seek);
        seek.setMax(10);//means max 10seconds


        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ContextCompat.checkSelfPermission(getApplicationContext()
                        , Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {

                    ActivityCompat.requestPermissions(MainActivity.this
                            ,new String[]{Manifest.permission.CAMERA},10);
                }
                else if(start.isChecked())
                {
                    startblink();
                }
            }
        });
    }

    private void startblink(){
        Timer t1 = new Timer();
        if(!start.isChecked()){
            t1.cancel();
            flashLightOff();
            isOn = false;
            return;
        }
        blinkInterval = 1000/(seek.getProgress() == 0?1:seek.getProgress());
//        String str = String.valueOf(blinkInterval);
//        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        t1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(isOn){
                    flashLightOff();
                    isOn = false;
                }else {
                    flashLightOn();
                    isOn = true;
                }
                startblink();
            }
        },blinkInterval);
    }

    void flashLightOn(){
        CameraManager cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,true);
        }catch (Exception e){

        }
    }

    void flashLightOff(){
        CameraManager cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,false);
        }catch (Exception e){

        }
    }
}
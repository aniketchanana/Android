package com.aniket.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    Button play,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void play(View v){
        if(player == null){
            player = MediaPlayer.create(this,R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(View v){
        if(player!=null){
            player.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }
    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this,"Media player released",Toast.LENGTH_SHORT).show();
        }
    }


}

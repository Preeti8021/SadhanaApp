package com.example.projectsadhana;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity {
    Button btnpause,btnplay,btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        MediaPlayer mp=new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String aPath="android.resource://"+getPackageName()+"/raw/music_file";
        Uri audioURI = Uri.parse(aPath);
        try {
            mp.setDataSource(this,audioURI);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnpause=findViewById(R.id.pause);
        btnplay=findViewById(R.id.play);
        btnstop=findViewById(R.id.stop);

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });
    }
}
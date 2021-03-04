package com.kriti.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stop,forward,rewind;
    MediaPlayer mplayer;
    
    int fTime = 5000;
    int bTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        forward = findViewById(R.id.forward);
        rewind = findViewById(R.id.rewind);
        mplayer = MediaPlayer.create(getApplicationContext(),R.raw.first);



        play.setOnClickListener((view)-> {
            mplayer.start();
        });

        pause.setOnClickListener((view)-> {
            mplayer.pause();
        });

        stop.setOnClickListener((view)-> {
            mplayer.stop();
        });

        forward.setOnClickListener((view)-> {
            if (mplayer != null) {
                int currentPosition = mplayer.getCurrentPosition();
                if (currentPosition + fTime <= mplayer.getDuration()) {
                    mplayer.seekTo(currentPosition + fTime);
                } else {
                    mplayer.seekTo(mplayer.getDuration());
                }
            }
        });

        rewind.setOnClickListener((view)-> {
            if (mplayer != null) {
                int currentPosition = mplayer.getCurrentPosition();
                if (currentPosition - bTime >= 0) {
                    mplayer.seekTo(currentPosition - bTime);
                } else {
                    mplayer.seekTo(0);
                }
            }
        });
    }
}
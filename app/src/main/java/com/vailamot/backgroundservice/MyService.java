package com.vailamot.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
     private MediaPlayer mediaPlayer;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("123","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startMusic();
        Log.e("123","onStartCommand");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("123","onDestroy");
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    // Phát nhạc
    private void startMusic() {
        if(mediaPlayer == null){
            mediaPlayer= MediaPlayer.create(getApplicationContext(), R.raw.song);
        }
        mediaPlayer.start();
    }
}
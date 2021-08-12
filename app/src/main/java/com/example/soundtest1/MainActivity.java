package com.example.soundtest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvAudioNatural, rcvTraffic, rcvFurniture, rcvSound;
    AudioAdapter audioAdapterNatrual, audioAdapterTraffic,
                 audioAdapterFurniture, audioAdapterSound;
    MediaPlayer mediaPlayer;
    Audio selectedAudio;
    String check = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }



    private void addControls() {

        // setAdapter for rcvNatural
        rcvAudioNatural = findViewById(R.id.rcvNatural);
        audioAdapterNatrual = new AudioAdapter(MainActivity.this, new IClickItemListener() {
            @Override
            public void onClickItem(Audio audio) {
                solveOnClick(audio);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        rcvAudioNatural.setLayoutManager(gridLayoutManager);
        audioAdapterNatrual.setData(getListDataNatural());
        rcvAudioNatural.setAdapter(audioAdapterNatrual);


        // setAdapter for rcvTraffic
        rcvTraffic = findViewById(R.id.rcvTraffic);
        audioAdapterTraffic = new AudioAdapter(MainActivity.this, new IClickItemListener() {
            @Override
            public void onClickItem(Audio audio) {
                solveOnClick(audio);
            }
        });
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this,4);
        rcvTraffic.setLayoutManager(gridLayoutManager1);
        audioAdapterTraffic.setData(getListDataTraffic());
        rcvTraffic.setAdapter(audioAdapterTraffic);


        // setAdapter for rcvFurniture
        rcvFurniture = findViewById(R.id.rcvFurniture);
        audioAdapterFurniture = new AudioAdapter(MainActivity.this, new IClickItemListener() {
            @Override
            public void onClickItem(Audio audio) {
                solveOnClick(audio);
            }
        });
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,4);
        rcvFurniture.setLayoutManager(gridLayoutManager2);
        audioAdapterFurniture.setData(getListDataFurniture());
        rcvFurniture.setAdapter(audioAdapterFurniture);


        // setAdapter for rcvSound
        rcvSound = findViewById(R.id.rcvSound);
        audioAdapterSound = new AudioAdapter(MainActivity.this, new IClickItemListener() {
            @Override
            public void onClickItem(Audio audio) {
                solveOnClick(audio);
            }
        });
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this,4);
        rcvSound.setLayoutManager(gridLayoutManager3);
        audioAdapterSound.setData(getListDataSound());
        rcvSound.setAdapter(audioAdapterSound);


    }

    private List<Audio> getListDataSound() {
        List<Audio> list = new ArrayList<>();
        list.add(new Audio("sound", R.raw.whitenoise, R.drawable.ic_soundwave));
        return list;
    }

    private List<Audio> getListDataFurniture() {
        List<Audio> list = new ArrayList<>();
        list.add(new Audio("washingmachine", R.raw.washingmachine, R.drawable.ic_washingmachine));
        list.add(new Audio("vacuum", R.raw.vacuumcleaner, R.drawable.ic_vacuum));
        list.add(new Audio("clock", R.raw.clock, R.drawable.ic_clock));
        list.add(new Audio("radio", R.raw.radio, R.drawable.ic_radio));
        list.add(new Audio("hairdryer", R.raw.hairdryer, R.drawable.ic_hairdryer));
        list.add(new Audio("fan", R.raw.fan, R.drawable.ic_fan));
        list.add(new Audio("shower", R.raw.shower, R.drawable.ic_shower));
        list.add(new Audio("catsnores", R.raw.catsnores, R.drawable.ic_cat));

        return list;
    }

    private List<Audio> getListDataTraffic() {
        List<Audio> list = new ArrayList<>();
        list.add(new Audio("car", R.raw.car, R.drawable.ic_car));
        list.add(new Audio("truck", R.raw.truck, R.drawable.ic_truck));
        list.add(new Audio("train", R.raw.train, R.drawable.ic_train));
        list.add(new Audio("plane", R.raw.plane, R.drawable.ic_airplane));

        return list;
    }

    private List<Audio> getListDataNatural() {
        List<Audio> list = new ArrayList<>();
        list.add(new Audio("wave", R.raw.wave, R.drawable.ic_wave));
        list.add(new Audio("fire", R.raw.fire, R.drawable.ic_fire));
        list.add(new Audio("waterflowing", R.raw.waterflowing, R.drawable.ic_river));
        list.add(new Audio("forest", R.raw.forest, R.drawable.ic_forest));
        list.add(new Audio("heartbeat", R.raw.heartbeat, R.drawable.ic_heart));
        list.add(new Audio("windy", R.raw.plane, R.drawable.ic_windy));
        list.add(new Audio("rain", R.raw.rain, R.drawable.ic_rainy));
        list.add(new Audio("crikets", R.raw.crikets, R.drawable.ic_insect));

        return list;
    }

    private void solveOnClick(Audio audio) {
        selectedAudio = audio;
        if(mediaPlayer == null ) {
            mediaPlayer = MediaPlayer.create(MainActivity.this,selectedAudio.getMusic_file());
        }
        else{
            if(selectedAudio.getKey().equals(check)) {

            }
            else  {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(MainActivity.this,selectedAudio.getMusic_file());
            }
        }
        check = audio.getKey();
        mediaPlayer.setLooping(true);
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        else {
            mediaPlayer.start();
        }
    }
}
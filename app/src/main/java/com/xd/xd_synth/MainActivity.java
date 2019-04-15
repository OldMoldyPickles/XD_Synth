package com.xdavis.XD_Synth;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final int WHOLE_NOTE = 1000;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button11;
    private Button button12;
    private CheckBox checkBox;
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private MediaPlayerThread mpt;
    private MediaPlayer mpE;
    private MediaPlayer mpF;
    private MediaPlayer mpFs;
    private MediaPlayer mpGs;
    private MediaPlayer mpA;
    private MediaPlayer mpB;
    private MediaPlayer mpCs;
    private MediaPlayer mpDs;
    private MediaPlayer mpEh;
    private MediaPlayer mpFhs;
    private MediaPlayer mpD;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button11 = (Button)findViewById(R.id.button11);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        mpt = new MediaPlayerThread (MainActivity.this);
        mpE = MediaPlayer.create(this, R.raw.scalee);
        mpF = MediaPlayer.create(this, R.raw.scalef);
        mpFs = MediaPlayer.create(this, R.raw.scalefs);
        mpGs = MediaPlayer.create(this, R.raw.scalegs);
        mpA = MediaPlayer.create(this, R.raw.scalea);
        mpB = MediaPlayer.create(this, R.raw.scaleb);
        mpCs = MediaPlayer.create(this, R.raw.scalecs);
        mpDs = MediaPlayer.create(this, R.raw.scaleds);
        mpEh = MediaPlayer.create(this, R.raw.scalehighe);
        mpFhs = MediaPlayer.create(this, R.raw.scalehighfs);
        mpD = MediaPlayer.create(this, R.raw.scaled);
        final MediaPlayer [] Challenge3 = {mpE, mpFs, mpGs, mpA, mpB, mpCs, mpDs, mpE};
        final int[] Challenge2 = {R.raw.scalea, R.raw.scaleb, R.raw.scalebb, R.raw.scalec, R.raw.scalecs, R.raw.scaled, R.raw.scaleds, R.raw.scalee, R.raw.scalef, R.raw.scalefs, R.raw.scaleg, R.raw.scalegs, R.raw.scalehighe, R.raw.scalehighf, R.raw.scalehighfs, R.raw.scalehighg};
        final int[] Challenge7 = {R.raw.scalea, R.raw.scalea, R.raw.scalehighe, R.raw.scalehighe, R.raw.scalehighfs, R.raw.scalehighfs, R.raw.scalehighe, R.raw.scaled, R.raw.scaled, R.raw.scalecs, R.raw.scalecs, R.raw.scaleb, R.raw.scaleb, R.raw.scalea};
        final int[] Challenge9 = {R.raw.scalehighe, R.raw.scalehighe, R.raw.scaled, R.raw.scaled, R.raw.scalecs, R.raw.scalecs, R.raw.scaleb};
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.notes, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.times, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.times, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);

        button1.setOnClickListener(new View.OnClickListener() {
            private void delayPlaying(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Log.e("Synthesizer_Activity","Audio playback interrupted.");
                }
            }
            @Override
            public void onClick(View v) {
                mpE.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            private void delayPlaying(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Log.e("Synthesizer_Activity","Audio playback interrupted.");
                }
            }
            @Override
            public void onClick(View v) {
                mpF.start();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            //challenge 1
            private void delayPlaying(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Log.e("Synthesizer_Activity","Audio playback interrupted.");
                }
            }
            @Override
            public void onClick(View v) {
                mpE.start(); delayPlaying(WHOLE_NOTE/2);
                mpFs.start(); delayPlaying(WHOLE_NOTE/2);
                mpGs.start(); delayPlaying(WHOLE_NOTE/2);
                mpA.start(); delayPlaying(WHOLE_NOTE/2);
                mpB.start(); delayPlaying(WHOLE_NOTE/2);
                mpCs.start(); delayPlaying(WHOLE_NOTE/2);
                mpDs.start(); delayPlaying(WHOLE_NOTE/2);
                mpE.start(); delayPlaying(WHOLE_NOTE/2);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            //challenge 2
            @Override
            public void onClick(View v) {
                int i;
                for (i = spinner2.getSelectedItemPosition() + 1; i > 0; i--) {
                    mpt.playNote(Challenge2[spinner.getSelectedItemPosition()], WHOLE_NOTE);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            //challenge 3
            private void delayPlaying(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Log.e("Synthesizer_Activity","Audio playback interrupted.");
                }
            }
            @Override
            public void onClick(View v) {
                for(MediaPlayer x: Challenge3) {
                    x.start();
                    delayPlaying(WHOLE_NOTE/2);
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            //challenge 5
            private void delayPlaying(int delay) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Log.e("Synthesizer_Activity","Audio playback interrupted.");
                }
            }
            @Override
            public void onClick(View v) {
                mpA.start(); delayPlaying(WHOLE_NOTE/2);
                mpA.start(); delayPlaying(WHOLE_NOTE/2);
                mpEh.start(); delayPlaying(WHOLE_NOTE/2);
                mpFhs.start(); delayPlaying(WHOLE_NOTE/2);
                mpFhs.start(); delayPlaying(WHOLE_NOTE/2);
                mpEh.start(); delayPlaying(WHOLE_NOTE/2);
                mpD.start(); delayPlaying(WHOLE_NOTE/2);
                mpD.start(); delayPlaying(WHOLE_NOTE/2);
                mpCs.start(); delayPlaying(WHOLE_NOTE/2);
                mpCs.start(); delayPlaying(WHOLE_NOTE/2);
                mpB.start(); delayPlaying(WHOLE_NOTE/2);
                mpB.start(); delayPlaying(WHOLE_NOTE/2);
                mpA.start(); delayPlaying(WHOLE_NOTE/2);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            //challenge 7
            @Override
            public void onClick(View v) {
                int i;
                for(i=0; i < Challenge7.length; i++){
                    mpt.playNote(Challenge7[i], WHOLE_NOTE);
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            //challenge 8
            @Override
            public void onClick(View v) {
                int i;
                for(i=0; i < Challenge7.length; i++){
                    mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            //challenge 9
            @Override
            public void onClick(View v) {
                int i;
                for(i=0; i < Challenge7.length; i++){
                    mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                }
                for(i = 0; i < Challenge9.length; i++){
                    mpt.playNote(Challenge9[i], WHOLE_NOTE/2);
                }
                for(i=0; i < Challenge7.length; i++){
                    mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            //challenge 10 and 11
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    int i;
                    for(i=0; i < Challenge7.length; i++){
                        mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                    }
                    for(i = spinner3.getSelectedItemPosition() + 1; i > 0; i--) {
                        for (i = 0; i < Challenge9.length; i++) {
                            mpt.playNote(Challenge9[i], WHOLE_NOTE / 2);
                        }
                    }
                    for(i=0; i < Challenge7.length; i++){
                        mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                    }
                }
                else {
                    int i;
                    for(i=0; i < Challenge7.length; i++){
                        mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                    }
                    for(i=0; i < Challenge7.length; i++){
                        mpt.playNote(Challenge7[i], WHOLE_NOTE/2);
                    }
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
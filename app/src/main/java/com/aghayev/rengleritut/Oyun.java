package com.aghayev.rengleritut;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Oyun extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
    int score;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView [] imageArray;
    Handler handler;
    Runnable runnable;
    MediaPlayer coinSound;
    MediaPlayer sesSound;
    MediaPlayer alSound;
    int level;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        timeText =  findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15= findViewById(R.id.imageView15);
        coinSound = MediaPlayer.create(this,R.raw.coin);
        sesSound = MediaPlayer.create(this,R.raw.pirc);
        alSound = MediaPlayer.create(this, R.raw.almaq);


        imageArray = new ImageView [] {imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15};
        hideImage();
        score = 0;


        new CountDownTimer(15000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Vaxt: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Vaxt bitdi: ");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Intent intent = new Intent(Oyun.this,Son.class);
                intent.putExtra("Score",score);
                startActivity(intent);
                onStop();

            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    public void increaseScore(View view){

        score++;
        coinSound.start();
        scoreText.setText("Xal: " + score);



    }

    public void score(View view){

        score = score +4;
        alSound.start();
        scoreText.setText("Xal: " + score);



    }

    public void negative (View view){

        score = score -2 ;
        sesSound.start();
        scoreText.setText("Xal: " + score);




    }


    public void hideImage(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){

                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(12);
                imageArray[i].setVisibility(View.VISIBLE);
                Intent gelenIntent = getIntent();
                level = gelenIntent.getIntExtra("level", 500);
                handler.postDelayed(this,level);

            }
        };

        handler.post(runnable);

    }
}
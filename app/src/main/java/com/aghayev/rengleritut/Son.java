package com.aghayev.rengleritut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.aghayev.rengleritut.MainActivity.recScore;

public class Son extends AppCompatActivity {

    TextView  endText,endScore;
    int rec,score;
    MediaPlayer alkisSound;
    MediaPlayer gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son);

        endText = findViewById(R.id.endText);
        endScore = findViewById(R.id.scoreText);
        alkisSound = MediaPlayer.create(this,R.raw.alkis);
        gameOver = MediaPlayer.create(this,R.raw.gameover);

        rec = recScore.getInt("Record",0);
        Intent intent = getIntent();
        score = intent.getIntExtra("Score",0);

        if(score>rec){
            endText.setText("Siz rekord qırdınız");
            endScore.setText("Sizin xalınız:\n" + score);
            alkisSound.start();
            recScore.edit().putInt("Record",score).apply();
        }else{
            gameOver.start();
            endText.setText("Oyun Bitdi!");
            endScore.setText("Sizin xalınız:\n" + score);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public void gohome(View view){
        Intent intent = new Intent(Son.this,MainActivity.class);
        startActivity(intent);
    }
}
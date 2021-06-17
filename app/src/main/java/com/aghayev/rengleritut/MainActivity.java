package com.aghayev.rengleritut;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int recScoreInt;
    TextView recText,textView;
    Button deleteBtn;

    public static SharedPreferences recScore;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recScore  = this.getSharedPreferences("com.aghayev.rengleritut", Context.MODE_PRIVATE);
        recScoreInt = recScore.getInt("Record",0);
        deleteBtn = findViewById(R.id.btnDelete);
        recText = findViewById(R.id.recordText);
        textView = findViewById(R.id.textView);
        recText.setVisibility(View.INVISIBLE);
        deleteBtn.setVisibility(View.INVISIBLE);
        if(recScoreInt>0){
            recText.setText("Yeni Rekord:\n" + recScoreInt);
            recText.setVisibility(View.VISIBLE);
            deleteBtn.setVisibility(View.VISIBLE);
            textView.setText("Təkrar Xoş Gəlmisiniz");
        }
    }

    @Override
    public void onBackPressed() {

        moveTaskToBack(true);
    }

    public void basla (View view){

        Intent intent = new Intent(MainActivity.this,Giris.class);
        startActivity(intent);
        onStop();
    }
    public void deleteRec(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        alert.setTitle("Razısınız?");
        alert.setMessage("Sizin rekordunuz silinəcək.");
        alert.setPositiveButton("Bəli", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                recScore.edit().remove("Record").apply();
                recText.setVisibility(View.INVISIBLE);
                deleteBtn.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this,"Rekordunuz silindi!",Toast.LENGTH_LONG).show();

            }
        });

        alert.setNegativeButton("Xeyr", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Oyun yaddaşdadır!", Toast.LENGTH_LONG).show();
            }
        });

        alert.show();


    }
}
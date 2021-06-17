package com.aghayev.rengleritut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Giris extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void easy(View view){
        Intent intent = new Intent(Giris.this, com.aghayev.rengleritut.Oyun.class);
        intent.putExtra("level", 520);

        startActivity(intent);
        onStop();
    }

    public void medium(View view){
        Intent intent = new Intent(Giris.this, com.aghayev.rengleritut.Oyun.class);
        intent.putExtra("level", 450);
        startActivity(intent);
        onStop();
    }

    public void hard(View view){
        Intent intent = new Intent(Giris.this, com.aghayev.rengleritut.Oyun.class);
        intent.putExtra("level", 300);

        startActivity(intent);
        onStop();
    }
}
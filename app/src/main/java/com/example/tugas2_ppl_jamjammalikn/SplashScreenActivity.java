package com.example.tugas2_ppl_jamjammalikn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    //Kodingan Jamjam Malik Nurjaman

    private String TAG = SplashScreenActivity.class.getSimpleName();
    private int TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,
                        PesananActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_OUT);
    }
}
package com.example.talha.projectdatastructure;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class StartingActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
//    private int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
//
//        if (progress ==0 || progress ==10){
//            mProgressBar.setVisibility(View.VISIBLE);
//            mProgressBar.setMax(100);
//        }
//
//        else if(progress < mProgressBar.getMax()){
//            mProgressBar.setProgress(progress);
//        }
//
//        else if(progress == 100){
//            Intent i = new Intent(StartingActivity.this, LoginActivity.class);
//            startActivity(i);
//        }
//
//        else {
//            mProgressBar.setProgress(0);
//            mProgressBar.setSecondaryProgress(0);
//            progress = 0;
//            mProgressBar.setVisibility(View.GONE);
//        }
//        progress = progress +10;

        mProgressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(StartingActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}

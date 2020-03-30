package com.jerry.km3practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, QualitativeAnalysis.class);
                startActivity(intent);
                finish();
            }
        }, 1600);
    }
}

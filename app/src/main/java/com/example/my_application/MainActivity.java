package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
//    potrzebne do pisania logow w Logcat
    private static final String TAG = "onCreatedMethodSHOW";

//    wypisywanie daty w elemncie TextView (android)
    TextView textView_output;
//    utowrzenie przycisku aby wystartowal Kalkulator
    Button launchCalculator;
    Button exitProgram;

    //    lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_output = findViewById(R.id.output);
        launchCalculator = findViewById(R.id.l_turnOnTheCalculator);
        exitProgram = findViewById(R.id.exit);

        launchCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              Navigate from MainActivity to Main3Activity
                Intent intent = new Intent(MainActivity.this, Kalkulator.class);
                startActivity(intent);
            }
        });

        exitProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    //    lifecycle
    @Override
    protected void onStart() {
        super.onStart();
    }

    //    lifecycle
    @Override
    protected void onResume() {
        super.onResume();
    }

    //    lifecycle
    @Override
    protected void onPause() {
        super.onPause();
    }

    //    lifecycle
    @Override
    protected void onStop() {
        super.onStop();
    }

    //    lifecycle
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    //    lifecycle
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

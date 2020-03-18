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

    //    lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pisanie logów w Logcat
        Log.i(TAG, "onCreate CALLED");

//        zrob referencje do textView_output elementu o id: output;
        textView_output = findViewById(R.id.output);
        launchCalculator = findViewById(R.id.l_turnOnTheCalculator);

        launchCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date date = new Date();
//              ustawia text("argument") do textView: output
                textView_output.setText("Dzis jest "+ date.toString());


//              powiadomienie na dole ekranu :)
                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


//              Navigate from MainActivity to Main3Activity
                Intent intent = new Intent(MainActivity.this, Kalkulator.class);
                startActivity(intent);
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

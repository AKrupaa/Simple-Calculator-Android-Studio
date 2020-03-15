package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
//    potrzebne do pisania logow w Logcat
    private static final String TAG = "onCreatedMethodSHOW";

//    wypisywanie daty w elemncie TextView (android)
    TextView textView_output;


    //    lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pisanie logów w Logcat
        Log.i(TAG, "onCreate CALLED");

//        zrob referencje do textView_output elementu o id: output;
        textView_output = findViewById(R.id.output);
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

//    wyskoczy tekst kliknales przycisk AC
    public void clickHandler(View view) {
        Date date = new Date();

        textView_output.setText("Dzis jest "+ date.toString());

        Toast.makeText(this,"Kliknales przycisk AC", Toast.LENGTH_LONG).show();
    }
}

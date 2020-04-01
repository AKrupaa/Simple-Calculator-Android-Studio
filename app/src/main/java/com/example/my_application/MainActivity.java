package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
    Button launchCalculatorAdvanced;
    Button launchCalculatorSimple;
    Button launchInfo;
    Button exitProgram;

    //    lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchCalculatorAdvanced = findViewById(R.id.turnOnTheCalculatorAdvanced);
        launchCalculatorSimple = findViewById(R.id.turnOnTheCalculatorSimple);
        launchInfo = findViewById(R.id.turnOnTheInfo);
        exitProgram = findViewById(R.id.exit);

        launchInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = "Informacje o twórcy";
                final String message = "Wykonał i opracował:\n\n\nArkadiusz Krupiński, Poland\n\n\n" +
                        "Aby rozpocząć wybierz swoją wersję kalkulatora";

                popUp(title, message);
            }
        });

        launchCalculatorSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Navigate from MainActivity to Main3Activity
                Intent intent = new Intent(MainActivity.this, Kalkulator.class);
                intent.putExtra("isThisSimpleCalculator", "1");
                startActivity(intent);
            }
        });

        launchCalculatorAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Navigate from MainActivity to Main3Activity
                Intent intent = new Intent(MainActivity.this, Kalkulator.class);
                intent.putExtra("isThisSimpleCalculator", "0");
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

    // szkoda ze ne wiem jak wyslac funkcje, wiec to bedzie tylko na potrzeby info o mnie
    private void popUp(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                //set icon
                .setIcon(android.R.drawable.ic_dialog_alert)
                //set title
                .setTitle(title)
                //set message
                .setMessage(message)
                //set positive button
                .setPositiveButton("Zrozumiałem!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        //nothing happened
//                        finish();
                    }
                })
                //set negative button
                .setNegativeButton("Sprwadź mój GitHub", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what should happen when negative button is clicked
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/AKrupaa"));
                        startActivity(browserIntent);
                    }
                })
                .show();
    }
}

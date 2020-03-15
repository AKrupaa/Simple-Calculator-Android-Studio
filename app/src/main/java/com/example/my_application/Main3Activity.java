package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Button btn_ac, btn_del, btn_percent, btn_division, btn_seven, btn_eight, btn_nine, btn_multiply, btn_four, btn_five, btn_six, btn_subtraction;
    Button btn_one, btn_two, btn_three, btn_addition, btn_swap, btn_zero, btn_dot, btn_equals;
    TextView textView_input, textView_output;

    String stringContainer = "";

    public void setButtons() {
        this.btn_ac = findViewById(R.id.ac);
        this.btn_del = findViewById(R.id.del);
        this.btn_percent = findViewById(R.id.percent);
        this.btn_division = findViewById(R.id.division);
        this.btn_seven = findViewById(R.id.seven);
        this.btn_eight = findViewById(R.id.eight);
        this.btn_nine = findViewById(R.id.nine);
        this.btn_multiply = findViewById(R.id.multiply);
        this.btn_four = findViewById(R.id.four);
        this.btn_five = findViewById(R.id.five);
        this.btn_six = findViewById(R.id.six);
        this.btn_subtraction = findViewById(R.id.subtraction);
        this.btn_one = findViewById(R.id.one);
        this.btn_two = findViewById(R.id.two);
        this.btn_three = findViewById(R.id.three);
        this.btn_addition = findViewById(R.id.addition);
        this.btn_swap = findViewById(R.id.swap);
        this.btn_zero = findViewById(R.id.zero);
        this.btn_dot = findViewById(R.id.dot);
        this.btn_equals = findViewById(R.id.equals);
    }

    public void setTextView() {
        textView_input = findViewById(R.id.input);
        textView_output = findViewById(R.id.output);
    }

    public String addToStringContainer(Button button) {
        this.stringContainer = this.stringContainer + button.getText().toString();
        return this.stringContainer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        findViewById buttons
        setButtons();
//        findViewById buttons
        setTextView();

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.setText("");
                textView_output.setText("");
            }
        });

        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_seven);
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_output.setText(stringContainer);
            }
        });
    }
}

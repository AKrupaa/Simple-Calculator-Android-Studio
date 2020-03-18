package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class Kalkulator extends AppCompatActivity {

    Button btn_ac, btn_del, btn_percent, btn_division, btn_seven, btn_eight, btn_nine, btn_multiply, btn_four, btn_five, btn_six, btn_subtraction;
    Button btn_one, btn_two, btn_three, btn_addition, btn_swap, btn_zero, btn_dot, btn_equals;
    TextView textView_input, textView_output;

    String stringContainer = "";


    void makeToast(String typeWhatYouWantToSeeAsAString) {
//                    powiadomienie na dole ekranu :)
            android.content.Context context = getApplicationContext();
            CharSequence text = typeWhatYouWantToSeeAsAString;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
    }

    public String mathStringToNumbers(String evaluation) {
//      https://stackoverflow.com/questions/1454425/reference-javax-script-scriptengine-in-android-or-evaluate-a-javascript-expressi
        Context rhino = Context.enter();
//      turn off optimization to work with android
        rhino.setOptimizationLevel(-1);

//        String evaluation = stringContainer;
        String result;

        Scriptable scope = rhino.initStandardObjects();

        evaluation = evaluation.replaceAll("x", "*");

        if(evaluation.endsWith("/") || evaluation.endsWith("*") || evaluation.endsWith("-") || evaluation.endsWith("+")) {


//            makeToast("Warunek spelniony");
            evaluation = removeLastCharacter(evaluation);
            textView_input = replaceTheContentOfTextView(textView_input, evaluation);
            setStringContainer(evaluation);
        }

//            makeToast("Warunek nie spelniony");
        result = rhino.evaluateString(scope, evaluation , "JavaScript", 1, null).toString();

        return result;
    }

    public void setButtons()
//    ustawia wszystkie przyciski, uzywajac findViewById()
    {
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

    public void setTextView()
//    ustawia wszystkie textViews, uzywajac findViewById()
    {
        textView_input = findViewById(R.id.input);
        textView_output = findViewById(R.id.output);
    }

    public String addToStringContainer(Button button)
//    dodaje symbole do pojemnika na string
    {
        this.stringContainer = this.stringContainer + button.getText().toString();
        textView_input.setText(this.stringContainer);
        return this.stringContainer;
    }

    public String removeLastCharacter(String str) {
        String result = "";
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
//        Toast.makeText(this, "value is " + result, Toast.LENGTH_SHORT).show();
        return result;
    }

    public TextView replaceTheContentOfTextView(TextView textView, String text_to_replace) {
        textView.setText(text_to_replace);
        return textView;
    }

    public void setStringContainer(String stringContainer) {
        this.stringContainer = stringContainer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
//    gdy stworzysz aplikację
    {
        super.onCreate(savedInstanceState);
//        ustaw activity_main3
        setContentView(R.layout.activity_main3);

//        findViewById buttons
        setButtons();
//        findViewById buttons
        setTextView();

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                czyści stringContainer oraz wszystkie textViewsy

//                to jest w androidzie
                textView_input.setText("");
                textView_output.setText("");

//                to jest w javce => class String
                stringContainer = "";
            }
        });

        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_nine);
            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_eight);
            }
        });

        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_seven);
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_six);
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_five);
            }
        });

        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_four);
            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_three);
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_two);
            }
        });

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_one);
            }
        });

        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_zero);
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_dot);
            }
        });

        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_percent);
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_division);
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_multiply);
            }
        });

        btn_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_subtraction);
            }
        });

        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = addToStringContainer(btn_addition);
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = removeLastCharacter(stringContainer);
                textView_input.setText(stringContainer);
            }
        });

//        równa się?
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
            String result = mathStringToNumbers(stringContainer);
            textView_output.setText(result);
            }
        });
    }
}

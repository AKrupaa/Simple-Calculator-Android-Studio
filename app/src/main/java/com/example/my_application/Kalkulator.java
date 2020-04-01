package com.example.my_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;


public class Kalkulator extends AppCompatActivity {

    private Button btn_ac, btn_del, btn_percent, btn_division, btn_seven, btn_eight, btn_nine, btn_multiply, btn_four, btn_five, btn_six, btn_subtraction;
    private Button btn_one, btn_two, btn_three, btn_addition, btn_zero, btn_dot, btn_equals, btn_openBracket, btn_closeBracket;
    private Button btn_ln, btn_sin, btn_cos, btn_tan, btn_log, btn_exp, btn_opposite;
    private TextView textView_input;

//    tu przechowuje wynik działania
    private String stringContainer = "";
//  info: (int) 1 => cal prosty, (int) 0 => cal zaawansowany
    int chosenOne = 1;

    //      powiadomienie na dole ekranu :)
    void makeToast(String typeWhatYouWantToSeeAsAString) {
        android.content.Context context = getApplicationContext();
        CharSequence text = typeWhatYouWantToSeeAsAString;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //    ---------------------------------------------------the most important fragment of code-----------------------------------------------------
    public String mathStringToNumbers(String evaluation) {

//            implementation 'org.mariuszgromada.math:MathParser.org-mXparser:4.4.2'
//            >> build.grade <<
        String result;

//        Expression e = new Expression("2^3*2");
        evaluation = evaluation.replaceAll("x", "*");
//        reszta z dzielenia > operator #
        evaluation = evaluation.replaceAll("%", "#");
//        bo ktos zapomni w logX(Y)
        evaluation = evaluation.replaceAll("X", "10");
        Expression e = new Expression(evaluation);
        double abc = e.calculate();
        result = Double.toString(abc);

////        jeżeli nie ma wyrażenia matematycznego...
//        if( evaluation.length() == 0 )
//            evaluation = "0";
//
////        jeżeli pierwszy znak jest specjalny, ale dalej nie ma cyfr...
//        if ( (theLastOfUs(evaluation.substring(0,1))) && evaluation.length() == 1 ) {
//            evaluation = "0";
//            makeToast("To nie jest wyrażenie matematyczne");
//        }
//
////        jezeli na koncu jest znak specjalny
//        if( theLastOfUs(evaluation) )
//            evaluation = removeLastCharacter(evaluation);
//
////        na poczatku jest znak specjalny inny niz minus => jest to blad uzytkownika
//        if ( minusTheLastOfUs(evaluation.substring(0,1)) ) {
//            evaluation = "0";
//            makeToast("Zacząłeś znakiem specjalnym");
//        }
//
////        sprawdza liczbe ( ) i je uzupelnia
//        evaluation = checkBrackets(evaluation);
//
//        evaluation = evaluation.replaceAll("x", "*");


        return result;
    }
//    ---------------------------------------------------the most important fragment of code-----------------------------------------------------

    /*

    public String checkBrackets(String string) {
        String result = "";
        int valuesOfBrackets = 0;

        for(int i = 0; i < string.length(); i ++) {
            if (string.charAt(i) == '(')
                valuesOfBrackets ++;

            if (string.charAt(i) == ')')
                valuesOfBrackets--;
        }

        if (valuesOfBrackets > 0) {
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0; i < valuesOfBrackets; i++)
                stringBuilder.append(")");
            string = stringBuilder.toString();
        }

        if (valuesOfBrackets < 0) {
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = valuesOfBrackets; i < 0; i++) {
                stringBuilder.insert(0, "(");
            }
            string = stringBuilder.toString();
        }

//      działa pełnosprytnie
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '(' && string.charAt(i+1) ==')' && i+1 != string.length()) {
                result = "0";
                makeToast("Oszukujesz z nawiasami");
                return result;
            }
        }

        result = string;
        return result;
    }

    */

    public String changeValueOfStringToOpposite(String string) {
        String result;

//      jeżeli nie ma wyrażenia matematycznego...
        if(string.length() == 0)
            string = "0";

//        jeżeli 1 znak jest specjalny, ale dalej nie ma cyfr...
        if(theLastOfUs(string.substring(0,1)) && string.length() == 1)
            string = "0";

//        jeżeli na końcu jest znak specjalny
        if(theLastOfUs(string) )
            string = removeLastCharacter(string);

        result = "-(" + string + ")";

        return result;
    }

    public Boolean theLastOfUs(String s) {
        if ( s.endsWith("/") || s.endsWith("*") || s.endsWith("x") || s.endsWith("-") || s.endsWith("+") || s.endsWith(".") || s.endsWith("%") || s.endsWith(")") ) {
            return true;
        } else {
            return false;
        }
    }

//    public Boolean minusTheLastOfUs(String s) {
//        if ( s.endsWith("/") || s.endsWith("*") || s.endsWith("x") || s.endsWith("+") || s.endsWith(".") || s.endsWith("%") ) {
//            return true;
//        } else
//            return false;
//    }

    private void setAdvancedButtons()
    {
        this.btn_openBracket = findViewById(R.id.openBracket);
        this.btn_closeBracket = findViewById(R.id.closeBracket);
        this.btn_ln = findViewById(R.id.ln);
        this.btn_sin = findViewById(R.id.sin);
        this.btn_cos = findViewById(R.id.cos);
        this.btn_tan = findViewById(R.id.tan);
        this.btn_log = findViewById(R.id.log);
        this.btn_exp = findViewById(R.id.exp);
    }
    //    ustawia wszystkie przyciski, uzywajac findViewById()
    public void setButtons()
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
//        this.btn_swap = findViewById(R.id.swap);
        this.btn_zero = findViewById(R.id.zero);
        this.btn_dot = findViewById(R.id.dot);
        this.btn_equals = findViewById(R.id.equals);
        this.btn_opposite = findViewById(R.id.oppositeValue);
        if(chosenOne == 0)  // cal zaawansowany
        setAdvancedButtons();
    }

    public void setTextView()
//    ustawia wszystkie textViews, uzywajac findViewById()
    {
        textView_input = findViewById(R.id.input);
//        textView_output = findViewById(R.id.output);
    }

    public String addToStringContainer(Button button)
//    dodaje symbole do pojemnika na string
//    i aktualizuje od razu textView_input
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
        return result;
    }

    public TextView replaceTheContentOfTextView(TextView textView, String text_to_replace) {
        textView.setText(text_to_replace);
        return textView;
    }

    public void setStringContainer(String stringContainer) {
        this.stringContainer = stringContainer;
    }

    public void changeTheLastOfUsIfPrevious(Button button) {
        if(theLastOfUs(stringContainer)){
            stringContainer = removeLastCharacter(stringContainer);
            textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
        }

        stringContainer = addToStringContainer(button);
    }

//   --------------------------------------------------- przechowywanie info przy ROTACJI ---------------------------------------------------
//      https://stackoverflow.com/questions/151777/how-to-save-an-activity-state-using-save-instance-state?page=1&tab=votes#tab-top
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        outState.putString("stringContainer", stringContainer);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        stringContainer = savedInstanceState.getString("stringContainer");
        setStringContainer(stringContainer);
        textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
    }
//      https://stackoverflow.com/questions/151777/how-to-save-an-activity-state-using-save-instance-state?page=1&tab=votes#tab-top
//    --------------------------------------------------- przechowywanie info przy ROTACJI ---------------------------------------------------


    @Override
    protected void onCreate(Bundle savedInstanceState)
//    gdy stworzysz aplikację
    {
        super.onCreate(savedInstanceState);
        //odbieram info z poprzedniej aktywnosci :)))) ------------------------------------------------------------------
        Intent intent = getIntent();
        String message = intent.getStringExtra("isThisSimpleCalculator");
        chosenOne = Integer.valueOf(message);

        //        ustaw activity_main3
        if(chosenOne == 0)
            setContentView(R.layout.activity_main3);            // ustaw zaawansowany kalkulator i zostaw kodzik
        else
            setContentView(R.layout.simple_calculator_layout);  // ustaw prosty i zostaw kodzik

//        makeToast(stringContainer);
//        findViewById Buttons
        setButtons();
//        findViewById TextView
        setTextView();

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                czyści stringContainer oraz wszystkie textViewsy

//                to jest w androidzie
                textView_input.setText("");

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
                changeTheLastOfUsIfPrevious(btn_dot);
            }
        });

        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheLastOfUsIfPrevious(btn_percent);
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheLastOfUsIfPrevious(btn_division);
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheLastOfUsIfPrevious(btn_multiply);
            }
        });

        btn_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheLastOfUsIfPrevious(btn_subtraction);
            }
        });

        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheLastOfUsIfPrevious(btn_addition);
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = removeLastCharacter(stringContainer);
                textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
            }
        });

        if(chosenOne == 0)  // cal zaawansowany
        {
            btn_openBracket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_openBracket);
                }
            });

            btn_closeBracket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_closeBracket);
                }
            });

            btn_ln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_ln);
                    setStringContainer(stringContainer+"(");
                    textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
                }
            });

            btn_sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_sin);
                    setStringContainer(stringContainer+"(");
                    textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
                }
            });

            btn_cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_cos);
                    setStringContainer(stringContainer+"(");
                    textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
                }
            });

            btn_tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_tan);
                    setStringContainer(stringContainer+"(");
                    textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
                }
            });

            btn_log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stringContainer = addToStringContainer(btn_log);
                    setStringContainer(stringContainer+"X(");
                    textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
                }
            });

            btn_exp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setStringContainer(stringContainer+"^(");
                    textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
                }
            });
        }

//        zmiana znaku
        btn_opposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringContainer = changeValueOfStringToOpposite(stringContainer);
                textView_input = replaceTheContentOfTextView(textView_input, stringContainer);
            }
        });

//        równa się?
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String NaN_String = "NaN";

                String result = mathStringToNumbers(stringContainer);
                int isNaN = result.compareTo(NaN_String);
                if(isNaN == 0) {
                    makeToast("Not a number");
                    makeToast("Sprawdź składnie wyrażenia!");
                } else{
                    textView_input = replaceTheContentOfTextView(textView_input, result);
                    setStringContainer(result);
                }
            }
        });
    }
}

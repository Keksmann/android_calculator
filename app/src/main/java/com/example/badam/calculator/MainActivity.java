package com.example.badam.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private TextView result_view;
    private String display;
    private float first_number;
    private float second_number;
    private float result_number;
    private String current_state;   // Das ist keine schöne Lösung für eine State Machine.
    private Boolean isNeg;

    // TODO Klammern implementieren
    // TODO add multiline support

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisierung
        result_view = (TextView) (findViewById(R.id.textView));
        result_number = 0;
        display = "";
        current_state = "clear";
        isNeg = false;
    }

    public void set_number(View v){
        if(current_state.equals("result")){
            resetDisplay();
            current_state = "clear";
        }
        switch(v.getId()){      // Switch-Case ist irgendwie keine schöne Lösung
            case R.id.button_0:
                display += 0;
                break;
            case R.id.button_1:
                display += 1;
                break;
            case R.id.button_2:
                display += 2;
                break;
            case R.id.button_3:
                display += 3;
                break;
            case R.id.button_4:
                display += 4;
                break;
            case R.id.button_5:
                display += 5;
                break;
            case R.id.button_6:
                display += 6;
                break;
            case R.id.button_7:
                display += 7;
                break;
            case R.id.button_8:
                display += 8;
                break;
            case R.id.button_9:
                display += 9;
                break;
        }
        result_view.setText(display);
    }

    public void set_decimal(View v){
        display += ".";
        result_view.setText(display);
    }

    public void calc_add(View v){
        first_number = Float.parseFloat(display);
        current_state = "add";
        resetDisplay();
    }

    public void calc_sub(View v){
        first_number = Float.parseFloat(display);
        current_state = "sub";
        resetDisplay();
    }

    public void calc_mult(View v){
        first_number = Float.parseFloat(display);
        current_state = "mult";
        resetDisplay();
    }

    public void calc_div(View v){
        first_number = Float.parseFloat(display);
        current_state = "div";
        resetDisplay();
    }

    private void resetDisplay(){
        display = "";
        isNeg = false;
        result_view.setText(display);
    }

    public void calc_equals(View v){
        second_number = Float.parseFloat(display);

        if(current_state.equals("add")){
            result_number = first_number + second_number;
        }
        else if(current_state.equals("sub")){
            result_number = first_number - second_number;
        }
        else if(current_state.equals("mult")){
            result_number = first_number * second_number;
        }
        else if(current_state.equals("div")){
            result_number = first_number / second_number;
        }

        display = Float.toString(result_number);
        display = cut_decimal_zero(display);
        result_view.setText(display);
        current_state = "result";
    }

    public String cut_decimal_zero(String display){
        int count_chars = display.length();
        String last_symbols = display.substring(count_chars - 2, count_chars);
        String ret_display;
        if(last_symbols.equals(".0")){
            ret_display = display.substring(0, count_chars - 2);
        }
        else{
            ret_display = display;
        }
        return ret_display;
    }

    public void clear_screen(View v){
        resetDisplay();

        first_number = 0;
        second_number = 0;
        current_state = "clear";
    }

    public void del_number(View v){
        display = display.substring(0, display.length() - 1);
        result_view.setText(display);
        // TODO Methode testen. Das buggt noch rum.
    }

    public void set_neg(View v){
        // Vorzeichen der aktuellen Zahl ändern.
        if(!isNeg) {
            display = "-" + display;
        }
        else if(isNeg){
            display = display.substring(1, display.length());
        }

        isNeg = !isNeg;
        result_view.setText(display);
    }
}


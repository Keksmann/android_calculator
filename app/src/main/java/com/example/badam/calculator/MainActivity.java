package com.example.badam.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView result_view;
    private String display;
    private int first_number;
    private int second_number;
    private int result_number;
    private String[] states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisierung
        result_view = (TextView) (findViewById(R.id.textView));
        result_number = 0;
        display = "";
        states = new String[5];
        states[0] = "clear";
        states[1] = "add";
        states[2] = "sub";
        states[3] = "mult";
        states[4] = "div";
    }

    public void set_number(View v){
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

    public void calc_plus(View v){
        first_number = Integer.parseInt(display);
        display = "";
        result_view.setText(display);
    }

    public void calc_equals(View v){
        second_number = Integer.parseInt(display);
        // TODO hier state abfragen

        result_number = first_number + second_number;
        display = Integer.toString(result_number);
        result_view.setText(display);
    }

    public void clear_screen(View v){
        display = "";
        result_view.setText(display);
    }
}


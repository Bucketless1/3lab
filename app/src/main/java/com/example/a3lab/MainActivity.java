package com.example.a3lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView calculatorScreen;
    private String currentNumber;
    private String operator;
    private String function;
    private double result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);
        currentNumber = "";
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentNumber += button.getText().toString();
        calculatorScreen.setText(currentNumber);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        result = Double.parseDouble(currentNumber);
        currentNumber = "";
    }

    public void onFunctionClick(View view){
        Button button = (Button) view;
        function = button.getText().toString();
    }

    public void onEqualClick(View view) {
        if (!currentNumber.equals("")) {
            double secondNumber = Double.parseDouble(currentNumber);
            switch (operator) {
                case "+":
                    result += secondNumber;
                    break;
                case "-":
                    result -= secondNumber;
                    break;
                case "*":
                    result *= secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result /= secondNumber;
                    } else {
                        // handle division by zero
                    }
                    break;
                // You can add more cases for other operations like %, square root, etc.
            }
            calculatorScreen.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    public void onClearClick(View view) {
        currentNumber = "";
        calculatorScreen.setText("");
    }
}
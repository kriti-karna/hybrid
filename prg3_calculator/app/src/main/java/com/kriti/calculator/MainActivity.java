package com.kriti.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, clear, plus, minus, multiply, divide, equals;
    public int nOperandFlag = 0;
    public String lastKey;
    public int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        clear = findViewById(R.id.clear);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"1");
                lastKey = "1";
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"2");
                lastKey = "2";
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"3");
                lastKey = "3";

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"4");
                lastKey = "4";

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"5");
                lastKey = "5";

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"6");
                lastKey = "6";

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"7");
                lastKey = "7";

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"8");
                lastKey = "8";

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"9");
                lastKey = "9";

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n;
                n = result.length();
                if (n == 0){
                    result.setText("");
                }
                else{
                    result.setText(result.getText()+"0");
                    lastKey = "0";
                }

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int n;
                n = result.length();

                //This calculator supports only one operation at a time
                if(nOperandFlag != 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Only one operation allowed", Toast.LENGTH_SHORT);
                    toast.show();
                }

                //The expression should not start with a symbol
                else if (n == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Cannot start expression with operation", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    nOperandFlag = 1;
                    result.setText(result.getText()+"+");
                    lastKey = "+";
                    pos = n;
                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n;
                n = result.length();
                if(nOperandFlag != 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Only one operation allowed", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (n == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Cannot start expression with operation", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    nOperandFlag = 2;
                    result.setText(result.getText()+"-");
                    lastKey = "-";
                    pos = n;
                }

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n;
                n = result.length();
                if(nOperandFlag != 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Only one operation allowed", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (n == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Cannot start expression with operation", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    nOperandFlag = 3;
                    result.setText(result.getText()+"×");
                    lastKey = "×";
                    pos = n;
                }

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n;
                n = result.length();
                if(nOperandFlag != 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Only one operation allowed", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (n == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Cannot start expression with operation", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    nOperandFlag = 4;
                    result.setText(result.getText()+"÷");
                    lastKey = "÷";
                    pos = n;
                }

            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To avoid the expression to end with operation symbol
                if(lastKey == "+"||lastKey == "-"||lastKey == "÷"||lastKey == "×"){
                    Toast toast = Toast.makeText(getApplicationContext(), "Second operand missing", Toast.LENGTH_SHORT);
                    toast.show();
                }

                //To avoid accepting an expression without operation
                else if(nOperandFlag == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "There is no expression", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else{
                    String exp = result.getText().toString();
                    calcExpression(exp);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                nOperandFlag = 0;
                lastKey = "";

            }
        });

    }
    public void calcExpression(String exp){
        String op1, op2;
        float op1N, op2N, res = 0;

        result = findViewById(R.id.result);

        op1 = exp.substring(0,pos);
        op2 = exp.substring(pos+1,result.length());

        op1N = Integer.parseInt(op1);
        op2N = Integer.parseInt(op2);

        switch (nOperandFlag){
            case 1:
                res = op1N + op2N;
                break;
            case 2:
                res = op1N - op2N;
                break;
            case 3:
                res = op1N * op2N;
                break;
            case 4:
                if(op2N == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Divide by zero error", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    res = op1N / op2N;
                }
                break;
        }

        result.setText(""+res);
    }
}

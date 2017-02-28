package com.example.michaelmonty.calculator_monty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Double savedVal = 0.0;
    private Double currentVal = 0.0;

    private boolean isInput = false;

    private String inputStr= "";
    private String operationStr="";
    private String savedStr= "";
    private String calcStr= "";

    private TextView ioTextView;
    private TextView prevAnsTextView;

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;


    private Button decimal;
    private Button add;
    private Button sub;
    private Button mult;
    private Button div;
    private Button clearAll;
    private Button clear;
    private Button equals;
    private Button plusMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ioTextView = (TextView) findViewById(R.id.I_OTextView);
        prevAnsTextView = (TextView) findViewById(R.id.prevAnsTextView);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);

        decimal = (Button) findViewById(R.id.decimal);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mult = (Button) findViewById(R.id.mult);
        div = (Button) findViewById(R.id.div);
        clearAll = (Button) findViewById(R.id.clearAll);
        clear = (Button) findViewById(R.id.clear);
        equals = (Button) findViewById(R.id.equals);
        plusMinus = (Button) findViewById(R.id.plusMinus);

        ioTextView.setText(savedStr+operationStr+inputStr);

        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('1');
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('2');
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('3');
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('4');
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('5');
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('6');
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('7');
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('8');
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('9');
            }
        });
        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('0');
            }
        });
        decimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                appendNum('.');
            }
        });
        plusMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                turnNeg();
            }
        });
        clearAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                inputStr = "";
                savedStr = "";
                operationStr = "";
                calcStr = "";
                savedVal = 0.0;
                currentVal = 0.0;
                ioTextView.setText(savedVal.toString());
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                inputStr = "";
                ioTextView.setText(savedStr+operationStr+inputStr);
            }
        });
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addOp('+');
            }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addOp('-');
            }
        });
        mult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addOp('*');
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addOp('/');
            }
        });
        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!savedStr.isEmpty() && !operationStr.isEmpty() && !inputStr.isEmpty())
                    cal();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("inputSave",inputStr);
        outState.putString("savedSave",savedStr);
        outState.putString("operationSave",operationStr);
        outState.putString("calcSave",calcStr);
        outState.putBoolean("isInputSave",isInput);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        inputStr = savedInstanceState.getString("inputSave");
        savedStr = savedInstanceState.getString("savedSave");
        operationStr = savedInstanceState.getString("operationSave");
        calcStr = savedInstanceState.getString("calcSave");
        isInput = savedInstanceState.getBoolean("isInputSave");

        prevAnsTextView.setText(calcStr);
        ioTextView.setText(savedStr + operationStr + inputStr);
    }

    public void appendNum(char input){

        if(!isInput){
            isInput = true;
        }
        if(input == '.' && !inputStr.contains(".")){
            inputStr = inputStr + ".";
        }
        else if(input =='1'){
            inputStr = inputStr + "1";
        }
        else if(input =='2'){
            inputStr = inputStr + "2";
        }
        else if(input =='3'){
            inputStr = inputStr + "3";
        }
        else if(input =='4'){
            inputStr = inputStr + "4";
        }
        else if(input =='5'){
            inputStr = inputStr + "5";
        }
        else if(input =='6'){
            inputStr = inputStr + "6";
        }
        else if(input =='7'){
            inputStr = inputStr + "7";
        }
        else if(input =='8'){
            inputStr = inputStr + "8";
        }
        else if(input =='9'){
            inputStr = inputStr + "9";
        }
        else if(input =='0'){
            inputStr = inputStr + "0";
        }
        ioTextView.setText(savedStr+operationStr+inputStr);
    }

    public void addOp(char input){
        if(savedStr.isEmpty()) {
            if (isInput) {
                if (input == '+') {
                    operationStr = "+";
                } else if (input == '-') {
                    operationStr = "-";
                } else if (input == '*') {
                    operationStr = "*";
                } else if (input == '/') {
                    operationStr = "/";
                }
                savedStr = inputStr;
                inputStr = "";
                ioTextView.setText(savedStr + operationStr + inputStr);
                isInput = false;
            }
        }

    }

    public void cal(){
        savedVal = Double.valueOf(savedStr);
        currentVal = Double.valueOf(inputStr);
        if(operationStr.contains("+"))
            savedVal = savedVal + currentVal;
        else if(operationStr.contains("-"))
            savedVal = savedVal - currentVal;
        else if(operationStr.contains("*"))
            savedVal = savedVal * currentVal;
        else if(operationStr.contains("/"))
            savedVal = savedVal / currentVal;
        savedStr = "";
        operationStr = "";
        inputStr = "";
        calcStr = savedVal.toString();
        savedVal = 0.0;
        currentVal = 0.0;
        prevAnsTextView.setText(calcStr);
        ioTextView.setText(savedStr + operationStr + inputStr);
    }

    public void turnNeg(){
        if(!inputStr.startsWith("-")){
            inputStr = "-" + inputStr;
        }
        else if(inputStr.startsWith("-")){
            inputStr = inputStr.substring(1);
        }
        ioTextView.setText(savedStr+operationStr+inputStr);
    }

}

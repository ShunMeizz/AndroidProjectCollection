package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Calculator extends AppCompatActivity {
    TextView tvResult, tvEquation;
    Button btnEquals;
    ArrayList<Button> allButtons;
    char opPS;
    String []numPS;
    Stack<String> opPM, numPM;
    boolean MDASflag;
    StringBuilder value, equation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        assigning();

       /* the logic is that while the user inputs numbers, they are dynamically added to our
       MDAS stack (numPM and opPM) and to our sequential array (numPS and opPS).*/
        for(Button b: allButtons){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String btnText = b.getText().toString();
                    if(btnText.equals("+")||btnText.equals("-")||btnText.equals("*")||btnText.equals("/")){
                        //For Performing Sequential using array(numPS and opPS)
                       if(numPS[0]==null){
                            numPS[0] = String.valueOf(value);
                        }else{
                            numPS[0] = tvResult.getText().toString(); //Save tvResult in numPS[0] to continue the sequence even after pressing the equal button.
                            numPS[1] = null;
                        }
                        opPS = btnText.charAt(0);

                        //For Performing MDAS using Stack(numPM and opPM)
                        if(value.length()!=0){ // Handles the case when a number was recently push in numPM stack and the user inputs an operator, so basically it doesn't append anything in our value, so we skip
                            numPM.push(String.valueOf(value));
                        }

                        if(opPM.size()>=1 && precedence()==2 && numPM.size()>=2){
                            performMDAS(opPM.pop());
                        }

                        opPM.push(btnText);

                        //Resetting the value
                        value.setLength(0);

                    }else{
                        value.append(btnText);

                       //For Performing Sequential using array(numPS and opPS)
                        if(numPS[0]!=null && opPS!='\0'){
                            numPS[1] = String.valueOf(value);
                            performSequential();
                        }else{
                            tvResult.setText(value);
                        }
                    }
                    equation.append(btnText);
                    tvEquation.setText(equation);
                }
            });
        }
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value.length()!=0){
                    numPM.push(String.valueOf(value)); //assuming that there's a digit left in our value SB
                    value.setLength(0);
                }
                if(numPM.size()<=opPM.size()){
                    tvResult.setText("ERROR");
                }else{
                    MDASflag = true;
                    Collections.reverse(numPM);
                    Collections.reverse(opPM);
                    while(!opPM.isEmpty()){
                        performMDAS(opPM.pop());
                    }
                }
            }
        });
    }
    public int precedence(){
        switch(opPM.peek()){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
    //giatay medyo libog pako sa MDAS usahay macorrect usahay dili hahhaha
    //dili mogana if kani, wae? 900/9+63-2-4*3.2, but mogana sa uban expression hmm
    public void performMDAS(String op){
        Double num1 = Double.valueOf(numPM.pop());
        Double num2 = Double.valueOf(numPM.pop());
        double answer = 0.0;
        switch(op){
            case "+":
                answer = num1+num2;
                break;
            case "-":
                answer = num1-num2;
                break;
            case "*":
                answer = num1*num2;
                break;
            case "/":
                if (num1 != 0) {
                    answer = num2 / num1;
                } else {
                    tvResult.setText("ERROR: Division by zero");
                    return;
                }
        }
        numPM.push(String.valueOf(answer));

        if(MDASflag && numPM.size()==1){
            Double num = Double.parseDouble(numPM.pop());
            String format = (num % 1 == 0) ? "%.0f" : "%.2f";
            tvResult.setText(String.format(format, num));
        }
    }

    public void performSequential(){
        if(numPS[0]!=null && numPS[1]!=null && opPS!='\0'){
            Double num1 = Double.valueOf(numPS[0]);
            Double num2 = Double.valueOf(numPS[1]);
            Double answerPS = 0.0;

            if(opPS == '+'){
                answerPS = num1+num2;
            }else if(opPS =='-'){
                answerPS = num1-num2;
            }else if(opPS == '*'){
                answerPS = num1*num2;
            }else if(opPS =='/'){
                answerPS = num1/num2;
            }

            //set the format to integer if '5.0' else nahh stick with double
            String format = (answerPS % 1 == 0) ? "%.0f" : "%.2f";
            tvResult.setText(String.format(format, answerPS));
        }
    }

    public void assigning() {

        int[] buttonIds = {R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour,
                R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine,
                R.id.btnAdd, R.id.btnMultiply, R.id.btnSubtract, R.id.btnDivide, R.id.btnDecimal};
        allButtons = new ArrayList<>();
        for (int id : buttonIds) {
            Button button = findViewById(id);
            allButtons.add(button);
        }

        tvEquation = findViewById(R.id.tvEquation);
        tvResult = findViewById(R.id.tvResult);
        btnEquals = findViewById(R.id.btnEquals); //special case ni siya hahaha
        opPS = '\0';
        numPS = new String[2];
        opPM = new Stack<>();
        numPM = new Stack<>();
        value = new StringBuilder(); //value will deal with numbers including if with decimals or nahh
        equation = new StringBuilder();
        MDASflag = false;

    }
}



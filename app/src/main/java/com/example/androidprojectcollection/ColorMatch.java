package com.example.androidprojectcollection;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.YELLOW;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ColorMatch extends AppCompatActivity {
    //Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button[][] cells = new Button[3][3];
    Button btnReturn;
    int [] colorChoices = {BLUE, YELLOW, GREEN};

    boolean enable = true;
    String left ="-1", right="-1", bottom="-1", top="-1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match);
        initializeCells();
        randomizeColor();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int finalI = i;
                int finalJ = j;
                cells[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(enable){
                            Button clickedButton = (Button) view;
                            if(finalI-1>0){
                                top = (String) cells[finalI-1][finalJ].getText();
                                changeColor(top, finalI-1, finalJ);
                            }
                            if(finalI+1<3){
                                bottom = (String) cells[finalI+1][finalJ].getText();
                                changeColor(bottom, finalI+1, finalJ);
                            }
                            if(finalJ+1<3){
                                right = (String) cells[finalI][finalJ+1].getText();
                                changeColor(right,finalI, finalJ+1);
                            }
                            if(finalJ-1>0){
                                left = (String) cells[finalI][finalJ-1].getText();
                                changeColor(left,finalI, finalJ-1);
                            }
                            /*if(clickedButton.getText()=="0"){
                               changeColor("0");
                                //changeColor(finalI, finalJ, colorChoices[1]);
                            }else if(clickedButton.getText()=="1"){
                                changeColor("1");
                                //changeColor(finalI, finalJ, colorChoices[2]);
                            }else if(clickedButton.getText()=="2"){
                                changeColor("2");
                                //changeColor(finalI, finalJ, colorChoices[0]);
                            }*/
                        }
                    }
                });
            }
        }
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomizeColor();
            }
        });
    }
    public void changeColor(String cell, int row, int col){
        if(cell=="0"){
            cells[row][col].setBackgroundColor(colorChoices[1]);
            cells[row][col].setText("1");
        }else if(cell=="1"){
            cells[row][col].setBackgroundColor(colorChoices[2]);
            cells[row][col].setText("2");
        }else if(cell=="2"){
            cells[row][col].setBackgroundColor(colorChoices[0]);
            cells[row][col].setText("0");
        }
        endWinCondition(cell);
    }
    /* public void changeColor(int row, int col, int color){
         String text="";
         if(color==0){
             text="0";
         }else if(color==1){
             text="1";
         }else if(color==2){
             text="2";
         }
         if(row-1>0){
             cells[row-1][col].setBackgroundColor(color); //Upper
             cells[row-1][col].setText(text); //Upper
         }
         if(row+1<3){
             cells[row+1][col].setBackgroundColor(color); //Bottom
             cells[row+1][col].setText(text); //Bottom
         }
         if(col-1>0){
             cells[row][col-1].setBackgroundColor(color); //Left
             cells[row][col-1].setText(text); //Left
         }
         if(col+1<3){
             cells[row][col+1].setBackgroundColor(color); //Right
             cells[row][col+1].setText(text);//Right
         }
         endWinCondition(text);
     }*/
    public void endWinCondition(String color){
        boolean checker = true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(cells[i][j].getText()!=color){
                    checker = false;
                }
            }
        }
        if(checker){
            Toast.makeText(ColorMatch.this,"You Won", Toast.LENGTH_SHORT).show();
            enable = false;
        }
    }
    public void randomizeColor(){
        enable = true;
        for(int i=0; i<3; i++){
            for(int j =0; j<3; j++){
                Random r = new Random();
                int color = r.nextInt(3);
                if(color==1){
                    cells[i][j].setBackgroundColor(Color.BLUE);
                    cells[i][j].setText("0");
                }else if(color==2){
                    cells[i][j].setBackgroundColor(Color.YELLOW);
                    cells[i][j].setText("1");
                }else{
                    cells[i][j].setBackgroundColor(Color.GREEN);
                    cells[i][j].setText("2");
                }
            }
        }
    }
    public void initializeCells(){
        cells[0][0] = findViewById(R.id.btnOne);
        cells[0][1] = findViewById(R.id.btnTwo);
        cells[0][2] = findViewById(R.id.btnThree);
        cells[1][0] = findViewById(R.id.btnFour);
        cells[1][1] = findViewById(R.id.btnFive);
        cells[1][2] = findViewById(R.id.btnSix);
        cells[2][0] = findViewById(R.id.btnSeven);
        cells[2][1] = findViewById(R.id.btnEight);
        cells[2][2] = findViewById(R.id.btnNine);
        btnReturn = (Button) findViewById(R.id.btnReturn);
    }
}
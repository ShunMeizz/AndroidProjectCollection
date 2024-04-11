package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectThree extends AppCompatActivity {
    Button[][] board = new Button[6][6];
    ArrayList<Button> B = new ArrayList<>();
    int check;
    TextView currPlayer, result;
    Button reset;
    Boolean player = true; //true - red , false - black
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three);
        initialize();
        currPlayer.setText("Player BLACK's turn");
           /*for(int i=0; i<B.size(); i++){
               if(i%5==0){
                   final int index = i;
                   B.get(i).setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           if(player){
                               B.get(index).setBackgroundColor(Color.BLACK);
                               currPlayer.setText("Player RED's turn");
                               player = false;
                           }else{
                               B.get(index).setBackgroundColor(Color.RED);
                               currPlayer.setText("Player BLACK's turn");
                               player = true;
                           }
                       }
                   });
               }
           }*/
            for (int col = 1; col <= 5; col++) {
                final int colIndex = col;
                    board[1][col].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int row = dropItem(colIndex);
                            if (player) {
                                board[row][colIndex].setBackgroundColor(Color.BLACK);
                                board[row][colIndex].setText("1");
                                currPlayer.setText("Player RED's turn");
                                currPlayer.setTextColor(Color.RED);
                                player = false;
                            } else {
                                board[row][colIndex].setBackgroundColor(Color.RED);
                                board[row][colIndex].setText("-1");
                                currPlayer.setText("Player BLACK's turn");
                                currPlayer.setTextColor(Color.BLACK);
                                player = true;
                            }
                            check = checkGameRowandCol();
                            if(check==1){
                                currPlayer.setText("Game End");
                                result.setText("BLACK WON");
                            }else if(check==-1){
                                currPlayer.setText("Game End");
                                result.setText("RED WON");
                            }
                        }
                    });
            }
            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i=1; i<=5; i++){
                        for(int j=1; j<=5; j++){
                            board[i][j].setBackgroundColor(Color.parseColor("#F6DACB"));
                            board[i][j].setText("0");
                            result.setText("Connect Three");
                            currPlayer.setText("Player BLACK's turn");
                        }
                    }
                }
            });


    }
    public int dropItem(int col) {
        for (int i = 5; i >= 1; i--) {
            if (board[i][col].getText().equals("0")) {
                return i;
            }
        }
        return -1;
    }
    private int checkGameRowandCol() {
        int piecesInLineB = 0 , piecesInLineR = 0;

        //Check Row
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                if (board[row][col].getText().equals("1")) {
                    piecesInLineB++;
                    if (piecesInLineB == 3) {
                        return 1;
                    }
                } else {
                    piecesInLineB = 0;
                }
                if (board[row][col].getText().equals("-1")) {
                    piecesInLineR++;
                    if (piecesInLineR == 3) {
                        return -1;
                    }
                } else {
                    piecesInLineR = 0;
                }
            }
        }

        //Check Column
        piecesInLineB = 0;
        piecesInLineR = 0;
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                if (board[col][row].getText().equals("1")) {
                    piecesInLineB++;
                    if (piecesInLineB == 3) {
                        return 1;
                    }
                } else {
                    piecesInLineB = 0;
                }
                if (board[col][row].getText().equals("-1")) {
                    piecesInLineR++;
                    if (piecesInLineR == 3) {
                        return -1;
                    }
                } else {
                    piecesInLineR = 0;
                }
            }
        }

        return 0;
    }


    public void initialize(){
        for(int row = 1; row <= 5; row++) {
            for(int col = 1; col <= 5; col++) {
                String resIDname = "btn"+row+col;
                board[row][col] = findViewById(this.getResources().getIdentifier(resIDname,"id",this.getPackageName()));
               // B.add(button[row][col]); //0 1 2 3 4 //5 6 7 8 9 //10
            }
        }
        currPlayer = findViewById(R.id.tv_currPlayer);
        result = findViewById(R.id.tv_result);
        reset = findViewById(R.id.btnReset);

    }
}
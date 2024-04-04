package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectThree extends AppCompatActivity {
    Button[][] button = new Button[6][6];
    ArrayList<Button> B = new ArrayList<>();

    TextView currPlayer;
    Boolean player = true; //true - red , false - black
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three);
        assigning();
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
                final int index = col;
                    button[1][col].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int row = dropItem(index);
                            if (player) {
                                button[row][index].setBackgroundColor(Color.BLACK);
                                currPlayer.setText("Player RED's turn");
                                player = false;
                            } else {
                                button[row][index].setBackgroundColor(Color.RED);
                                currPlayer.setText("Player BLACK's turn");
                                player = true;
                            }
                        }
                    });
            }
    }
    public int dropItem(int col){

        for(int i=5; i>=1; i--){
            if(!button[i][col].getBackground().equals(Color.BLACK) && !button[i][col].getBackground().equals(Color.RED)){
                return i;
            }
        }

    }
    public void assigning(){
        for(int row = 1; row <= 5; row++) {
            for(int col = 1; col <= 5; col++) {
                String resIDname = "btn"+row+col;
                button[row][col] = findViewById(this.getResources().getIdentifier(resIDname,"id",this.getPackageName()));
               // B.add(button[row][col]); //0 1 2 3 4 //5 6 7 8 9 //10
            }
        }
        currPlayer = findViewById(R.id.tv_currPlayer);
    }
}
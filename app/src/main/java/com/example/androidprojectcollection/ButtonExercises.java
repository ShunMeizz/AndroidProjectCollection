package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ButtonExercises extends AppCompatActivity {
    Button btnclose, btnchangeBG, btnchangebuttonBG, btndisappear, btntoast;
    ConstraintLayout layout;
    boolean isBlack, isGray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercises);
        this.setTitle("Button Exercises");
        btnclose = (Button) findViewById(R.id.btn_close);
        btnchangeBG = (Button) findViewById(R.id.btn_changeBG);
        btnchangebuttonBG = (Button) findViewById(R.id.btn_changebuttonBG);
        btndisappear = (Button) findViewById(R.id.btn_disappear);
        btntoast = (Button) findViewById(R.id.btn_toast);
        layout = findViewById(R.id.buttonexercises_layout);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ButtonExercises.this, ReturnActivity.class);
                startActivity(intent1);
            }
        });

        isBlack = false;
        btnchangeBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBlack) {
                    layout.setBackgroundColor(Color.WHITE);
                } else {
                    layout.setBackgroundColor(Color.BLACK);
                }
                isBlack = !isBlack;
            }
        });
        isGray = false;
        btnchangebuttonBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGray){
                    btnchangebuttonBG.setBackgroundColor(Color.MAGENTA);
                }else{
                    btnchangebuttonBG.setBackgroundColor(Color.GRAY);
                }
                isGray = !isGray;
            }
        });
        btndisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btndisappear.setVisibility(View.INVISIBLE);
            }
        });
        btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercises.this,"Hello World", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
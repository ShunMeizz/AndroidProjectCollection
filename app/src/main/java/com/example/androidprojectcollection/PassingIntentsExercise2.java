package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tvFname, tvLname, tvGender, tvBdate, tvPhonenum, tvEmailadd, tvAge, tvYearlevel, tvProgram, tvElem, tvSecondary, tvSeniorHigh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        tvFname = findViewById(R.id.tvOutputFname);
        tvLname = findViewById(R.id.tvOutputLname);
        tvGender = findViewById(R.id.tvOutputGender);
        tvBdate = findViewById(R.id.tvOutputBirthDate);
        tvPhonenum = findViewById(R.id.tvOutputPhoneNum);
        tvEmailadd = findViewById(R.id.tvOutputEmailAdd);

        tvAge = findViewById(R.id.tvOutputAge);
        tvYearlevel = findViewById(R.id.tvOutputYear);
        tvProgram = findViewById(R.id.tvOutputProgram);
        tvElem = findViewById(R.id.tvOutputElem);
        tvSecondary = findViewById(R.id.tvOutputSecondary);
        tvSeniorHigh = findViewById(R.id.tvOutputSeniorHigh);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String bdate = intent.getStringExtra("bdate_key");
        String pnum = intent.getStringExtra("pnum_key");
        String email = intent.getStringExtra("eadd_key");

        String age = intent.getStringExtra("age_key");
        String yearlevel = intent.getStringExtra("year_key");
        String program = intent.getStringExtra("program_key");
        String elem = intent.getStringExtra("elem_key");
        String secondary = intent.getStringExtra("secondary_key");
        String seniorhigh = intent.getStringExtra("seniorhigh_key");

        tvFname.setText(fname);
        tvLname.setText(lname);
        tvGender.setText(gender);
        tvBdate.setText(bdate);
        tvPhonenum.setText(pnum);
        tvEmailadd.setText(email);

        tvAge.setText(age);
        tvYearlevel.setText(yearlevel);
        tvProgram.setText(program);
        tvElem.setText(elem);
        tvSecondary.setText(secondary);
        tvSeniorHigh.setText(seniorhigh);
    }
}
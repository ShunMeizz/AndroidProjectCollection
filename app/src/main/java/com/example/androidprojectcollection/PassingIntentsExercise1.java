package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PassingIntentsExercise1 extends AppCompatActivity {
    Button btnClear, btnSubmit;
    EditText eFname, eLname, eBDate, ePhoneNum, eEmailAdd, eAge, eProgram, eElem, eSecondary, eSeniorHigh;
    RadioButton rMale, rFemale, rOthers, rFirst, rSecond, rThird, rFourth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise1);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);
        eFname = findViewById(R.id.eFname);
        eLname = findViewById(R.id.eLname);
        eBDate = findViewById(R.id.eBDate);
        ePhoneNum = findViewById(R.id.ePhoneNum);
        eEmailAdd = findViewById(R.id.eEmailAdd);
        eAge = findViewById(R.id.eAge);
        eProgram = findViewById(R.id.eProgram);
        eElem = findViewById(R.id.eElem);
        eSecondary = findViewById(R.id.eSecondary);
        eSeniorHigh = findViewById(R.id.eSeniorHigh);
        rMale = findViewById(R.id.rMale);
        rFemale = findViewById(R.id.rFemale);
        rOthers = findViewById(R.id.rOthers);
        rFirst = findViewById(R.id.rFirst);
        rSecond = findViewById(R.id.rSecond);
        rThird = findViewById(R.id.rThird);
        rFourth = findViewById(R.id.rFourth);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = eFname.getText().toString();
                String lname = eLname.getText().toString();
                String bDate = eBDate.getText().toString();
                String pNum = ePhoneNum.getText().toString();
                String emailAdd = eEmailAdd.getText().toString();
                String age = eAge.getText().toString();
                String program = eProgram.getText().toString();
                String elem = eElem.getText().toString();
                String secondary = eSecondary.getText().toString();
                String seniorhigh = eSeniorHigh.getText().toString();
                String gender, yearLevel;
                if(rMale.isChecked()){
                    gender = "Male";
                }else if(rFemale.isChecked()){
                    gender = "Female";
                }else{
                    gender = "Unknown";
                }
                if(rFirst.isChecked()){
                    yearLevel = "1st year";
                }else if(rSecond.isChecked()){
                    yearLevel = "2nd year";
                }else if(rThird.isChecked()){
                    yearLevel = "3rd year";
                }else if(rFourth.isChecked()){
                    yearLevel ="4th year";
                }else{
                    yearLevel = "Unknown";
                }

                Intent intent = new Intent(PassingIntentsExercise1.this, PassingIntentsExercise2.class);
                intent.putExtra("fname_key", fname);
                intent.putExtra("lname_key", lname);
                intent.putExtra("gender_key", gender);
                intent.putExtra("bdate_key", bDate);
                intent.putExtra("pnum_key", pNum);
                intent.putExtra("eadd_key", emailAdd);

                intent.putExtra("age_key", age);
                intent.putExtra("program_key", program);
                intent.putExtra("elem_key", elem);
                intent.putExtra("secondary_key", secondary);
                intent.putExtra("seniorhigh_key", seniorhigh);
                intent.putExtra("year_key", yearLevel);
                startActivity(intent);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eFname.setText("");
                eLname.setText("");
                eBDate.setText("");
                ePhoneNum.setText("");
                eEmailAdd.setText("");
                eAge.setText("");
                eProgram.setText("");
                eElem.setText("");
                eSecondary.setText("");
                eSeniorHigh.setText("");
                rMale.setChecked(false);
                rFemale.setChecked(false);
                rOthers.setChecked(false);
                rFirst.setChecked(false);
                rSecond.setChecked(false);
                rThird.setChecked(false);
                rFourth.setChecked(false);
            }
        });
    }

}
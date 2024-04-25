package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
        btnChanger = findViewById(R.id.btnTransformingButton);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.mItemChange:
                Toast.makeText(this, "Change Object", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cBtnSize:
                Toast.makeText(this, "Change in Size", Toast.LENGTH_SHORT).show();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
                layoutParams.width = 3000;
                btnChanger.setLayoutParams(layoutParams);
                return true;
            case R.id.cTextSize:
                Toast.makeText(this, "Change in Text Size", Toast.LENGTH_SHORT).show();
                btnChanger.setTextSize(48);
                return true;
            case R.id.cTextLabel:
                Toast.makeText(this, "Change in Text Label", Toast.LENGTH_SHORT).show();
                btnChanger.setText("YAY");
                return true;
            case R.id.cTextColor:
                Toast.makeText(this, "Change in Text Color", Toast.LENGTH_SHORT).show();
                btnChanger.setTextColor(Color.YELLOW);
                return true;
            case R.id.cBgColor:
                Toast.makeText(this, "Change in Background Color", Toast.LENGTH_SHORT).show();
                btnChanger.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.mItemReset:
                Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
                ConstraintLayout.LayoutParams layoutParam = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
                layoutParam.width = 600;
                layoutParam.height = 600;
                btnChanger.setLayoutParams(layoutParam);
                btnChanger.setBackgroundColor(Color.DKGRAY);
                btnChanger.setTypeface(null, Typeface.BOLD);
                btnChanger.setText("DEF");
                return true;
            case R.id.mItemExit:
                finish();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}
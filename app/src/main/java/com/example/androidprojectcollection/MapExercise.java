package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MapExercise extends AppCompatActivity {
    ImageButton btn1, btn2, btn3, btn4, btn5;
    ImageView imageView;
    TextView textView;
    //MapView mapView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_exercise);
        btn2 = findViewById(R.id.imageButton2);
        btn3 = findViewById(R.id.imageButton3);
        btn4 = findViewById(R.id.imageButton4);
        btn5 = findViewById(R.id.imageButton5);
        btn1 = findViewById(R.id.imageButton1);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textViewMap);
       // mapView = findViewById(R.id.mapView);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.nijo_castle_kyoto);
                textView.setText("Nijo Castle");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 35.01417846532642, 135.74844725466178"));
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.philosophers_path_kyoto);
                textView.setText("Philosopher's Path");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 35.0268038019237, 135.79546770926984"));
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.pontocho_kyoto);
                textView.setText("Pontocho");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 35.00627047648283, 135.7711193181553"));
                startActivity(i);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.yokai_street_kyoto);
                textView.setText("Yokai Street");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 35.026383001669416, 135.73397239699136"));
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.higashiyama_kyoto);
                textView.setText("Higashiyama");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 34.99164885015442, 135.7787433620116"));
                startActivity(i);
            }
        });

    }
}
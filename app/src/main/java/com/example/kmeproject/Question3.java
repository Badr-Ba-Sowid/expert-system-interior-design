package com.example.kmeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question3 extends AppCompatActivity {
    private Button nextButton;
    private CheckBox lightCB , darkCB , midToneCB , vibrantCB;
    RelativeLayout rootLayout;
    ArrayList<String> lines , elementsOfDesign;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        nextButton = findViewById(R.id.next_button_question3);
        lightCB = findViewById(R.id.light_check_box);
        darkCB = findViewById(R.id.dark_check_box);
        midToneCB = findViewById(R.id.mid_tone_check_box);
        vibrantCB = findViewById(R.id.vibrant_check_box);
        rootLayout = findViewById(R.id.question3_root_layout);
        getSupportActionBar().setTitle("MyDesigner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getIntent().getExtras()!=null){
            lines = getIntent().getStringArrayListExtra(Constants.LINES);
            elementsOfDesign = getIntent().getStringArrayListExtra(Constants.ELEMENTS_OF_DESIGN);
        }



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(darkCB.isChecked()||lightCB.isChecked()||midToneCB.isChecked()||vibrantCB.isChecked()){
                    ArrayList colors = getColors();
                    Intent intent = new Intent(getApplicationContext() , Question4.class);
                    intent.putStringArrayListExtra(Constants.COLORS , colors);
                    intent.putStringArrayListExtra(Constants.ELEMENTS_OF_DESIGN , elementsOfDesign);
                    intent.putStringArrayListExtra(Constants.LINES , lines);
                    startActivity(intent);
                }else{
                    Snackbar snackbar = Snackbar
                            .make(rootLayout, "Please make a selection", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

            }
        });
    }

    private ArrayList getColors() {
        ArrayList<String> colors = new ArrayList<>();
        if(vibrantCB.isChecked()){
            colors.add(Constants.VIBRANT);
        }
        if(darkCB.isChecked()){
            colors.add(Constants.DARK);
        }
        if(lightCB.isChecked()){
            colors.add(Constants.LIGHT);
        }
        if(midToneCB.isChecked()){
            colors.add(Constants.MID_TONE);
        }
        return colors;
    }
}

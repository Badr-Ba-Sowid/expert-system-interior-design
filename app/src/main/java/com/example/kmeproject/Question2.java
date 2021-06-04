package com.example.kmeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Question2 extends AppCompatActivity {
    private RelativeLayout rootLayout;
    Button nextButton;
    CheckBox simpleCB , superSimpleCB , midRangeCB , detailedCB;
    ArrayList<String> lines;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        nextButton = findViewById(R.id.next_button_question2);
        rootLayout = findViewById(R.id.question2_root_layout);
        simpleCB = findViewById(R.id.simple);
        superSimpleCB = findViewById(R.id.super_simple);
        midRangeCB = findViewById(R.id.mid_range);
        detailedCB = findViewById(R.id.detailed);
        getSupportActionBar().setTitle("MyDesigner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // get the data from the last question
        lines = new ArrayList<>();
        if(getIntent().getExtras()!=null) {
             lines = getIntent().getExtras().getStringArrayList(Constants.LINES);
        }
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(superSimpleCB.isChecked()||simpleCB.isChecked()||midRangeCB.isChecked()||detailedCB.isChecked()){
                    ArrayList<String> elementsOfDesign =  getElementsOfDesign();
                    Intent intent  = new Intent(getApplicationContext(), Question3.class);
                    //add the elements of design and the lines array list
                    intent.putStringArrayListExtra(Constants.ELEMENTS_OF_DESIGN , elementsOfDesign);
                    intent.putStringArrayListExtra(Constants.LINES ,lines);
                    startActivity(intent);
                }else{
                    Snackbar snackbar = Snackbar
                            .make(rootLayout, "Please make a selection", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

            }


        });



    }
    private ArrayList<String> getElementsOfDesign() {
        ArrayList<String> elementsOfDesign = new ArrayList<>();
        if(simpleCB.isChecked()){
            elementsOfDesign.add(Constants.SIMPLE);
        }
        if(superSimpleCB.isChecked()){
            elementsOfDesign.add(Constants.SUPER_SIMPLE);
        }
        if(detailedCB.isChecked()){
            elementsOfDesign.add(Constants.DETAILED);
        }
        if(midRangeCB.isChecked()){
            elementsOfDesign.add(Constants.MID_RANGE);
        }
        return elementsOfDesign;

    }
}

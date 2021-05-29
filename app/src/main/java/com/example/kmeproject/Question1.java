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

import java.util.ArrayList;
import java.util.List;

public class Question1 extends AppCompatActivity {

    private Button nextButton;
    private CheckBox straightLinesCB , curvedLinesCB , curvedWithStraightLinesCB;
    RelativeLayout rootLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        nextButton = findViewById(R.id.next_button_question1);
        straightLinesCB = findViewById(R.id.straight_lines_check_box);
        curvedLinesCB = findViewById(R.id.curved_lines_check_box);
        curvedWithStraightLinesCB = findViewById(R.id.curved_with_straight_lines_check_box);
        rootLayout = findViewById(R.id.question1_root_layout);

        getSupportActionBar().setTitle("MyDesigner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if any button is checked
                if(straightLinesCB.isChecked()||curvedLinesCB.isChecked()||curvedWithStraightLinesCB.isChecked()){
                    // get the checked buttons
                    ArrayList<String> lines = getCheckedButtons();
                    Intent intent = new Intent(getApplicationContext() , Question2.class);
                    intent.putStringArrayListExtra(Constants.LINES , lines);
                    startActivity(intent);
                }else {
                    Snackbar snackbar = Snackbar
                            .make(rootLayout, "Please make a selection", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }
            }
        });



    }

    private ArrayList<String> getCheckedButtons() {
        ArrayList<String> lines = new ArrayList<>();
        if(straightLinesCB.isChecked()){
            lines.add(Constants.STRAIGHT_LINES);
        }
        if(curvedLinesCB.isChecked()){
            lines.add(Constants.CURVED_LINES);
        }
        if(curvedWithStraightLinesCB.isChecked()){
            lines.add(Constants.CURVED_WITH_STRAIGHT);
        }
        return lines;
    }
}

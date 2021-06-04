package com.example.kmeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question4 extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView seekBarCount;
    private Button getResultButton;
    private static final int LOW_BOUND = 6666;
    private static final int AVERAGE_BOUND = 13333;
    private RelativeLayout relativeLayout;
    ArrayList<String> lines , elementsOfDesign , colors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        seekBar = findViewById(R.id.seek_bar);
        seekBarCount = findViewById(R.id.seek_bar_text_view);
        getResultButton = findViewById(R.id.get_result);
        relativeLayout = findViewById(R.id.question_4_layout);
        getSupportActionBar().setTitle("MyDesigner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get all the answers from the arrayList
        if(getIntent().getExtras()!=null){
            lines = getIntent().getStringArrayListExtra(Constants.LINES);
            elementsOfDesign = getIntent().getStringArrayListExtra(Constants.ELEMENTS_OF_DESIGN);
            colors = getIntent().getStringArrayListExtra(Constants.COLORS);
        }



        getResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> budget = getBudget();
                //TODO add the logic for the inferance engine here
                // example of the function call
                String designResult = InferanceEngine.getCategory(lines , elementsOfDesign , colors , budget);
                Snackbar snackbar = Snackbar
                        .make(relativeLayout, designResult, Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        seekBar.incrementProgressBy(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i / 100;
                i = i * 100;
                seekBarCount.setText(String.valueOf(i) + " RM");

                int width = seekBar.getWidth() - seekBar.getPaddingLeft() - seekBar.getPaddingRight();
                int thumbPos = seekBar.getPaddingLeft() + width * seekBar.getProgress() / seekBar.getMax();

                seekBarCount.measure(0, 0);
                int txtW = seekBarCount.getMeasuredWidth();
                int delta = txtW / 2;
                seekBarCount.setX(seekBar.getX() + thumbPos - delta);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    private ArrayList<String> getBudget() {
        ArrayList<String> budget = new ArrayList<>();
        if(seekBar.getProgress()<LOW_BOUND){
            budget.add(Constants.LOW);
        }
        if(seekBar.getProgress()>=LOW_BOUND && seekBar.getProgress()<AVERAGE_BOUND){
            budget.add(Constants.AVERAGE);
        }
        if(seekBar.getProgress()>=AVERAGE_BOUND){
            budget.add(Constants.HIGH);
        }
        return budget;
    }
}

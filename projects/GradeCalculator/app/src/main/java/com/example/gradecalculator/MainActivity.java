package com.example.gradecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText assignment1;
    private EditText score1;
    private EditText weight1;
    private SeekBar scoreSeekBar1;
    private EditText assignment2;
    private EditText score2;
    private EditText weight2;
    private TextView result;
    private Button calculateInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignment1 = findViewById(R.id.assignment1);
        score1 = findViewById(R.id.score1);
        weight1 = findViewById(R.id.weight1);
        scoreSeekBar1 = findViewById(R.id.seekBar1);
        assignment2 = findViewById(R.id.assignment2);
        score2 = findViewById(R.id.score2);
        weight2 = findViewById(R.id.weight2);
        result = findViewById(R.id.resultText);
        calculateInput = findViewById(R.id.calculate);
        seekBarUpdater();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calculate:
                int testint = Integer.parseInt(score1.getText().toString());
                scoreSeekBar1.setProgress(testint);
                scoreSeekBar1.refreshDrawableState();
                calculate(view);
        }
    }

    public void seekBarUpdater( ) {
//        score1.setText("Test " + scoreSeekBar1.getProgress());

        scoreSeekBar1.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {
                int seekBarValue;
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    seekBarValue = progress;
                    score1.setText(Integer.toString(seekBarValue));
                    calculate2();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    score1.setText(Integer.toString(seekBarValue));
                    calculate2();
                }
            }
        );
    }

    public void buttonToSeekUpdater(final int scoreOne) {
        score1.addTextChangedListener(
            new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                    scoreSeekBar1.setProgress(0);
//                    calculate2();
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Log.i("TEST", "Updated seek");
//                    scoreSeekBar1.setProgress(scoreOne);
//                    scoreSeekBar1.refreshDrawableState();
//                    calculate2();
                }

                @Override
                public void afterTextChanged(Editable s) {
                    Log.i("TEST", "Updated seek after");
                    calculate2();
                }
            }
        );
    }

    @SuppressLint("SetTextI18n")
    public void calculate (View view) {
        float scoreOne = Integer.parseInt(score1.getText().toString());
//        scoreSeekBar1.setProgress(Math.round(scoreOne));
        buttonToSeekUpdater(Math.round(scoreOne));
        scoreOne = scoreOne/100;
        float scoreTwo = Integer.parseInt(score2.getText().toString());
        scoreTwo = scoreTwo/100;
        float weightOne = Integer.parseInt(weight1.getText().toString());
        float weightTwo = Integer.parseInt(weight2.getText().toString());

        float resultCalculation = (weightOne * scoreOne) + (weightTwo * scoreTwo);
        result.setText(Float.toString(resultCalculation));
    }

    public void calculate2 () {
        float scoreOne = Integer.parseInt(score1.getText().toString());
//        scoreSeekBar1.setProgress(Math.round(scoreOne));
//        buttonToSeekUpdater(Math.round(scoreOne));
        scoreOne = scoreOne/100;
        float scoreTwo = Integer.parseInt(score2.getText().toString());
        scoreTwo = scoreTwo/100;
        float weightOne = Integer.parseInt(weight1.getText().toString());
        float weightTwo = Integer.parseInt(weight2.getText().toString());

        float resultCalculation = (weightOne * scoreOne) + (weightTwo * scoreTwo);
        result.setText(Float.toString(resultCalculation));
    }

}

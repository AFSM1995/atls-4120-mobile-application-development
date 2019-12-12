package com.example.gradecalculator;

import android.content.Context;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

// I was able to programmatically create rows but unfortunately i was unable to set a unique id for each row.
// This i implemented this work around that requires a lot of hard code.
// This app is on the resume so rest assured it will be optimised.
// I added comments for a individual row instead of all of them to reduce lines.

// Sources:
// Icon: https://icon-library.net/icon/calculator-png-icon-13.html
// Icons: https://fontawesome.com/
// Code Help: In code

public class MainActivity extends AppCompatActivity {
    // Initiate Variables and objects.
    private EditText assignment1, assignment2, assignment3, assignment4, assignment5, assignment6, assignment7, assignment8, assignment9, assignment10;
    private EditText score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
    private EditText weight1, weight2, weight3, weight4, weight5, weight6, weight7, weight8, weight9, weight10;
    private SeekBar scoreSeekBar1, scoreSeekBar2, scoreSeekBar3, scoreSeekBar4, scoreSeekBar5, scoreSeekBar6, scoreSeekBar7, scoreSeekBar8, scoreSeekBar9, scoreSeekBar10;
    private Button lockOne, lockTwo, lockThree, lockFour, lockFive, lockSix, lockSeven, lockEight, lockNine, lockTen;
    private TextView currentGrade;
    private TextView maxText;
    private TextView minText;
    private TextView weightTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiate Variables and objects for rows.
        // This is done 10 times
        assignment1 = findViewById(R.id.assignment1);
        score1 = findViewById(R.id.score1);
        weight1 = findViewById(R.id.weight1);
        scoreSeekBar1 = findViewById(R.id.seekBar1);
        lockOne = findViewById(R.id.lock1);
        
        scoreSeekBar2 = findViewById(R.id.seekBar2);
        assignment2 = findViewById(R.id.assignment2);
        score2 = findViewById(R.id.score2);
        weight2 = findViewById(R.id.weight2);
        lockTwo = findViewById(R.id.lock2);

        scoreSeekBar3 = findViewById(R.id.seekBar3);
        assignment3 = findViewById(R.id.assignment3);
        score3 = findViewById(R.id.score3);
        weight3 = findViewById(R.id.weight3);
        lockThree = findViewById(R.id.lock3);

        scoreSeekBar4 = findViewById(R.id.seekBar4);
        assignment4 = findViewById(R.id.assignment4);
        score4 = findViewById(R.id.score4);
        weight4 = findViewById(R.id.weight4);
        lockFour = findViewById(R.id.lock4);

        scoreSeekBar5 = findViewById(R.id.seekBar5);
        assignment5 = findViewById(R.id.assignment5);
        score5 = findViewById(R.id.score5);
        weight5 = findViewById(R.id.weight5);
        lockFive = findViewById(R.id.lock5);

        scoreSeekBar6 = findViewById(R.id.seekBar6);
        assignment6 = findViewById(R.id.assignment6);
        score6 = findViewById(R.id.score6);
        weight6 = findViewById(R.id.weight6);
        lockSix = findViewById(R.id.lock6);

        scoreSeekBar7 = findViewById(R.id.seekBar7);
        assignment7 = findViewById(R.id.assignment7);
        score7 = findViewById(R.id.score7);
        weight7 = findViewById(R.id.weight7);
        lockSeven = findViewById(R.id.lock7);

        scoreSeekBar8 = findViewById(R.id.seekBar8);
        assignment8 = findViewById(R.id.assignment8);
        score8 = findViewById(R.id.score8);
        weight8 = findViewById(R.id.weight8);
        lockEight = findViewById(R.id.lock8);

        scoreSeekBar9 = findViewById(R.id.seekBar9);
        assignment9 = findViewById(R.id.assignment9);
        score9 = findViewById(R.id.score9);
        weight9 = findViewById(R.id.weight9);
        lockNine = findViewById(R.id.lock9);

        scoreSeekBar10 = findViewById(R.id.seekBar10);
        assignment10 = findViewById(R.id.assignment10);
        score10 = findViewById(R.id.score10);
        weight10 = findViewById(R.id.weight10);
        lockTen = findViewById(R.id.lock10);

        // Initiate Variables and objects for the resultt pane.
        currentGrade = findViewById(R.id.currentGrade);
        maxText = findViewById(R.id.maxGrade);
        minText = findViewById(R.id.minGrade);
        weightTotal = findViewById(R.id.weightTotal);

        // Call these functions to update the calculator user controls and results live.
        seekBarUpdater();
        buttonToSeekUpdater(0);

        // From lab, check for recovering the instance state.
        // This is done 10 times.
        if (savedInstanceState !=null){
            boolean state1 = savedInstanceState.getBoolean("assignment1");
            int visState1 = savedInstanceState.getInt("assignment1Vis");
            String button1 = savedInstanceState.getString("buttonText1");
            assignment1.setEnabled(state1);
            score1.setEnabled(state1);
            weight1.setEnabled(state1);
            scoreSeekBar1.setEnabled(state1);
            lockOne.setText(button1);
            scoreSeekBar1.setVisibility(visState1);
            assignment1.setVisibility(visState1);
            score1.setVisibility(visState1);
            weight1.setVisibility(visState1);
            lockOne.setVisibility(visState1);
            
            boolean state = savedInstanceState.getBoolean("assignment2");
            int visState = savedInstanceState.getInt("assignment2Vis");
            String button2 = savedInstanceState.getString("buttonText2");
            assignment2.setEnabled(state);
            score2.setEnabled(state);
            weight2.setEnabled(state);
            scoreSeekBar2.setEnabled(state);
            lockTwo.setText(button2);
            scoreSeekBar2.setVisibility(visState);
            assignment2.setVisibility(visState);
            score2.setVisibility(visState);
            weight2.setVisibility(visState);
            lockTwo.setVisibility(visState);

            boolean state3 = savedInstanceState.getBoolean("assignment3");
            int visState3 = savedInstanceState.getInt("assignment3Vis");
            String button3 = savedInstanceState.getString("buttonText3");
            assignment3.setEnabled(state3);
            score3.setEnabled(state3);
            weight3.setEnabled(state3);
            scoreSeekBar3.setEnabled(state3);
            lockThree.setText(button3);
            scoreSeekBar3.setVisibility(visState3);
            assignment3.setVisibility(visState3);
            score3.setVisibility(visState3);
            weight3.setVisibility(visState3);
            lockThree.setVisibility(visState3);

            boolean state4 = savedInstanceState.getBoolean("assignment4");
            int visState4 = savedInstanceState.getInt("assignment4Vis");
            String button4 = savedInstanceState.getString("buttonText4");
            assignment4.setEnabled(state4);
            score4.setEnabled(state4);
            weight4.setEnabled(state4);
            scoreSeekBar4.setEnabled(state4);
            lockFour.setText(button4);
            scoreSeekBar4.setVisibility(visState4);
            assignment4.setVisibility(visState4);
            score4.setVisibility(visState4);
            weight4.setVisibility(visState4);
            lockFour.setVisibility(visState4);

            boolean state5 = savedInstanceState.getBoolean("assignment5");
            int visState5 = savedInstanceState.getInt("assignment5Vis");
            String button5 = savedInstanceState.getString("buttonText5");
            assignment5.setEnabled(state5);
            score5.setEnabled(state5);
            weight5.setEnabled(state5);
            scoreSeekBar5.setEnabled(state5);
            lockFive.setText(button5);
            scoreSeekBar5.setVisibility(visState5);
            assignment5.setVisibility(visState5);
            score5.setVisibility(visState5);
            weight5.setVisibility(visState5);
            lockFive.setVisibility(visState5);

            boolean state6 = savedInstanceState.getBoolean("assignment6");
            int visState6 = savedInstanceState.getInt("assignment6Vis");
            String button6 = savedInstanceState.getString("buttonText6");
            assignment6.setEnabled(state6);
            score6.setEnabled(state6);
            weight6.setEnabled(state6);
            scoreSeekBar6.setEnabled(state6);
            lockSix.setText(button6);
            scoreSeekBar6.setVisibility(visState6);
            assignment6.setVisibility(visState6);
            score6.setVisibility(visState6);
            weight6.setVisibility(visState6);
            lockSix.setVisibility(visState6);

            boolean state7 = savedInstanceState.getBoolean("assignment7");
            int visState7 = savedInstanceState.getInt("assignment7Vis");
            String button7 = savedInstanceState.getString("buttonText7");
            assignment7.setEnabled(state7);
            score7.setEnabled(state7);
            weight7.setEnabled(state7);
            scoreSeekBar7.setEnabled(state7);
            lockSeven.setText(button7);
            scoreSeekBar7.setVisibility(visState7);
            assignment7.setVisibility(visState7);
            score7.setVisibility(visState7);
            weight7.setVisibility(visState7);
            lockSeven.setVisibility(visState7);

            boolean state8 = savedInstanceState.getBoolean("assignment8");
            int visState8 = savedInstanceState.getInt("assignment8Vis");
            String button8 = savedInstanceState.getString("buttonText8");
            assignment8.setEnabled(state8);
            score8.setEnabled(state8);
            weight8.setEnabled(state8);
            scoreSeekBar8.setEnabled(state8);
            lockEight.setText(button8);
            scoreSeekBar8.setVisibility(visState8);
            assignment8.setVisibility(visState8);
            score8.setVisibility(visState8);
            weight8.setVisibility(visState8);
            lockEight.setVisibility(visState8);

            boolean state9 = savedInstanceState.getBoolean("assignment9");
            int visState9 = savedInstanceState.getInt("assignment9Vis");
            String button9 = savedInstanceState.getString("buttonText9");
            assignment9.setEnabled(state9);
            score9.setEnabled(state9);
            weight9.setEnabled(state9);
            scoreSeekBar9.setEnabled(state9);
            lockNine.setText(button9);
            scoreSeekBar9.setVisibility(visState9);
            assignment9.setVisibility(visState9);
            score9.setVisibility(visState9);
            weight9.setVisibility(visState9);
            lockNine.setVisibility(visState9);

            boolean state10 = savedInstanceState.getBoolean("assignment10");
            int visState10 = savedInstanceState.getInt("assignment10Vis");
            String button10 = savedInstanceState.getString("buttonText10");
            assignment10.setEnabled(state10);
            score10.setEnabled(state10);
            weight10.setEnabled(state10);
            scoreSeekBar10.setEnabled(state10);
            lockTen.setText(button10);
            scoreSeekBar10.setVisibility(visState10);
            assignment10.setVisibility(visState10);
            score10.setVisibility(visState10);
            weight10.setVisibility(visState10);
            lockTen.setVisibility(visState10);
        }

        // Fab button run throught a switch to create a new row.
        // Which row is displayed is controlled by the clickconter.
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            int clickcount = 0;

            @Override
            public void onClick(View view) {

                // If triggered make the row appear.
                // Thos is done 9 times as row 1 is visible by default.
                switch (clickcount) {
                    case 0:
                        scoreSeekBar2.setVisibility(View.VISIBLE);
                        assignment2.setVisibility(View.VISIBLE);
                        score2.setVisibility(View.VISIBLE);
                        weight2.setVisibility(View.VISIBLE);
                        lockTwo.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        scoreSeekBar3.setVisibility(View.VISIBLE);
                        assignment3.setVisibility(View.VISIBLE);
                        score3.setVisibility(View.VISIBLE);
                        weight3.setVisibility(View.VISIBLE);
                        lockThree.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        scoreSeekBar4.setVisibility(View.VISIBLE);
                        assignment4.setVisibility(View.VISIBLE);
                        score4.setVisibility(View.VISIBLE);
                        weight4.setVisibility(View.VISIBLE);
                        lockFour.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        scoreSeekBar5.setVisibility(View.VISIBLE);
                        assignment5.setVisibility(View.VISIBLE);
                        score5.setVisibility(View.VISIBLE);
                        weight5.setVisibility(View.VISIBLE);
                        lockFive.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        scoreSeekBar6.setVisibility(View.VISIBLE);
                        assignment6.setVisibility(View.VISIBLE);
                        score6.setVisibility(View.VISIBLE);
                        weight6.setVisibility(View.VISIBLE);
                        lockSix.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        scoreSeekBar7.setVisibility(View.VISIBLE);
                        assignment7.setVisibility(View.VISIBLE);
                        score7.setVisibility(View.VISIBLE);
                        weight7.setVisibility(View.VISIBLE);
                        lockSeven.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        scoreSeekBar8.setVisibility(View.VISIBLE);
                        assignment8.setVisibility(View.VISIBLE);
                        score8.setVisibility(View.VISIBLE);
                        weight8.setVisibility(View.VISIBLE);
                        lockEight.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        scoreSeekBar9.setVisibility(View.VISIBLE);
                        assignment9.setVisibility(View.VISIBLE);
                        score9.setVisibility(View.VISIBLE);
                        weight9.setVisibility(View.VISIBLE);
                        lockNine.setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        scoreSeekBar10.setVisibility(View.VISIBLE);
                        assignment10.setVisibility(View.VISIBLE);
                        score10.setVisibility(View.VISIBLE);
                        weight10.setVisibility(View.VISIBLE);
                        lockTen.setVisibility(View.VISIBLE);
                        break;
                    // Tell the user that no more rows can be added.
                    // Toasts are from lab.
                    default:
                        Context context = getApplicationContext();
                        CharSequence text = "Maximum number of rows reached.";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                }
                clickcount = clickcount + 1;
            }
        });
    }

    public void seekBarUpdater( ) {
        // For basic usage of function (How do I listen for change?) https://stackoverflow.com/questions/8956218/android-seekbar-setonseekbarchangelistener
        // This is done 10 times.
        scoreSeekBar1.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue;
                    @Override
                    // Update text and call calculate
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue = progress;
                        if(fromUser) {
                            score1.setText(Integer.toString(seekBarValue));
                        }
                        calculate();
                    }
                    // Nothing is done here.
                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar2.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue2;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue2 = progress;
                        if(fromUser) {
                            score2.setText(Integer.toString(seekBarValue2));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar3.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue3;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue3 = progress;
                        if(fromUser) {
                            score3.setText(Integer.toString(seekBarValue3));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar4.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue4;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue4 = progress;
                        if(fromUser) {
                            score4.setText(Integer.toString(seekBarValue4));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar5.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue5;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue5 = progress;
                        if(fromUser) {
                            score5.setText(Integer.toString(seekBarValue5));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar6.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue6;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue6 = progress;
                        if(fromUser) {
                            score6.setText(Integer.toString(seekBarValue6));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar7.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue7;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue7 = progress;
                        if(fromUser) {
                            score7.setText(Integer.toString(seekBarValue7));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar8.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue8;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue8 = progress;
                        if(fromUser) {
                            score8.setText(Integer.toString(seekBarValue8));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar9.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue9;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue9 = progress;
                        if(fromUser) {
                            score9.setText(Integer.toString(seekBarValue9));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );

        scoreSeekBar10.setOnSeekBarChangeListener (
                new SeekBar.OnSeekBarChangeListener() {
                    int seekBarValue10;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBarValue10 = progress;
                        if(fromUser) {
                            score10.setText(Integer.toString(seekBarValue10));
                        }
                        calculate();
                    }

                    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override public void onStopTrackingTouch(SeekBar seekBar) { }
                }
        );
    }

    public void buttonToSeekUpdater(final int scoreOne) {
        // For basic usage of function (How do I listen for change?) https://stackoverflow.com/questions/18503809/set-addtextchangedlistener-in-a-function-android/18504081
        // This is done 10 times.
        score1.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    // Update seekbar from button change.
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Calculate insert 0 otherwise.
                        int testint = ((score1.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score1.getText().toString()));
                        scoreSeekBar1.setProgress(testint);
                        scoreSeekBar1.refreshDrawableState();
                    }
                    // Call calculate
                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score2.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint2 = ((score2.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score2.getText().toString()));
                        scoreSeekBar2.setProgress(testint2);
                        scoreSeekBar2.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score3.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint3 = ((score3.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score3.getText().toString()));
                        scoreSeekBar3.setProgress(testint3);
                        scoreSeekBar3.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score4.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint4 = ((score4.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score4.getText().toString()));
                        scoreSeekBar4.setProgress(testint4);
                        scoreSeekBar4.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score5.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint5 = ((score5.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score5.getText().toString()));
                        scoreSeekBar5.setProgress(testint5);
                        scoreSeekBar5.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score6.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint6 = ((score6.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score6.getText().toString()));
                        scoreSeekBar6.setProgress(testint6);
                        scoreSeekBar6.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score7.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint7 = ((score7.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score7.getText().toString()));
                        scoreSeekBar7.setProgress(testint7);
                        scoreSeekBar7.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score8.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint8 = ((score8.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score8.getText().toString()));
                        scoreSeekBar8.setProgress(testint8);
                        scoreSeekBar8.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score9.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint9 = ((score9.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score9.getText().toString()));
                        scoreSeekBar9.setProgress(testint9);
                        scoreSeekBar9.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        score10.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Update seekbar from button change.
                        int testint10 = ((score10.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score10.getText().toString()));
                        scoreSeekBar10.setProgress(testint10);
                        scoreSeekBar10.refreshDrawableState();
                    }

                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        // For basic usage of function (How do I listen for change?) https://stackoverflow.com/questions/8543449/how-to-use-the-textwatcher-class-in-android
        // Call calculate after text is changed. seek bar is not connected to weight only score.
        // This is done 10 times.
        weight1.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate(); }
                }
        );

        weight2.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight3.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight4.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight5.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight6.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight7.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight8.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight9.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );

        weight10.addTextChangedListener(
                new TextWatcher() {
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override public void afterTextChanged(Editable s) { calculate();
                    }
                }
        );
    }

    // This function is the heart of the operation. It is used to calculate the result bar at the bottom.
    // This fucntion is called after any change. Thus a calculate button is obsolete.
    public void calculate() {
        // Populate score variables for all rows. If nothing is resent insert a 0.
        int inputScore = ((score1.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score1.getText().toString());
        int inputScoreTwo = ((score2.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score2.getText().toString());
        int inputScoreThree = ((score3.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score3.getText().toString());
        int inputScoreFour = ((score4.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score4.getText().toString());
        int inputScoreFive = ((score5.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score5.getText().toString());
        int inputScoreSix = ((score6.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score6.getText().toString());
        int inputScoreSeven = ((score7.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score7.getText().toString());
        int inputScoreEight = ((score8.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score8.getText().toString());
        int inputScoreNine = ((score9.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score9.getText().toString());
        int inputScoreTen = ((score10.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score10.getText().toString());

        // Populate weight variables for all rows. If nothing is resent insert a 0.
        int inputWeightOne = ((weight1.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight1.getText().toString());
        int inputWeightTwo = ((weight2.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight2.getText().toString());
        int inputWeightThree = ((weight3.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight3.getText().toString());
        int inputWeightFour = ((weight4.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight4.getText().toString());
        int inputWeightFive = ((weight5.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight5.getText().toString());
        int inputWeightSix = ((weight6.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight6.getText().toString());
        int inputWeightSeven = ((weight7.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight7.getText().toString());
        int inputWeightEight = ((weight8.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight8.getText().toString());
        int inputWeightNine = ((weight9.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight9.getText().toString());
        int inputWeightTen = ((weight10.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight10.getText().toString());

        // Converted to float to fix last minute NaN error. Can be cleaned :)
        // For all row variables
        float scoreOne = inputScore;
        float scoreTwo = inputScoreTwo;
        float scoreThree = inputScoreThree;
        float scoreFour = inputScoreFour;
        float scoreFive = inputScoreFive;
        float scoreSix = inputScoreSix;
        float scoreSeven = inputScoreSeven;
        float scoreEight = inputScoreEight;
        float scoreNine = inputScoreNine;
        float scoreTen = inputScoreTen;

        // Converted to float to fix last minute NaN error. Can be cleaned :)
        // For all row variables
        float weightOne = inputWeightOne;
        float weightTwo = inputWeightTwo;
        float weightThree = inputWeightThree;
        float weightFour = inputWeightFour;
        float weightFive = inputWeightFive;
        float weightSix = inputWeightSix;
        float weightSeven = inputWeightSeven;
        float weightEight = inputWeightEight;
        float weightNine = inputWeightNine;
        float weightTen = inputWeightTen;

        // Convert to decimal, may be obsolete dont want to delete. Ran out of time to clean code sorry :)
        scoreOne = scoreOne/100;
        scoreTwo = scoreTwo/100;
        scoreThree = scoreThree/100;
        scoreFour = scoreFour/100;
        scoreFive = scoreFive/100;
        scoreSix = scoreSix/100;
        scoreSeven = scoreSeven/100;
        scoreEight = scoreEight/100;
        scoreNine = scoreNine/100;
        scoreTen = scoreTen/100;

        // Calculate the total weight
        float weightTotal = weightOne + weightTwo + weightThree + weightFour + weightFive + weightSix + weightSeven + weightEight + weightNine + weightTen;
        // Perform the operation
        double resultCalculation = ((weightOne * scoreOne) + (weightTwo * scoreTwo) + (weightThree * scoreThree) + (weightFour * scoreFour) + (weightFive * scoreFive) + (weightSix * scoreSix) + (weightSeven * scoreSeven) + (weightEight * scoreEight) + (weightNine * scoreNine) + (weightTen * scoreTen)) / weightTotal;

        // Declair variables for min and max.
        float maxScore = 0;
        float minScore = 0;

        // Only used to calculate min and max score.
        // if else statements used to populate min and max scores.
        // If its enabled insert a 100 for max to simulate best case.
        // If its not enabled insert a 0 for min to simulate worst case.
        // if its locked use user input for calculation.
        if (score1.isEnabled()) {
            maxScore = maxScore + (weightOne * 1);
            minScore = minScore + (weightOne * 0);
        } else {
            maxScore = maxScore + (weightOne * scoreOne);
            minScore = minScore + (weightOne * scoreOne);
        }
        if (score2.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score3.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score4.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score5.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score6.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score7.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score8.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score9.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }
        if (score10.isEnabled()) {
            maxScore = maxScore + (weightTwo * 1);
            minScore = minScore + (weightTwo * 0);
        } else {
            maxScore = maxScore + (weightTwo * scoreTwo);
            minScore = minScore + (weightTwo * scoreTwo);
        }

        // Calculate values.
        double minGradeUnrounded = (minScore / weightTotal) * 100;
        double maxGradeUnrounded = (maxScore / weightTotal) * 100;
        // 4 lines https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        // https://stackoverflow.com/questions/1456566/how-do-you-test-to-see-if-a-double-is-equal-to-nan
        // Convert to rouned and take care of NaN error.
        DecimalFormat newFormat = new DecimalFormat("#.##");
        double minGradeRounded =  (Double.isNaN(minGradeUnrounded)) ? 0 : Double.valueOf(newFormat.format(minGradeUnrounded));
        double maxGradeRounded =  (Double.isNaN(maxGradeUnrounded)) ? 0 : Double.valueOf(newFormat.format(maxGradeUnrounded));
        double currentGradeRounded =  (Double.isNaN(resultCalculation)) ? 0 : Double.valueOf(newFormat.format(resultCalculation*100));

        // Display results to user.
        currentGrade.setText("Current Grade: " + currentGradeRounded + " %");
        minText.setText("Min Grade Viable: " + minGradeRounded + " %");
        maxText.setText("Max Grade Viable: " + maxGradeRounded + " %");
        this.weightTotal.setText("Current Weight: " + weightTotal);
    }

    // https://stackoverflow.com/questions/33604702/edittext-enable-and-disable-on-button-click
    // https://stackoverflow.com/questions/6794234/change-focus-to-edittext-android?noredirect=1&lq=1
    // Function used to enable or disable a row from user input.
    // Ie locking a row to simulate a set in stone grade.
    // Unlocked means pending grade that you dont know what you got.
    public void disable(View view) {
        String targetScore;
        String targetWeight;

        switch (view.getId()) {
            // Each case represent s a row lock button.
            // This switch has 10 cases for each row.
            case R.id.lock1:
                targetScore = score1.getText().toString();
                targetWeight = weight1.getText().toString();

                // Display toasts if score or weight is emplty.
                // You cant have a empty final grade
                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                // https://developer.android.com/reference/android/view/View#setEnabled(boolean)
                // Enalble or disabled dependiing on the button  enabled state.
                // Run calculate after to update grade.
                if(score1.isEnabled()) {
                    assignment1.setEnabled(false);
                    score1.setEnabled(false);
                    weight1.setEnabled(false);
                    scoreSeekBar1.setEnabled(false);
                    lockOne.setText("Locked");
                    calculate();
                } else {
                    assignment1.setEnabled(true);
                    score1.setEnabled(true);
                    weight1.setEnabled(true);
                    scoreSeekBar1.setEnabled(true);
                    lockOne.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock2:
                targetScore = score2.getText().toString();
                targetWeight = weight2.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score2.isEnabled()) {
                    assignment2.setEnabled(false);
                    score2.setEnabled(false);
                    weight2.setEnabled(false);
                    scoreSeekBar2.setEnabled(false);
                    lockTwo.setText("Locked");
                    calculate();
                } else {
                    assignment2.setEnabled(true);
                    score2.setEnabled(true);
                    weight2.setEnabled(true);
                    scoreSeekBar2.setEnabled(true);
                    lockTwo.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock3:
                targetScore = score3.getText().toString();
                targetWeight = weight3.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score3.isEnabled()) {
                    assignment3.setEnabled(false);
                    score3.setEnabled(false);
                    weight3.setEnabled(false);
                    scoreSeekBar3.setEnabled(false);
                    lockThree.setText("Locked");
                    calculate();
                } else {
                    assignment3.setEnabled(true);
                    score3.setEnabled(true);
                    weight3.setEnabled(true);
                    scoreSeekBar3.setEnabled(true);
                    lockThree.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock4:
                targetScore = score4.getText().toString();
                targetWeight = weight4.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score4.isEnabled()) {
                    assignment4.setEnabled(false);
                    score4.setEnabled(false);
                    weight4.setEnabled(false);
                    scoreSeekBar4.setEnabled(false);
                    lockFour.setText("Locked");
                    calculate();
                } else {
                    assignment4.setEnabled(true);
                    score4.setEnabled(true);
                    weight4.setEnabled(true);
                    scoreSeekBar4.setEnabled(true);
                    lockFour.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock5:
                targetScore = score5.getText().toString();
                targetWeight = weight5.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score5.isEnabled()) {
                    assignment5.setEnabled(false);
                    score5.setEnabled(false);
                    weight5.setEnabled(false);
                    scoreSeekBar5.setEnabled(false);
                    lockFive.setText("Locked");
                    calculate();
                } else {
                    assignment5.setEnabled(true);
                    score5.setEnabled(true);
                    weight5.setEnabled(true);
                    scoreSeekBar5.setEnabled(true);
                    lockFive.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock6:
                targetScore = score6.getText().toString();
                targetWeight = weight6.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score6.isEnabled()) {
                    assignment6.setEnabled(false);
                    score6.setEnabled(false);
                    weight6.setEnabled(false);
                    scoreSeekBar6.setEnabled(false);
                    lockSix.setText("Locked");
                    calculate();
                } else {
                    assignment6.setEnabled(true);
                    score6.setEnabled(true);
                    weight6.setEnabled(true);
                    scoreSeekBar6.setEnabled(true);
                    lockSix.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock7:
                targetScore = score7.getText().toString();
                targetWeight = weight7.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score7.isEnabled()) {
                    assignment7.setEnabled(false);
                    score7.setEnabled(false);
                    weight7.setEnabled(false);
                    scoreSeekBar7.setEnabled(false);
                    lockSeven.setText("Locked");
                    calculate();
                } else {
                    assignment7.setEnabled(true);
                    score7.setEnabled(true);
                    weight7.setEnabled(true);
                    scoreSeekBar7.setEnabled(true);
                    lockSeven.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock8:
                targetScore = score8.getText().toString();
                targetWeight = weight8.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score8.isEnabled()) {
                    assignment8.setEnabled(false);
                    score8.setEnabled(false);
                    weight8.setEnabled(false);
                    scoreSeekBar8.setEnabled(false);
                    lockEight.setText("Locked");
                    calculate();
                } else {
                    assignment8.setEnabled(true);
                    score8.setEnabled(true);
                    weight8.setEnabled(true);
                    scoreSeekBar8.setEnabled(true);
                    lockEight.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock9:
                targetScore = score9.getText().toString();
                targetWeight = weight9.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score9.isEnabled()) {
                    assignment9.setEnabled(false);
                    score9.setEnabled(false);
                    weight9.setEnabled(false);
                    scoreSeekBar9.setEnabled(false);
                    lockNine.setText("Locked");
                    calculate();
                } else {
                    assignment9.setEnabled(true);
                    score9.setEnabled(true);
                    weight9.setEnabled(true);
                    scoreSeekBar9.setEnabled(true);
                    lockNine.setText("Unlocked");
                    calculate();
                }
                break;
            case R.id.lock10:
                targetScore = score10.getText().toString();
                targetWeight = weight10.getText().toString();

                if (targetScore.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A score must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                } else if (targetWeight.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "A weight must be typed in to lock the row.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                if(score10.isEnabled()) {
                    assignment10.setEnabled(false);
                    score10.setEnabled(false);
                    weight10.setEnabled(false);
                    scoreSeekBar10.setEnabled(false);
                    lockTen.setText("Locked");
                    calculate();
                } else {
                    assignment10.setEnabled(true);
                    score10.setEnabled(true);
                    weight10.setEnabled(true);
                    scoreSeekBar10.setEnabled(true);
                    lockTen.setText("Unlocked");
                    calculate();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Populate saved values on screen rotate.
        // This is done for each row.
        outState.putBoolean("assignment1", assignment1.isEnabled());
        outState.putInt("assignment1Vis", assignment1.getVisibility());
        outState.putString("buttonText1", lockOne.getText().toString());
        
        outState.putBoolean("assignment2", assignment2.isEnabled());
        outState.putInt("assignment2Vis", assignment2.getVisibility());
        outState.putString("buttonText2", lockTwo.getText().toString());

        outState.putBoolean("assignment3", assignment3.isEnabled());
        outState.putInt("assignment3Vis", assignment3.getVisibility());
        outState.putString("buttonText3", lockThree.getText().toString());

        outState.putBoolean("assignment4", assignment4.isEnabled());
        outState.putInt("assignment4Vis", assignment4.getVisibility());
        outState.putString("buttonText4", lockFour.getText().toString());

        outState.putBoolean("assignment5", assignment5.isEnabled());
        outState.putInt("assignment5Vis", assignment5.getVisibility());
        outState.putString("buttonText5", lockFive.getText().toString());

        outState.putBoolean("assignment6", assignment6.isEnabled());
        outState.putInt("assignment6Vis", assignment6.getVisibility());
        outState.putString("buttonText6", lockSix.getText().toString());

        outState.putBoolean("assignment7", assignment7.isEnabled());
        outState.putInt("assignment7Vis", assignment7.getVisibility());
        outState.putString("buttonText7", lockSeven.getText().toString());

        outState.putBoolean("assignment8", assignment8.isEnabled());
        outState.putInt("assignment8Vis", assignment8.getVisibility());
        outState.putString("buttonText8", lockEight.getText().toString());

        outState.putBoolean("assignment9", assignment9.isEnabled());
        outState.putInt("assignment9Vis", assignment9.getVisibility());
        outState.putString("buttonText9", lockNine.getText().toString());

        outState.putBoolean("assignment10", assignment10.isEnabled());
        outState.putInt("assignment10Vis", assignment10.getVisibility());
        outState.putString("buttonText10", lockTen.getText().toString());
    }
}
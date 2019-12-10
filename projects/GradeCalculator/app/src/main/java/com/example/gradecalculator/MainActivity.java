package com.example.gradecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class MainActivity extends AppCompatActivity {
    private EditText assignment1;
    private EditText score1;
    private EditText weight1;
    private SeekBar scoreSeekBar1;
    private EditText assignment2;
    private EditText score2;
    private EditText weight2;
    private TextView result;
    private TextView maxText;

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
        maxText = findViewById(R.id.max);
        seekBarUpdater();
        buttonToSeekUpdater(0);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRow();
            }
        });
    }

    @SuppressLint("ResourceType")
    public void addRow() {
        TableLayout mainTable = (TableLayout)findViewById(R.id.tableLayout2);
        TableRow row = new TableRow(this);
        TableRow sliderow = new TableRow(this);
        TextView txt = new TextView(this);
        EditText txtbox = new EditText(this);
        EditText txtbox2 = new EditText(this);
        EditText txtbox3 = new EditText(this);
        txtbox.setHint("Assignment");
        txtbox2.setHint("Score");
        txtbox2.setTag("score3");

        row.addView(txtbox);
        row.addView(txtbox2);
        row.addView(txtbox3);
        txtbox2.setId(R.id.button_group_cancel);
        mainTable.addView(row, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        //addSeekbar();
    }

    public void addSeekbar() {
        TableLayout mainTable = (TableLayout)findViewById(R.id.tableLayout2);
        TableRow row = new TableRow(this);
        SeekBar seek = new SeekBar(this);
        SeekBar seek2 = new SeekBar(this);
        SeekBar seek3 = new SeekBar(this);
        SeekBar seek4 = new SeekBar(this);
        row.setGravity(Gravity.CENTER);
        row.addView(seek);
        mainTable.addView(row, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
    }

    public void test() {
        TableLayout table = (TableLayout) findViewById(R.id.tableLayout1);

        for (int i = 0; i < table.getChildCount(); i++)
        {
            if( table.getChildAt( i ) instanceof EditText ) {
                // DO something with text
            }
        }
    }

    public void seekBarUpdater( ) {
        scoreSeekBar1.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {
                int seekBarValue;
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    seekBarValue = progress;
                    if(fromUser) {
                        score1.setText(Integer.toString(seekBarValue));
                    }
                    calculate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            }
        );
    }

    public void buttonToSeekUpdater(final int scoreOne) {
        score1.addTextChangedListener(
            new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    int testint = ((score1.getText().toString()).length() <= 0 ? 0 : Integer.parseInt(score1.getText().toString()));
                    scoreSeekBar1.setProgress(testint);
                    scoreSeekBar1.refreshDrawableState();
                }

                @Override
                public void afterTextChanged(Editable s) {
                    calculate();
                }
            }
        );

        score2.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        calculate();
                    }
                }
        );

        weight1.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        calculate();
                    }
                }
        );

        weight2.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        calculate();
                    }
                }
        );
    }

    public void calculate () {
        int inputScore = ((score1.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score1.getText().toString());
        float scoreOne = inputScore;
        scoreOne = scoreOne/100;
        int inputScoreTwo = ((score2.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(score2.getText().toString());
        float scoreTwo = inputScoreTwo;
        scoreTwo = scoreTwo/100;
        int inputWeightOne = ((weight1.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight1.getText().toString());
        float weightOne = inputWeightOne;
        int inputWeightTwo = ((weight2.getText().toString()).length() <= 0) ? 0 : Integer.parseInt(weight2.getText().toString());
        float weightTwo = inputWeightTwo;

        float resultCalculation = (weightOne * scoreOne) + (weightTwo * scoreTwo);
        result.setText(Float.toString(resultCalculation));

        TextView group_can;

        group_can = findViewById(R.id.button_group_cancel);
        maxText.setText(group_can.getText().toString());
    }
}

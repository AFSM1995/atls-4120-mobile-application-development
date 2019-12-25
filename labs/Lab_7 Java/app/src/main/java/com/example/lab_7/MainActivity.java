package com.example.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputBox1;
    EditText inputBox2;
    private CheckBox sureBox;
    private RadioGroup operation;
    private Spinner problemSelect;
    private Switch sureBoxSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBox1 = findViewById(R.id.inputOne);
        inputBox2 = findViewById(R.id.inputTwo);
        sureBox = findViewById(R.id.checkBox);
        operation = findViewById(R.id.radioGroup);
        problemSelect = findViewById(R.id.spinner);
        sureBoxSwitch = findViewById(R.id.noSure);
    }

    @SuppressLint("SetTextI18n")
    public void calculate (View view) {
        // Spinner
        String problemType = String.valueOf(problemSelect.getSelectedItem());
        // Text Response
        TextView textFeedback = findViewById(R.id.question);
        // Button Text
        TextView buttonText = findViewById(R.id.checkButton);
        // Image
        ImageView imageFeedback = findViewById(R.id.imageView);
        // Radio Buttons
        int cost_id = operation.getCheckedRadioButtonId();

        int Value1 = Integer.parseInt(inputBox1.getText().toString());
        int Value2 = Integer.parseInt(inputBox2.getText().toString());
        int answer;
        boolean sure = sureBox.isChecked();
        boolean noSureBox = this.sureBoxSwitch.isChecked();

        switch (problemType) {
            case "50":
                answer = 50;
                break;
            case "100":
                answer = 100;
                break;
            case "75":
                answer = 75;
                break;
            default:
                answer = 25;
        }
        if (cost_id == -1) {
            // Toast 1
            Context context = getApplicationContext();
            CharSequence text = "Please select ether addition or subtraction";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (sure || noSureBox) {
            if ((Value1 + Value2) == answer && cost_id == R.id.add) {
                buttonText.setText("Correct");
                textFeedback.setText(Value1 + " + " + Value2 + " = " + answer);
                imageFeedback.setImageResource(R.drawable.ic_check_solid);
            } else if ((Value1 - Value2) == answer && cost_id == R.id.sub) {
                buttonText.setText("Correct");
                textFeedback.setText(Value1 + " - " + Value2 + " = " + answer);
                imageFeedback.setImageResource(R.drawable.ic_check_solid);
            } else {
                buttonText.setText("Incorrect");
                imageFeedback.setImageResource(R.drawable.ic_times_solid);
            }
        } else {
            // Toast 2
            Context context = getApplicationContext();
            CharSequence text = "Please select the checkbox :)";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
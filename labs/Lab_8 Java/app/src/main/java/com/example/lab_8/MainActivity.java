package com.example.lab_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button sendButton;
    private Spinner colorOption;
    private Spinner numberOption;
    private EditText question;
    private Data_structure fortuneTemplate = new Data_structure();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.fortuneButton);
        colorOption = findViewById(R.id.colorSpinner);
        numberOption = findViewById(R.id.numberSpinner);
        question = findViewById(R.id.question);


        // Create button listener
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                fortuneHandler(views);
            }
        };
        sendButton.setOnClickListener(onclick);
    }

    private void fortuneHandler(View views){
        // Retrieving, Setting, and getting.
        Integer colorPosition = colorOption.getSelectedItemPosition();
        Integer numberPosition = numberOption.getSelectedItemPosition();
        String secretQuestion = question.getText().toString();
        fortuneTemplate.setResult(colorPosition, numberPosition, secretQuestion);
        String returnedAnswer = fortuneTemplate.getAnswer();
        String returnedURL = fortuneTemplate.getHoroscopeURL();
        String storedQuestion = fortuneTemplate.getQuestion();
        Integer storedColor = fortuneTemplate.getColor();
        Integer storedNumber = fortuneTemplate.getNumber();

        // Explicit Intent
        Intent nextActivity = new Intent(MainActivity.this, Activity2.class);
        nextActivity.putExtra("answer", returnedAnswer);
        nextActivity.putExtra("horoscopeURL", returnedURL);
        nextActivity.putExtra("question", storedQuestion);
        nextActivity.putExtra("selectedColorNumber", storedColor);
        nextActivity.putExtra("selectedNumber", storedNumber);
        startActivity(nextActivity);
    }
}

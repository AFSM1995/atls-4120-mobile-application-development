package com.example.lab_8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private String answer;
    private String horoscopeURL;
    private String question;
//    private Integer selectedColorNumber;
//    private Integer selectedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Implicit Intent
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });

        // Retrieve activity 1 input
        Intent retrieveVariables = getIntent();
        answer = retrieveVariables.getStringExtra("answer");
        horoscopeURL = retrieveVariables.getStringExtra("horoscopeURL");
        question = retrieveVariables.getStringExtra("question");
//        selectedColorNumber = Integer.valueOf(Objects.requireNonNull(retrieveVariables.getStringExtra("selectedColorNumber")));
//        selectedNumber = Integer.valueOf(Objects.requireNonNull(retrieveVariables.getStringExtra("selectedNumber")));

        //update text view
        TextView questionView = findViewById(R.id.displayQuestion);
        questionView.setText("You question, " + question);

        TextView answerView = findViewById(R.id.displayAnswer);
        answerView.setText("You answer, " + answer);
    }

    private void loadWebSite(View view){
        Intent horoscope = new Intent((Intent.ACTION_VIEW));
        horoscope.setData(Uri.parse(horoscopeURL));
        startActivity(horoscope);
    }
}
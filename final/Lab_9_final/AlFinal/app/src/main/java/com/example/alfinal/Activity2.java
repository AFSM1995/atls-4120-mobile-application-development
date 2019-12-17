package com.example.alfinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

// Could not use fab started our with wrong templete. But its here in spirti.
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private String answer;
    private String websiteURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Implicit Intent in spirit.
        // Implicit Intent in spirit.
        // Implicit Intent in spirit.
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadWebSite(view);
//            }
//        });

        // Retrieve activity 1 input
        Intent retrieveVariables = getIntent();
        answer = retrieveVariables.getStringExtra("loaction");
        websiteURL = retrieveVariables.getStringExtra("websiteURL");

        //update text view
        TextView questionView = findViewById(R.id.displayQuestion);
        questionView.setText("You should check out " + answer);
    }

    private void loadWebSite(View view){
        Intent horoscope = new Intent((Intent.ACTION_VIEW));
        horoscope.setData(Uri.parse(websiteURL));
        startActivity(horoscope);
    }
}
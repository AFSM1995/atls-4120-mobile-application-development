package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
    }

    public void updateView(View view) {
        String nameValue = name.getText().toString();

        TextView outputText = findViewById(R.id.editText);
        TextView outputText2 = findViewById(R.id.text);
        ImageView north = findViewById(R.id.imageView);

        if (nameValue.equals("north dakota") || nameValue.equals("North Dakota")) {
            outputText.setText("That is correct " + nameValue + " is indeed the best!");
            outputText2.setText(nameValue + " is famous for clear sky's.");
            north.setImageResource(R.drawable.dark);
        } else {
            outputText.setText("No silly " + nameValue + " is not the best state, that title belongs to North Dakota");
            outputText2.setText(nameValue + " is famous for International Peace Garden");
            north.setImageResource(R.drawable.tipi);
        }
    }
}

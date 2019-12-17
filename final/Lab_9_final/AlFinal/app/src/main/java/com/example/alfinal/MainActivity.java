package com.example.alfinal;

import androidx.appcompat.app.AppCompatActivity;


// NOTES ATIONS only happen onbuild button click.
// then button 2 works.

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button meat;
    private RadioButton burrito;
    private RadioButton taco;
    private CheckBox salsa;
    private CheckBox cream;
    private CheckBox cheese;
    private CheckBox guacamole;
    private TextView resultText;
    private Spinner spin;
    private Switch freeSwitch;
    private ImageView displayImage;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.NameText);
        meat = findViewById(R.id.Meatbutton);
        burrito = findViewById(R.id.burritoradioButton2);
        taco = findViewById(R.id.tacoradioButton);
        salsa = findViewById(R.id.salsa);
        cream = findViewById(R.id.cream);
        cheese = findViewById(R.id.cheese);
        guacamole = findViewById(R.id.guacamole);
        resultText = findViewById(R.id.resultText);
        spin = findViewById(R.id.spinner);
        freeSwitch = findViewById(R.id.freeSwitch);
        displayImage = findViewById(R.id.imageView);
        sendButton = findViewById(R.id.fortuneButton);

    }

//    public void meatClicked (View view) {
//        boolean clicked = true;
//        calculate (View view, true);
//    }

    public void calculate (View view) {

        String userName;
        String mainChoice = null;
        String salsaResult = null;
        String creamResult = null;
        String cheeseResult = null;
        String guackResult = null;
        String loactionSelected = null;
        String glutin = null;
        boolean AddSalsa = salsa.isChecked();
        boolean Addcream = cream.isChecked();
        boolean Addcheese = cheese.isChecked();
        boolean Addguacamole = guacamole.isChecked();
        boolean IsBurrito = burrito.isChecked();
        boolean IsTaco = taco.isChecked();
        String location = String.valueOf(spin.getSelectedItem());
        boolean isSwiched = this.freeSwitch.isChecked();
        String websiteURLRight = null;


        if (isSwiched) {
            glutin = "glutin";
            // Toast 1
            Context context = getApplicationContext();
            CharSequence text = "You Selected A Glutin Option.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            glutin = "no glutin";
            // Toast 2
            Context context = getApplicationContext();
            CharSequence text = "You Selected A Non Glutin Option.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        switch (location) {
            case "The Hill":
                loactionSelected = "Illegal Petes";
                websiteURLRight = "http://illegalpetes.com/";
                break;
            case "29th Street":
                loactionSelected = "Chipotle";
                websiteURLRight = "https://www.chipotle.com/";
                break;
            case "Pearl Street":
                loactionSelected = "Bartaco";
                websiteURLRight = "https://bartaco.com/";
                break;
            default:
                loactionSelected = "Chipotle";
                websiteURLRight = "https://www.chipotle.com/";
        }


        if (IsBurrito) {
            mainChoice = "burrito";
            displayImage.setImageResource(R.drawable.burrito);
        } else if (IsTaco){
            mainChoice = "taco";
            displayImage.setImageResource(R.drawable.taco);

        }

        if (AddSalsa) {
            salsaResult = "Salsa";
        } else {
            salsaResult = "no salsa";
        }

        if (Addcream) {
            creamResult = "cream";
        } else {
            creamResult = "no cream";
        }

        if (Addcheese) {
            cheeseResult = "cheese";
        } else {
            cheeseResult = "no cheese";
        }

        if (Addguacamole) {
            guackResult = "guacamole";
        } else {
            guackResult = "no guacamole";
        }

        userName = name.getText().toString();

        resultText.setText(userName + " wants a " + mainChoice + " in a corn tortilla with " + salsaResult + ", " + creamResult + ", " + cheeseResult + ", " + guackResult + ". You should eat at " + loactionSelected + ". They have " + glutin + " options.");

        // Create button listener
        final String finalLoactionSelected = loactionSelected;
        final String finalWebsiteURLRight = websiteURLRight;
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                // Explicit Intent
                Intent nextActivity = new Intent(MainActivity.this, Activity2.class);
                nextActivity.putExtra("loaction", finalLoactionSelected);
                nextActivity.putExtra("websiteURL", finalWebsiteURLRight);
                startActivity(nextActivity);
            }
        };
        sendButton.setOnClickListener(onclick);
    }
}

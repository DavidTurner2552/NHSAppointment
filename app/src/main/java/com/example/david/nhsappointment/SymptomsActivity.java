package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SymptomsActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
    }

    // https://patient.info/symptom-checker
    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
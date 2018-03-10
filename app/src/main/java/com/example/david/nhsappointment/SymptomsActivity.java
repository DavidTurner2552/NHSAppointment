package com.example.david.nhsappointment;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.net.Uri;

public class SymptomsActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;
    private ImageButton profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        profile_button.setOnClickListener(this);

        final EditText editText = (EditText) findViewById(R.id.symptoms);

        Button searchButton = (Button) findViewById(R.id.search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String symptoms = editText.getText().toString();
                System.out.println("Open webpage");
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://patient.info/symptom-checker?Symptoms=" + symptoms));
                startActivity(browserIntent);
            }
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.profile_button) {
            Intent i = new Intent(this, ProfilePage.class);
            startActivity(i);
        }
    }
}
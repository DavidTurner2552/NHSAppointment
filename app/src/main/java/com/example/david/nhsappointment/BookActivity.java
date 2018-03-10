package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;
    private ImageButton profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        profile_button.setOnClickListener(this);
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

package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        String[] profile = dataBaseConnection.profileQuery();

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("Name: " + profile[0]);
        TextView dob = (TextView) findViewById(R.id.dob);
        dob.setText("DoB: " + profile[1]);
        TextView address = (TextView) findViewById(R.id.address);
        address.setText("Address: " + profile[2]);
        TextView doctor = (TextView) findViewById(R.id.doctor);
        doctor.setText("Doctor: " + profile[3]);
        TextView telephone = (TextView) findViewById(R.id.telephone);
        telephone.setText("Telephone: " + profile[4]);
        TextView email = (TextView) findViewById(R.id.email);
        email.setText("Email: " + profile[5]);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
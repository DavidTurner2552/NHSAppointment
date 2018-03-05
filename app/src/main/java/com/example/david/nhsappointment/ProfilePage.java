package com.example.david.nhsappointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        String[] profile = dataBaseConnection.profileQuery();

        EditText name = (EditText) findViewById(R.id.name);
        name.setText("Name: " + profile[0]);
        EditText dob = (EditText) findViewById(R.id.dob);
        dob.setText("DoB: " + profile[1]);
        EditText address = (EditText) findViewById(R.id.address);
        address.setText("Address: " + profile[2]);
        EditText doctor = (EditText) findViewById(R.id.doctor);
        doctor.setText("Doctor: " + profile[3]);
        EditText telephone = (EditText) findViewById(R.id.telephone);
        telephone.setText("Telephone: " + profile[4]);
        EditText email = (EditText) findViewById(R.id.email);
        email.setText("Email: " + profile[5]);
    }
}

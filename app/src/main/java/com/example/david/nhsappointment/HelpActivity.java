package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.david.nhsappointment.R;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;
    private ImageButton profile_button;
    private Button q1_button;
    private Button q2_button;
    private Button q3_button;
    private Button q4_button;
    private Button q5_button;
    private TextView answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        profile_button.setOnClickListener(this);
        q1_button = (Button) findViewById(R.id.question_1);
        q1_button.setOnClickListener(this);
        q2_button = (Button) findViewById(R.id.question_2);
        q2_button.setOnClickListener(this);
        q3_button = (Button) findViewById(R.id.question_3);
        q3_button.setOnClickListener(this);
        q4_button = (Button) findViewById(R.id.question_4);
        q4_button.setOnClickListener(this);
        q5_button = (Button) findViewById(R.id.question_5);
        q5_button.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.profile_button){
            Intent i = new Intent(this, ProfilePage.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.question_1){
            TextView answers = (TextView) findViewById(R.id.answer);
            answers.setText(R.string.answer_1);
        }
        else if (v.getId() == R.id.question_2){
            TextView answers = (TextView) findViewById(R.id.answer);
            answers.setText(R.string.answer_2);
        }
        else if (v.getId() == R.id.question_3){
            TextView answers = (TextView) findViewById(R.id.answer);
            answers.setText(R.string.answer_3);
        }
        else if (v.getId() == R.id.question_4){
            TextView answers = (TextView) findViewById(R.id.answer);
            answers.setText(R.string.answer_4);
        }
        else if (v.getId() == R.id.question_5){
            TextView answers = (TextView) findViewById(R.id.answer);
            answers.setText(R.string.answer_5);
        }
    }
}
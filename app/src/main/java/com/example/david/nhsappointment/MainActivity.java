package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton home_button;
    private ImageButton book_button;
    private ImageButton cancel_button;
    private ImageButton change_button;
    private ImageButton local_button;
    private ImageButton symptoms_button;
    private ImageButton help_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
        book_button = (ImageButton) findViewById(R.id.book_button);
        book_button.setOnClickListener(this);
        cancel_button = (ImageButton) findViewById(R.id.cancel_button);
        cancel_button.setOnClickListener(this);
        change_button = (ImageButton) findViewById(R.id.change_button);
        change_button.setOnClickListener(this);
        local_button = (ImageButton) findViewById(R.id.local_button);
        local_button.setOnClickListener(this);
        symptoms_button = (ImageButton) findViewById(R.id.symptoms_button);
        symptoms_button.setOnClickListener(this);
        help_button = (ImageButton) findViewById(R.id.help_button);
        help_button.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v.getId() == R.id.home_button){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.book_button){
            Intent i = new Intent(this, BookActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.cancel_button){
            Intent i = new Intent(this, CancelActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.change_button){
            Intent i = new Intent(this, ChangeActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.local_button){
            Intent i = new Intent(this, LocalActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.symptoms_button){
            Intent i = new Intent(this, SymptomsActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.help_button){
            Intent i = new Intent(this, HelpActivity.class);
            startActivity(i);
        }
    }
}

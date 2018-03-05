package com.example.david.nhsappointment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        LoginButton();
    }

    public void LoginButton(){
        username = findViewById(R.id.cusUsername);
        password = findViewById(R.id.cusPassword);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (dataBaseConnection.loginQuery(username.getText().toString(), password.getText().toString())) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            LoginActivity.this.startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Incorrect login details", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}
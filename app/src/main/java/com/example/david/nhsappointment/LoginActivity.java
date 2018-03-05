package com.example.david.nhsappointment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login_button;
    private String nameRes;
    private String passRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        LoginButton();
    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.cusUsername);
        password = (EditText)findViewById(R.id.cusPassword);
        login_button = (Button)findViewById(R.id.login_button);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dataBaseConnection.loginQuery(1);

//                        if (username.getText().toString().equals(nameRes) //&&
//                        //password.getText().toString().equals("1")
//                        ){
//                            Toast.makeText(LoginActivity.this,"Username and password is correct",
//                                    Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(v.getContext(), UserActivity.class));
//                        }
//                        else {
//                            Toast.makeText(LoginActivity.this,"Username and password is NOT correct",
//                                    Toast.LENGTH_SHORT).show();
//                        }
                    }
                }
        );
    }
}
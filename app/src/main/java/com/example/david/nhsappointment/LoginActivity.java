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

                        try {
                            String host = "jdbc:mysql://team1uni.ckqzrcwbv3dj.eu-west-1.rds.amazonaws.com:8080/team1uni";
                            String uName = "root";
                            String uPass = "team1uni";
                            Connection con = DriverManager.getConnection(host, uName, uPass);

                            Statement stmt = con.createStatement() ;
                            String query = "SELECT name FROM Customer WHERE customerID = "+password + ";" ;
                            ResultSet rs = stmt.executeQuery(query) ;
                            ResultSetMetaData rsmd = rs.getMetaData();
                            int columnsNumber = rsmd.getColumnCount();
                            while (rs.next()) {
                                for (int i = 1; i <= columnsNumber; i++) {
                                    if (i > 1); //System.out.print(",  ");
                                    String columnValue = rs.getString(i);
                                    nameRes = columnValue;
                                    System.out.print(columnValue);
                                }
                                //System.out.println("");

                            }
                        }
                        catch (SQLException err){
                            System.out.println(err.getMessage());
                        }

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
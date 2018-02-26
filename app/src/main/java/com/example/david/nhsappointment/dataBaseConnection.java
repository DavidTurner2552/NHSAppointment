package com.example.david.nhsappointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by David on 05/02/2018.
 */

    public abstract class dataBaseConnection {

        public static void main(String[] args){
            System.out.println(com.example.david.nhsappointment.dataBaseConnection.loginQuery(1));
        }

        public static String loginQuery(int password)
        {
            try {
                String host = "jdbc:mysql://team1uni.ckqzrcwbv3dj.eu-west-1.rds.amazonaws.com:8080/team1uni";
                String uName = "root";
                String uPass = "team1uni";
                Connection con = DriverManager.getConnection(host, uName, uPass);

                Statement stmt = con.createStatement() ;
                String query = "SELECT name FROM Customer WHERE customerID = "+password+";" ;
                ResultSet rs = stmt.executeQuery(query) ;
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        return columnValue;
                    }
                    System.out.println("");
                }
                con.close();
            }
            catch (SQLException err){
                System.out.println(err.getMessage());
            }
            return "";
        }
    }

}

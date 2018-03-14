package com.example.david.nhsappointment.dummy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David on 14/03/2018.
 */

public class dataBase {
    public static void getName() {
        try {
            String host = "jdbc:mysql://team1uni.ckqzrcwbv3dj.eu-west-1.rds.amazonaws.com:8080/team1uni";
            String uName = "root";
            String uPass = "team1uni";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT name FROM Customer WHERE customerID = 1";//+password + "" ;
            ResultSet rs = stmt.executeQuery(query);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) ;
                    System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    // nameRes = columnValue;
                    System.out.print(columnValue);
                }
                //System.out.println("");

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void getDetails() {
        try {
            String host = "jdbc:mysql://team1uni.ckqzrcwbv3dj.eu-west-1.rds.amazonaws.com:8080/team1uni";
            String uName = "root";
            String uPass = "team1uni";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT * FROM Customer WHERE customerID = 1";//+password + "" ;
            ResultSet rs = stmt.executeQuery(query);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) ;
                    System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    // nameRes = columnValue;
                    System.out.print(columnValue);
                }
                //System.out.println("");

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    public static String getDoctor() {
        try {
            String host = "jdbc:mysql://team1uni.ckqzrcwbv3dj.eu-west-1.rds.amazonaws.com:8080/team1uni";
            String uName = "root";
            String uPass = "team1uni";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            java.sql.Statement stmt = con.createStatement();
            String query = "SELECT name FROM Doctor WHERE customerID = 1";//+password + "" ;
            ResultSet rs = stmt.executeQuery(query);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) ;
                    System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    // nameRes = columnValue;
                    return columnValue;
                }
                //System.out.println("");
                return "";

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return "";
    }
    public static void main(String args[]){
        dataBase db = new dataBase();
        db.getName();
        db.getDetails();
        db.getDoctor();
    }
}

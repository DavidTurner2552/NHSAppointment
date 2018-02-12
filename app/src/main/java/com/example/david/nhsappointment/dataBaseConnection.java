package com.example.david.nhsappointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by David on 05/02/2018.
 */

public class dataBaseConnection {

    public static void main(String[] args){
        try {
//            Properties info = new Properties();
//            info.setProperty("java.net.useSystemProxies", "true");
//            info.put("http.proxyHost", "wwwproxy.hud.ac.uk");
//            info.put("http.proxyPort", "3128");
//            //info.put("proxy_user", "[proxy user]");
//            //info.put("proxy_password", "[proxy password]");
//            info.put("user", "root");
//            info.put("password", "team1uni");
            String host = "jdbc:mysql://team1uni.ckqzrcwbv3dj.eu-west-1.rds.amazonaws.com:8080/team1uni";
            String uName = "root";
            String uPass = "team1uni";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = con.createStatement() ;
            String query = "SELECT name FROM Doctors Where doctorID = 2;" ;
            ResultSet rs = stmt.executeQuery(query) ;
            System.out.println(rs.getString(1));
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}

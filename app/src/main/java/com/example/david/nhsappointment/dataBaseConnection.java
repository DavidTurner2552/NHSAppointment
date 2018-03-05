package com.example.david.nhsappointment;

/**
 * Created by David on 05/02/2018.
 */

    public abstract class dataBaseConnection {

        public static boolean loginQuery(String email, String password)
        {
            if (email.equals(Variables.login[0]) && password.equals(Variables.login[1]))
            {
                return true;
            }
            return false;
        }

        public static String[] profileQuery()
        {
            return Variables.profile;
        }
    }
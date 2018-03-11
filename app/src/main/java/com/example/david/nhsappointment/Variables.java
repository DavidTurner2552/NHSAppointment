package com.example.david.nhsappointment;

import java.util.ArrayList;

/**
 * Created by Jeremy on 05/03/2018.
 */

public abstract class Variables {

    public static String[] profile = {"Bob", "25/04/1991", "34 Huddersfield Road", "Dr. Greg Davies", "01421 893800", "bob@gmail.com"};
    public static String[] login = {"bob@gmail.com", "25/04/1991"};
    public static String[] symptoms = {};

   // public static String[] availableTimes = {"09:00", "09:30", "10:00", "10:30", "11:00"};

    public static ArrayList<String> availableTimes = new ArrayList<String>() {{
        add("09:00");
        add("09:30");
        add("10:00");
        add("10:30");
        add("11:00");
        add("11:30");
        add("12:00");
    }};

    public static ArrayList<String> bookedTimes = new ArrayList<String>() {{

    }};

}

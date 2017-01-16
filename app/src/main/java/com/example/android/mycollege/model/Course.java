package com.example.android.mycollege.model;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;
import static android.R.attr.requireDeviceUnlock;

/**
 * Created by benjamin.mamani on 12/01/2017.
 */

public class Course {
    int sessionCount = 0;
    String name = "";
    String _id = "";
    String id_studient = "";
    List<Session> sessions;

    public Course(String name){
        this.name = name;
        sessions = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public double getAverage(){
        double total_average = 0;

        for (Session session : sessions) {
            total_average += session.score;
        }
        if(sessions.size() >= 1){
            return total_average/sessions.size();
        }else{
            return 0.0;
        }
    }
}

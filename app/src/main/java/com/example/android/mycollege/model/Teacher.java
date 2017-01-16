package com.example.android.mycollege.model;

import java.util.ArrayList;

/**
 * Created by benjamin.mamani on 16/01/2017.
 */

public class Teacher {
    private String user = "";
    private String password = "";
    private String name = "";

    private ArrayList<Course> courseList;

    public Teacher(){
        user = "";
        password = "";
        name = "";
        courseList = new ArrayList<>();
    }
    public Teacher(String name, String user, String password){
        this.user = user;
        this.password = password;
        this.name = name;
        courseList = new ArrayList<>();
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public void addCourse(Course course){
        courseList.add(course);
    }
    public ArrayList<Course> getCourseList(){
        return courseList;
    }
}

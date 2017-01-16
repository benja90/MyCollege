package com.example.android.mycollege.model;

/**
 * Created by benjamin.mamani on 16/01/2017.
 */

public class Teacher {
    private String user = "";
    private String password = "";
    private String name = "";

    public Teacher(){
        user = "";
        password = "";
        name = "";
    }
    public Teacher(String name, String user, String password){
        this.user = user;
        this.password = password;
        this.name = name;
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
}

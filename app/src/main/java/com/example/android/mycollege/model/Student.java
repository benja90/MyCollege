package com.example.android.mycollege.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin.mamani on 12/01/2017.
 */

public class Student {
    String _id = "";
    private String name = "";
    private String lastName = "";
    private String user = "";
    private String password = "";
    private String email = "";
    private String cellPhone = "";
    private String address = "";
    private double latitud = 0;
    private double longitud = 0;
    int foto;
    List<Course> courses = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCouse(Course course){
        this.courses.add(course);
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}

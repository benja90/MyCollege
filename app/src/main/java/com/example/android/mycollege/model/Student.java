package com.example.android.mycollege.model;

import com.example.android.mycollege.staticDataBase.GetStaticData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin.mamani on 12/01/2017.
 */

public class Student {
    String _id = "";
    private int internal_id = 0;
    private String name = "";
    private String lastName = "";
    private String email = "";
    private String cellPhone = "";
    private String address = "";
    private int latitud = 0;
    private int longitud = 0;
    int foto;
    List<Course> courses = new ArrayList<>();

    public int session01 = 0;
    public int session02 = 0;
    public int session03 = 0;
    public int session04 = 0;
    public int session05 = 0;
    public int session06 = 0;
    public int session07 = 0;
    public int session08 = 0;




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

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getAverage(){
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double average = (session01+session02+session03+session04+session05+session06+session07+session08)/8;
        return decimalFormat.format(average);
    }

    public int getInternal_id() {
        return internal_id;
    }

    public void setInternal_id(int internal_id) {
        this.internal_id = internal_id;
    }

    public Student(){
        GetStaticData.currentId += 1;
        internal_id = GetStaticData.currentId;
    }
}

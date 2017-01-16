package com.example.android.mycollege.staticDataBase;

import com.example.android.mycollege.model.Course;
import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin.mamani on 16/01/2017.
 */

public class GetStaticData {
    private static GetStaticData instace = null;
    private static String currentStudent = "";
    private static String currentTeacher = "";

    private List<Student> dataStudent;
    private List<Teacher> teacherList;

    protected GetStaticData(){
        loadData();
    }

    public static GetStaticData getInstace(){
        if(instace == null){
            instace = new GetStaticData();
        }
        return  instace;
    }

    public Student getStudientTest(String user){

        for (Student student : dataStudent) {
            if(student.getUser().equals(user))
                return student;
        }
        return new Student();
    }
    public Student getCurrentStudent(){
        return getStudientTest(currentStudent);
    }
    public void setCurrentStudent(String studentUser){
        currentStudent = studentUser;
    }
    public Teacher getCurrentTeacher(){
        return getTeacher(currentTeacher);
    }
    public Teacher getTeacher(String user){

        for (Teacher teacher : teacherList) {
            if(teacher.getUser().equals(user))
                return teacher;
        }
        return new Teacher();
    }

    public void setCurrentTeacher(String teacherUser){
        currentTeacher = teacherUser;
    }

    private void loadData(){

        Teacher teacher = new Teacher("Benjamin Mamani", "benja", "123456");
        teacherList = new ArrayList<>();
        teacherList.add(teacher);


        dataStudent = new ArrayList<>();
        Student studentTest01 = new Student();
        studentTest01.setAddress("Malecon Balta 678, Miraflores");
        studentTest01.setCellPhone("958125632");
        studentTest01.setEmail("example@android.com");
        studentTest01.setLastName("Test");
        studentTest01.setName("Testing");
        studentTest01.setUser("test");
        studentTest01.setPassword("android");

        Course course = new Course("Android Basic");
        studentTest01.addCouse(course);
        dataStudent.add(studentTest01);
    }

    private void addStudient(Student student){
        dataStudent.add(student);
    }


}

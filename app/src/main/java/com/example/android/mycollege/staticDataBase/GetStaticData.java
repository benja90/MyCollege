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

    public static Student student = new Student();
    public static int currentCoursePosition = 0;
    public static int currentStudentPosition = 0;

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

        dataStudent = new ArrayList<>();
        teacherList = new ArrayList<>();
        Teacher teacher = new Teacher("Benjamin Mamani", "benja", "123456");
        Course courseBasic = new Course("Android Basic", 8, "0001");

        Student studentTest01 = new Student();
        studentTest01.setAddress("Malecon Balta 678, Miraflores");
        studentTest01.setCellPhone("958125632");
        studentTest01.setEmail("example@android.com");
        studentTest01.setLastName("Student");
        studentTest01.setName("One");

        studentTest01.session01 = 12;
        studentTest01.session02 = 0;
        studentTest01.session03 = 0;
        studentTest01.session04 = 14;
        studentTest01.session05 = 19;
        studentTest01.session06 = 20;
        studentTest01.session07 = 0;
        studentTest01.session08 = 10;

        courseBasic.addStudent(studentTest01);

        teacher.addCourse(courseBasic);






        Course course = new Course("Android Basic");
        studentTest01.addCouse(course);
        dataStudent.add(studentTest01);


        teacherList.add(teacher);
    }

    private void addStudient(Student student){
        dataStudent.add(student);
    }

    public Student getCurrentStudent(){
        return getCurrentCourse().getStudentList().get(currentStudentPosition);
    }
    public Course getCurrentCourse(){
        return getCurrentTeacher().getCourseList().get(currentCoursePosition);
    }

}

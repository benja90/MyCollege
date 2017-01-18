package com.example.android.mycollege;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.mycollege.adapter.StudentAdapter;
import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.staticDataBase.GetStaticData;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by benjamin.mamani on 16/01/2017.
 */

public class StudentListActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);


        ArrayList<Student> studentList = GetStaticData.getInstace().getCurrentTeacher().getCourseList().get(GetStaticData.getInstace().currentCoursePosition).getStudentList();



        ListView listView = (ListView)findViewById(R.id.course_list_student);
        StudentAdapter studentAdapter = new StudentAdapter(this, studentList);
        listView.setAdapter(studentAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                GetStaticData.getInstace().currentStudentPosition = i;
                Intent intent = new Intent(StudentListActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_list_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_list_student_add:
                Intent intent = new Intent(getApplicationContext(),CreateStudientActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

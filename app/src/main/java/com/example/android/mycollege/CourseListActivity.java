package com.example.android.mycollege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.mycollege.adapter.CourseAdapter;
import com.example.android.mycollege.model.Course;
import com.example.android.mycollege.staticDataBase.GetStaticData;

import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        ArrayList<Course> courseArrayList = GetStaticData.getInstace().getCurrentTeacher().getCourseList();

        ListView listView = (ListView)findViewById(R.id.course_list_details);
        final CourseAdapter courseAdapter = new CourseAdapter(this, courseArrayList);
        listView.setAdapter(courseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GetStaticData.getInstace().currentCoursePosition = position;
                Intent intent = new Intent(CourseListActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });

    }

}

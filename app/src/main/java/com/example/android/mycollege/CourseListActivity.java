package com.example.android.mycollege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.mycollege.adapter.CourseAdapter;
import com.example.android.mycollege.model.Course;

import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        ArrayList<Course> courseArrayList = new ArrayList<>();
        courseArrayList.add(new Course("Android"));

        ListView listView = (ListView)findViewById(R.id.course_list_details);
        final CourseAdapter courseAdapter = new CourseAdapter(this, courseArrayList);
        listView.setAdapter(courseAdapter);

        Button managerAccount = (Button)findViewById(R.id.course_list_btn_manager);
        managerAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseListActivity.this, EditStudientActivity.class);
                startActivity(intent);
            }
        });
    }

}

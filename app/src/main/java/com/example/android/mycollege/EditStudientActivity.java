package com.example.android.mycollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.staticDataBase.GetStaticData;

public class EditStudientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_studient);

        GetStaticData staticData = GetStaticData.getInstace();
        Student student = staticData.getCurrentStudent();

        ((EditText)findViewById(R.id.edit_name)).setText(student.getName());

    }
}

package com.example.android.mycollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.staticDataBase.GetStaticData;

import static com.example.android.mycollege.staticDataBase.GetStaticData.student;

public class CreateStudientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_studient);

        Button saveButton = (Button)findViewById(R.id.create_btn);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.setName(((EditText)findViewById(R.id.create_name)).getText().toString());
                student.setLastName(((EditText)findViewById(R.id.create_last_name)).getText().toString());
                student.setEmail(((EditText)findViewById(R.id.create_email)).getText().toString());
                student.setCellPhone(((EditText)findViewById(R.id.create_phone)).getText().toString());
                student.setAddress(((EditText)findViewById(R.id.create_address)).getText().toString());
                student.setLatitud(Integer.parseInt(((EditText)findViewById(R.id.create_latitude)).getText().toString()));
                student.setLatitud(Integer.parseInt(((EditText)findViewById(R.id.create_longitude)).getText().toString()));

                GetStaticData.getInstace().getCurrentCourse().getStudentList().add(student);
                finish();
            }
        });
    }
}

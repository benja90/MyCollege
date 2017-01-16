package com.example.android.mycollege;

import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.staticDataBase.GetStaticData;

public class EditStudientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_studient);

        GetStaticData staticData = GetStaticData.getInstace();
        final Student student = staticData.getCurrentStudent();

        ((EditText)findViewById(R.id.edit_name)).setText(student.getName());
        ((EditText)findViewById(R.id.edit_address)).setText(student.getAddress());
        ((EditText)findViewById(R.id.edit_email)).setText(student.getEmail());
        ((EditText)findViewById(R.id.edit_last_name)).setText(student.getLastName());
        ((EditText)findViewById(R.id.edit_phone)).setText(student.getCellPhone());
        ((EditText)findViewById(R.id.edit_longitude)).setText(student.getLongitud()+"");
        ((EditText)findViewById(R.id.edit_latitude)).setText(student.getLatitud()+"");

        Button save = (Button)findViewById(R.id.edit_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.setName(((EditText) findViewById(R.id.edit_name)).getText().toString());
                student.setLastName(((EditText) findViewById(R.id.edit_last_name)).getText().toString());
                student.setAddress(((EditText) findViewById(R.id.edit_address)).getText().toString());
                student.setEmail(((EditText) findViewById(R.id.edit_email)).getText().toString());
                student.setCellPhone(((EditText) findViewById(R.id.edit_phone)).getText().toString());
                try {
                    student.setLatitud(Integer.parseInt(((EditText) findViewById(R.id.edit_latitude)).getText().toString()));
                }catch (Exception ec){
                    Log.e("Err", ec.getLocalizedMessage());
                }
                try{
                    student.setLongitud(Integer.parseInt(((EditText)findViewById(R.id.edit_longitude)).getText().toString()));
                }catch (Exception ec){
                    Log.e("Err", ec.getLocalizedMessage());
                }




                GetStaticData.getInstace().getCurrentCourse().getStudentList().set(GetStaticData.currentStudentPosition, student);

            }
        });

    }
}



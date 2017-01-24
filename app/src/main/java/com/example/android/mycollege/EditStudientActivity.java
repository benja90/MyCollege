package com.example.android.mycollege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.staticDataBase.GetStaticData;

import java.util.Iterator;
import java.util.Set;

import static com.example.android.mycollege.staticDataBase.GetStaticData.getInstace;
import static com.example.android.mycollege.staticDataBase.GetStaticData.student;

public class EditStudientActivity extends AppCompatActivity {
    final String LOG_TAG = EditStudientActivity.class.getSimpleName();
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String idStudent = bundle.get("idStudent")+"";//intent.getStringExtra("idStudent");

        Log.i(LOG_TAG, idStudent);
        int indexStudent = Integer.parseInt(idStudent);

        student = GetStaticData.getInstace().getStudent(indexStudent);

        setContentView(R.layout.activity_edit_studient);

        GetStaticData staticData = GetStaticData.getInstace();


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


            }
        });


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_update_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: onBackPressed(); break;
            case R.id.menu_update_student_save:


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

                Toast toast =Toast.makeText(getApplicationContext(),"ActionComplete", Toast.LENGTH_SHORT);
                toast.show();
                GetStaticData.getInstace().setStudent(student);

                //GetStaticData.getInstace().getCurrentCourse().getStudentList().set(GetStaticData.currentStudentPosition, student);
                onBackPressed();

                break;


        }
        return super.onOptionsItemSelected(item);
    }
}



package com.example.android.mycollege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.model.Teacher;
import com.example.android.mycollege.staticDataBase.GetStaticData;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //// LOAD STATIC DATA BECOUSE DONT HAVE SQL CONNECTION




        Button btnSignUp = (Button)findViewById(R.id.login_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CreateStudientActivity.class);
                startActivity(intent);

            }
        });

        Button btnSignIn = (Button)findViewById(R.id.login_signin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText user = (EditText) findViewById(R.id.login_user);
                EditText password = (EditText) findViewById(R.id.login_password);

                GetStaticData data = GetStaticData.getInstace();
                Teacher teacherUser = data.getTeacher(user.getText().toString());
               /* if(teacherUser.getName() != ""){
                    data.setCurrentTeacher(teacherUser.getUser());
                    Intent intent = new Intent(LoginActivity.this, CourseListActivity.class);
                    startActivity(intent);
                }else{
                     ((EditText) findViewById(R.id.login_user)).setText("INCORRECT USER");
                }*/
                data.setCurrentTeacher("benja");
                Intent intent = new Intent(LoginActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });
    }
}

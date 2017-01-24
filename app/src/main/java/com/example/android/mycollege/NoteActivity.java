package com.example.android.mycollege;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mycollege.model.Student;
import com.example.android.mycollege.staticDataBase.GetStaticData;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.mycollege.staticDataBase.GetStaticData.getInstace;
import static com.example.android.mycollege.staticDataBase.GetStaticData.student;

public class NoteActivity extends AppCompatActivity {
    final private String LOG_TAG = NoteActivity.class.getSimpleName();
    Button getAverage;
    Button reset;
    InputMethodManager iMM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String idStudent = bundle.get("idStudent")+"";

        Log.i(LOG_TAG, idStudent);


        int indexStudent = Integer.parseInt(idStudent);


        final Student student = GetStaticData.getInstace().getStudent(indexStudent);//getInstace().getCurrentStudent();



        iMM = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        ((EditText)findViewById(R.id.txt_average)).setText("0.00");
        ((EditText)findViewById(R.id.txt_average)).setEnabled(false);


        setValues((CheckBox) findViewById(R.id.cbx_score01),(EditText) findViewById(R.id.txt_score01), student.session01);
        setValues((CheckBox) findViewById(R.id.cbx_score02),(EditText) findViewById(R.id.txt_score02), student.session02);
        setValues((CheckBox) findViewById(R.id.cbx_score03),(EditText) findViewById(R.id.txt_score03), student.session03);
        setValues((CheckBox) findViewById(R.id.cbx_score04),(EditText) findViewById(R.id.txt_score04), student.session04);
        setValues((CheckBox) findViewById(R.id.cbx_score05),(EditText) findViewById(R.id.txt_score05), student.session05);
        setValues((CheckBox) findViewById(R.id.cbx_score06),(EditText) findViewById(R.id.txt_score06), student.session06);
        setValues((CheckBox) findViewById(R.id.cbx_score07),(EditText) findViewById(R.id.txt_score07), student.session07);
        setValues((CheckBox) findViewById(R.id.cbx_score08),(EditText) findViewById(R.id.txt_score08), student.session08);

        final List<View[]> allScore = new ArrayList<>();
        allScore.add(new View[]{findViewById(R.id.cbx_score01),findViewById(R.id.txt_score01)});
        allScore.add(new View[]{findViewById(R.id.cbx_score02),findViewById(R.id.txt_score02)});
        allScore.add(new View[]{findViewById(R.id.cbx_score03),findViewById(R.id.txt_score03)});
        allScore.add(new View[]{findViewById(R.id.cbx_score04),findViewById(R.id.txt_score04)});
        allScore.add(new View[]{findViewById(R.id.cbx_score05),findViewById(R.id.txt_score05)});
        allScore.add(new View[]{findViewById(R.id.cbx_score06),findViewById(R.id.txt_score06)});
        allScore.add(new View[]{findViewById(R.id.cbx_score07),findViewById(R.id.txt_score07)});
        allScore.add(new View[]{findViewById(R.id.cbx_score08),findViewById(R.id.txt_score08)});/*
        for (View[] views : allScore) {
            final CheckBox cbxTemp = (CheckBox)views[0];
            final EditText textTemp = (EditText)views[1];
            iMM.showSoftInput(textTemp, InputMethodManager.SHOW_IMPLICIT);
            textTemp.setEnabled(false);
            cbxTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enableEditor(cbxTemp, textTemp);
                }
            });
        }*/

        getAverage = (Button)findViewById(R.id.btn_average);
        getAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                student.session01 = saveValues((EditText)findViewById(R.id.txt_score01));
                student.session02 = saveValues((EditText)findViewById(R.id.txt_score02));
                student.session03 = saveValues((EditText)findViewById(R.id.txt_score03));
                student.session04 = saveValues((EditText)findViewById(R.id.txt_score04));
                student.session05 = saveValues((EditText)findViewById(R.id.txt_score05));
                student.session06 = saveValues((EditText)findViewById(R.id.txt_score06));
                student.session07 = saveValues((EditText)findViewById(R.id.txt_score07));
                student.session08 = saveValues((EditText)findViewById(R.id.txt_score08));
                /*double average = 0.0;
                int countScore = 0;

                for (View[] views : allScore) {
                    countScore++;
                    if(checkCorrectScoreValue((EditText)views[1])){
                        average +=  Integer.parseInt(((EditText)views[1]).getText().toString());
                    }
                }

                 average = average/countScore;*/
                 //((EditText)findViewById(R.id.txt_average)).setText(""+average);
                 ((EditText)findViewById(R.id.txt_average)).setText(student.getAverage());

               // getInstace().getCurrentCourse().getStudentList().set(GetStaticData.currentStudentPosition,student);
                GetStaticData.getInstace().setStudent(student);
            }
        });

        reset = (Button)findViewById(R.id.btn_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText)findViewById(R.id.txt_average)).setText("0.00");

                for (View[] views : allScore) {
                    ((CheckBox)views[0]).setChecked(false);
                    ((EditText)views[1]).setEnabled(false);
                    ((EditText)views[1]).setText("");
                }

                student.session01 = saveValues((EditText)findViewById(R.id.txt_score01));
                student.session02 = saveValues((EditText)findViewById(R.id.txt_score02));
                student.session03 = saveValues((EditText)findViewById(R.id.txt_score03));
                student.session04 = saveValues((EditText)findViewById(R.id.txt_score04));
                student.session05 = saveValues((EditText)findViewById(R.id.txt_score05));
                student.session06 = saveValues((EditText)findViewById(R.id.txt_score06));
                student.session07 = saveValues((EditText)findViewById(R.id.txt_score07));
                student.session08 = saveValues((EditText)findViewById(R.id.txt_score08));
                GetStaticData.getInstace().setStudent(student);
                //getInstace().getCurrentCourse().getStudentList().set(GetStaticData.currentStudentPosition,student);
            }
        });



        getSupportActionBar().setTitle(student.getName()+" "+student.getLastName());
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }

    public boolean checkCorrectScoreValue(EditText text){
        if(text.getText() == null)
            return false;
        if(text.getText().toString().equals(""))
            return false;
        try{
            int score = Integer.parseInt(text.getText().toString());
            if(score > 20 || score < 0)
                return false;
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void enableEditor(CheckBox checkBox, EditText editText){
        if(checkBox.isChecked()){
            editText.setEnabled(true);
            editText.requestFocus();
            iMM.showSoftInput(editText,InputMethodManager.SHOW_IMPLICIT);
        }else{
            editText.setEnabled(false);
            editText.setText("");
        }
    }

    public void setValues(final CheckBox checkBox, final EditText editText, int value){
        if(value == 0){
            checkBox.setChecked(false);
            editText.setEnabled(false);
            editText.setText("");
        }else{
            checkBox.setChecked(true);
            editText.setEnabled(true);
            editText.setText(value+"");
        }
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableEditor(checkBox, editText);
            }
        });
    }

    public int saveValues(EditText editText){
        if(checkCorrectScoreValue(editText)){
            String data = editText.getText().toString();
            if(data.equals(""))
                return 0;
            else
                return Integer.parseInt(data);
        }
        return 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: onBackPressed(); break;
            case R.id.menu_scores_delete:
                Log.i("DEBV", "ELEMIN");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ////DELETE

                        Student student = GetStaticData.getInstace().getCurrentStudent();
                        GetStaticData.getInstace().getCurrentCourse().getStudentList().remove(student);
                        Toast toast =Toast.makeText(getApplicationContext(),"ActionComplete", Toast.LENGTH_SHORT);
                        toast.show();
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ////DELETE
                    }
                });

                builder.setTitle("CONFIRM");
                builder.setMessage("REALLY?");
                builder.show();


                break;
            case R.id.menu_scores_update:
                Intent intent = new Intent(getApplicationContext(), EditStudientActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }



}

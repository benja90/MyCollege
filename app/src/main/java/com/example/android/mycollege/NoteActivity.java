package com.example.android.mycollege;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity {

    Button getAverage;
    Button reset;
    InputMethodManager iMM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        iMM = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        ((EditText)findViewById(R.id.txt_average)).setText("0.00");
        ((EditText)findViewById(R.id.txt_average)).setEnabled(false);


        final List<View[]> allScore = new ArrayList<>();
        allScore.add(new View[]{findViewById(R.id.cbx_score01),findViewById(R.id.txt_score01)});
        allScore.add(new View[]{findViewById(R.id.cbx_score02),findViewById(R.id.txt_score02)});
        allScore.add(new View[]{findViewById(R.id.cbx_score03),findViewById(R.id.txt_score03)});
        allScore.add(new View[]{findViewById(R.id.cbx_score04),findViewById(R.id.txt_score04)});
        allScore.add(new View[]{findViewById(R.id.cbx_score05),findViewById(R.id.txt_score05)});
        allScore.add(new View[]{findViewById(R.id.cbx_score06),findViewById(R.id.txt_score06)});
        allScore.add(new View[]{findViewById(R.id.cbx_score07),findViewById(R.id.txt_score07)});
        allScore.add(new View[]{findViewById(R.id.cbx_score08),findViewById(R.id.txt_score08)});
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
        }

        getAverage = (Button)findViewById(R.id.btn_average);
        getAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double average = 0.0;
                int countScore = 0;

                for (View[] views : allScore) {
                    countScore++;
                    if(checkCorrectScoreValue((EditText)views[1])){
                        average +=  Integer.parseInt(((EditText)views[1]).getText().toString());
                    }
                }

                 average = average/countScore;
                 ((EditText)findViewById(R.id.txt_average)).setText(""+average);

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
            }
        });


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
}

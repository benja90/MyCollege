package com.example.android.mycollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    CheckBox cbxSessio01;//To know check state
    CheckBox cbxSessio02;
    CheckBox cbxSessio03;
    CheckBox cbxSessio04;

    EditText txtScore01;
    EditText txtScore02;
    EditText txtScore03;
    EditText txtScore04;

    Button getAverage;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ((EditText)findViewById(R.id.txt_average)).setText("0");
        ((EditText)findViewById(R.id.txt_average)).setEnabled(false);
        txtScore01 = (EditText)findViewById(R.id.txt_score01);
        txtScore02 = (EditText)findViewById(R.id.txt_score02);
        txtScore03 = (EditText)findViewById(R.id.txt_score03);
        txtScore04 = (EditText)findViewById(R.id.txt_score04);

        txtScore01.setEnabled(false);
        txtScore02.setEnabled(false);
        txtScore03.setEnabled(false);
        txtScore04.setEnabled(false);

        cbxSessio01 = (CheckBox)findViewById(R.id.cbx_score01);
        cbxSessio02 = (CheckBox)findViewById(R.id.cbx_score02);
        cbxSessio03 = (CheckBox)findViewById(R.id.cbx_score03);
        cbxSessio04 = (CheckBox)findViewById(R.id.cbx_score04);

        cbxSessio01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){
                    txtScore01.setEnabled(true);
                }else{
                    txtScore01.setEnabled(false);
                    txtScore01.setText("");
                }
            }
        });
        cbxSessio02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){
                    txtScore02.setEnabled(true);
                }else{
                    txtScore02.setEnabled(false);
                    txtScore02.setText("");
                }
            }
        });
        cbxSessio03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){
                    txtScore03.setEnabled(true);
                }else{
                    txtScore03.setEnabled(false);
                    txtScore03.setText("");
                }
            }
        });
        cbxSessio04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){
                    txtScore04.setEnabled(true);
                }else{
                    txtScore04.setEnabled(false);
                    txtScore04.setText("");
                }
            }
        });

        getAverage = (Button)findViewById(R.id.btn_average);
        getAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double average = 0.0;
                int countScore = 0;

                if(checkCorrectScoreValue(txtScore01)){
                    countScore++;
                    average += Integer.parseInt(txtScore01.getText().toString());
                }
                if(checkCorrectScoreValue(txtScore02)){
                    countScore++;
                    average += Integer.parseInt(txtScore02.getText().toString());
                }
                if(checkCorrectScoreValue(txtScore03)){
                    countScore++;
                    average += Integer.parseInt(txtScore03.getText().toString());
                }
                if(checkCorrectScoreValue(txtScore04)){
                    countScore++;
                    average += Integer.parseInt(txtScore04.getText().toString());
                }
                if(countScore==0){
                    ((EditText)findViewById(R.id.txt_average)).setText("0");
                }else{
                    average = average/countScore;
                    ((EditText)findViewById(R.id.txt_average)).setText(""+average);
                }
            }
        });

        reset = (Button)findViewById(R.id.btn_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText)findViewById(R.id.txt_average)).setText("0.00");
                txtScore01.setText("");
                txtScore02.setText("");
                txtScore03.setText("");
                txtScore04.setText("");

                txtScore01.setEnabled(false);
                txtScore02.setEnabled(false);
                txtScore03.setEnabled(false);
                txtScore04.setEnabled(false);

                cbxSessio01.setChecked(false);
                cbxSessio02.setChecked(false);
                cbxSessio03.setChecked(false);
                cbxSessio04.setChecked(false);

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
}

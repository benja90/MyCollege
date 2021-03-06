package com.example.android.mycollege.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.mycollege.EditStudientActivity;
import com.example.android.mycollege.NoteActivity;
import com.example.android.mycollege.R;
import com.example.android.mycollege.StudentListActivity;
import com.example.android.mycollege.model.Student;

import java.util.ArrayList;

/**
 * Created by benjamin.mamani on 16/01/2017.
 */

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Activity context, ArrayList<Student> studentArrayList) {
        super(context, 0, studentArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.student_list, parent, false);
        }

        final Student student = getItem(position);
        ((TextView)listItemView.findViewById(R.id.student_list_name)).setText(student.getName()+" "+student.getLastName());
        ((TextView)listItemView.findViewById(R.id.student_list_score)).setText(student.getAverage());


        ((TextView)listItemView.findViewById(R.id.student_list_score)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NoteActivity.class);
                intent.putExtra("idStudent", student.getInternal_id());
                getContext().startActivity(intent);
            }
        });
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditStudientActivity.class);
                intent.putExtra("idStudent", student.getInternal_id());
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}

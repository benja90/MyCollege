package com.example.android.mycollege.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.mycollege.R;
import com.example.android.mycollege.model.Course;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by benjamin.mamani on 13/01/2017.
 */

public class CourseAdapter extends ArrayAdapter<Course> {
    private static final String LOG_TAG = CourseAdapter.class.getSimpleName();

    public CourseAdapter(Activity context, ArrayList<Course> courseArrayList){
        super(context,0,courseArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_studient_course,parent,false);
        }

        Course course = getItem(position);
        TextView score  = (TextView)listItemView.findViewById(R.id.list_course_score_total);
        TextView name   = (TextView)listItemView.findViewById(R.id.list_course_score_name);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        name.setText(course.getName());
        score.setText(decimalFormat.format(course.getAverage()));

        return listItemView;
    }
}

package com.example.android.mycollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    GridView gridViewList;
    String[] arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridViewList = (GridView)findViewById(R.id.grid_view_list);
        initList();
        loadList();
    }


    private void initList(){
        arrayList = new String[50];
        for(int i=0;i<50;i++){
            arrayList[i] = "List Student "+i;
        }
    }
    private void loadList(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        gridViewList.setAdapter(arrayAdapter);
    }

}

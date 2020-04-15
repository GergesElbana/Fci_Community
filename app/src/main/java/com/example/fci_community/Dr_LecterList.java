package com.example.fci_community;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Dr_LecterList extends AppCompatActivity {
public static String []items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr__lecter_list);
        ListView list=(ListView)findViewById(R.id.dr_lecturelistview);
        ArrayAdapter<String>adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
                ,items);
        list.setAdapter(adapter);



    }
}

package com.example.fci_community.Dr_Lecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Tablayout.ManageLectureActivity;
import com.example.fci_community.R;

public class Activity_Dr_Lecture_List extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[]subject={"IT","CS","IS"};
    ListView lectureListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr__lecter_list);
        getSupportActionBar().hide();

        lectureListView=(ListView)findViewById(R.id.dr_lecturelistview);
        ArrayAdapter<String > adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subject);
        lectureListView.setAdapter(adapter);
        lectureListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Activity_Dr_Lecture_List.this, ManageLectureActivity.class);
                startActivity(intent);
    }
}

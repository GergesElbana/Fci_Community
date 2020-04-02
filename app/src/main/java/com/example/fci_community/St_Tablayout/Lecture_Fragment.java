package com.example.fci_community.St_Tablayout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fci_community.Lecture.Lecture_activity;
import com.example.fci_community.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Lecture_Fragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listLecture;
    String[]subject={"IT","CS","IS"};


    public Lecture_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile_, container, false);


        listLecture=(ListView)v.findViewById(R.id.list_Lecture);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,subject);
        listLecture.setAdapter(adapter);

        listLecture.setOnItemClickListener(this);
        return   v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getActivity(),Lecture_activity.class);
        startActivity(intent);

    }
}
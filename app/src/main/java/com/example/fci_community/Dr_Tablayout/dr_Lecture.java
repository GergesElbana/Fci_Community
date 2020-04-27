package com.example.fci_community.Dr_Tablayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.fci_community.Dr_Lecture.Activity_Dr_Lecture_List;
import com.example.fci_community.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class dr_Lecture extends Fragment implements View.OnClickListener {
   private   Button btn_1,btn_2,btn_3,btn_4;
   private String[]subjecto={"IT","CS","IS","ggggg","naaa"};
 private    ListView lectureListView;
    private Object Activity_Dr_Lecture_List;

    public dr_Lecture() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_dr__lecture, container, false);
        btn_1=(Button) v.findViewById(R.id.button1);
        btn_2=(Button) v.findViewById(R.id.button2);
        btn_3=(Button) v.findViewById(R.id.button3);
        btn_4=(Button) v.findViewById(R.id.button4);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);

        return v;
    }
 Activity_Dr_Lecture_List f=new Activity_Dr_Lecture_List();
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent intent=new Intent(getActivity(), Activity_Dr_Lecture_List.class);
                startActivity(intent);
                break;
            case R.id.button2:

                lectureListView=(ListView)v.findViewById(R.id.dr_lecturelistview);
                ArrayAdapter<String > adapter=new ArrayAdapter<String>(f,android.R.layout.simple_list_item_1,subjecto);
                lectureListView.setAdapter(adapter);
                Intent nt=new Intent(getActivity(), Activity_Dr_Lecture_List.class);
                startActivity(nt);

                break;
            case R.id.button3:

                break;
            case R.id.button4:

                break;


        }

    }
}

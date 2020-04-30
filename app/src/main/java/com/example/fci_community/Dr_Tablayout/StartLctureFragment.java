package com.example.fci_community.Dr_Tablayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fci_community.Dr_Lecture.Dr_Absence;
import com.example.fci_community.Dr_Lecture.Dr_Assinment;
import com.example.fci_community.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartLctureFragment extends Fragment {
    private TextView Absanacetxt,Assignmenttxt;
    public StartLctureFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_start_lcture, container, false);

        Absanacetxt=(TextView)v.findViewById(R.id.tex_AbsanceCode);
        Assignmenttxt=(TextView)v.findViewById(R.id.tex_Assignment);



        Absanacetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt=new Intent(getContext(), Dr_Absence.class);
                startActivity(intnt);
            }
        });
        Assignmenttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(getContext(), Dr_Assinment.class);
                startActivity(intt);
            }
        });
        return v;
    }


}

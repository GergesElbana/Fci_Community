package com.example.fci_community.Lecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fci_community.R;

public class Lecture_activity extends Fragment implements View.OnClickListener {

    Button buttonAbsence,buttonAssign;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.lecture_activity, container, false);

        buttonAbsence=(Button) v.findViewById(R.id.btn_Abs);
        buttonAssign=(Button) v.findViewById(R.id.btn_Assign);
        buttonAbsence.setOnClickListener(this);
        buttonAssign.setOnClickListener(this);


        return v;
    }






    @Override
    public void onClick(View v) {

        if(v==buttonAbsence)
        {
            Intent intent=new Intent(getActivity(),St_Absence.class);
            startActivity(intent);
        }

        else if(v==buttonAssign)
        {
            Intent intent=new Intent(getActivity(),St_Assignment.class);
            startActivity(intent);
        }

    }
}

package com.example.fci_community.Dr_Tablayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.fci_community.Dr_Lecture.Activity_Dr_Lecture_List;
import com.example.fci_community.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class dr_Lecture extends Fragment implements View.OnClickListener {
     Button btn_1,btn_2,btn_3,btn_4;
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

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent intent=new Intent(getActivity(), Activity_Dr_Lecture_List.class);
                startActivity(intent);
                break;
            case R.id.button2:

                break;
            case R.id.button3:

                break;
            case R.id.button4:

                break;


        }

    }
}

package com.example.fci_community.Dr_Tablayout;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fci_community.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListofAssignmentFragment extends Fragment {


    public ListofAssignmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_listof_assignment, container, false);;

        return v;
    }

}

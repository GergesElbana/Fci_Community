package com.example.fci_community.Dr_Tablayout;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fci_community.Firebase.StudentModuel;
import com.example.fci_community.Lecture.Lecture_activity;
import com.example.fci_community.Lecture.St_Absence;
import com.example.fci_community.R;
import com.example.fci_community.Student_Iformation;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListOfAbsanceFragment extends Fragment {

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayListAbs;
    ListView AbsenceList;
    FirebaseDatabase fireData = FirebaseDatabase.getInstance();
    DatabaseReference dataAbs = fireData.getReference("Groups");
    String array;

    public ListOfAbsanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_of_absance, container, false);

        AbsenceList = (ListView) v.findViewById(R.id.AbsenceListView);
        arrayListAbs = new ArrayList<>();
        data();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayListAbs);
        AbsenceList.setAdapter(adapter);


        return v;
    }


    public void data() {

        dataAbs.child(dr_Lecture.Nahola).child("Subjects").child(ManageLectureActivity.Dr_itemName).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

              //  s=dr_Lecture.Nahola;
                for (DataSnapshot snap: dataSnapshot.getChildren()) {

                     array = snap.getValue().toString();
                    arrayListAbs.add(array);
                    adapter.notifyDataSetChanged();
                    Log.v("nahl", array);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}
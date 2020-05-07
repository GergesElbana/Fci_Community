package com.example.fci_community.Dr_Tablayout;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fci_community.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListofAssignmentFragment extends Fragment {

    FirebaseDatabase fireData1 = FirebaseDatabase.getInstance();
   DatabaseReference dataAbssign = fireData1.getReference("Groups");
    private ListView listViewAssign;
   private ArrayAdapter<String>arrayAdapter;
   private ArrayList<String>arrayListAssign;
   private String arrayName;


    public ListofAssignmentFragment() {
        /// Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_listof_assignment, container, false);

        dataListAssign();

        listViewAssign=(ListView)v.findViewById(R.id.ListofAssiment);
        arrayListAssign=new ArrayList<>();

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayListAssign);
        listViewAssign.setAdapter(arrayAdapter);

        return v;
    }

    private void dataListAssign()
    {

        dataAbssign.child(dr_Lecture.Nahola).child("Subjects").child(ManageLectureActivity.Dr_itemName)
                .child("Assignment").child("Name").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                    arrayName = dataSnapshot.getValue().toString();
                    arrayListAssign.add(arrayName);
                    arrayAdapter.notifyDataSetChanged();
                    Log.v("naaa", arrayName);


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

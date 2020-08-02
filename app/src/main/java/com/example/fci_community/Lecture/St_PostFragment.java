package com.example.fci_community.Lecture;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fci_community.Adapters.DoctorRecyclerAdapter;
import com.example.fci_community.Firebase.PostItems;
import com.example.fci_community.R;
import com.example.fci_community.Student_Iformation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class St_PostFragment extends Fragment {

    private RecyclerView stPostRecycler;
    private List<PostItems> postList;
    private DoctorRecyclerAdapter recyclerAdapter;
    private FirebaseDatabase fdatabase;
    private DatabaseReference mReference;


    public St_PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_st__post, container, false);

        stPostRecycler=view.findViewById(R.id.st_PostRecycler);
        stPostRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
       // stPostRecycler.setHasFixedSize(true);
        fdatabase=FirebaseDatabase.getInstance();
        mReference=fdatabase.getReference("Groups");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mReference.child(Student_Iformation.te_Group).child("Subjects")
                .child(St_MangerLectureActivity.strName).child("post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList=new ArrayList<>();

                for (DataSnapshot dataSnapshot1 :dataSnapshot.getChildren())
                {
                    PostItems postItems=dataSnapshot1.getValue(PostItems.class);
                    postList.add(postItems);
                }

                recyclerAdapter=new DoctorRecyclerAdapter(getActivity(),postList);
                stPostRecycler.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

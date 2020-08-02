package com.example.fci_community.Dr_Tablayout;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fci_community.Adapters.DoctorRecyclerAdapter;
import com.example.fci_community.Firebase.PostItems;
import com.example.fci_community.R;
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
public class DoctorPostFragment extends Fragment {

    private Button buttonAddPost;
    private RecyclerView doctorPostRecycler;
    private DoctorRecyclerAdapter doctorRecyclerAdapter;
    private List<PostItems> itemsList;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    public DoctorPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_doctor_post, container, false);

        doctorPostRecycler=view.findViewById(R.id.rv_Post);
        doctorPostRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Groups");

        buttonAddPost=view.findViewById(R.id.btn_addPost);

        buttonAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doctorAddPostIntent=new Intent(getActivity(),DoctorAddPostActivity.class);
                startActivity(doctorAddPostIntent);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        databaseReference.child(dr_Lecture.Nahola).child("Subjects").
                child(ManageLectureActivity.Dr_itemName).child("post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                itemsList=new ArrayList<>();

                for (DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()) {
                    PostItems postItems = dataSnapshot1.getValue(PostItems.class);
                    itemsList.add(postItems);

               }
                doctorRecyclerAdapter=new DoctorRecyclerAdapter(getActivity(),itemsList);
                doctorPostRecycler.setAdapter(doctorRecyclerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

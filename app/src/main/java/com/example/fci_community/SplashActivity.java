package com.example.fci_community;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SplashActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

     //   SubjectModuel sbm=new SubjectModuel("java","01233","Absance","Asssinment");


     //   myRef.child("Groups").child("GroupOne").child("Students").child("Student_1").setValue(stm)//  myRef.child("Groups").child("GroupOne").child("Sbjects").setValue(sbm);
        myRef.child("Groups").child("GroupOne").child("Sbjects").child("Absance").setValue("1222");
    }
}

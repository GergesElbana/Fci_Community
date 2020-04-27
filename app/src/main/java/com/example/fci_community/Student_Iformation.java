package com.example.fci_community;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Firebase.StudentModuel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student_Iformation extends AppCompatActivity {
     private   EditText St_Name,St_mail,St_pass,St_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__iformation);
        St_Name=(EditText)findViewById(R.id.StudentName);
        St_mail=(EditText)findViewById(R.id.StudentMail);
        St_pass=(EditText)findViewById(R.id.StudentPass);
        St_id=(EditText)findViewById(R.id.StudentID);

    }





    public void StudentData(View view) {
        StudentModuel stm=new StudentModuel(St_Name.getText().toString(),St_mail.getText().toString(),
                St_pass.getText().toString(),St_id.getText().toString(),St_id.getText().toString() );
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("Groups").child("GroupOne").
                child("Students").push().setValue(stm);
    }
}

package com.example.fci_community;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Firebase.StudentModuel;
import com.example.fci_community.St_Tablayout.St_mainactivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student_Iformation extends AppCompatActivity {
    private EditText St_Name, St_mail, St_pass, St_id, St_phot;
    public static StudentModuel stm;
    public static String stName;
    RadioGroup groups;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__iformation);
        compinitial();


    }


    private void compinitial() {

        St_Name = (EditText) findViewById(R.id.StudentName);
        St_mail = (EditText) findViewById(R.id.StudentMail);
        St_pass = (EditText) findViewById(R.id.StudentPass);
        St_id = (EditText) findViewById(R.id.StudentID);
        St_id = (EditText) findViewById(R.id.StudentID);
        groups = (RadioGroup) findViewById(R.id.groups);


    }

    public void StudentData(View view) {

        stName = St_Name.getText().toString();
        String stid = St_id.getText().toString();
        String stMail = St_mail.getText().toString();
        String stPas = St_pass.getText().toString();
        if (TextUtils.isEmpty(stName) || TextUtils.isEmpty(stMail)
                || TextUtils.isEmpty(stPas) || TextUtils.isEmpty(stid)) {

            Toast.makeText(this, "Enter All Data", Toast.LENGTH_SHORT).show();
        } else {
    /* stm =new StudentModuel(stName,stMail,stPas,stid);
        myRef.child("Groups").child("GroupOne").
        child("Students").child(stid).setValue(stm);*/
    Radio();
            Intent intent = new Intent(Student_Iformation.this, St_mainactivity.class);
            startActivity(intent);
        }
    }

    private void Radio()
    {

        groups.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                stName = St_Name.getText().toString();
                String stid = St_id.getText().toString();
                String stMail = St_mail.getText().toString();
                String stPas = St_pass.getText().toString();

                if (checkedId == R.id.group_one) {
                    Toast.makeText(Student_Iformation.this, "group one", Toast.LENGTH_SHORT).show();

                    stm = new StudentModuel(stName, stMail, stPas, stid);
                    myRef.child("Groups").child("GroupOne").
                            child("Students").child(stid).setValue(stm);

                } else if (checkedId == R.id.group_two) {
                    Toast.makeText(Student_Iformation.this, "group two", Toast.LENGTH_SHORT).show();


                    stm = new StudentModuel(stName, stMail, stPas, stid);
                    myRef.child("Groups").child("GroupTwo").
                            child("StudentsTwo").child(stid).setValue(stm);
                } else if (checkedId == R.id.group_three) {
                    Toast.makeText(Student_Iformation.this, "group three", Toast.LENGTH_SHORT).show();

                    stm = new StudentModuel(stName, stMail, stPas, stid);
                    myRef.child("Groups").child("GroupThree").
                            child("StudentsThree").child(stid).setValue(stm);
                } else if (checkedId == R.id.group_four) {
                    Toast.makeText(Student_Iformation.this, "group four", Toast.LENGTH_SHORT).show();

                    stm = new StudentModuel(stName, stMail, stPas, stid);
                    myRef.child("Groups").child("GroupFour")
                            .child("StudentsFour").child(stid).setValue(stm);
                }
            }
        });

    }

}

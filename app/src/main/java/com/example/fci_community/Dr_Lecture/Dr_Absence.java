package com.example.fci_community.Dr_Lecture;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Tablayout.ManageLectureActivity;
import com.example.fci_community.Lecture.Lecture_activity;
import com.example.fci_community.R;
import com.example.fci_community.Student_Iformation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dr_Absence extends AppCompatActivity {
    public static  String lct_code;
    private EditText doctor_code;
    private String[] array_sub={"CD","IS","IT"};
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
   private DatabaseReference myRefl = database.getReference("Groups");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dr_absence);
        getSupportActionBar().hide();
        doctor_code=(EditText)findViewById(R.id.Lct_Code);

    }

    public void OpenNewLecture(View view) {
        lct_code = doctor_code.getText().toString();
        for (int i = 0; i < array_sub.length - 1; i++) {
            if (ManageLectureActivity.Dr_itemName.equals(array_sub[i])) {

                myRefl.child("GroupOne").child("Subjects").child(array_sub[i]).child("Code").setValue(lct_code);
                Toast.makeText(this, "Absance tacked", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void EndLecture(View view) {

        finish();
    }
}

package com.example.fci_community.Lecture;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Lecture.Dr_Absence;
import com.example.fci_community.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class St_Absence extends AppCompatActivity {
    private EditText st_code;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("GroupOne");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st_absence);
        getSupportActionBar().hide();
        st_code=(EditText)findViewById(R.id.student_code);

    }
    public void st_starlecture(View view) {
        String b=st_code.getText().toString();
      if (b.equals(Dr_Absence.lct_code)){

       //   StudentModuel s=new
          //  myRef.child("k").setValue(Student);
            Toast.makeText(this, "Absance tacked", Toast.LENGTH_SHORT).show();
            finish();
        } }
}

package com.example.fci_community.Lecture;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Lecture.Dr_Absence;
import com.example.fci_community.Firebase.StudentModuel;
import com.example.fci_community.R;
import com.example.fci_community.Student_Iformation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class St_Absence extends AppCompatActivity {
    private EditText st_code;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRefl = database.getReference("Groups");
    TextView bbbb;
    private String []Sub_arr={"CS","IS","IT"};
    private String gerges;
    private String firebasecode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st_absence);
        getSupportActionBar().hide();
        st_code=(EditText)findViewById(R.id.student_code);
        bbbb=(TextView) findViewById(R.id.xxxx);

       // getFirebadeCode();
    }
    public void st_starlecture(View view) {
        String b=st_code.getText().toString();
      if (b.equals(Dr_Absence.lct_code)){
          for(int i=0; i<Sub_arr.length-1;i++)
          {
              if (Lecture_activity.strName.equals(Sub_arr[i]))
              {

                  myRefl.child("GroupOne").child("Subjects").child(Sub_arr[i]).child("Absance").push().setValue(Student_Iformation.stName);
                  Toast.makeText(this, "Absance tacked", Toast.LENGTH_SHORT).show();
              }
          }
         /*   myRefl.addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                  StudentModuel g=new StudentModuel();

                  gerges=dataSnapshot.child("GroupOne").child("Students").child(g.getId()).child("name").getValue().toString();
                 bbbb.setText(gerges);*
              }

              @Override
              public void onCancelled(@NonNull DatabaseError databaseError) {

              }
          });*/


            
        } }

        private void getFirebadeCode()
        {
            myRefl.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (int i=0; i<Sub_arr.length-1;i++)
                    {
                        if(Lecture_activity.strName.equals(Sub_arr[i]))
                        {
                            firebasecode=dataSnapshot.child("GroupOne").child("Subjects").child(Sub_arr[i]).child("code").getValue().toString();
                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
}

package com.example.fci_community.Lecture;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Lecture.Dr_Assinment;
import com.example.fci_community.Firebase.AssignmentModuel;
import com.example.fci_community.R;
import com.example.fci_community.Student_Iformation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class St_Assignment extends AppCompatActivity implements View.OnClickListener {
  private TextView Qust,Ans_1,Ans_2,Ans_3,Ans_4;
  private AssignmentModuel Asm;
  private String Rans;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefl = database.getReference("Groups");
    private DatabaseReference myRef2 = database.getReference("Groups");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st_assignment);
        getSupportActionBar().hide();
        initialcomponent();
        Asm=new AssignmentModuel();
        GetQustion();
        Ans_1.setOnClickListener(this);
        Ans_2.setOnClickListener(this);
        Ans_3.setOnClickListener(this);
        Ans_4.setOnClickListener(this);
      //  Log.v("gerges",Rans);

        myRef2.child(Student_Iformation.te_Group).child("Subjects").child(St_MangerLectureActivity.strName)
                .child("Assignment").child("1").child("r_Ans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Rans=dataSnapshot.getValue().toString();
                Log.v("Na7ola",Rans);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void initialcomponent(){
        Qust=findViewById(R.id.txt_qustion);
        Ans_1=findViewById(R.id.answer_1);
        Ans_2=findViewById(R.id.answer_2);
        Ans_3=findViewById(R.id.answer_3);
        Ans_4=findViewById(R.id.answer_4);
    }



    private void GetQustion(){

        myRefl.child(Student_Iformation.te_Group).child("Subjects").child(St_MangerLectureActivity.strName)
                .child("Assignment").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snap:dataSnapshot.getChildren()) {

                    Asm = snap.getValue(AssignmentModuel.class);
                    Qust.setText(Asm.getQus());
                    Ans_1.setText(Asm.getAns_1());
                    Ans_2.setText(Asm.getAns_2());
                    Ans_3.setText(Asm.getAns_3());
                    Ans_4.setText(Asm.getAns_4());
                    //Rans=Asm.getR_Ans();



                }

             // Rans=dataSnapshot.child("1").getValue().toString();
                Log.v("Na7ola",Rans);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {



            }
        });





    }


    @Override
    public void onClick(View v) {
        String A=Ans_1.getText().toString();
        String b=Ans_2.getText().toString();
        String c=Ans_3.getText().toString();
        String d=Ans_2.getText().toString();

      if(v.getId()==R.id.answer_1){

        //  Toast.makeText(this, "gggg", Toast.LENGTH_SHORT).show();

            if (A.equals(Rans)){
                myRefl.child(Student_Iformation.te_Group).child("Subjects")
                        .child(St_MangerLectureActivity.strName).child("Assignment")
                        .child("Name").push().setValue(Student_Iformation.stName);
                Toast.makeText(this, "mmmmm", Toast.LENGTH_SHORT).show();
                finish();



            }
        }
      else  if(v.getId()==R.id.answer_2){
       //   Toast.makeText(this, "gggg", Toast.LENGTH_SHORT).show();
            if (b.equals(Rans)){
                myRefl.child(Student_Iformation.te_Group).child("Subjects")
                        .child(St_MangerLectureActivity.strName).child("Assignment")
                        .child("Name").push().setValue(Student_Iformation.stName);
                Toast.makeText(this, "mmmmm", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
     else   if(v.getId()==R.id.answer_3){

            if (c.equals(Rans)){
                myRefl.child(Student_Iformation.te_Group).child("Subjects")
                        .child(St_MangerLectureActivity.strName).child("Assignment")
                        .child("Name").push().setValue(Student_Iformation.stName);
                Toast.makeText(this, "mmmmm", Toast.LENGTH_SHORT).show();
                finish();

            }
        }
     else   if(v.getId()==R.id.answer_4){
          //  Toast.makeText(this, "gggg", Toast.LENGTH_SHORT).show();
            if (d.equals(Rans)){
                myRefl.child(Student_Iformation.te_Group).child("Subjects")
                        .child(St_MangerLectureActivity.strName).child("Assignment")
                        .child("Name").push().setValue(Student_Iformation.stName);
                Toast.makeText(this, "mmmmm", Toast.LENGTH_SHORT).show();
                finish();

            }

        }
    }
}

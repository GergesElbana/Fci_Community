package com.example.fci_community.Dr_Lecture;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Tablayout.ManageLectureActivity;
import com.example.fci_community.Dr_Tablayout.dr_Lecture;
import com.example.fci_community.Firebase.AssignmentModuel;
import com.example.fci_community.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dr_Assinment extends AppCompatActivity {
    private EditText Ans_1,Ans_2,Ans_3,Ans_4,R_Ans,Qust;
    private String ans1,ans2,ans3,ans4,qus;
    public static String Rans;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Groups");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dr_assinment);
        getSupportActionBar().hide();
        initialcomponant();
    }
    private void initialcomponant(){
        Ans_1=findViewById(R.id.et_answer1);
        Ans_2=findViewById(R.id.et_answer2);
        Ans_3=findViewById(R.id.et_answer3);
        Ans_4=findViewById(R.id.et_answer4);
        R_Ans=findViewById(R.id.et_Ranswer);
        Qust=findViewById(R.id.et_Question);
    }


    public void SendingQustion(View view) {
        ans1=Ans_1.getText().toString();
        ans2=Ans_2.getText().toString();
        ans3=Ans_3.getText().toString();
        ans4=Ans_4.getText().toString();
        Rans=R_Ans.getText().toString();
        qus=Qust.getText().toString();
        AssignmentModuel Asm=new AssignmentModuel(ans1,ans2,ans3,ans4,Rans,qus);
        myRef.child(dr_Lecture.Nahola).child("Subjects").child(ManageLectureActivity.Dr_itemName).child("Assignment").child("1").setValue(Asm);


    }
}

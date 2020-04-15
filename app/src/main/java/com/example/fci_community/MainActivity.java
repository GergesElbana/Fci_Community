package com.example.fci_community;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Tablayout.Doctor_activity;
import com.example.fci_community.Lecture.Lecture_activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
           FirebaseAuth mAuth;
  private  FirebaseAuth.AuthStateListener mAuthstatelistner;
  private  EditText edtPass,edtmail;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Fci_community");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edtmail=(EditText)findViewById(R.id.useremail);
         edtPass=(EditText)findViewById(R.id.userpass);
         getSupportActionBar().hide();
        myRef.child("students").child("1").setValue("nahla");
         mAuth= FirebaseAuth.getInstance();
         mAuthstatelistner= new FirebaseAuth.AuthStateListener() {
          @Override
          public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
             if(firebaseAuth.getCurrentUser()!=null){
                // Intent it=new Intent(MainActivity.this, Doctor_activity.class);
               //  startActivity(it);



             String s=firebaseAuth.getUid();

             if (s.equals("Bh6lSxglzkWq1emzgjJkRG2SNXs1")){

                 Intent in=new Intent(MainActivity.this, Lecture_activity.class);
                 startActivity(in);
             }
             else if(s.equals("vhbutJcCCWUY7DKqKBTPVMwteph1")){
                 Intent it=new Intent(MainActivity.this, Doctor_activity.class);
                 startActivity(it);

             }


          }}
      };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthstatelistner);
    }



    public void loginbuttonclicked(View view) {
        String mail =edtmail.getText().toString();
        String pass=edtPass.getText().toString();


        if(TextUtils.isEmpty(mail)||TextUtils.isEmpty(pass))
        {

            Toast.makeText(this, "Enter both value", Toast.LENGTH_SHORT).show();
        }
         else{
             mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if (!task.isSuccessful()){

                         Toast.makeText(MainActivity.this, "Go and Sing in", Toast.LENGTH_SHORT).show();
                     }

                 }
             });



        }





    }
}

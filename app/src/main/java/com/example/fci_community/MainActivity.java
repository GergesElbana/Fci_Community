package com.example.fci_community;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.Dr_Tablayout.Doctor_activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
           FirebaseAuth mAuth;
  private  FirebaseAuth.AuthStateListener mAuthstatelistner;
  private  EditText edtPass,edtmail;

    /**  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        Configuration configuration = getResources().getConfiguration();
        if (isSlectedLanguageRTL) {
            configuration.setLayoutDirection(new Locale("fa"));
        } else {
            configuration.setLayoutDirection(Locale.ENGLISH);
        }
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edtmail=(EditText)findViewById(R.id.useremail);
         edtPass=(EditText)findViewById(R.id.userpass);
         getSupportActionBar().hide();

         mAuth= FirebaseAuth.getInstance();
         mAuthstatelistner= new FirebaseAuth.AuthStateListener() {
          @Override
          public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
             if(firebaseAuth.getCurrentUser()!=null){
             String s=firebaseAuth.getUid();

             if (s.equals("Bh6lSxglzkWq1emzgjJkRG2SNXs1")){

                 Intent in=new Intent(MainActivity.this, Student_Iformation.class);
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
        String mail =edtmail.getText().toString().trim();
        String pass=edtPass.getText().toString().trim();


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

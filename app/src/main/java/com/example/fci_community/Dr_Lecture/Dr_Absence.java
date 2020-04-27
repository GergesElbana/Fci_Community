package com.example.fci_community.Dr_Lecture;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.R;

public class Dr_Absence extends AppCompatActivity {
    public static  String lct_code;
    private EditText doctor_code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dr_absence);
        getSupportActionBar().hide();
        doctor_code=(EditText)findViewById(R.id.Lct_Code);

    }

    public void OpenNewLecture(View view) {
        lct_code =doctor_code.getText().toString();

    }

    public void EndLecture(View view) {

        finish();
    }
}

package com.example.fci_community.Lecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fci_community.R;

public class Lecture_activity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAbsence,buttonAssign;
    TextView txtItem;
    public static String strName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture_activity);
        getSupportActionBar().hide();

        buttonAbsence=(Button) findViewById(R.id.btn_Abs);
        buttonAssign=(Button) findViewById(R.id.btn_Assign);
        buttonAbsence.setOnClickListener(this);
        buttonAssign.setOnClickListener(this);
        txtItem=(TextView)findViewById(R.id.item_name);

        strName=getIntent().getExtras().getString("name");
        txtItem.setText(strName);

    }

    @Override
    public void onClick(View v) {

        if(v==buttonAbsence)
        {
            Intent intent=new Intent(this,St_Absence.class);
            startActivity(intent);
        }

        else if(v==buttonAssign)
        {
            Intent intent=new Intent(this,St_Assignment.class);
            startActivity(intent);
        }

    }
}

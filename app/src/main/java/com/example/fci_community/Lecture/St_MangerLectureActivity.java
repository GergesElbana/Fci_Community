package com.example.fci_community.Lecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.fci_community.Adapters.Tab_adapter;
import com.example.fci_community.R;
import com.google.android.material.tabs.TabLayout;

public class St_MangerLectureActivity extends AppCompatActivity {

    private TabLayout stLecturTL;
    private ViewPager stLectureVP;
    TextView txtItem;
    public static String strName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st__manger_lecture);

        stLecturTL=(TabLayout)findViewById(R.id.stLecture_tabLayout);
        stLectureVP= findViewById(R.id.stLecture_viewPager);
        txtItem=(TextView)findViewById(R.id.item_name);

           strName=getIntent().getExtras().getString("name");
        txtItem.setText(strName);

        setupFragment();
        getSupportActionBar().hide();
    }

    private void setupFragment()
    {
        Tab_adapter tabAdapter=new Tab_adapter(getSupportFragmentManager());
        tabAdapter.addFragment(new Lecture_activity());
        tabAdapter.addFragment(new St_PostFragment());

        stLectureVP.setAdapter(tabAdapter);
        stLecturTL.setupWithViewPager(stLectureVP);
        stLecturTL.getTabAt(0).setText("lecture");
        stLecturTL.getTabAt(1).setText("Posts");
    }
}

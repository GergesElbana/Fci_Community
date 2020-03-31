package com.example.fci_community.St_Tablayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.fci_community.Adapters.Tab_adapter;
import com.example.fci_community.R;
import com.google.android.material.tabs.TabLayout;

public class St_mainactivity extends AppCompatActivity {
ViewPager st_vp;
TabLayout st_tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_mainactivity);
       st_setViewPager();
    }
    private void st_setViewPager() {
        Tab_adapter st_adapter = new Tab_adapter(getSupportFragmentManager());

        st_adapter.addFragment(new Home_Fragment());
        st_adapter.addFragment(new Lecture_Fragment());
        st_adapter.addFragment(new Profile_Fragment());


        st_vp=(ViewPager) findViewById(R.id.st_viewpager);

        st_vp.setAdapter(st_adapter);

        st_tp=(TabLayout)findViewById(R.id.st_tablayout);

        st_tp.setupWithViewPager(st_vp);

        st_tp.getTabAt(0).setIcon(R.drawable.ic_home);
        st_tp.getTabAt(1).setIcon(R.drawable.ic_lecter);
        st_tp.getTabAt(2).setIcon(R.drawable.ic_profile);

    }
}

package com.example.fci_community.Dr_Tablayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.fci_community.Adapters.Tab_adapter;
import com.example.fci_community.R;
import com.google.android.material.tabs.TabLayout;

public class Doctor_activity extends AppCompatActivity {
 private   TabLayout dr_tp;
   private ViewPager dr_vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_activity);
        getSupportActionBar().hide();
        setViewPager();
    }
    private void setViewPager() {
        Tab_adapter adapter = new Tab_adapter(getSupportFragmentManager());
        adapter.addFragment(new dr_HomeFragment());
        adapter.addFragment(new dr_Lecture());
        adapter.addFragment(new dr_profile());
        dr_vp=(ViewPager) findViewById(R.id.viewpager);
        dr_vp.setAdapter(adapter);
        dr_tp=(TabLayout)findViewById(R.id.tablayout);
        dr_tp.setupWithViewPager(dr_vp);
        dr_tp.getTabAt(0).setIcon(R.drawable.ic_home);
        dr_tp.getTabAt(1).setIcon(R.drawable.ic_lecter);
        dr_tp.getTabAt(2).setIcon(R.drawable.ic_profile);

    }
}

package com.example.fci_community.Dr_Tablayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.fci_community.Adapters.Tab_adapter;
import com.example.fci_community.R;
import com.google.android.material.tabs.TabLayout;

public class ManageLectureActivity extends AppCompatActivity {
    private   TabLayout dr_tp;
    private ViewPager dr_vp;
   private TextView drItemName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_lecture);
        getSupportActionBar().hide();

        dr_vp=(ViewPager)findViewById(R.id.viewpager1);
        dr_tp=(TabLayout)findViewById(R.id.tablayout1);
        drItemName=(TextView)findViewById(R.id.dr_itemname);

        String Dr_itemName=getIntent().getExtras().getString("sub_name");
        drItemName.setText(Dr_itemName);

        setViewPager1();
    }
    private void setViewPager1() {
        Tab_adapter adaptera = new Tab_adapter(getSupportFragmentManager());

        adaptera.addFragment(new StartLctureFragment() );
        adaptera.addFragment(new ListOfAbsanceFragment());
        adaptera.addFragment(new ListofAssignmentFragment());




        dr_vp.setAdapter(adaptera);



        dr_tp.setupWithViewPager(dr_vp);

        dr_tp.getTabAt(0).setText("Start");
        dr_tp.getTabAt(1).setText("Absance");
        dr_tp.getTabAt(2).setText("Assignment");

    }

}

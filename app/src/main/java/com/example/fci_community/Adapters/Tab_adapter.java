package com.example.fci_community.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Tab_adapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentlist =new ArrayList<>();
    public Tab_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
    public void addFragment(Fragment fragment){

        fragmentlist.add(fragment);
    }
}

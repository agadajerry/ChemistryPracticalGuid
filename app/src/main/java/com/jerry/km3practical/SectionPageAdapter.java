package com.jerry.km3practical;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SectionPageAdapter extends FragmentPagerAdapter {

    private int numOfTab;


    public SectionPageAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTab = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
    switch(position){
        case 0:
        return new IntroFragment();
        case 1:
            return new LabRules();

        case 2:
            return new QualitativeFragment();
        case 3:
            return new MetalicFragement();

        case 4:
            return new AcidicFragment();
        case 5:
            return new QuantitativePart();

        case 6:
            return new VolumetricFragment();
        default:
                return null;
    }
    }

    @Override
    public int getCount() {
        return numOfTab;
    }

}

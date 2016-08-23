package com.example.adnan.inventoryapp;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Adnan on 8/21/2016.
 */
public class pagerAdapter extends FragmentStatePagerAdapter {
    String i[];

    public pagerAdapter(android.support.v4.app.FragmentManager fm, String tites[]) {
        super(fm);
        this.i=tites;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentProducts();
        }
        if (position == 1) {
            fragment = new DetailsFragment();
        }


        return fragment;
    }

    @Override
    public int getCount() {

        return i.length;

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return i[position];
    }
}

package com.aries.smart.module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aries.smart.R;

/**
 * Created by damon on 2018/4/19.
 */

public class SkinAvatarAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private Fragment[] fragments;
    private Context mContext;

    public SkinAvatarAdapter(FragmentManager fm, Fragment[] fragments, String[] titles , Context context) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


}

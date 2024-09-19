package com.aries.smart.module.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aries.smart.R;
import com.blankj.utilcode.util.ScreenUtils;

/**
 * Created by damon on 2018/4/19.
 */

public class LoginAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private Fragment[] fragments;
    private Context mContext;

    public LoginAdapter(FragmentManager fm, Fragment[] fragments, String[] titles , Context context) {
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

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item_bg, null);
        /*ViewGroup.LayoutParams params = new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);*/

        TextView textView=view.findViewById(R.id.tv_tab);
        textView.setText(titles[position]);
        return view;
    }
}

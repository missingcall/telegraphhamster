package com.aries.smart.module.login.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aries.smart.R;
import com.aries.smart.module.adapter.LoginAdapter;
import com.google.android.material.tabs.TabLayout;

public class LoginDialogFragment extends DialogFragment {

    private String[] titles = new String[]{"密码登录", "验证码登录"};
    private Fragment[] fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = inflater.inflate(R.layout.dialog_login, null);
        TabLayout tlLogin = view.findViewById(R.id.stl_pine);
        ViewPager vpLogin = view.findViewById(R.id.vp_wallet);

        fragments = new Fragment[titles.length];
        fragments[0] = new LoginPasswordFragment();
        fragments[1] = new LoginSmsFragment();

        LoginAdapter loginAdapter = new LoginAdapter(getChildFragmentManager(), fragments, titles,getActivity());
        vpLogin.setAdapter(loginAdapter);
        tlLogin.setupWithViewPager(vpLogin);

        return view;
    }
}

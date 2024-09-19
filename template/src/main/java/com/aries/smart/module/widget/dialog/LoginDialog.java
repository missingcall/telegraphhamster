package com.aries.smart.module.widget.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aries.smart.R;
import com.aries.smart.module.adapter.LoginAdapter;
import com.aries.smart.module.login.fragment.LoginPasswordFragment;
import com.aries.smart.module.login.fragment.LoginSmsFragment;
import com.google.android.material.tabs.TabLayout;
import com.trello.rxlifecycle3.components.support.RxAppCompatDialogFragment;

public class LoginDialog extends RxAppCompatDialogFragment {

    private String[] titles = new String[]{"密码登录", "验证码登录"};
    private Fragment[] fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = inflater.inflate(R.layout.dialog_login, container, false);

        TabLayout tlLogin = view.findViewById(R.id.tl_login);

        ViewPager vpLogin = view.findViewById(R.id.vp_login);
        fragments = new Fragment[titles.length];
        fragments[0] = new LoginPasswordFragment();
        fragments[1] = new LoginSmsFragment();

        LoginAdapter loginAdapter = new LoginAdapter(getChildFragmentManager(), fragments, titles, getActivity());
        vpLogin.setAdapter(loginAdapter);
        tlLogin.setupWithViewPager(vpLogin);



        //设置自定义tab
        for (int i = 0; i < tlLogin.getTabCount(); i++) {
            TabLayout.Tab tab = tlLogin.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(loginAdapter.getTabView(i));
            }
        }

        //设置第一页为选中状态时的tab文字颜色为白色
        View customView=tlLogin.getTabAt(0).getCustomView();
        TextView textView=customView.findViewById(R.id.tv_tab);
        textView.setTextColor(Color.WHITE);


        tlLogin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑
                View view = tab.getCustomView();
                TextView textView = view.findViewById(R.id.tv_tab);
                textView.setTextColor(Color.WHITE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑
                View view = tab.getCustomView();
                TextView textView = view.findViewById(R.id.tv_tab);
                textView.setTextColor(getResources().getColor(R.color.text_white_99));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        Window window = getDialog().getWindow();
        if (window != null) {
            // 一定要设置Background，如果不设置，window属性设置无效
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
            DisplayMetrics dm = new DisplayMetrics();
            if (getActivity() != null) {
                WindowManager windowManager = getActivity().getWindowManager();
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(dm);
                    WindowManager.LayoutParams params = window.getAttributes();
                    params.gravity = Gravity.BOTTOM;
                    // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
//                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
//                    params.height = (int) (ScreenUtils.getScreenHeight() * 0.5);
//                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    window.setAttributes(params);
                }
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}

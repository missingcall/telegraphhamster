package com.aries.smart.module.widget.dialog;

import android.content.Context;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aries.library.fast.FastManager;
import com.aries.library.fast.basis.BasisActivity;
import com.aries.library.fast.i.IFastTitleView;
import com.aries.smart.R;
import com.aries.smart.module.login.adapter.LoginAdapter;
import com.aries.smart.module.login.fragment.LoginPasswordFragment;
import com.aries.smart.module.login.fragment.LoginSmsFragment;
import com.aries.ui.util.FindViewUtil;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.material.tabs.TabLayout;

public class LoginDialog extends DialogFragment implements IFastTitleView {

    private String[] titles = new String[]{"密码登录", "验证码登录"};
    private Fragment[] fragments;
    private WindowManager.LayoutParams mLayoutParams;
    protected TitleBarView mTitleBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = inflater.inflate(R.layout.dialog_login, container, false);

        if (FastManager.getInstance().getActivityFragmentControl() != null) {
            FastManager.getInstance().getActivityFragmentControl().setContentViewBackground(view, this.getClass());
        }
        mTitleBar = FindViewUtil.getTargetView(view, TitleBarView.class);

        TabLayout tlLogin = view.findViewById(R.id.tl_login);

        //自定义TabLayout
/*        TabLayout.Tab tab = tlLogin.newTab();
        View tabView = inflater.inflate(R.layout.tab_item_bg, null);
        TextView tv = (TextView) view.findViewById(R.id.choose_icon_tab_tv);
        tv.setText(listData.get(i).getName());
        tab.setCustomView(view);
        tabLayout.addTab(tab);*/

        ViewPager vpLogin = view.findViewById(R.id.vp_login);
        fragments = new Fragment[titles.length];
        fragments[0] = new LoginPasswordFragment();
        fragments[1] = new LoginSmsFragment();

        LoginAdapter loginAdapter = new LoginAdapter(getChildFragmentManager(), fragments, titles, getActivity());
        vpLogin.setAdapter(loginAdapter);
        vpLogin.setCurrentItem(0);// 设置当前显示标签页为第一页
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

        View customView1=tlLogin.getTabAt(1).getCustomView();
        TextView textView1=customView1.findViewById(R.id.tv_tab);
        textView.setTextColor(Color.GRAY);

        tlLogin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑
                View view=tab.getCustomView();
                TextView textView=view.findViewById(R.id.tv_tab);
                textView.setTextColor(Color.WHITE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑
                View view=tab.getCustomView();
                TextView textView=view.findViewById(R.id.tv_tab);
                textView.setTextColor(Color.GRAY);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Window window = getDialog().getWindow();
        mLayoutParams = window.getAttributes();
        //高度百分比
        mLayoutParams.height = (int) (ScreenUtils.getScreenHeight() * 0.65);
        mLayoutParams.gravity = Gravity.BOTTOM;


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

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
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.height = (int) (ScreenUtils.getScreenHeight() * 0.65);
                    ;
                    window.setAttributes(params);
                }
            }
        }
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setTitleMainText(R.string.login_password);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTitleBar.setStatusBarLightMode(getActivity(), false);
        mTitleBar = null;
    }
}

package com.aries.smart.module.market;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.library.fast.util.ToastUtil;
import com.aries.smart.R;
import com.aries.ui.view.radius.RadiusTextView;
import com.aries.ui.view.title.TitleBarView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AriesHoo on 2018/8/10 12:22
 * @E-Mail: AriesHoo@126.com
 * Function: 主页演示
 * Description:
 */
public class MarketFragment extends FastTitleFragment {

    protected final static String LENOVO_PACKAGE_NAME = "com.lenovo.browser.hd";
    protected final static String GOOGLE_PACKAGE_NAME = "com.android.chrome";

    public static MarketFragment newInstance() {
        Bundle args = new Bundle();
        MarketFragment fragment = new MarketFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setTitleMainText(R.string.home);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
    }

    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        //Fragment 可见性变化回调


    }

    public boolean isAppInstall(String packageName) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
        return launchIntent != null;
    }


}

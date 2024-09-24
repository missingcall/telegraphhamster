package com.aries.smart.module.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.aries.library.fast.module.activity.FastRefreshLoadActivity;
import com.aries.smart.R;
import com.aries.ui.view.title.TitleBarView;
import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * 成就勋章页面 产品需求还没出 嵌套列表
 */
public class MedalAchievementActivity extends FastRefreshLoadActivity {

    @Override
    public int getContentLayout() {
        return R.layout.activity_medal_achievement;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mStatusManager.showSuccessLayout();
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return null;
    }

    @Override
    public void loadData(int page) {

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.medal_achievement)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }
}

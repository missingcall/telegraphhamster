package com.aries.smart.module.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;
import com.aries.smart.module.adapter.SkinAvatarAdapter;
import com.aries.smart.module.market.OrchardFragment;
import com.aries.ui.view.tab.SegmentTabLayout;
import com.aries.ui.view.tab.listener.OnTabSelectListener;
import com.aries.ui.view.title.TitleBarView;

import butterknife.BindView;

public class MyWarehouseActivity extends FastTitleActivity {

    @BindView(R.id.stl_orchard_bank)
    SegmentTabLayout mStlOrchardBank;
    @BindView(R.id.vp_orchard_bank)
    ViewPager mVpOrchardBank;
    private Fragment[] fragments;
    private String[] mTitles = {"仓鼠果园", "松果银行"};

    @Override
    public int getContentLayout() {
        return R.layout.activity_my_warehouse;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        fragments = new Fragment[mTitles.length];
        fragments[0] = OrchardFragment.getInstance();
        fragments[1] = OrchardFragment.getInstance();

        SkinAvatarAdapter skinAvatarAdapter = new SkinAvatarAdapter(getSupportFragmentManager(), fragments, mTitles, this);
        mVpOrchardBank.setAdapter(skinAvatarAdapter);

        mStlOrchardBank.setTabData(mTitles);
        mStlOrchardBank.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //改变下面fragment页面
                mVpOrchardBank.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.my_warehouse)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }
}

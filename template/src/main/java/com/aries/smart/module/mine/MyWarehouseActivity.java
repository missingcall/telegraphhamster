package com.aries.smart.module.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aries.library.fast.manager.TabLayoutManager;
import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;
import com.aries.smart.module.adapter.SkinAvatarAdapter;
import com.aries.smart.module.market.OrchardFragment;
import com.aries.ui.view.tab.SegmentTabLayout;
import com.aries.ui.view.title.TitleBarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MyWarehouseActivity extends FastTitleActivity {

    @BindView(R.id.stl_orchard_bank)
    SegmentTabLayout mStlOrchardBank;
    @BindView(R.id.vp_orchard_bank)
    ViewPager mVpOrchardBank;
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.guideline_h)
    Guideline mGuidelineH;
    @BindView(R.id.iv_top)
    ImageView mIvTop;
    @BindView(R.id.imageView2)
    ImageView mImageView2;

    private List<Fragment> listFragment = new ArrayList<>();

    @Override
    public int getContentLayout() {
        return R.layout.activity_my_warehouse;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        listFragment.clear();
        listFragment.add(WarehouseOrchardFragment.getInstance());
        listFragment.add(WarehouseOrchardFragment.getInstance());
        TabLayoutManager.getInstance().setSegmentTabData(this, mStlOrchardBank, mVpOrchardBank,
                getTitles(R.array.arrays_tab_squirrel_orchard_bank), listFragment);

        mStlOrchardBank.setCurrentTab(0);

    }

    private String[] getTitles(int array) {
        return getResources().getStringArray(array);
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

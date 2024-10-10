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
import com.aries.smart.constant.ApiConstant;
import com.aries.ui.view.tab.SegmentTabLayout;
import com.aries.ui.view.title.TitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PineConeTransferRecordsActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.stl_all_in_out)
    SegmentTabLayout mStlAllInOut;
    @BindView(R.id.vp_records)
    ViewPager mVpRecords;
    private List<Fragment> listFragment = new ArrayList<>();

    @Override
    public int getContentLayout() {
        return R.layout.activity_pine_cone_transfer_records;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        listFragment.clear();
        listFragment.add(PineConeTransferRecordsFragment.getInstance(ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_ALL));
        listFragment.add(PineConeTransferRecordsFragment.getInstance(ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_002));
        listFragment.add(PineConeTransferRecordsFragment.getInstance(ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_009));
        TabLayoutManager.getInstance().setSegmentTabData(this, mStlAllInOut, mVpRecords,
                getTitles(R.array.arrays_tab_all_in_out), listFragment);

        mStlAllInOut.setCurrentTab(0);
    }

    private String[] getTitles(int array) {
        return getResources().getStringArray(array);
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.pinecone_transfer_in_out_records)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }
}

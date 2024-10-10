package com.aries.smart.module.market;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.allen.library.SuperTextView;
import com.aries.library.fast.manager.GlideManager;
import com.aries.library.fast.manager.TabLayoutManager;
import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.App;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.adapter.QuickJumpAdapter;
import com.aries.smart.module.adapter.SkinAvatarAdapter;
import com.aries.smart.module.main.HomeFragment;
import com.aries.smart.module.mine.AccessoriesFragment;
import com.aries.smart.module.mine.PersonalImageActivity;
import com.aries.smart.module.mine.RankActivity;
import com.aries.smart.module.mine.SettingActivity;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.module.widget.WaveLoadingView;
import com.aries.smart.module.widget.dialog.CleanDialog;
import com.aries.smart.module.widget.dialog.FeedDialog;
import com.aries.smart.module.widget.dialog.HowToPlayDialog;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.aries.smart.retrofit.response.QuickJumpResponse;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.view.tab.SegmentTabLayout;
import com.aries.ui.view.tab.listener.OnTabSelectListener;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: AriesHoo on 2018/8/10 12:22
 * @E-Mail: AriesHoo@126.com
 * Function: 主页演示
 * Description:
 */
public class MarketFragment extends FastTitleFragment {


    List<QueryMarketListResponse> list = new ArrayList<>();
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.gl_vertical)
    Guideline mGlVertical;
    @BindView(R.id.pb_exp)
    ProgressBar mPbExp;
    @BindView(R.id.tv_rank)
    TextView mTvRank;
    @BindView(R.id.tv_exp)
    TextView mTvExp;
    @BindView(R.id.cl_rank)
    ConstraintLayout mClRank;
    @BindView(R.id.stv_daily)
    SuperTextView mStvDaily;
    @BindView(R.id.cl_level_ranking_daily_output)
    ConstraintLayout mClLevelRankingDailyOutput;
    @BindView(R.id.iv_top)
    ImageView mIvTop;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    @BindView(R.id.stl_orchard_bank)
    SegmentTabLayout mStlOrchardBank;
    @BindView(R.id.vp_orchard_bank)
    ViewPager mVpOrchardBank;

    private List<Fragment> listFragment = new ArrayList<>();

    public static MarketFragment newInstance() {
        Bundle args = new Bundle();
        MarketFragment fragment = new MarketFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.market)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_market;
    }

    @SuppressLint("CheckResult")
    @Override
    public void initView(Bundle savedInstanceState) {

        //获取每日可获得松果
        AuthRepository.getInstance().queryDayIncome().subscribe(queryDayIncomeResponse -> {
            if (StringUtils.equals(queryDayIncomeResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                //TODO yhd 接口数据不全
                mStvDaily.getCenterBottomTextView().setText(queryDayIncomeResponse.getData());

            }
        }, throwable -> {

        });

        //TODO yhd 获取等级数据
        AuthRepository.getInstance().getLevel().subscribe(getLevelResponse -> {
            if (StringUtils.equals(getLevelResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                //等级
                mTvRank.setText(getLevelResponse.getData().getLevel().toString());
                //进度条
                mPbExp.setProgress(getLevelResponse.getData().getTotalAmount() % 100);

            }
        }, throwable -> {

        });


        listFragment.clear();
        listFragment.add(OrchardFragment.getInstance(ApiConstant.API_HAMSTER_MARKET_TYPE_001));
        listFragment.add(OrchardFragment.getInstance(ApiConstant.API_HAMSTER_MARKET_TYPE_003));
        TabLayoutManager.getInstance().setSegmentTabData(this, mStlOrchardBank, mVpOrchardBank,
                getTitles(R.array.arrays_tab_squirrel_orchard_bank), listFragment);

    }

    private String[] getTitles(int array) {
        return getResources().getStringArray(array);
    }

    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        //Fragment 可见性变化回调


    }


    @OnClick({R.id.cl_rank, R.id.stv_daily})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.cl_rank:

                break;

            case R.id.stv_daily:

                break;
        }
    }
}

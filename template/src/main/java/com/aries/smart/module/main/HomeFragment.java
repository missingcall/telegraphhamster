package com.aries.smart.module.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.aries.library.fast.FastManager;
import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.module.mine.PersonalImageActivity;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.view.title.TitleBarView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: AriesHoo on 2018/8/10 12:22
 * @E-Mail: AriesHoo@126.com
 * Function: 主页演示
 * Description:
 */
public class HomeFragment extends FastTitleFragment {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.riv_buy_skin_bg)
    RoundImageView mRivBuySkinBg;
    @BindView(R.id.riv_avatar)
    RoundImageView mRivAvatar;
    @BindView(R.id.tv_buy_skin)
    TextView mTvBuySkin;
    @BindView(R.id.tv_nickname)
    TextView mTvNickname;
    @BindView(R.id.tv_uid)
    TextView mTvUid;
    @BindView(R.id.iv_copy_uid)
    ImageView mIvCopyUid;
    @BindView(R.id.gl_vertical)
    Guideline mGlVertical;
    @BindView(R.id.pb_exp)
    ProgressBar mPbExp;
    @BindView(R.id.tv_rank)
    TextView mTvRank;
    @BindView(R.id.tv_exp)
    TextView mTvExp;
    @BindView(R.id.cl_level_ranking_daily_output)
    ConstraintLayout mClLevelRankingDailyOutput;
    @BindView(R.id.iv_top)
    ImageView mIvTop;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.stv_assets)
    SuperTextView mStvAssets;
    @BindView(R.id.iv_hamster_development)
    ImageView mIvHamsterDevelopment;
    private TitleBarViewHelper mTitleBarViewHelper;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.home)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
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


    @OnClick({R.id.riv_buy_skin_bg, R.id.riv_avatar, R.id.tv_buy_skin})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.riv_buy_skin_bg:
            case R.id.riv_avatar:
            case R.id.tv_buy_skin:
                FastUtil.startActivity(getActivity(), PersonalImageActivity.class);

        }
    }
}

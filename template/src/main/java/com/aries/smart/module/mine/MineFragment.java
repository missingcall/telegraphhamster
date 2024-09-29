package com.aries.smart.module.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.allen.library.SuperTextView;
import com.aries.library.fast.i.IFastRefreshView;
import com.aries.library.fast.manager.LoggerManager;
import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.retrofit.FastUploadRequestBody;
import com.aries.library.fast.retrofit.FastUploadRequestListener;
import com.aries.library.fast.util.SizeUtil;
import com.aries.smart.R;
import com.aries.smart.WebViewActivity;
import com.aries.smart.module.adapter.LoginAdapter;
import com.aries.smart.module.widget.OverScrollView;
import com.aries.smart.module.widget.MarqueeFactory;
import com.aries.smart.module.widget.MarqueeView;
import com.aries.smart.module.widget.SimpleNoticeMF;
import com.aries.smart.utils.ImagePickerHelper;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.util.StatusBarUtil;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.transformer.TransitionEffect;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Author: AriesHoo on 2018/7/13 17:09
 * @E-Mail: AriesHoo@126.com
 * @Function: 我的
 * @Description:
 */
public class MineFragment extends FastTitleFragment implements IFastRefreshView {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.stv_person_info)
    SuperTextView mStvPersonInfo;
    @BindView(R.id.iv_top)
    ImageView mIvTop;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    @BindView(R.id.cl_receive_bg)
    ConstraintLayout mClReceiveBg;
    @BindView(R.id.tl_pine)
    TabLayout mTlPine;
    @BindView(R.id.vp_wallet)
    ViewPager mVpWallet;
    @BindView(R.id.mv_text)
    MarqueeView mMvText;
    @BindView(R.id.cl_wallet)
    ConstraintLayout mClWallet;
    @BindView(R.id.tv_to_be_collected)
    TextView mTvToBeCollected;
    @BindView(R.id.iv_pine)
    ImageView mIvPine;
    @BindView(R.id.tv_to_be_collected_num)
    TextView mTvToBeCollectedNum;
    @BindView(R.id.btn_receive)
    Button mBtnReceive;
    @BindView(R.id.bb)
    BGABanner mBb;
    @BindView(R.id.sv_containerMine)
    OverScrollView mSvContainerMine;
    @BindView(R.id.rLayoutMine)
    ConstraintLayout mRLayoutMine;
    @BindView(R.id.guideline_horizontal)
    Guideline mGuidelineHorizontal;
    @BindView(R.id.iv_mine_warehouse)
    ImageView mIvMineWarehouse;
    @BindView(R.id.iv_mine_invite)
    ImageView mIvMineInvite;
    @BindView(R.id.iv_mine_achievement)
    ImageView mIvMineAchievement;
    @BindView(R.id.iv_mine_setting)
    ImageView mIvMineSetting;
    @BindView(R.id.cl_setting_bg)
    ConstraintLayout mClSettingBg;
    private String[] titles = new String[]{"松果", "松子"};
    private Fragment[] fragments;


    private ImageView mIvHead;
    private boolean mIsLight;
    private SmartRefreshLayout mRefreshLayout;

    private ImagePickerHelper mImagePickerHelper;
    private TitleBarViewHelper mTitleBarViewHelper;
    private static final int REQUEST_CODE_CHOOSE = 23;

    private List<Integer> listArraysBanner = Arrays.asList(R.array.arrays_banner_all);

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Activity 可以通过给根布局添加SmartRefreshLayout实现
     * Fragment 根布局getParent 为null无法获取父容器故需传递一个被SmartRefreshLayout包裹的View
     * 如Fragment根布局为SmartRefreshLayout 此处传递null即可
     *
     * @return
     */
    @Override
    public View getContentView() {
        return mSvContainerMine;
    }

    @Override
    public void setRefreshLayout(SmartRefreshLayout refreshLayout) {
        mRefreshLayout = refreshLayout;
        int statusHeight = StatusBarUtil.getStatusBarHeight() + getResources().getDimensionPixelSize(R.dimen.dp_title_height);
        LoggerManager.i("statusHeight:" + statusHeight + ";dp:" + SizeUtil.px2dp(statusHeight));
        refreshLayout.setHeaderInsetStart(SizeUtil.px2dp(statusHeight));
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.mine)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mImagePickerHelper = new ImagePickerHelper(mContext);

        mTitleBarViewHelper = new TitleBarViewHelper(mContext)
                .setTitleBarView(mTitleBar)
                .setOverScrollView(mSvContainerMine)
                .setShowTextEnable(true)
                .setMaxHeight(0)
                .setOnScrollListener(new TitleBarViewHelper.OnScrollListener() {
                    @Override
                    public void onScrollChange(int alpha, boolean isLightMode) {
                        mIsLight = isLightMode;
                    }
                });
        LoggerManager.i("initView_getParent:" + mContentView.getParent() + ";rootView:" + mContentView.getRootView());

        final List<String> datas = Arrays.asList("松果转入/转出记录", "货币转出记录");

        MarqueeFactory<TextView, String> marqueeFactory1 = new SimpleNoticeMF(getContext());
        mMvText.setMarqueeFactory(marqueeFactory1);
        mMvText.startFlipping();
        marqueeFactory1.setOnItemClickListener((view, holder) -> ToastUtils.showShort(holder.getData()));
        marqueeFactory1.setData(datas);

        fragments = new Fragment[titles.length];
        fragments[0] = new WalletPineConesFragment();
        fragments[1] = new WalletPineNutsFragment();

        LoginAdapter loginAdapter = new LoginAdapter(getChildFragmentManager(), fragments, titles, getActivity());
        mVpWallet.setAdapter(loginAdapter);
        mTlPine.setupWithViewPager(mVpWallet);

        setBanner(0);
    }

    private void setBanner(int position) {
        List<String> images = Arrays.asList(getResources().getStringArray(listArraysBanner.get(position)));

        mBb.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, Object model, int position) {
                ImageView iv = (ImageView) itemView;
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(itemView.getContext()).load(model).fitCenter().into(iv);
            }
        });
        mBb.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                WebViewActivity.start(mContext, model.toString(), false);
            }
        });

        mBb.setData(images, null);
        mBb.setTransitionEffect(TransitionEffect.Cube);
//        mRefreshLayout.finishRefresh();
    }


    private RequestBody getUploadRequestBody(File file, FastUploadRequestListener listener) {
        if (listener == null) {
            return RequestBody.create(MultipartBody.FORM, file);
        }
        return new FastUploadRequestBody(RequestBody.create(MultipartBody.FORM, file), listener);
    }


    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        if (isVisibleToUser) {
            if (mRefreshLayout != null) {
                //不需要自动刷新
//                mRefreshLayout.autoRefresh();
            }
            if (mIsLight) {
                StatusBarUtil.setStatusBarLightMode(mContext);
            } else {
                StatusBarUtil.setStatusBarDarkMode(mContext);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mImagePickerHelper != null) {
            mImagePickerHelper.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTitleBarViewHelper != null) {
            mTitleBarViewHelper.onDestroy();
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
    }

    @OnClick({R.id.btn_receive, R.id.iv_mine_warehouse, R.id.iv_mine_invite, R.id.iv_mine_achievement, R.id.iv_mine_setting})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_receive:

                break;

            case R.id.iv_mine_warehouse:

                break;

            case R.id.iv_mine_invite:

                break;

            case R.id.iv_mine_achievement:

                break;

            case R.id.iv_mine_setting:

                break;

        }
    }
}

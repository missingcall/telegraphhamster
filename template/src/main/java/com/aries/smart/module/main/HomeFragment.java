package com.aries.smart.module.main;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.aries.library.fast.manager.GlideManager;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.App;
import com.aries.smart.R;

import com.aries.smart.module.adapter.QuickJumpAdapter;

import com.aries.smart.module.mine.RankActivity;
import com.aries.smart.module.mine.PersonalImageActivity;
import com.aries.smart.module.mine.SettingActivity;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.module.widget.WaveLoadingView;
import com.aries.smart.module.widget.dialog.CleanDialog;
import com.aries.smart.module.widget.dialog.FeedDialog;
import com.aries.smart.module.widget.dialog.HowToPlayDialog;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.response.QuickJumpResponse;
import com.aries.smart.utils.TitleBarViewHelper;
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
public class HomeFragment extends FastTitleRefreshLoadFragment<QuickJumpResponse> {

    List<QuickJumpResponse> list = new ArrayList<>();

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
    @BindView(R.id.iv_hamster_development_bg)
    ImageView mIvHamsterDevelopmentBg;
    @BindView(R.id.iv_hamster_development)
    ImageView mIvHamsterDevelopment;
    @BindView(R.id.wlv_clean)
    WaveLoadingView mWlvClean;
    @BindView(R.id.wlv_food)
    WaveLoadingView mWlvFood;
    @BindView(R.id.iv_cleanliness)
    ImageView mIvCleanliness;
    @BindView(R.id.iv_satiety)
    ImageView mIvSatiety;
    @BindView(R.id.stv_daily)
    SuperTextView mStvDaily;
    @BindView(R.id.cl_rank)
    ConstraintLayout mClRank;
    @BindView(R.id.iv_quest)
    ImageView mIvQuest;
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

    @SuppressLint("CheckResult")
    @Override
    public void initView(Bundle savedInstanceState) {

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        mRecyclerView.setLayoutManager(layoutManager);


        //获取info
        AuthRepository.getInstance().info().subscribe(infoResponse -> {
            if (StringUtils.equals(infoResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //头像
                GlideManager.loadCircleImg(infoResponse.getData().getProfilePath(), mRivAvatar);
                //昵称
                mTvNickname.setText(infoResponse.getData().getNickname());
                //uid
                mTvUid.setText(infoResponse.getData().getDisplayId());

            }
        }, throwable -> {
            ToastUtils.showShort("获取用户信息失败 : " + throwable);
            LogUtils.d(throwable);
        });

        //获取每日可获得松果
        AuthRepository.getInstance().queryDayIncome().subscribe(queryDayIncomeResponse -> {
            if (StringUtils.equals(queryDayIncomeResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //TODO yhd 接口数据不全
                mStvDaily.getCenterBottomTextView().setText(queryDayIncomeResponse.getData());

            }
        }, throwable -> {

        });

        //TODO yhd 获取等级数据
        AuthRepository.getInstance().getLevel().subscribe(getLevelResponse -> {
            if (StringUtils.equals(getLevelResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //等级
                mTvRank.setText(getLevelResponse.getData().getLevel().toString());
                //进度条
                mPbExp.setProgress(getLevelResponse.getData().getTotalAmount() % 100);

            }
        }, throwable -> {

        });


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


    @OnClick({R.id.riv_buy_skin_bg, R.id.riv_avatar,
            R.id.tv_buy_skin, R.id.iv_copy_uid,
            R.id.cl_rank, R.id.stv_daily, R.id.iv_hamster_development,
            R.id.wlv_clean, R.id.wlv_food, R.id.iv_cleanliness,
            R.id.iv_satiety, R.id.iv_quest, R.id.stv_assets})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.riv_buy_skin_bg:
            case R.id.riv_avatar:
            case R.id.tv_buy_skin:
                FastUtil.startActivity(getActivity(), PersonalImageActivity.class);
                break;

            case R.id.iv_copy_uid:
                //复制uid到剪切板
                ClipboardUtils.copyText(mTvUid.getText());
                ToastUtils.showShort("复制成功 : " + ClipboardUtils.getText());
                break;


            case R.id.cl_rank:
                //排行页面
                FastUtil.startActivity(getActivity(), RankActivity.class);
                break;


            case R.id.stv_daily:
                //跳转设置界面
                FastUtil.startActivity(getActivity(), SettingActivity.class);
                break;

            case R.id.iv_hamster_development:
                //TODO yhd 每次点击获得松果奖励

                break;

            case R.id.wlv_clean:
            case R.id.iv_cleanliness:
                CleanDialog cleanDialog = new CleanDialog(getActivity());
                cleanDialog.show();
                break;

            case R.id.wlv_food:
            case R.id.iv_satiety:
                FeedDialog feedDialog = new FeedDialog(getActivity());
                feedDialog.show();
                break;

            case R.id.iv_quest:

                break;

            case R.id.stv_assets:
                //弹出玩法说明Dialog
                HowToPlayDialog howToPlayDialog = new HowToPlayDialog(getActivity());
                howToPlayDialog.show();
                break;

        }
    }


    @SuppressLint("CheckResult")
    @Override
    public void loadData() {
        super.loadData();


        //获取钱包信息
        AuthRepository.getInstance().getMyMoneyBag().subscribe(getMyMoneyBagResponse -> {
            if (StringUtils.equals(getMyMoneyBagResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //测试数据
//                getMyMoneyBagResponse.getData().setDiamond(99999);
                App.getApp().getViewModel().setDataBean(getMyMoneyBagResponse.getData());
                mStvAssets.getCenterTextView().setText(getMyMoneyBagResponse.getData().getDiamond());

            }

        }, throwable -> {
            LogUtils.d("getMyMoneyBagResponse : " + throwable);
        });
    }

    private BaseQuickAdapter mAdapter;

    @Override
    public BaseQuickAdapter getAdapter() {
        mAdapter = new QuickJumpAdapter();
        return mAdapter;
    }

    @Override
    public void loadData(int page) {
        QuickJumpResponse achievementDisplayEntity1 = new QuickJumpResponse(true, "最佳新人1", "https://fastly.picsum.photos/id/452/200/200.jpg?hmac=f5vORXpRW2GF7jaYrCkzX3EwDowO7OXgUaVYM2NNRXY");
        QuickJumpResponse achievementDisplayEntity2 = new QuickJumpResponse(false, "最佳新人2", "https://fastly.picsum.photos/id/562/200/200.jpg?hmac=F4ylYRNFPH6rDzYo48_NUieJXXI2yaMl9ElwGeFQHZo");
        QuickJumpResponse achievementDisplayEntity3 = new QuickJumpResponse(true, "最佳新人3", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");
        QuickJumpResponse achievementDisplayEntity4 = new QuickJumpResponse(true, "最佳新人4", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");


        list.add(achievementDisplayEntity1);
        list.add(achievementDisplayEntity2);
        list.add(achievementDisplayEntity3);
        list.add(achievementDisplayEntity4);

        mAdapter.addData(list);
        mStatusManager.showSuccessLayout();

        //TODO yhd 快捷跳转
/*        RxJavaManager.getInstance().getDelayObservable(list, 2, TimeUnit.MILLISECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new FastObserver<List<WidgetEntity>>() {
                    @Override
                    public void _onNext(List<WidgetEntity> entity) {
                        FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), entity, null);
                    }
                });*/
    }
}

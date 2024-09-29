package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.allen.library.SuperTextView;
import com.aries.library.fast.manager.GlideManager;
import com.aries.library.fast.module.activity.FastRefreshLoadActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.module.adapter.AchievementDisplayAdapter;
import com.aries.smart.module.adapter.SkinAvatarAdapter;
import com.aries.smart.module.entity.AchievementDisplayEntity;
import com.aries.smart.module.widget.dialog.UpdateNicknameDialog;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.view.tab.SegmentTabLayout;
import com.aries.ui.view.tab.listener.OnTabSelectListener;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalImageActivity extends FastRefreshLoadActivity {

    List<AchievementDisplayEntity> list = new ArrayList<>();
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.stv_person_info)
    SuperTextView mStvPersonInfo;
    @BindView(R.id.stv_achievement)
    SuperTextView mStvAchievement;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    @BindView(R.id.ll_achievement)
    LinearLayout mLlAchievement;
    @BindView(R.id.tv_skin_avatar)
    TextView mTvSkinAvatar;
    @BindView(R.id.stl_skin_avatar)
    SegmentTabLayout mStlSkinAvatar;
    @BindView(R.id.ll_avatar_skin)
    LinearLayout mLlAvatarSkin;
    @BindView(R.id.vp_skin_avatar)
    ViewPager mVpContentFastLib;


    private TitleBarViewHelper mTitleBarViewHelper;

    private String[] mTitles = {"皮肤", "头像"};
    private Fragment[] fragments;


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.personal_image)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_personal_image;
    }

    @SuppressLint("CheckResult")
    @Override
    public void initView(Bundle savedInstanceState) {

        //点击修改头像(预留功能)
        mStvPersonInfo.getLeftIconIV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //修改昵称
        mStvPersonInfo.getLeftTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拉起修改昵称Dialog
                UpdateNicknameDialog updateNicknameDialog = new UpdateNicknameDialog(PersonalImageActivity.this, R.style.tran_dialog);
                updateNicknameDialog.show();


/*                UpdateNicknameTo updateNicknameTo = new UpdateNicknameTo();
                updateNicknameTo.setNickname();
                AuthRepository.getInstance().updateNickname(updateNicknameTo).subscribe(updateNicknameResponse -> {
                    if (StringUtils.equals(updateNicknameResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                        //修改成功

                    }
                }, throwable -> {
                    ToastUtils.showShort("获取用户信息失败");
                });*/
            }
        });


        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(layoutManager);

        mTitleBarViewHelper = new TitleBarViewHelper(mContext)
                .setTitleBarView(mTitleBar)
                .setRecyclerView(mRecyclerView)
                .setMinHeight(0);

        fragments = new Fragment[mTitles.length];
        fragments[0] = AccessoriesFragment.getInstance("001");
        fragments[1] = AccessoriesFragment.getInstance("002");

        //这里两句居然把状态栏文字颜色给改了 我惊了! 并且怎么改都改不回来 (查了半天原来是因为新建Fragment的时候重新执行了setTitleBar 要重写才能好
        SkinAvatarAdapter skinAvatarAdapter = new SkinAvatarAdapter(getSupportFragmentManager(), fragments, mTitles, this);
        mVpContentFastLib.setAdapter(skinAvatarAdapter);


        mStlSkinAvatar.setTabData(mTitles);
        mStlSkinAvatar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //切换文字 , 改变下面fragment页面
                if (position == 0) {
                    mTvSkinAvatar.setText(R.string.skin);

                } else {
                    mTvSkinAvatar.setText(R.string.avatar);

                }
                mVpContentFastLib.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        //请求头像,昵称
        AuthRepository.getInstance().info().subscribe(infoResponse -> {
            if (StringUtils.equals(infoResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //头像
                GlideManager.loadCircleImg(infoResponse.getData().getProfilePath(), mStvPersonInfo.getLeftIconIV());
                //昵称
                mStvPersonInfo.getLeftTextView().setText(infoResponse.getData().getNickname());


            }
        }, throwable -> {
            ToastUtils.showShort("获取用户信息失败 : " + throwable);
            LogUtils.d(throwable);
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTitleBarViewHelper != null) {
            mTitleBarViewHelper.onDestroy();
        }
    }


    @Override
    public boolean isLoadMoreEnable() {
        return false;
    }

    @Override
    public boolean isRefreshEnable() {
        return false;
    }


    private BaseQuickAdapter mAdapter;

    @Override
    public BaseQuickAdapter getAdapter() {
        mAdapter = new AchievementDisplayAdapter();
        return mAdapter;
    }

    @Override
    public void loadData(int page) {
        AchievementDisplayEntity achievementDisplayEntity1 = new AchievementDisplayEntity(true, "最佳新人1", "https://fastly.picsum.photos/id/452/200/200.jpg?hmac=f5vORXpRW2GF7jaYrCkzX3EwDowO7OXgUaVYM2NNRXY");
        AchievementDisplayEntity achievementDisplayEntity2 = new AchievementDisplayEntity(false, "最佳新人2", "https://fastly.picsum.photos/id/562/200/200.jpg?hmac=F4ylYRNFPH6rDzYo48_NUieJXXI2yaMl9ElwGeFQHZo");
        AchievementDisplayEntity achievementDisplayEntity3 = new AchievementDisplayEntity(true, "最佳新人3", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");
        AchievementDisplayEntity achievementDisplayEntity4 = new AchievementDisplayEntity(true, "最佳新人3", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");


        list.add(achievementDisplayEntity1);
        list.add(achievementDisplayEntity2);
        list.add(achievementDisplayEntity3);
        list.add(achievementDisplayEntity4);

        mAdapter.addData(list);
        mStatusManager.showSuccessLayout();

        //TODO yhd (成就接口待替换 要重新写一下list 最多加4个)请求成就接口
/*        RxJavaManager.getInstance().getDelayObservable(list, 2, TimeUnit.MILLISECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new FastObserver<List<WidgetEntity>>() {
                    @Override
                    public void _onNext(List<WidgetEntity> entity) {
                        FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), entity, null);
                    }
                });*/
    }

    @OnClick({R.id.stv_achievement})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.stv_achievement:
                FastUtil.startActivity(this, MedalAchievementActivity.class);
                break;
        }
    }
}

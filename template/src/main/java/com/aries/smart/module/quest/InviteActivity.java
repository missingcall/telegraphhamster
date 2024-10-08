package com.aries.smart.module.quest;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.aries.library.fast.module.activity.FastRefreshLoadActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.module.adapter.InvitedFriendsAdapter;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class InviteActivity extends FastRefreshLoadActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_invite_friends)
    TextView mTvInviteFriends;
    @BindView(R.id.tv_invite_friends_detail)
    TextView mTvInviteFriendsDetail;
    @BindView(R.id.iv_icon)
    ImageView mIvIcon;
    @BindView(R.id.tv_friend_reward)
    TextView mTvFriendReward;
    @BindView(R.id.tv_friend_reward_detail)
    TextView mTvFriendRewardDetail;
    @BindView(R.id.cl_friend_reward)
    ConstraintLayout mClFriendReward;
    @BindView(R.id.cl_my_reward_code)
    ConstraintLayout mClMyRewardCode;
    @BindView(R.id.tv_friends_i_invited)
    TextView mTvFriendsIInvited;
    @BindView(R.id.iv_refresh)
    ImageView mIvRefresh;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    @BindView(R.id.btn_invitation_poster)
    Button mBtnInvitationPoster;
    @BindView(R.id.btn_copy)
    ImageButton mBtnCopy;

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.invite_friends)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_invite;
    }

    @SuppressLint("CheckResult")
    @Override
    public void initView(Bundle savedInstanceState) {
        mTitleBarViewHelper = new TitleBarViewHelper(mContext)
                .setTitleBarView(mTitleBar)
                .setRecyclerView(mRecyclerView)
                .setMinHeight(0);

        //TODO yhd 替换空布局 不生效 暂时不研究了
        /*View emptyView = View.inflate(mContext, R.layout.view_empty_invite_firends, null);
        mFastRefreshLoadDelegate.setStatusManager(emptyView);*/
    }

    private BaseQuickAdapter mAdapter;

    @Override
    public BaseQuickAdapter getAdapter() {
        mAdapter = new InvitedFriendsAdapter();
        return mAdapter;
    }

    @Override
    public void loadData(int page) {
        mStatusManager.showSuccessLayout();
    }


    private TitleBarViewHelper mTitleBarViewHelper;

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

    @OnClick({R.id.iv_refresh, R.id.btn_invitation_poster, R.id.btn_copy})

    void onBindClick(View view) {
        switch (view.getId()) {

            case R.id.iv_refresh:
                //点击设置rv下拉刷新
                mRefreshLayout.autoRefresh();
                break;

            case R.id.btn_invitation_poster:
                //进入海报页面
                FastUtil.startActivity(this,InvitationPosterActivity.class);
                break;

            case R.id.btn_copy:
                //TODO yhd 生成邀请链接
                ClipboardUtils.copyText(mTvFriendRewardDetail.getText());
                ToastUtils.showShort("复制成功 : " + ClipboardUtils.getText());
                break;
        }
    }
}
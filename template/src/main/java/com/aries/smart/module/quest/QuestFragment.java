package com.aries.smart.module.quest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.module.adapter.DailyTaskInfoAdapter;
import com.aries.smart.module.widget.OverScrollView;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.response.SelectTaskInfoListResponse;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Function: 任务
 * @Description:
 */
public class QuestFragment extends FastTitleRefreshLoadFragment<SelectTaskInfoListResponse.DataBean.NoviceTaskInfoListBean> {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.iv_quest_bg)
    ImageView mIvQuestBg;
    @BindView(R.id.tv_quest_more)
    TextView mTvQuestMore;
    @BindView(R.id.tv_quest_daily_quest)
    TextView mTvQuestDailyQuest;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.tv_invite_friends)
    TextView mTvInviteFriends;
    @BindView(R.id.btn_invite)
    Button mBtnInvite;
    @BindView(R.id.iv_invite_friends)
    ImageView mIvInviteFriends;
    @BindView(R.id.tv_invite_friends_detail_2)
    TextView mTvInviteFriendsDetail2;
    @BindView(R.id.tv_total_pine_awarded)
    TextView mTvTotalPineAwarded;
    @BindView(R.id.tv_total_pine_awarded_num)
    TextView mTvTotalPineAwardedNum;
    @BindView(R.id.cl_total_pine_awarded)
    ConstraintLayout mClTotalPineAwarded;
    @BindView(R.id.tv_total_invited_people)
    TextView mTvTotalInvitedPeople;
    @BindView(R.id.tv_total_invited_people_num)
    TextView mTvTotalInvitedPeopleNum;
    @BindView(R.id.cl_total_invited_people)
    ConstraintLayout mClTotalInvitedPeople;
    @BindView(R.id.cl_invite_friend)
    ConstraintLayout mClInviteFriend;
    @BindView(R.id.sv_containerMine)
    OverScrollView mSvContainerMine;
    @BindView(R.id.rLayoutMine)
    ConstraintLayout mRLayoutMine;
    private BaseQuickAdapter mAdapter;

    public static QuestFragment newInstance() {
        Bundle args = new Bundle();
        QuestFragment fragment = new QuestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_quset;
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.quest)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

    }

    private TitleBarViewHelper mTitleBarViewHelper;

    @Override
    public void initView(Bundle savedInstanceState) {

        mStatusManager.showSuccessLayout();
    }

    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        //Fragment 可见性变化回调
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        mAdapter = new DailyTaskInfoAdapter();
        return mAdapter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(int page) {
        AuthRepository.getInstance().selectTaskInfoList().subscribe(selectTaskInfoListResponse -> {
            if (StringUtils.equals(selectTaskInfoListResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //TODO yhd 后台返回的日常任务里有数据 先用来展示 后面再换成日常任务
                mAdapter.setList(selectTaskInfoListResponse.getData().getNoviceTaskInfoList());

//                mAdapter.setList(selectTaskInfoListResponse.getData().getDailyTaskInfoList());

            }
        }, throwable -> {

        });
    }

    @OnClick({R.id.btn_invite})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_invite:
                FastUtil.startActivity(getContext(), InviteActivity.class);
                break;
        }
    }
}

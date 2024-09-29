package com.aries.smart.module.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;
import com.aries.smart.retrofit.response.SelectTaskInfoListResponse;
import com.aries.smart.constant.Constants;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import butterknife.OnClick;

/**
 * @Author: AriesHoo on 2018/8/10 9:51
 * @E-Mail: AriesHoo@126.com
 * Function: 描述性条目适配器
 * Description:
 */
//TODO 需要替换bean为daily
public class DailyTaskInfoAdapter extends BaseQuickAdapter<SelectTaskInfoListResponse.DataBean.NoviceTaskInfoListBean, BaseViewHolder> {

    ImageView mIvIcon;
    TextView mTvQuest;
    TextView mTvQuestProgress;
    TextView mTvQuestDetails;
    ImageView mIvReward;
    TextView mTvRewardNum;
    Button mBtnFinish;
    ConstraintLayout mClQuickJumpItem;

    public DailyTaskInfoAdapter() {
        super(R.layout.item_daily_task_info);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, SelectTaskInfoListResponse.DataBean.NoviceTaskInfoListBean dailyTaskInfoListBean) {

        mIvIcon = baseViewHolder.findView(R.id.iv_icon);
        mTvQuest = baseViewHolder.findView(R.id.tv_quest);
        mTvQuestProgress = baseViewHolder.findView(R.id.tv_quest_progress);
        mTvQuestDetails = baseViewHolder.findView(R.id.tv_quest_details);
        mIvReward = baseViewHolder.findView(R.id.iv_reward);
        mTvRewardNum = baseViewHolder.findView(R.id.tv_reward_num);
        mBtnFinish = baseViewHolder.findView(R.id.btn_finish);
        mClQuickJumpItem = baseViewHolder.findView(R.id.cl_quick_jump_item);

        //TODO yhd 任务后端还在改
        GlideManager.loadImg(dailyTaskInfoListBean.getTaskIcon(), mIvIcon);
        mTvQuest.setText(dailyTaskInfoListBean.getTaskName());


        if (StringUtils.equals(dailyTaskInfoListBean.getFinishStatus(), Constants.TASK_NOT_FINISH)) {
            mBtnFinish.setEnabled(true);
            mBtnFinish.setBackgroundResource(R.drawable.selector_btn_blue_gray_radius);
            mBtnFinish.setText(R.string.go_finish);
        } else if (StringUtils.equals(dailyTaskInfoListBean.getFinishStatus(), Constants.TASK_WAIT_TO_REWARD)) {
            mBtnFinish.setEnabled(true);
            mBtnFinish.setBackgroundResource(R.drawable.btn_wait_to_reward_bg);
            mBtnFinish.setText(R.string.wait_to_reward);
        } else if (StringUtils.equals(dailyTaskInfoListBean.getFinishStatus(), Constants.TASK_FINISH)) {
            mBtnFinish.setEnabled(false);
            mBtnFinish.setBackgroundResource(R.drawable.selector_btn_blue_deep_radius);
            mBtnFinish.setText(R.string.finished);
        }


    }

    @OnClick({R.id.btn_finish})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_finish:

                break;
        }
    }
}

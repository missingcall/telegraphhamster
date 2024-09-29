package com.aries.smart.module.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;
import com.aries.smart.module.entity.AchievementDisplayEntity;
import com.aries.smart.utils.BaseItemTouchViewHolder;

import java.util.ArrayList;

/**
 * @Author: AriesHoo on 2018/8/10 9:51
 * @E-Mail: AriesHoo@126.com
 * Function: 描述性条目适配器
 * Description:
 */
public class InvitedFriendsAdapter extends BaseItemTouchQuickAdapter<AchievementDisplayEntity, BaseItemTouchViewHolder> {

    public InvitedFriendsAdapter() {
        super(R.layout.item_invited_firends, new ArrayList<>());
    }

    @Override
    protected void convert(BaseItemTouchViewHolder helper, AchievementDisplayEntity item) {

        ImageView iv_icon = helper.getView(R.id.iv_icon);
        GlideManager.loadImg(item.getPicUrl(), iv_icon);
        TextView tv_name = helper.getView(R.id.tv_name);
        tv_name.setText(item.getName());
        ImageView iv_reward = helper.getView(R.id.iv_reward);
        GlideManager.loadImg(item.getPicUrl(), iv_icon);
        TextView tv_reward_num = helper.getView(R.id.tv_reward_num);
        tv_reward_num.setText(item.getName());

    }

}

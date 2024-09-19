package com.aries.smart.module.adapter;

import android.view.View;
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
public class AchievementDisplayAdapter extends BaseItemTouchQuickAdapter<AchievementDisplayEntity, BaseItemTouchViewHolder> {

    public AchievementDisplayAdapter() {
        super(R.layout.item_achievement_display, new ArrayList<>());
    }

    @Override
    protected void convert(BaseItemTouchViewHolder helper, AchievementDisplayEntity item) {

        ImageView iv_jewel = helper.getView(R.id.iv_achievement_item_jewel);
        GlideManager.loadImg(item.getPicUrl(), iv_jewel);
        TextView tv_name = helper.getView(R.id.tv_achievement_item_name);
        tv_name.setText(item.getName());
        ImageView iv_new = helper.getView(R.id.iv_achievement_item_new);
        if (item.isNew()) {
            iv_new.setVisibility(View.VISIBLE);
        } else {
            iv_new.setVisibility(View.INVISIBLE);
        }

    }

}

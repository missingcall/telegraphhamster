package com.aries.smart.module.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;
import com.aries.smart.module.entity.AchievementDisplayEntity;
import com.aries.smart.module.widget.NiceImageView;
import com.aries.smart.retrofit.response.GameCenterResponse;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

/**
 * @Author: AriesHoo on 2018/8/10 9:51
 * @E-Mail: AriesHoo@126.com
 * Function: 描述性条目适配器
 * Description:
 */
public class GameCenterAdapter extends BaseQuickAdapter<GameCenterResponse, BaseViewHolder> {

    public GameCenterAdapter() {
        super(R.layout.item_game_center, new ArrayList<>());
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, GameCenterResponse gameCenterResponse) {
        //点击跳转对应的游戏
        baseViewHolder.getView(R.id.cl_game_center_item).setOnClickListener(view -> ToastUtils.showShort("点击" + gameCenterResponse.name));
        ImageView iv_game_icon = baseViewHolder.getView(R.id.iv_game_icon);
        GlideManager.loadImg(gameCenterResponse.getPicUrl(), iv_game_icon);
        TextView tv_game_center_item_name = baseViewHolder.getView(R.id.tv_game_center_item_name);
        tv_game_center_item_name.setText(gameCenterResponse.getName());

        //蒙版
        NiceImageView niv_mask = baseViewHolder.getView(R.id.niv_mask);
        niv_mask.setVisibility(View.VISIBLE);

        //敬请期待
        TextView tv_coming_soon = baseViewHolder.getView(R.id.tv_coming_soon);

        //是否有新上标
        ImageView iv_game_new = baseViewHolder.getView(R.id.iv_game_new);

    }
}

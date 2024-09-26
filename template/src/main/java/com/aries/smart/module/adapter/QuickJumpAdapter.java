package com.aries.smart.module.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;

import com.aries.smart.retrofit.response.QuickJumpResponse;
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
public class QuickJumpAdapter extends BaseQuickAdapter<QuickJumpResponse, BaseViewHolder> {

    public QuickJumpAdapter() {
        super(R.layout.item_quick_jump, new ArrayList<>());
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, QuickJumpResponse achievementDisplayEntity) {
        //点击跳转对应的游戏
        baseViewHolder.getView(R.id.cl_quick_jump_item).setOnClickListener(view -> ToastUtils.showShort("点击" + achievementDisplayEntity.name));
        ImageView iv_jewel = baseViewHolder.getView(R.id.iv_icon);
        GlideManager.loadImg(achievementDisplayEntity.getPicUrl(), iv_jewel);
        TextView tv_name = baseViewHolder.getView(R.id.tv_name);
        tv_name.setText(achievementDisplayEntity.getName());

    }
}

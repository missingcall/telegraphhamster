package com.aries.smart.module.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;
import com.aries.smart.module.entity.AccessoriesInfoListResponse;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

/**
 * @Author: AriesHoo on 2018/8/10 9:51
 * @E-Mail: AriesHoo@126.com
 * Function: 描述性条目适配器
 * Description:
 */
public class AccessoriesRecordsAdapter extends BaseQuickAdapter<AccessoriesInfoListResponse.DataBean.RecordsBean, BaseViewHolder> {

    public AccessoriesRecordsAdapter() {
        super(R.layout.item_skin_display, new ArrayList<>());
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, AccessoriesInfoListResponse.DataBean.RecordsBean recordsResponse) {
        baseViewHolder.setText(R.id.tv_name, recordsResponse.getName());
        GlideManager.loadImg(recordsResponse.getIcon(), baseViewHolder.getView(R.id.iv_skin));
        ImageView iv_lock = baseViewHolder.getView(R.id.iv_lock);
        iv_lock.setVisibility(recordsResponse.isUnlockStatus() ? View.VISIBLE : View.GONE);
        
    }
}

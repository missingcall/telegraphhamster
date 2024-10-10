package com.aries.smart.module.adapter;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;
import com.aries.smart.module.widget.NiceImageView;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author: AriesHoo on 2018/8/10 9:51
 * @E-Mail: AriesHoo@126.com
 * Function: 描述性条目适配器
 * Description:
 */
public class PineConeTransferRecordsAdapter extends BaseQuickAdapter<QueryMarketListResponse.DataBean, BaseViewHolder> {


    @BindView(R.id.tv_flow_kind_coin_type)
    TextView mTvFlowKindCoinType;
    @BindView(R.id.tv_coin_number)
    TextView mTvCoinNumber;
    @BindView(R.id.tv_flow_kind_coin_type_message)
    TextView mTvFlowKindCoinTypeMessage;
    @BindView(R.id.tv_time_operation)
    TextView mTvTimeOperation;
    @BindView(R.id.tv_warehouse_balance)
    TextView mTvWarehouseBalance;

    public PineConeTransferRecordsAdapter(View view) {
        super(R.layout.item_pine_cone_transfer_records);

    }

    @NonNull
    @Override
    protected BaseViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder = super.onCreateDefViewHolder(parent, viewType);
        ButterKnife.bind(this, baseViewHolder.itemView);
        return baseViewHolder;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, QueryMarketListResponse.DataBean dataBean) {


    }
}

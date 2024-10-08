package com.aries.smart.module.adapter;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.widget.NiceImageView;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.module.widget.dialog.BuyHamstersDialog;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
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
public class WarehouseOrchardAdapter extends BaseQuickAdapter<QueryMarketListResponse.DataBean, BaseViewHolder> {


    @BindView(R.id.riv_commodity_icon)
    RoundImageView mRivCommodityIcon;
    @BindView(R.id.tv_commodity_name)
    TextView mTvCommodityName;
    @BindView(R.id.tv_day_income)
    TextView mTvDayIncome;
    @BindView(R.id.tv_total_revenue)
    TextView mTvTotalRevenue;
    @BindView(R.id.tv_total_revenue_num)
    TextView mTvTotalRevenueNum;
    @BindView(R.id.gl_horizontal)
    Guideline mGlHorizontal;
    @BindView(R.id.tv_time_limit)
    TextView mTvTimeLimit;
    @BindView(R.id.tv_coin_price)
    TextView mTvCoinPrice;
    @BindView(R.id.ll_coin_price)
    LinearLayout mLlCoinPrice;
    @BindView(R.id.riv_bg_mask)
    NiceImageView mRivBgMask;
    @BindView(R.id.tv_sold_out)
    TextView mTvSoldOut;
    @BindView(R.id.cl_quick_jump_item)
    ConstraintLayout mClQuickJumpItem;

    public WarehouseOrchardAdapter(View view) {
        super(R.layout.item_warehouse_orchard);

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
        GlideManager.loadImg(dataBean.getCommodityIcon(), mRivCommodityIcon);
        baseViewHolder.setText(R.id.tv_commodity_name, dataBean.getCommodityName())
                .setText(R.id.tv_time_limit, "剩余天数: " + dataBean.getTimeLimit() + "天")
                .setText(R.id.tv_total_revenue_num , "+" + dataBean.getTotalIncome())
        ;

        String sStart = "每天可以产出\n";
        String sEnd = "松果";
        SpannableString spannableString = new SpannableString(sStart + dataBean.getDayIncome() + sEnd);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FDC120")), sStart.length(), spannableString.length() - sEnd.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTvDayIncome.setText(spannableString);

    }
}

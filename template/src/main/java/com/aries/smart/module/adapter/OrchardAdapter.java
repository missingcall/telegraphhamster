package com.aries.smart.module.adapter;

import android.graphics.Color;
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
public class OrchardAdapter extends BaseQuickAdapter<QueryMarketListResponse.DataBean, BaseViewHolder> {


    @BindView(R.id.riv_commodity_icon)
    RoundImageView mRivCommodityIcon;
    @BindView(R.id.iv_commodity_icon_activation)
    TextView mIvCommodityIconActivation;
    @BindView(R.id.riv_commodity_icon_mask)
    NiceImageView mRivCommodityIconMask;
    @BindView(R.id.iv_lock)
    ImageView mIvLock;
    @BindView(R.id.iv_starter_icon)
    ImageView mIvStarterIcon;
    @BindView(R.id.tv_commodity_name)
    TextView mTvCommodityName;
    @BindView(R.id.tv_day_income)
    TextView mTvDayIncome;
    @BindView(R.id.iv_pine_cones)
    ImageView mIvPineCones;
    @BindView(R.id.tv_day_income_num)
    TextView mTvDayIncomeNum;
    @BindView(R.id.gl_horizontal)
    Guideline mGlHorizontal;
    @BindView(R.id.gl_vertical)
    Guideline mGlVertical;
    @BindView(R.id.tv_time_limit)
    TextView mTvTimeLimit;
    @BindView(R.id.iv_pay_type)
    ImageView mIvPayType;
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

    public OrchardAdapter(View view) {
        super(R.layout.item_orchard);

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
                .setText(R.id.tv_day_income_num, dataBean.getDayIncome() + "")
                .setText(R.id.tv_time_limit, dataBean.getTimeLimit() + "天");
        //TODO CommodityMark字段不明确 首发的icon需要修改
        if (StringUtils.equals(dataBean.getCommodityMark(), "first")) {
            mIvStarterIcon.setVisibility(View.VISIBLE);
        } else {
            mIvStarterIcon.setVisibility(View.GONE);
        }

        switch (dataBean.getPayType()) {
            //001 松果支付
            case ApiConstant.API_HAMSTER_MARKET_PAY_TYPE_001:
                GlideManager.loadImg(R.drawable.unlock_pinecone, mIvPayType);
                break;

            //002 松子支付
            case ApiConstant.API_HAMSTER_MARKET_PAY_TYPE_002:
                GlideManager.loadImg(R.drawable.unlock_pine_nuts, mIvPayType);
                break;

            //  003 第三方支付
            case ApiConstant.API_HAMSTER_MARKET_PAY_TYPE_003:
                GlideManager.loadImg(R.drawable.pay_type_cash, mIvPayType);
                break;
        }


        //设置点击事件
        switch (dataBean.getGoodsStatue()) {
            //001 商品可购买
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_001:
                mTvSoldOut.setVisibility(View.GONE);
                mRivBgMask.setVisibility(View.GONE);
                mRivCommodityIconMask.setVisibility(View.GONE);
                mIvLock.setVisibility(View.GONE);
                mIvCommodityIconActivation.setVisibility(View.GONE);
                baseViewHolder.setText(R.id.tv_coin_price, dataBean.getCoinPrice() + "");
                mTvCoinPrice.setTextColor(Color.parseColor("#FFFFFF"));
                break;

            //002 商品已售磬
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_002:
                mTvSoldOut.setVisibility(View.VISIBLE);
                mRivBgMask.setVisibility(View.VISIBLE);
                mRivCommodityIconMask.setVisibility(View.GONE);
                mIvLock.setVisibility(View.GONE);
                mIvCommodityIconActivation.setVisibility(View.GONE);
                baseViewHolder.setText(R.id.tv_coin_price, dataBean.getCoinPrice() + "");
                mTvCoinPrice.setTextColor(Color.parseColor("#FFFFFF"));
                break;

            // 003 用户未解锁
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_003:
                mTvSoldOut.setVisibility(View.GONE);
                mRivBgMask.setVisibility(View.GONE);
                mRivCommodityIconMask.setVisibility(View.VISIBLE);
                mIvLock.setVisibility(View.VISIBLE);
                mIvCommodityIconActivation.setVisibility(View.GONE);
                baseViewHolder.setText(R.id.tv_coin_price, dataBean.getCoinPrice() + "");
                mTvCoinPrice.setTextColor(Color.parseColor("#FFFFFF"));
                break;

            //004 用户已拥有(待激活)
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_004:
                mTvSoldOut.setVisibility(View.GONE);
                mRivBgMask.setVisibility(View.GONE);
                mRivCommodityIconMask.setVisibility(View.GONE);
                mIvLock.setVisibility(View.GONE);
                mIvCommodityIconActivation.setVisibility(View.VISIBLE);
                baseViewHolder.setText(R.id.tv_coin_price, dataBean.getCoinPrice() + "");
                mTvCoinPrice.setTextColor(Color.parseColor("#FFFFFF"));
                break;

            //005 用户已拥有(生效中)
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_005:
                mTvSoldOut.setVisibility(View.GONE);
                mRivBgMask.setVisibility(View.GONE);
                mRivCommodityIconMask.setVisibility(View.GONE);
                mIvLock.setVisibility(View.GONE);
                mIvCommodityIconActivation.setVisibility(View.GONE);
                baseViewHolder.setText(R.id.tv_coin_price, "采集中...");
                mTvCoinPrice.setTextColor(Color.parseColor("#80F68D"));
                break;
        }


    }

    @Override
    protected void setOnItemClick(@NonNull View v, int position) {
        super.setOnItemClick(v, position);

        QueryMarketListResponse.DataBean dataBean = getData().get(position);
        switch (dataBean.getGoodsStatue()) {
              //001 商品可购买
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_001:
                //004 用户已拥有(待激活)
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_004:
                //005 用户已拥有(生效中)
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_005:
                BuyHamstersDialog buyHamstersDialog = new BuyHamstersDialog(getContext(), dataBean);
                buyHamstersDialog.show();

                break;

            //002 商品已售磬
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_002:
                ToastUtils.showShort(R.string.sold_out);
                break;

            // 003 用户未解锁
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_003:
                ToastUtils.showShort(StringUtils.getString(R.string.please_activate_first) + dataBean.getPreconditionsName());
                break;


        }


    }
}

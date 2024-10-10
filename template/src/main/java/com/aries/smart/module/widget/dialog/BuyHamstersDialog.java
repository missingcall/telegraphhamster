package com.aries.smart.module.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.App;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.request.ActivationPropIdTo;
import com.aries.smart.retrofit.request.MarketBuyTo;
import com.aries.smart.retrofit.response.GetMyMoneyBagResponse;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyHamstersDialog extends CommonDialog {


    public QueryMarketListResponse.DataBean mDataBean;
    @BindView(R.id.guideline_horizontal)
    Guideline mGuidelineHorizontal;
    @BindView(R.id.guideline_vertical)
    Guideline mGuidelineVertical;
    @BindView(R.id.btn_exit)
    Button mBtnExit;
    @BindView(R.id.tv_feed)
    TextView mTvFeed;
    @BindView(R.id.riv_commodity_icon)
    RoundImageView mRivCommodityIcon;
    @BindView(R.id.tv_time_remaining)
    TextView mTvTimeRemaining;
    @BindView(R.id.iv_pine_cone_1)
    ImageView mIvPineCone1;
    @BindView(R.id.iv_pine_cone_2)
    ImageView mIvPineCone2;
    @BindView(R.id.tv_production)
    TextView mTvProduction;
    @BindView(R.id.tv_production_num)
    TextView mTvProductionNum;
    @BindView(R.id.tv_activate_new_ways)
    TextView mTvActivateNewWays;
    @BindView(R.id.tv_cultivate_the_hamster)
    TextView mTvCultivateTheHamster;
    @BindView(R.id.cl_describe)
    ConstraintLayout mClDescribe;
    @BindView(R.id.tv_available)
    TextView mTvAvailable;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;

    public BuyHamstersDialog(Context context) {
        super(context);

        initView(context);
    }

    public BuyHamstersDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public BuyHamstersDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public BuyHamstersDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    public BuyHamstersDialog(Context context, QueryMarketListResponse.DataBean dataBean) {
        super(context);
        mDataBean = dataBean;
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_buy_hamsters, null);
        setContentView(view);

        ButterKnife.bind(this);

        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mLayoutParams.gravity = Gravity.BOTTOM;

        if (mDataBean == null) {
            return;
        }

        GlideManager.loadImg(mDataBean.getCommodityIcon(), mRivCommodityIcon);
        mTvTimeRemaining.setText(mDataBean.getTimeLimit() + "天");
        mTvProductionNum.setText("每天产出" + mDataBean.getDayIncome() + "松果，松果可参与到各种玩法");

        switch (mDataBean.getGoodsStatue()) {
            //001 商品可购买
            case ApiConstant.GOODS_STATUE_TYPE_001:
                mTvAvailable.setVisibility(View.VISIBLE);

                GetMyMoneyBagResponse.DataBean dataBean = App.getApp().getWalletModel().getDataBean().getValue();
                if (dataBean == null) {
                    return;
                }
                LogUtils.d("dataBean : " + dataBean);
                String s = "我拥有的 " + dataBean.getDiamond();
                SpannableString spannableString = new SpannableString(s);
                ImageSpan imageSpan;
                switch (mDataBean.getPayType()) {
                    //松果支付
                    case ApiConstant.API_HAMSTER_MARKET_PAY_TYPE_001:
                        imageSpan = new ImageSpan(context, R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
                        spannableString.setSpan(imageSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        break;

                    //松子支付
                    case ApiConstant.API_HAMSTER_MARKET_PAY_TYPE_002:
                        imageSpan = new ImageSpan(context, R.drawable.unlock_pine_nuts, DynamicDrawableSpan.ALIGN_BOTTOM);
                        spannableString.setSpan(imageSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        break;

                    //三方支付
                    case ApiConstant.API_HAMSTER_MARKET_PAY_TYPE_003:
                        imageSpan = new ImageSpan(context, R.drawable.pay_type_cash, DynamicDrawableSpan.ALIGN_BOTTOM);
                        spannableString.setSpan(imageSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        break;
                }
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FDC120")), 5, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mTvAvailable.setText(spannableString);
                break;

/*            //002 商品已售磬
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_002:

                break;

            // 003 用户未解锁
            case ApiConstant.API_HAMSTER_MARKET_QUERYMARKETLIST_GOODSSTATUE_TYPE_003:

                break;*/

            //004 用户已拥有(待激活)
            case ApiConstant.GOODS_STATUE_TYPE_004:
                mTvAvailable.setVisibility(View.GONE);
                mBtnConfirm.setText(R.string.activate_now);
                mBtnConfirm.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void onClick(View view) {
                        //背包物品激活
                        ActivationPropIdTo activationPropIdTo = new ActivationPropIdTo();
                        activationPropIdTo.setPropId(mDataBean.getPropId());
                        AuthRepository.getInstance().activation(activationPropIdTo).subscribe(baseResponse -> {
                            if (StringUtils.equals(baseResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                                ToastUtils.showShort(R.string.activation_successful);
                            } else if(StringUtils.equals(baseResponse.getResponseCode(), ApiConstant.RESPONSE_FAILED_TO_PASS_REAL_NAME_AUTHENTICATION)){
                                //实名认证弹窗
                                RealNameDialog realNameDialog = new RealNameDialog(getContext(), R.style.tran_dialog);
                                realNameDialog.show();
                            }else {
                                ToastUtils.showShort(baseResponse.getResponseMessage());
                            }
                        }, throwable -> {

                        });
                        dismiss();
                    }
                });

                break;

            //005 用户已拥有(生效中)
            case ApiConstant.GOODS_STATUE_TYPE_005:
                mBtnConfirm.setText(R.string.collecting_in_progress);
                mBtnConfirm.setEnabled(false);
                mTvTimeRemaining.setTextColor(getContext().getResources().getColor(R.color.green_light));

                break;
        }

        String config = "确认购买 " + "123";
        SpannableString spannableStringConfig = new SpannableString(config);
        ImageSpan imageConfig = new ImageSpan(context, R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableStringConfig.setSpan(imageConfig, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mBtnConfirm.setText(spannableStringConfig);

        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                MarketBuyTo marketBuyTo = new MarketBuyTo();
                marketBuyTo.setMoney(mDataBean.getCoinPrice());
                marketBuyTo.setGoodsId(mDataBean.getCommodityInfoId());
                AuthRepository.getInstance().buy(marketBuyTo).subscribe(unlockSkinResponse -> {
                    if (StringUtils.equals(unlockSkinResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                        ToastUtils.showShort(R.string.purchase_successful);
                    } else {
                        ToastUtils.showShort(unlockSkinResponse.getResponseMessage());
                    }
                }, throwable -> {

                });
                dismiss();
            }
        });

        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //关闭弹窗
                dismiss();
            }
        });

    }

}

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
import com.aries.smart.module.widget.NumberView;
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
import butterknife.OnClick;

public class PineconePassbookDialog extends CommonDialog {


    public QueryMarketListResponse.DataBean mDataBean;
    @BindView(R.id.guideline_horizontal)
    Guideline mGuidelineHorizontal;
    @BindView(R.id.guideline_vertical)
    Guideline mGuidelineVertical;
    @BindView(R.id.btn_exit)
    Button mBtnExit;
    @BindView(R.id.tv_passbook)
    TextView mTvPassbook;
    @BindView(R.id.tv_collect_daily)
    TextView mTvCollectDaily;
    @BindView(R.id.riv_commodity_icon)
    RoundImageView mRivCommodityIcon;
    @BindView(R.id.nv_count)
    NumberView mNvCount;
    @BindView(R.id.iv_pine_cone_1)
    ImageView mIvPineCone1;
    @BindView(R.id.tv_collection_instructions)
    TextView mTvCollectionInstructions;
    @BindView(R.id.tv_collection_instructions_describe)
    TextView mTvCollectionInstructionsDescribe;
    @BindView(R.id.cl_describe)
    ConstraintLayout mClDescribe;
    @BindView(R.id.tv_available)
    TextView mTvAvailable;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    private String mConfig;

    public PineconePassbookDialog(Context context) {
        super(context);

        initView(context);
    }

    public PineconePassbookDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public PineconePassbookDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public PineconePassbookDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    public PineconePassbookDialog(Context context, QueryMarketListResponse.DataBean dataBean) {
        super(context);
        mDataBean = dataBean;
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_pinecone_passbook, null);
        setContentView(view);

        ButterKnife.bind(this);

        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mLayoutParams.gravity = Gravity.BOTTOM;

        if (mDataBean == null) {
            return;
        }

        GlideManager.loadImg(mDataBean.getCommodityIcon(), mRivCommodityIcon);
        mTvCollectDaily.setText(getContext().getString(R.string.collect_daily) + mDataBean.getDayIncome());
        mTvCollectionInstructionsDescribe.setText("周期"
                + mDataBean.getTimeLimit() + "天，每天获得"
                + mDataBean.getDayIncome() + "，到期预计总"
                + mDataBean.getTotalIncome()
        );

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
                            } else if (StringUtils.equals(baseResponse.getResponseCode(), ApiConstant.RESPONSE_FAILED_TO_PASS_REAL_NAME_AUTHENTICATION)) {
                                //实名认证弹窗
                                RealNameDialog realNameDialog = new RealNameDialog(getContext(), R.style.tran_dialog);
                                realNameDialog.show();
                            } else {
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
                break;
        }


        mConfig = "确认购买 " + mDataBean.getCoinPrice();

        SpannableString spannableStringConfig = new SpannableString(mConfig);
        ImageSpan imageConfig = new ImageSpan(context, R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableStringConfig.setSpan(imageConfig, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mBtnConfirm.setText(spannableStringConfig);

        mNvCount.setOnValueChangeListener(new NumberView.OnValueChangeListener() {
            @Override
            public void onValueChange(int value) {
                mConfig = "确认购买 " + value * mDataBean.getCoinPrice();
                SpannableString spannableStringConfig = new SpannableString(mConfig);
                ImageSpan imageConfig = new ImageSpan(context, R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
                spannableStringConfig.setSpan(imageConfig, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mBtnConfirm.setText(spannableStringConfig);
            }
        });

        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                MarketBuyTo marketBuyTo = new MarketBuyTo();
                marketBuyTo.setMoney(mDataBean.getCoinPrice());
                marketBuyTo.setGoodsId(mDataBean.getCommodityInfoId());
                AuthRepository.getInstance().buy(marketBuyTo).subscribe(baseResponse ->  {
                    if (StringUtils.equals(baseResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                        ToastUtils.showShort(R.string.purchase_successful);
                    } else {
                        ToastUtils.showShort(baseResponse.getResponseMessage());
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

    @OnClick({R.id.btn_exit, R.id.btn_confirm})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exit:
                break;
            case R.id.btn_confirm:
                break;
        }
    }
}

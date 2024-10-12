package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.widget.MarqueeFactory;
import com.aries.smart.module.widget.MarqueeView;
import com.aries.smart.module.widget.SimpleNoticeMF;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.response.QueryColletRecordListResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WalletPineConesFragment extends FastTitleFragment {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.icon_nuts)
    ImageView mIconNuts;
    @BindView(R.id.btn_give_away)
    Button mBtnGiveAway;
    @BindView(R.id.btn_currency_conversion)
    Button mBtnCurrencyConversion;
    @BindView(R.id.mv_text)
    MarqueeView mMvText;
    private List<String> mData = new ArrayList<>(); //轮播消息List

    @Override
    public int getContentLayout() {
        return R.layout.fragment_wallet_pine_cones;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {

    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData() {
        //获取最近的日期

        //请求松果转换记录 2024-01-01 00:00:00 ~ 2030-01-01 00:00:00 显示最近的5条
        AuthRepository.getInstance().queryColletRecordList(ApiConstant.DATE_START_TIME, ApiConstant.DATE_END_TIME, 1, 5).subscribe(queryColletRecordListResponse -> {
            if (StringUtils.equals(queryColletRecordListResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                mData.add("松果转入/转出记录");
                List<QueryColletRecordListResponse.DataBean.RecordsBean> records = queryColletRecordListResponse.getData().getRecords();
                String s = "";
                for (QueryColletRecordListResponse.DataBean.RecordsBean bean : records) {
                    switch (bean.getCoinType()) {
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_ALL:
                            s = getString(R.string.coinType_all);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_001:
                            s = getString(R.string.coinType_001);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_002:
                            s = getString(R.string.coinType_002);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_003:
                            s = getString(R.string.coinType_003);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_004:
                            s = getString(R.string.coinType_004);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_005:
                            s = getString(R.string.coinType_005);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_006:
                            s = getString(R.string.coinType_006);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_007:
                            s = getString(R.string.coinType_007);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_008:
                            s = getString(R.string.coinType_008);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_009:
                            s = getString(R.string.coinType_009);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_010:
                            s = getString(R.string.coinType_010);
                            break;
                        case ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_011:
                            s = getString(R.string.coinType_011);
                            break;
                    }
                    mData.add(s + " :   " + bean.getCoinNumber());
                }

                MarqueeFactory<TextView, String> marqueeFactory1 = new SimpleNoticeMF(getContext());
                mMvText.setMarqueeFactory(marqueeFactory1);
                mMvText.startFlipping();
                marqueeFactory1.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<TextView, String>() {
                    @Override
                    public void onItemClick(View view, MarqueeFactory.ViewHolder<TextView, String> holder) {
                        ToastUtils.showShort(holder.getData());
                        //跳转松果松子转换页面
                        FastUtil.startActivity(getActivity(), PineConeTransferRecordsActivity.class);
                    }
                });
                marqueeFactory1.setData(mData);
            }else {
                ToastUtils.showShort(queryColletRecordListResponse.getResponseMessage());
            }
        }, throwable -> {
//            ToastUtils.showShort(throwable.getMessage());
        });


    }

    @OnClick({R.id.btn_give_away, R.id.btn_currency_conversion})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_give_away:
                break;
            case R.id.btn_currency_conversion:
                break;
        }
    }
}

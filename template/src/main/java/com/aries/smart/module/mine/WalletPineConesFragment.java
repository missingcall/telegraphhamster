package com.aries.smart.module.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.smart.R;
import com.aries.ui.view.title.TitleBarView;

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

package com.aries.smart.module.login;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;
import com.aries.smart.module.widget.ClearEditText;
import com.aries.ui.view.title.TitleBarView;

import butterknife.BindView;
import butterknife.OnClick;

public class FindPasswordStep1Activity extends FastTitleActivity {
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_phone_verify)
    TextView mTvPhoneVerify;
    @BindView(R.id.ll_phone)
    LinearLayout mLlPhone;
    @BindView(R.id.tv_phone_verified)
    TextView mTvPhoneVerified;
    @BindView(R.id.cet_phone)
    ClearEditText mCetPhone;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    @Override
    public int getContentLayout() {
        return R.layout.activity_find_password_step1;
    }

    @Override
    public void initView(Bundle savedInstanceState) {


    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.find_psw)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

    }

    private String getPhone() {
        return mCetPhone.getText().toString().trim();
    }

    @OnClick({R.id.btn_next})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:

                break;
        }
    }
}

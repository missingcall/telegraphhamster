package com.aries.smart.module.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.allen.library.SuperTextView;
import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.constant.Event;
import com.aries.smart.module.widget.dialog.LogoutDialog;
import com.aries.ui.view.title.TitleBarView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountSecurityActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_account_security)
    TextView mTvAccountSecurity;
    @BindView(R.id.stv_change_phone_number)
    SuperTextView mStvChangePhoneNumber;
    @BindView(R.id.stv_login_password)
    SuperTextView mStvLoginPassword;
    @BindView(R.id.stv_real_name_authentication)
    SuperTextView mStvRealNameAuthentication;
    @BindView(R.id.stv_cancel_account)
    SuperTextView mStvCancelAccount;
    private List<Fragment> listFragment = new ArrayList<>();

    @Override
    public int getContentLayout() {
        return R.layout.activity_account_security;
    }

    @Override
    public void initView(Bundle savedInstanceState) {


    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.account_security)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }

    @OnClick({R.id.stv_change_phone_number, R.id.stv_login_password, R.id.stv_real_name_authentication, R.id.stv_cancel_account})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.stv_change_phone_number:
                //更换手机号
                FastUtil.startActivity(this, ChangePhoneNumberActivity.class);
                break;

            case R.id.stv_login_password:
                FastUtil.startActivity(this, ChangeLoginPasswordActivity.class);
                break;

            case R.id.stv_real_name_authentication:

                break;

            case R.id.stv_cancel_account:

                break;
        }
    }
}

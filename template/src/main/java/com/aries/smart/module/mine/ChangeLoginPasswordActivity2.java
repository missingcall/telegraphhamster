package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;
import com.aries.smart.module.widget.ClearEditText;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.request.ResetUserLoginPasswordTo;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeLoginPasswordActivity2 extends FastTitleActivity {
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_phone_verify)
    TextView mTvPhoneVerify;
    @BindView(R.id.cet_psw)
    ClearEditText mCetPsw;
    @BindView(R.id.cet_psw_again)
    ClearEditText mCetPswAgain;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;

    @Override
    public int getContentLayout() {
        return R.layout.activity_change_login_password_2;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.change_login_psw)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

    }

    @SuppressLint("CheckResult")
    @OnClick({R.id.btn_confirm})
    void onBindClick(View view) {
        switch (view.getId()) {
            //用户输入新密码后点击【确认】，校验密码位数，若小于8位则toast提示“密码位数过短”，大于或等于8位校验通过。
            // 校验密码一致性，若新登录密码与确认密码不一致则toast提示“新密码不一致，请重新输入”，
            case R.id.btn_confirm:
                if (StringUtils.length(getPsw()) < 8 || StringUtils.length(getPswAgain()) < 8) {
                    ToastUtils.showShort(R.string.psw_too_short);
                } else {
                    if (!StringUtils.equals(getPsw(), getPswAgain())) {
                        ToastUtils.showShort(R.string.psw_not_equals);
                    } else {
                        //发送修改请求 密码一致且位数大于或等于8位toast提示“密码修改成功”同时返回登录界面
                        ResetUserLoginPasswordTo resetUserLoginPasswordTo = new ResetUserLoginPasswordTo();
                        resetUserLoginPasswordTo.setPassword(getPsw());
                        AuthRepository.getInstance().resetUserLoginPassword(resetUserLoginPasswordTo).subscribe(resetUserLoginPasswordResponse -> {
                            if (StringUtils.equals(resetUserLoginPasswordResponse.getResponseCode(), "200")) {
                                ToastUtils.showShort(R.string.set_psw_success);
                                finish();
                            } else {
                                ToastUtils.showShort(R.string.set_psw_fail);
                            }
                        }, throwable -> {
                            ToastUtils.showShort(R.string.set_psw_fail);
                        });
                    }
                }
                break;
        }
    }

    private String getPsw() {
        return mCetPsw.getText().toString().trim();
    }

    private String getPswAgain() {
        return mCetPswAgain.getText().toString().trim();
    }
}

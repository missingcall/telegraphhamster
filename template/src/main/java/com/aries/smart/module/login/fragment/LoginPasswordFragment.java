package com.aries.smart.module.login.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.MainActivity;
import com.aries.smart.R;
import com.aries.smart.module.login.FindPasswordStep2Activity;
import com.aries.smart.module.login.widget.ClearEditText;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.PasswordLoginTo;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginPasswordFragment extends FastTitleFragment {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.ll_phone)
    LinearLayout mLlPhone;
    @BindView(R.id.cet_phone)
    ClearEditText mCetPhone;
    @BindView(R.id.ll_password)
    LinearLayout mLlPassword;
    @BindView(R.id.cet_password)
    ClearEditText mCetPassword;
    @BindView(R.id.btn_sign_in)
    Button mBtnSignIn;
    @BindView(R.id.tv_forget_password)
    TextView mTvForgetPassword;
    private TextWatcher watcher;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_login_password;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //默认不可点击
        mBtnSignIn.setEnabled(false);
        //账号密码验证码都不为空可确认 2次檢查
        watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (TextUtils.isEmpty(getPhone())) {
                    mBtnSignIn.setEnabled(false);
                } else {
                    mBtnSignIn.setEnabled(true);
                }

                if (TextUtils.isEmpty(getPassword()) || TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getPassword())) {
                    mBtnSignIn.setEnabled(false);
                } else {
                    mBtnSignIn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        mCetPhone.addTextChangedListener(watcher);
        mCetPassword.addTextChangedListener(watcher);
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setTitleMainText(R.string.login_password);
    }


    @OnClick({R.id.btn_sign_in, R.id.tv_forget_password})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:

                //简单校验电话号码
                if (!RegexUtils.isMobileSimple(getPhone())) {
                    ToastUtils.showShort(R.string.worng_pn_or_psw);
                    return;
                }

                //登录
                PasswordLoginTo passwordLoginTo = new PasswordLoginTo();
                passwordLoginTo.setMachineCode(DeviceUtils.getUniqueDeviceId());
                passwordLoginTo.setMobile(getPhone());
                passwordLoginTo.setPassword(getPassword());
                LogUtils.d(passwordLoginTo);
                AuthRepository.getInstance().passwordLogin(passwordLoginTo).subscribe(passwordLoginResponse -> {
                    LogUtils.d(passwordLoginResponse);
                    if (StringUtils.equals(passwordLoginResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                        //TODO yhd 登录成功 进入首页 将用户数据记录
                        ToastUtils.showShort(getString(R.string.login_success));
                        FastUtil.startActivity(getActivity(), MainActivity.class);
                        getActivity().finish();
                    } else {
                        ToastUtils.showShort(getString(R.string.worng_pn_or_psw));
                    }
                }, throwable -> {
                    ToastUtils.showShort(getString(R.string.worng_pn_or_psw));
                });
                break;

            case R.id.tv_forget_password:
                //忘记密码
                FastUtil.startActivity(getActivity(), FindPasswordStep2Activity.class);
                break;
        }
    }

    private String getPhone() {
        return mCetPhone.getText().toString().trim();
    }

    private String getPassword() {
        return mCetPassword.getText().toString().trim();
    }
}

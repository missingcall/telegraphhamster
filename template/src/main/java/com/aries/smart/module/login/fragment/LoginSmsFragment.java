package com.aries.smart.module.login.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;

import com.aries.library.fast.manager.LoggerManager;
import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.util.FastUtil;
import com.aries.library.fast.util.ToastUtil;
import com.aries.smart.MainActivity;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.login.FindPasswordStep2Activity;
import com.aries.smart.module.login.widget.ClearEditText;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.LoginTo;
import com.aries.smart.utils.ConstantUtils;
import com.aries.smart.utils.PreferenceUtil;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginSmsFragment extends FastTitleFragment {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.guideline_sign_up_2)
    Guideline mGuidelineSignUp2;
    @BindView(R.id.ll_phone)
    LinearLayout mLlPhone;
    @BindView(R.id.cet_phone)
    ClearEditText mCetPhone;
    @BindView(R.id.ll_verify)
    LinearLayout mLlVerify;
    @BindView(R.id.et_verify)
    ClearEditText mEtVerify;
    @BindView(R.id.btn_verify)
    Button mBtnVerify;
    @BindView(R.id.btn_currency_conversion)
    Button mBtnSignIn;
    @BindView(R.id.tv_forget_password)
    TextView mTvForgetPassword;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_login_sms;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //默认不可点击
        mBtnSignIn.setEnabled(false);

        //电话号码和验证码检查
        mCetPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (TextUtils.isEmpty(getPhone())) {
                    mBtnVerify.setEnabled(false);
                } else {
                    mBtnVerify.setEnabled(true);
                }

                if (TextUtils.isEmpty(getVerify()) || TextUtils.isEmpty(getPhone())) {
                    mBtnSignIn.setEnabled(false);
                } else {
                    mBtnSignIn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mEtVerify.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (TextUtils.isEmpty(getVerify()) || TextUtils.isEmpty(getPhone())) {
                    mBtnSignIn.setEnabled(false);
                } else {
                    mBtnSignIn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setTitleMainText(R.string.login_sms);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @OnClick({R.id.btn_verify, R.id.btn_currency_conversion, R.id.tv_forget_password})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_verify:
                toVerify();
                break;

            case R.id.btn_currency_conversion:
                //在未输入手机号与验证码时【立即登录】按钮为灰态无法点击，当两者均输入后【立即登录】按钮亮起可被点击（备注：不需要做位数判断）
                toConfirm();
                break;

            case R.id.tv_forget_password:
                FastUtil.startActivity(getActivity(), FindPasswordStep2Activity.class);
                break;
        }
    }

    private String getPhone() {
        return mCetPhone.getText().toString().trim();
    }

    private String getVerify() {
        return mEtVerify.getText().toString().trim();
    }

    private void toVerify() {
        //手机号为空
        if (StringUtils.isTrimEmpty(getPhone())) {
            ToastUtil.show(getString(R.string.wrong_phonenum));
            return;
        }
        //简单验证手机号 //中国精确匹配 isMobileExact
        if (!RegexUtils.isMobileSimple(getPhone())) {
            ToastUtil.show(getString(R.string.wrong_phonenum));
            return;
        }
        //开始验证
        startVerify();
    }

    //短信验证码校验---成功--->登录
    @SuppressLint("CheckResult")
    private void toConfirm() {
        //第二步 验证手机号和验证码是否匹配,先调短信验证码校验接口/hamster-user/sms/verificationCode 再调登录接口/hamster-user/user/login
        AuthRepository.getInstance().verificationCode(getVerify(), getPhone(), ApiConstant.SMS_TYPE_LOGIN).subscribe(verificationCodeResponse -> {
            if (StringUtils.equals(verificationCodeResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //校验通过 调登录接口
                LoginTo loginTo = new LoginTo();
                loginTo.setMobile(getPhone());
                loginTo.setAccessFlags(ApiConstant.TO_ACCOUNT_CREATE_ACCESS_FLAGS_ANDROID);
                loginTo.setMachineCode(DeviceUtils.getUniqueDeviceId());
                loginTo.setSmsCode(getVerify());

                AuthRepository.getInstance().login(loginTo).subscribe(loginResponse -> {
                    //验证通过
                    if (StringUtils.equals(loginResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                        //登录成功存入token
                        PreferenceUtil.put(ConstantUtils.TOKEN_HEAD, loginResponse.getData().getTokenHead());
                        PreferenceUtil.put(ConstantUtils.AUTHORIZATION_TOKEN, loginResponse.getData().getToken());
                        FastUtil.startActivity(getContext(), MainActivity.class);
                        getActivity().finish();
                    } else {
                        ToastUtils.showShort(R.string.worng_phonenum_or_verifycode);
                    }
                }, throwable -> {
                    ToastUtils.showShort(R.string.worng_phonenum_or_verifycode);
                });
            } else {
                ToastUtils.showShort(R.string.worng_phonenum_or_verifycode);
            }
        }, throwable -> {
            ToastUtils.showShort(R.string.worng_phonenum_or_verifycode);
        });


    }

    private boolean clickable = true;

    @SuppressLint("CheckResult")
    private void startVerify() {
        // 获取验证码
        mBtnVerify.setEnabled(false);
        if (clickable) {
            // 请求验证码
            AuthRepository.getInstance().smsSendCode(getPhone(), ApiConstant.SMS_TYPE_LOGIN)
                    .subscribe(smsSendResponse -> {
                        LoggerManager.d("startVerify", smsSendResponse.getResponseCode());
                        LoggerManager.d("startVerify", smsSendResponse.getResponseMessage());

                        if (StringUtils.equals(smsSendResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                            ToastUtils.showShort(R.string.wait_sms);
                        } else {
                            ToastUtils.showShort(R.string.wrong_phonenum);
                        }
                    }, throwable -> {
                        ToastUtils.showShort(R.string.get_sms_fail);
                    });


            clickable = false;
            timer.start();
        } else {
            ToastUtil.show("操作太快，稍后再试");
        }
    }

    private CountDownTimer timer = new CountDownTimer(60000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            StringBuffer sb = new StringBuffer("");
            synchronized (this) {
                sb.append("").append(millisUntilFinished / 1000).append("s");
            }
            mBtnVerify.setText(sb.toString());
        }

        @Override
        public void onFinish() {
            clickable = true;
            mBtnVerify.setText("重新获取");
            mBtnVerify.setEnabled(true);
        }
    };
}

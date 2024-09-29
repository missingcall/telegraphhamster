package com.aries.smart.module.login;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.library.fast.util.ToastUtil;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.widget.ClearEditText;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.LoginTo;
import com.aries.smart.constant.ConstantUtils;
import com.aries.smart.utils.PreferenceUtil;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class FindPasswordStep2Activity extends FastTitleActivity {
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
    @BindView(R.id.et_verify)
    ClearEditText mEtVerify;
    @BindView(R.id.ll_verify)
    LinearLayout mLlVerify;
    @BindView(R.id.btn_verify)
    Button mBtnVerify;
    @BindView(R.id.ll_verify_out)
    LinearLayout mLlVerifyOut;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    @Override
    public int getContentLayout() {
        return R.layout.activity_find_password_step2;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
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

    @SuppressLint("CheckResult")
    @OnClick({R.id.btn_verify, R.id.btn_next})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_verify:
                //获取验证码
                mBtnVerify.setEnabled(false);
                if (clickable) {
                    // 请求验证码
                    AuthRepository.getInstance().smsSendCode(getPhone(), ApiConstant.SMS_TYPE_RETRIEVE_PASSWORD)
                            .subscribe(smsSendResponse -> {
                                LogUtils.d("startVerify-SMS_TYPE_RETRIEVE_PASSWORD", smsSendResponse.getResponseCode());
                                LogUtils.d("startVerify-SMS_TYPE_RETRIEVE_PASSWORD", smsSendResponse.getResponseMessage());

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

                break;

            case R.id.btn_next:
                //第一步
                if (mLlVerifyOut.getVisibility() == View.GONE) {
                    //进行手机号校验
                    AuthRepository.getInstance().queryPhoneExist(getPhone()).subscribe(queryPhoneExistResponse -> {
                        //通过手机号获取用户信息 接口需求已提
                        if (StringUtils.equals(queryPhoneExistResponse.getResponseCode(), "200")) {
                            //验证通过,进入下一步
                            //手机号校验通过后展示的验证码栏置空，输入框提示为“请输入验证码”,同时锁定手机号无法更改
                            mCetPhone.setEnabled(false);
                            mTvPhoneVerified.setVisibility(View.VISIBLE);
                            mLlVerifyOut.setVisibility(View.VISIBLE);

                        } else {
                            //手机未注册
                            ToastUtils.showShort(R.string.phone_num_incorrect_or_notregistered);
                        }
                    }, throwable -> {
                        ToastUtils.showShort(R.string.phone_num_incorrect_or_notregistered);
                    });
                } else {
                    //第二步 验证手机号和验证码是否匹配,先调短信验证码校验接口/hamster-user/sms/verificationCode 再调登录接口/hamster-user/user/login
                    AuthRepository.getInstance().verificationCode(getVerify(), getPhone(), ApiConstant.SMS_TYPE_RETRIEVE_PASSWORD).subscribe(verificationCodeResponse -> {
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
                                    PreferenceUtil.put(ConstantUtils.TOKEN_HEAD,loginResponse.getData().getTokenHead());
                                    PreferenceUtil.put(ConstantUtils.AUTHORIZATION_TOKEN,loginResponse.getData().getToken());
                                    FastUtil.startActivity(this, FindPasswordStep3Activity.class);
                                    finish();
                                } else {
                                    ToastUtils.showShort(R.string.wrong_sms_verify);
                                }
                            }, throwable -> {
                                ToastUtils.showShort(R.string.wrong_sms_verify);
                            });
                        } else {
                            ToastUtils.showShort(R.string.wrong_sms_verify);
                        }
                    }, throwable -> {
                        ToastUtils.showShort(R.string.wrong_sms_verify);
                    });


                }

                break;
        }
    }

    private String getPhone() {
        return mCetPhone.getText().toString().trim();
    }

    private String getVerify() {
        return mEtVerify.getText().toString().trim();
    }

    private boolean clickable = true;
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

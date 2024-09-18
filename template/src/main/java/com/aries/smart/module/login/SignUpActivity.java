package com.aries.smart.module.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;

import com.aries.library.fast.manager.LoggerManager;
import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.ToastUtil;
import com.aries.smart.R;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.login.widget.ClearEditText;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.request.AccountCreateTo;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.tv_account_registration)
    TextView mTvAccountRegistration;
    @BindView(R.id.tv_hint)
    TextView mTvHint;
    @BindView(R.id.ll_phone)
    LinearLayout mLlPhone;
    @BindView(R.id.tv_phone_number)
    TextView mTvPhoneNumber;
    @BindView(R.id.cet_phone)
    ClearEditText mCetPhone;
    @BindView(R.id.ll_password)
    LinearLayout mLlPassword;
    @BindView(R.id.cet_password)
    ClearEditText mCetPassword;
    @BindView(R.id.ll_verify)
    LinearLayout mLlVerify;
    @BindView(R.id.et_verify)
    EditText mEtVerify;
    @BindView(R.id.btn_verify)
    Button mBtnVerify;
    @BindView(R.id.ll_invite_code)
    LinearLayout mLlInviteCode;
    @BindView(R.id.tv_invite_code)
    TextView mTvInviteCode;
    @BindView(R.id.cet_invite)
    ClearEditText mCetInvite;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    @BindView(R.id.guideline_sign_up_1)
    Guideline mGuidelineSignUp1;
    @BindView(R.id.guideline_sign_up_2)
    Guideline mGuidelineSignUp2;

    @Override
    public int getContentLayout() {
        return R.layout.activity_sign_up;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        //账号密码验证码都不为空可确认 三次檢查
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

                if (TextUtils.isEmpty(getVerify()) || TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getPassword())) {
                    mBtnConfirm.setEnabled(false);
                } else {
                    mBtnConfirm.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCetPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (TextUtils.isEmpty(getVerify()) || TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getPassword())) {
                    mBtnConfirm.setEnabled(false);
                } else {
                    mBtnConfirm.setEnabled(true);
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

                if (TextUtils.isEmpty(getVerify()) || TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getPassword())) {
                    mBtnConfirm.setEnabled(false);
                } else {
                    mBtnConfirm.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setStatusBarLightMode(false)
                .setVisibility(View.GONE);
    }


    @OnClick({R.id.btn_back, R.id.btn_verify, R.id.btn_confirm})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_verify:
                toVerify();
                break;
            case R.id.btn_confirm:
                toConfirm();
                break;
        }
    }


    private String getPhone() {
        return mCetPhone.getText().toString().trim();
    }

    private String getPassword() {
        return mCetPassword.getText().toString().trim();
    }

    private String getVerify() {
        return mEtVerify.getText().toString().trim();
    }

    private String getInviteCode() {
        return mCetInvite.getText().toString().trim();
    }

    private void toVerify() {
        //手机号为空
        if (StringUtils.isTrimEmpty(getPhone())) {
            ToastUtil.show(getString(R.string.wrong_phonenum));
            return;
        }
        //简单验证手机号
        if (!RegexUtils.isMobileSimple(getPhone())) {
            ToastUtil.show(getString(R.string.wrong_phonenum));
            return;
        }
        //开始验证
        startVerify();
    }

    //短信验证码校验---成功--->创建用户
    @SuppressLint("CheckResult")
    private void toConfirm() {
        //密码过短
        if (StringUtils.length(getPassword()) < 8) {
            ToastUtils.showShort(R.string.toast_password_too_short);
            return;
        }

        AuthRepository.getInstance().verificationCode(getVerify(), getPhone(), ApiConstant.SMS_TYPE_REGISTER)
                .subscribe(smsVerificationResponse -> {
                    LoggerManager.d("smsVerificationResponse", smsVerificationResponse.getResponseCode());
                    LoggerManager.d("smsVerificationResponse", smsVerificationResponse.getResponseMessage());
                    if (StringUtils.equals(smsVerificationResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                        //校验成功 创建用户
                        AccountCreateTo accountCreateTo = new AccountCreateTo();
                        accountCreateTo.setAccessFlags(ApiConstant.TO_ACCOUNT_CREATE_ACCESS_FLAGS_ANDROID); //访问标识 0：代表Android；1：代表IOS；可为空
                        accountCreateTo.setInviteCode(getInviteCode()); //	邀请码；用户UID
                        accountCreateTo.setMachineCode(DeviceUtils.getUniqueDeviceId()); //	机器码
                        accountCreateTo.setPassword(getPassword()); // 密码
                        accountCreateTo.setPhone(getPhone()); // 号码
                        accountCreateTo.setSmsCode(getVerify()); // 短信验证码
                        LogUtils.d(accountCreateTo);

                        AuthRepository.getInstance().accountCreate(accountCreateTo).subscribe(accountCreateResponse -> {
                            LoggerManager.d("accountCreateResponse", accountCreateResponse.getResponseCode());
                            LoggerManager.d("accountCreateResponse", accountCreateResponse.getResponseMessage());
                            if (StringUtils.equals(accountCreateResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                                //创建成功,返回登录页面
                                ToastUtils.showShort("注册成功");
                                finish();
                            }else {
                                ToastUtils.showShort(accountCreateResponse.getResponseMessage());
                            }
                        },throwable -> {
                            //创建用户响应超时

                        });
                    } else {
                        //校验失败,提示
                        ToastUtils.showShort(R.string.wrong_sms_verify);
                    }
                },throwable -> {
                    //短信验证响应超时

                });
    }

    private boolean clickable = true;

    @SuppressLint("CheckResult")
    private void startVerify() {
        // 获取验证码
        mBtnVerify.setEnabled(false);
        if (clickable) {
            // 请求验证码
            AuthRepository.getInstance().smsSendCode(getPhone(), ApiConstant.SMS_TYPE_REGISTER)
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

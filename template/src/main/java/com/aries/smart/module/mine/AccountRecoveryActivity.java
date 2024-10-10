package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.library.fast.util.ToastUtil;
import com.aries.smart.App;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.request.AccountRecoveryTo;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountRecoveryActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_phone_number)
    TextView mTvPhoneNumber;
    @BindView(R.id.tv_current_bound_phone_number)
    TextView mTvCurrentBoundPhoneNumber;
    @BindView(R.id.guideline_sign_up_2)
    Guideline mGuidelineSignUp2;
    @BindView(R.id.ll_verify)
    LinearLayout mLlVerify;
    @BindView(R.id.et_verify)
    EditText mEtVerify;
    @BindView(R.id.btn_verify)
    Button mBtnVerify;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    private List<Fragment> listFragment = new ArrayList<>();
    private String mMobile;

    @Override
    public int getContentLayout() {
        return R.layout.activity_account_recovery;
    }

    @Override
    public void initView(Bundle savedInstanceState) {


    }

    @Override
    public void loadData() {
        super.loadData();

        if (App.getApp().getInfoModel().getDataBean().getValue() == null || App.getApp().getInfoModel().getDataBean().getValue().getMobile() == null) {
            return;
        }

        //获取当前用户手机号
        mMobile = App.getApp().getInfoModel().getDataBean().getValue().getMobile();
        StringBuilder builder = new StringBuilder(mMobile);
        builder.replace(4, 8, "****");
        mTvPhoneNumber.setText(builder);
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.recover_account)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }


    @SuppressLint("CheckResult")
    @OnClick({R.id.btn_verify, R.id.btn_confirm})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_verify:
                //开始验证
                startVerify();
                break;

            case R.id.btn_confirm:
                AuthRepository.getInstance().verificationCode(getVerify(), mMobile, ApiConstant.SMS_TYPE_RETRIEVE_ACCOUNT).subscribe(verificationCodeResponse -> {
                    if (StringUtils.equals(verificationCodeResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                        //校验通过 请求恢复接口
                        if (verificationCodeResponse.isData()) {
                            AccountRecoveryTo accountRecoveryTo = new AccountRecoveryTo();
                            accountRecoveryTo.setMobile(mMobile);
                            accountRecoveryTo.setSmsCode(getVerify());
                            AuthRepository.getInstance().accountRecovery(accountRecoveryTo).subscribe(accountRecoveryResponse -> {
                                if (StringUtils.equals(accountRecoveryResponse.getResponseCode(), ApiConstant.RESPONSE_OK) && accountRecoveryResponse.isData()) {
                                    //恢复成功
                                    ToastUtils.showShort(R.string.account_recovery_successful);
                                } else {
                                    ToastUtils.showShort(accountRecoveryResponse.getResponseMessage());
                                }
                            }, throwable -> {

                            });
                            finish();
                        } else {
                            ToastUtils.showShort(verificationCodeResponse.getResponseMessage());
                        }

                    } else {
                        ToastUtils.showShort(verificationCodeResponse.getResponseMessage());
                    }
                }, throwable -> {
                    ToastUtils.showShort(R.string.worng_verifycode);
                });

                break;
        }
    }

    private String getVerify() {
        return mEtVerify.getText().toString().trim();
    }

    private boolean clickable = true;

    @SuppressLint("CheckResult")
    private void startVerify() {
        // 获取验证码
        mBtnVerify.setEnabled(false);
        if (clickable) {
            // 请求验证码
            AuthRepository.getInstance().smsSendCode(mMobile, ApiConstant.SMS_TYPE_RETRIEVE_ACCOUNT)
                    .subscribe(smsSendResponse -> {
                        if (StringUtils.equals(smsSendResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                            ToastUtils.showShort(R.string.wait_sms);
                        } else {
                            ToastUtils.showShort(smsSendResponse.getResponseMessage());
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

}

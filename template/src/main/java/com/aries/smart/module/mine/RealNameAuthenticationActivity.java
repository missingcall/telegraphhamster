package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.LiveData;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.App;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.widget.ClearEditText;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.request.InsertUserAuthenticationTo;
import com.aries.smart.retrofit.response.InfoResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RealNameAuthenticationActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.ll_real_name)
    LinearLayout mLlRealName;
    @BindView(R.id.tv_real_name)
    TextView mTvRealName;
    @BindView(R.id.cet_real_name)
    ClearEditText mCetRealName;
    @BindView(R.id.ll_card_id)
    LinearLayout mLlCardId;
    @BindView(R.id.tv_card_id)
    TextView mTvCardId;
    @BindView(R.id.cet_card_id)
    ClearEditText mCetCardId;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    @BindView(R.id.ll_authentication_status)
    LinearLayout mLlAuthenticationStatus;
    @BindView(R.id.tv_authentication_status)
    TextView mTvAuthenticationStatus;
    @BindView(R.id.tv_authentication_status_detail)
    TextView mTvAuthenticationStatusDetail;
    @BindView(R.id.tv_authentication_status_detail_1)
    TextView mTvAuthenticationStatusDetail1;
    @BindView(R.id.tv_authentication_status_detail_2)
    TextView mTvAuthenticationStatusDetail2;

    private String mFullName;//姓名
    private String mIdNumber;//身份证号

    private boolean mIsRealNameStatus; //实名状态 默认未实名

    @Override
    public int getContentLayout() {
        return R.layout.activity_real_name_authentication;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.real_name_authentication)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

    }

    @OnClick({R.id.btn_confirm})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                InsertUserAuthenticationTo insertUserAuthenticationTo = new InsertUserAuthenticationTo();
                insertUserAuthenticationTo.setName(getName());
                insertUserAuthenticationTo.setCardNo(getIdNumber());
                AuthRepository.getInstance().insertUserAuthentication(insertUserAuthenticationTo).subscribe(selectByUserIdResponse -> {
                    //TODO yhd 跳转至支付宝进行人脸识别认证，支付宝人脸比对不通过toast提示“您的信息与人脸比对不一致

                    //实名认证和活体认证进行绑定 判断返回的状态 BiometricAuthenticationActivity

                    if (StringUtils.equals(selectByUserIdResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                        ToastUtils.showShort(R.string.real_name_authentication_success);
                        //重新刷新状态
                        loadData();
                    } else {
                        ToastUtils.showShort(selectByUserIdResponse.getResponseMessage());
                    }
                }, throwable -> {
                    ToastUtils.showShort(R.string.real_name_authentication_failed);
                });
                break;
        }
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData() {
        super.loadData();

        LiveData<InfoResponse.DataBean> dataBean = App.getApp().getInfoModel().getDataBean();
        String userId = dataBean.getValue().getUserId();
        AuthRepository.getInstance().selectByUserId(userId).subscribe(selectByUserIdResponse -> {
            if (StringUtils.equals(selectByUserIdResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                //data为空或者cardno为空:未实名
                if (selectByUserIdResponse.getData() == null || StringUtils.isEmpty(selectByUserIdResponse.getData().getCardNo())) {
                    mIsRealNameStatus = false;
                    mTvAuthenticationStatusDetail.setText(R.string.not_authenticated);
                    mTvAuthenticationStatusDetail.setTextColor(getResources().getColor(R.color.red_light));

                    mBtnConfirm.setVisibility(View.VISIBLE);
                } else {
                    //已实名
                    mIsRealNameStatus = true;
                    mTvAuthenticationStatusDetail.setText(R.string.verified);
                    mTvAuthenticationStatusDetail.setTextColor(getResources().getColor(R.color.white));

                    //获取姓名和身份证号
                    mFullName = selectByUserIdResponse.getData().getFullName();
                    StringBuilder builderName = new StringBuilder(mFullName);
                    builderName.replace(1, 2, "*");
                    mCetRealName.setText(builderName);
                    mCetRealName.setEnabled(false);

                    mIdNumber = selectByUserIdResponse.getData().getIdNumber();
                    StringBuilder builderId = new StringBuilder(mIdNumber);
                    builderName.replace(3, 15, "************");
                    mCetCardId.setText(builderName);
                    mCetCardId.setEnabled(false);

                    mBtnConfirm.setVisibility(View.GONE);
                }


            }
        }, throwable -> {

        });
    }

    private String getName() {
        return mCetRealName.getText().toString().trim();
    }

    private String getIdNumber() {
        return mCetCardId.getText().toString().trim();
    }
}

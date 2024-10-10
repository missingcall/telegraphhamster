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
import com.aries.smart.WebAppActivity;
import com.aries.smart.WebViewActivity;
import com.aries.smart.constant.Event;
import com.aries.smart.module.widget.RoundImageView;
import com.aries.smart.module.widget.dialog.LogoutDialog;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.AppUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AboutUsActivity extends FastTitleActivity {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.riv_icon)
    RoundImageView mRivIcon;
    @BindView(R.id.tv_app_name)
    TextView mTvAppName;
    @BindView(R.id.tv_version_code)
    TextView mTvVersionCode;
    @BindView(R.id.stv_privacy_agreement)
    SuperTextView mStvPrivacyAgreement;
    @BindView(R.id.stv_software_usage_agreement)
    SuperTextView mStvSoftwareUsageAgreement;

    @Override
    public int getContentLayout() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTvVersionCode.setText(mTvVersionCode.getText() + ":" + AppUtils.getAppVersionCode());
    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.about_us)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }

    @OnClick({R.id.stv_privacy_agreement, R.id.stv_software_usage_agreement})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.stv_privacy_agreement:
                WebAppActivity.start(this, "https://m.baidu.com");
                break;
            case R.id.stv_software_usage_agreement:
                WebAppActivity.start(this, "https://m.baidu.com");
                break;
        }
    }
}

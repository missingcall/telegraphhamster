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
import com.aries.smart.module.widget.dialog.CleanDialog;
import com.aries.smart.module.widget.dialog.LogoutDialog;
import com.aries.ui.view.title.TitleBarView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_setting)
    TextView mTvSetting;
    @BindView(R.id.stv_account_security)
    SuperTextView mStvAccountSecurity;
    @BindView(R.id.stv_personal_information_collection_checklist)
    SuperTextView mStvPersonalInformationCollectionChecklist;
    @BindView(R.id.stv_list_of_third_party_information_sharing)
    SuperTextView mStvListOfThirdPartyInformationSharing;
    @BindView(R.id.stv_about_us)
    SuperTextView mStvAboutUs;
    @BindView(R.id.btn_exit)
    Button mBtnExit;
    private List<Fragment> listFragment = new ArrayList<>();

    @Override
    public int getContentLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView(Bundle savedInstanceState) {


    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.setting)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }

    @OnClick({R.id.stv_account_security, R.id.stv_personal_information_collection_checklist, R.id.stv_list_of_third_party_information_sharing, R.id.stv_about_us, R.id.btn_exit})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.stv_account_security:
//账号安全
                FastUtil.startActivity(this,AccountSecurityActivity.class);
                break;

            case R.id.stv_personal_information_collection_checklist:
//个人信息收集清单
                break;

            case R.id.stv_list_of_third_party_information_sharing:
//第三方信息共享清单
                break;

            case R.id.stv_about_us:
//关于我们
                break;

            case R.id.btn_exit:
//退出登录dialog
                LogoutDialog logoutDialog = new LogoutDialog(this);
                logoutDialog.show();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Event.LogOutEvent event) {
        //退出登录
        finish();
    }
}

package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.WebAppActivity;
import com.aries.smart.WebViewActivity;
import com.aries.smart.utils.RxTextTool;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class CancelAccountActivity extends FastTitleActivity {


    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.tv_cancel_account_des)
    TextView mTvCancelAccountDes;
    @BindView(R.id.tv_cancel_account_des_1)
    TextView mTvCancelAccountDes1;
    @BindView(R.id.tv_cancel_account_des_2)
    TextView mTvCancelAccountDes2;
    @BindView(R.id.tv_cancel_account_des_2_sub)
    TextView mTvCancelAccountDes2Sub;
    @BindView(R.id.tv_cancel_account_des_3)
    TextView mTvCancelAccountDes3;
    @BindView(R.id.tv_cancel_account_des_3_sub)
    TextView mTvCancelAccountDes3Sub;
    @BindView(R.id.cb_agree)
    CheckBox mCbAgree;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    @BindView(R.id.tv_account_cancel_agreement)
    TextView mTvAccountCancelAgreement;

    @Override
    public int getContentLayout() {
        return R.layout.activity_cancel_account;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setUpHypertext();
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.cancel_account)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

    }

    @SuppressLint("CheckResult")
    @OnClick({R.id.btn_confirm})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                if (mCbAgree.isChecked()) {
                    FastUtil.startActivity(this, CancelAccountActivity2.class);
                    finish();
                } else {
                    ToastUtils.showShort(R.string.please_check_the_agreement);
                }

                break;
        }

    }

    //隐私链接设置
    private void setUpHypertext() {
        mTvAccountCancelAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        RxTextTool.Builder builder = RxTextTool.getBuilder("").setAlign(Layout.Alignment.ALIGN_OPPOSITE);
//        int titleColor = getResources().getColor(R.color.half_opacity_white);
//        int urlColor = getResources().getColor(R.color.half_opacity_white);
        int titleColor = getResources().getColor(R.color.text_white);
        int urlColor = getResources().getColor(R.color.text_hyperlink);
        builder.append(" ").setForegroundColor(titleColor)
                .append(" "/*+getResources().getString(R.string.app_content)*/ + "《" + getResources().getString(R.string.app_name) + "注销协议》")
//                .setUnderline()
                .setClickSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        //TODO yhd 打开注销协议
                        WebAppActivity.start(CancelAccountActivity.this, "https://m.baidu.com");
                    }

                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        ds.setColor(urlColor);
//                        ds.setUnderlineText(true);
                    }
                })
                .into(mTvAccountCancelAgreement);

        mCbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

    }
}

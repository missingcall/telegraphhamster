package com.aries.smart.module.login;

import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.WebViewActivity;
import com.aries.smart.module.widget.dialog.AgreePrivacyDialog;
import com.aries.smart.module.widget.dialog.LoginDialog;
import com.aries.smart.utils.RxTextTool;
import com.aries.ui.view.title.TitleBarView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends FastTitleActivity {


    @BindView(R.id.ll_activity_login)
    LinearLayout mLlLogin;

   /* @BindView(R.id.fl_sign_in)
    FrameLayout mFlSignIn;//登录
    @BindView(R.id.fl_sign_up)
    FrameLayout mFlSignUp;//注册*/

    @BindView(R.id.cb_agree)
    CheckBox mCbAgree;
    @BindView(R.id.tv_protocol)
    TextView mTvProtocol;
    @BindView(R.id.btn_currency_conversion)
    Button mBtnSignIn;
    @BindView(R.id.btn_sign_up)
    Button mBtnSignUp;

    private boolean isAgreeProtocol = false;

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //隐私协议链接
        setUpHypertext();

    }

    private void setUpHypertext() {
        mTvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        RxTextTool.Builder builder = RxTextTool.getBuilder("").setAlign(Layout.Alignment.ALIGN_OPPOSITE);
//        int titleColor = getResources().getColor(R.color.half_opacity_white);
//        int urlColor = getResources().getColor(R.color.half_opacity_white);
        int titleColor = getResources().getColor(R.color.text_white);
        int urlColor = getResources().getColor(R.color.text_hyperlink);
        builder.append(" ").setForegroundColor(titleColor)
                .append(" "/*+getResources().getString(R.string.app_content)*/ + "《用户使用协议》")
//                .setUnderline()
                .setClickSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        //TODO yhd 打开服务协议
                        WebViewActivity.start(LoginActivity.this, "https://m.baidu.com");
                    }

                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        ds.setColor(urlColor);
//                        ds.setUnderlineText(true);
                    }
                }).append("和").setForegroundColor(titleColor)
                .append(" "/*+getResources().getString(R.string.app_content)*/ + "《隐私协议》")
//                .setUnderline()
                .setClickSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        //TODO yhd 打开隐私协议
                        WebViewActivity.start(LoginActivity.this, "https://m.baidu.com");
                    }

                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        ds.setColor(urlColor);
//                        ds.setUnderlineText(true);
                    }
                })
                .into(mTvProtocol);

        mCbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isAgreeProtocol = isChecked;
            }
        });

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setStatusBarLightMode(false)
                .setVisibility(View.GONE);
    }


    @OnClick({R.id.btn_currency_conversion, R.id.btn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //点击登录
            case R.id.btn_currency_conversion:
                //判断协议勾选状态
                if (isAgreeProtocol) {

//                    FastUtil.startActivity(this ,SignInActivity.class);
                    //弹出登录页面 DialogFragment
                    LoginDialog loginDialog = new LoginDialog();
                    loginDialog.show(getSupportFragmentManager(),"tag");
                } else {
                    //弹窗提示
                    agreeToPrivacy();
                }
                break;

            //点击注册
            case R.id.btn_sign_up:
                FastUtil.startActivity(mContext, SignUpActivity.class);

            default:
                break;
        }
    }

    private void agreeToPrivacy() {
        AgreePrivacyDialog agreePrivacyDialog = new AgreePrivacyDialog(this, R.style.tran_dialog, mCbAgree);
        agreePrivacyDialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

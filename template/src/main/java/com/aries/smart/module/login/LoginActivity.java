package com.aries.smart.module.login;

import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.library.fast.util.ToastUtil;
import com.aries.smart.R;
import com.aries.smart.WebViewActivity;
import com.aries.smart.utils.RxTextTool;
import com.aries.ui.view.title.TitleBarView;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends FastTitleActivity {



    @BindView(R.id.ll_activity_login)
    LinearLayout mLlLogin;

    @BindView(R.id.fl_sign_in)
    FrameLayout mFlSignIn;//登录
    @BindView(R.id.fl_sign_up)
    FrameLayout mFlSignUp;//注册
    @BindView(R.id.cb_agree)
    CheckBox mCbAgree;
    @BindView(R.id.tv_protocol)
    TextView mTvProtocol;

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
                .append(" "/*+getResources().getString(R.string.app_content)*/+"《用户使用协议》")
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
                .append(" "/*+getResources().getString(R.string.app_content)*/+"《隐私协议》")
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

    /**
     * 检查是否同意协议
     */
    private boolean checkIsAgree() {
        if (!isAgreeProtocol) {
            ToastUtil.show("请先勾选同意《"+getResources().getString(R.string.app_content)+"服务协议》、《"+getResources().getString(R.string.app_content)+"用户隐私协议》");
            return false;
        }
        return true;
    }

    @OnClick({R.id.fl_sign_in, R.id.fl_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_sign_in:
                ToastUtil.show("登录");
                break;

            case R.id.fl_sign_up:
                ToastUtil.show("注册");
                break;

            default:
                break;
        }
    }

}

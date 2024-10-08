package com.aries.smart.module.widget.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;

import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.constant.ConstantUtils;
import com.aries.smart.constant.Event;
import com.aries.smart.module.login.LoginActivity;
import com.blankj.utilcode.util.SPUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogoutDialog extends CommonDialog {

    @BindView(R.id.guideline_horizontal)
    Guideline mGuidelineHorizontal;
    @BindView(R.id.guideline_vertical)
    Guideline mGuidelineVertical;
    @BindView(R.id.btn_exit)
    Button mBtnExit;
    @BindView(R.id.tv_check_logout)
    TextView mTvCheckLogout;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;


    public LogoutDialog(Context context) {
        super(context);
        initView(context);
    }

    public LogoutDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public LogoutDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public LogoutDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_logout, null);
        setContentView(view);
        ButterKnife.bind(this);

        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mLayoutParams.gravity = Gravity.BOTTOM;


    }

    @OnClick({R.id.btn_exit, R.id.btn_confirm, R.id.btn_cancel})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exit:
                dismiss();
                break;
            case R.id.btn_confirm:
                //退出当前登录账号，并返回登录页面
                SPUtils.getInstance().remove(ConstantUtils.AUTHORIZATION_TOKEN);
                SPUtils.getInstance().remove(ConstantUtils.TOKEN_HEAD);
                SPUtils.getInstance().remove(ConstantUtils.IS_AGREE_PROTOCOL);
                /*FastRetrofit.getInstance().addHeader(ConstantUtils.AUTHORIZATION_TOKEN, PreferenceUtil.getString(ConstantUtils.TOKEN_HEAD, "")
                        + PreferenceUtil.getString(ConstantUtils.AUTHORIZATION_TOKEN, ""));*/
                FastUtil.startActivity(getContext(), LoginActivity.class);
                EventBus.getDefault().post(Event.LogOutEvent.INSTANCE);
                dismiss();
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }
}

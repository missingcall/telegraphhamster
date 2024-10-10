package com.aries.smart.module.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aries.library.fast.util.FastUtil;
import com.aries.smart.R;
import com.aries.smart.module.mine.AccountRecoveryActivity;
import com.aries.smart.retrofit.response.PasswordLoginResponse;

public class AccountRecoveryDialog extends CommonDialog {


    private PasswordLoginResponse.DataBean mData;

    public AccountRecoveryDialog(Context context, PasswordLoginResponse.DataBean data) {
        super(context);
        mData = data;
        initView(context);
    }

    public AccountRecoveryDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public AccountRecoveryDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public AccountRecoveryDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_account_recovery, null);
        setContentView(view);


        TextView tvAccountRecovery = view.findViewById(R.id.tv_account_recovery);
        Button btnConfirm = view.findViewById(R.id.btn_confirm);
        Button btnCancel = view.findViewById(R.id.btn_cancel);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //恢复账号
                FastUtil.startActivity(getContext(), AccountRecoveryActivity.class);
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //关闭弹窗
                dismiss();
            }
        });

        if (mData == null || mData.getDestroyDate() == null) {
            return;
        }
        tvAccountRecovery.setText("账号（UID：" + mData.getUserId() + "）于" + mData.getDestroyDate().toString() + "申请注销，7天内可以撤销申请，过期则自动注销账号");
    }
}

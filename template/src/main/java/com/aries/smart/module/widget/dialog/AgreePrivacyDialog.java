package com.aries.smart.module.widget.dialog;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.aries.smart.R;
import com.blankj.utilcode.util.ScreenUtils;

public class AgreePrivacyDialog extends CommonDialog {

    CheckBox mCheckBox;

    public AgreePrivacyDialog(Context context) {
        super(context);
        initView(context);
    }

    public AgreePrivacyDialog(Context context, int themeResId, CheckBox checkBox) {
        super(context, themeResId);
        mCheckBox = checkBox;
        initView(context);
    }

    public AgreePrivacyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public AgreePrivacyDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_agree_privacy, null);
        setContentView(view);

        mLayoutParams.height = (int) (ScreenUtils.getScreenHeight()* 0.55);
        mLayoutParams.gravity = Gravity.BOTTOM;

        Button btnConfirm = view.findViewById(R.id.btn_confirm);
        Button btnCancel = view.findViewById(R.id.btn_cancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //关闭弹窗并勾选底部协议
                if (mCheckBox != null) {
                    mCheckBox.setChecked(true);
                }
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


    }
}

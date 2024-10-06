package com.aries.smart.module.widget.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.aries.smart.R;
import com.blankj.utilcode.util.ScreenUtils;

public class RealNameDialog extends CommonDialog {


    public RealNameDialog(Context context) {
        super(context);
        initView(context);
    }

    public RealNameDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public RealNameDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public RealNameDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_real_name, null);
        setContentView(view);

        Button btnConfirm = view.findViewById(R.id.btn_confirm);
        Button btnCancel = view.findViewById(R.id.btn_cancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //去实名

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

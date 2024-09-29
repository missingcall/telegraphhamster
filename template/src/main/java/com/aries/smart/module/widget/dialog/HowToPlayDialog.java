package com.aries.smart.module.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aries.smart.App;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.repository.AccessoriesRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.UnlockSkinTo;
import com.aries.smart.retrofit.response.GetMyMoneyBagResponse;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

public class HowToPlayDialog extends CommonDialog {
/*    private static final String DEVELOP_TYPE_CLEAN = "清洗仓鼠";
    private static final String DEVELOP_TYPE_REBORN = "复活仓鼠";
    private static final String DEVELOP_TYPE_FEED = "喂养仓鼠";*/

    public HowToPlayDialog(Context context) {
        super(context);

        initView(context);
    }

    public HowToPlayDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public HowToPlayDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public HowToPlayDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_how_to_plau, null);
        setContentView(view);

        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mLayoutParams.gravity = Gravity.BOTTOM;

        view.findViewById(R.id.btn_exit).setOnClickListener(view1 -> {dismiss();});
        view.findViewById(R.id.btn_confirm).setOnClickListener(view1 -> {dismiss();});


    }
}

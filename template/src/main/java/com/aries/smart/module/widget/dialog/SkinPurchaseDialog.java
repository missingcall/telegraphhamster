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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;

import com.aries.library.fast.manager.GlideManager;
import com.aries.smart.App;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.repository.AccessoriesRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.UnlockSkinTo;
import com.aries.smart.retrofit.response.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.response.GetMyMoneyBagResponse;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

public class SkinPurchaseDialog extends CommonDialog {

    AccessoriesInfoListResponse.DataBean.RecordsBean mRecordsBean;

    public SkinPurchaseDialog(Context context, AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean) {
        super(context);
        mRecordsBean = recordsBean;
        initView(context);
    }

    public SkinPurchaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public SkinPurchaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public SkinPurchaseDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_skin_purchase, null);
        setContentView(view);

        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mLayoutParams.gravity = Gravity.BOTTOM;


        ImageView rivImage = view.findViewById(R.id.riv_image);
        TextView tvAvailable = view.findViewById(R.id.tv_available);

        Button btnConfirm = view.findViewById(R.id.btn_confirm);
        Button btnCancel = view.findViewById(R.id.btn_cancel);

        LogUtils.d("mRecordsBean : " + mRecordsBean);

        if (mRecordsBean != null) {
            GlideManager.loadImg(mRecordsBean.getIcon(), rivImage);
        }

        GetMyMoneyBagResponse.DataBean dataBean = App.getApp().getViewModel().getDataBean().getValue();
        LogUtils.d("dataBean : " + dataBean);
        if (dataBean == null) {
            return;
        }
        String s = "我拥有的 " + dataBean.getDiamond();
        SpannableString spannableString = new SpannableString(s);
        ImageSpan image = new ImageSpan(context, R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableString.setSpan(image, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FDC120")), 5, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvAvailable.setText(spannableString);


        String config = "确认购买 " + mRecordsBean.getUnlockParameters();
        SpannableString spannableStringConfig = new SpannableString(config);
        ImageSpan imageConfig = new ImageSpan(context, R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableStringConfig.setSpan(imageConfig, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        btnConfirm.setText(spannableStringConfig);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                UnlockSkinTo unlockSkinTo = new UnlockSkinTo();
                unlockSkinTo.setType(ApiConstant.ACCESSORIES_TYPE_SKIN);
                AccessoriesRepository.getInstance().unlockSkin(unlockSkinTo).subscribe(unlockSkinResponse -> {
                    if (StringUtils.equals(unlockSkinResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                        ToastUtils.showShort(R.string.purchase_successful);
                    }else {
                        ToastUtils.showShort(unlockSkinResponse.getResponseMessage());
                    }
                }, throwable -> {

                });
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

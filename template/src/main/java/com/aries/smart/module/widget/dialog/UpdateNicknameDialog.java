package com.aries.smart.module.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aries.library.fast.FastManager;
import com.aries.library.fast.retrofit.FastRetrofit;
import com.aries.smart.R;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.UpdateNicknameTo;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * 修改昵称Dialog
 */
public class UpdateNicknameDialog extends CommonDialog {

    public UpdateNicknameDialog(Context context) {
        super(context);
        initView(context);
    }

    public UpdateNicknameDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public UpdateNicknameDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public UpdateNicknameDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    @SuppressLint("CheckResult")
    private void initView(Context context) {
        this.getWindow().setWindowAnimations(R.style.DialogVerticalINOut);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_update_nickname, null);
        setContentView(view);
        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mLayoutParams.gravity = Gravity.BOTTOM;


        EditText et_nickname = view.findViewById(R.id.et_nickname);
        TextView tv_nickname_current = view.findViewById(R.id.tv_nickname_current);
        TextView tv_nickname_available = view.findViewById(R.id.tv_nickname_available);

        //获取钱包中松果
        /*AuthRepository.getInstance().getMyMoneyBag().subscribe(getMyMoneyBagResponse -> {
            if (StringUtils.equals(getMyMoneyBagResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                int diamond = getMyMoneyBagResponse.getData().getDiamond();

                SpannableString spannableString = new SpannableString("我可用的 " + diamond);
                ImageSpan image = new ImageSpan(getContext(), R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
                spannableString.setSpan(image, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv_nickname_available.setText(spannableString);

            }

        }, throwable -> {
            SpannableString spannableString = new SpannableString("我可用的 "  + "?");
            ImageSpan image = new ImageSpan(getContext(), R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
            spannableString.setSpan(image, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_nickname_available.setText(spannableString);
            ToastUtils.showShort("获取钱包失败");
        });

        //验证是否首次修改昵称
        AuthRepository.getInstance().checkFirstUpdateNickname().subscribe(updateNicknameResponse -> {
            if (StringUtils.equals(updateNicknameResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                //首次修改
                SpannableString spannableString = new SpannableString("确认\n" + "首次免费 ");
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.GREEN);
                spannableString.setSpan(foregroundColorSpan, 4, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv_nickname_available.setText(spannableString);

            }else {
                //非首次修改
                SpannableString spannableString = new SpannableString("确认 "  + "");
                ImageSpan image = new ImageSpan(getContext(), R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
                spannableString.setSpan(image, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv_nickname_available.setText(spannableString);
                ToastUtils.showShort("获取钱包失败");
            }

        }, throwable -> {


        });*/

        Button btnConfirm = view.findViewById(R.id.btn_confirm);
        Button btnCancel = view.findViewById(R.id.btn_cancel);

        et_nickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_nickname_current.setText(s.length() + "/8");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //新昵称为空就返回
                if (StringUtils.isTrimEmpty(et_nickname.getText().toString())) {
                    return;
                }

                //掉修改昵称接口 关闭弹窗
                UpdateNicknameTo updateNicknameTo = new UpdateNicknameTo();
                updateNicknameTo.setNickname(et_nickname.getText().toString());
                AuthRepository.getInstance().updateNickname(updateNicknameTo).subscribe(updateNicknameResponse -> {
                    if (StringUtils.equals(updateNicknameResponse.getResponseCode(), BaseRepository.RESPONSE_OK)) {
                        ToastUtils.showShort("昵称修改成功,等待审核...");
                    }
                }, throwable -> {
                    ToastUtils.showShort("昵称修改失败");
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

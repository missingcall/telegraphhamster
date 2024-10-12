package com.aries.smart.module.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.aries.smart.R;

/**
 * Created by damon on 2018/4/23.
 */

public class SureCancelDialog extends CommonDialog implements View.OnClickListener {

    private OnInitListener listener;
    private TextView mTvHintInfo;
    private Button mTvCancel;
    private Button mTvSure;
    private TextView mTvHintTitle;

    public SureCancelDialog(Activity context) {
        super(context);
        initView(context);
    }

    public SureCancelDialog(Context context)
    {
        super(context);
        initView(context);
    }


    public SureCancelDialog(Fragment fragment) {
        super(fragment.getContext());
        initView(fragment);
    }

    public SureCancelDialog(Activity context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public SureCancelDialog(Fragment fragment, int themeResId) {
        super(fragment.getContext(), themeResId);
        initView(fragment);
    }

    public SureCancelDialog(Activity context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    public SureCancelDialog(Fragment fragment, float alpha, int gravity) {
        super(fragment.getContext(), alpha, gravity);
        initView(fragment);
    }
    private void initView(Context context) {infalteView();}
    private void initView(Activity activity)
    {
        infalteView();
    }

    private void infalteView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_sure_cancle, null);
        mTvHintInfo = (TextView) inflate.findViewById(R.id.tv_hint_info);
        mTvCancel = inflate.findViewById(R.id.bt_cancel);
        mTvCancel.setOnClickListener(this);
        mTvSure = inflate.findViewById(R.id.bt_sure);
        mTvHintTitle = inflate.findViewById(R.id.tv_hint_title);
        mTvSure.setOnClickListener(this);
        setContentView(inflate);
    }

    public Button getSureView(){
        return mTvSure;
    }

    public Button getCancelView(){
        return mTvCancel;
    }

    public void setmTvHintTitle(String title){
        mTvHintTitle.setText(title);
    }

    public void setmTvHintInfo(String info)
    {
        mTvHintInfo.setText(info);
    }

    public void setmTvSureText(String sureText)
    {
        mTvSure.setText(sureText);
    }

    public void setmTvCancelText(String cancelText)
    {
        mTvCancel.setText(cancelText);
    }


    private void initView(Fragment fragment)
    {
        infalteView();
    }

    public SureCancelDialog isHideTitle(){
        mTvHintTitle.setVisibility(View.GONE);
        return this;
    }

    public SureCancelDialog initInfo(OnInitListener listener){
        if (listener != null)
        {
            this.listener = listener;
            listener.setHintInfo(mTvHintInfo);
        }
        return this;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_cancel:
                if (listener != null)
                    listener.cancelEvent();
                cancel();
                break;
            case R.id.bt_sure:
                if (listener != null)
                    listener.sureEvent();
                cancel();
                break;
        }
    }

    public TextView getTvTitle() {
        return mTvHintTitle;
    }

    public interface OnInitListener{
        void setHintInfo(TextView infoView);
        void cancelEvent();
        void sureEvent();
    }
}

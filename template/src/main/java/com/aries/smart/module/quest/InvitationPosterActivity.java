package com.aries.smart.module.quest;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;

import com.allen.library.CircleImageView;
import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;

import com.aries.smart.utils.ShareUtils;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.king.zxing.util.CodeUtils;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;

import butterknife.BindView;
import butterknife.OnClick;

public class InvitationPosterActivity extends FastTitleActivity {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.guideline_horizontal)
    Guideline mGuidelineHorizontal;
    @BindView(R.id.btn_wechat)
    CircleImageView mBtnWechat;
    @BindView(R.id.btn_save)
    Button mBtnSave;
    @BindView(R.id.btn_wechat_friends)
    CircleImageView mBtnWechatFriends;
    @BindView(R.id.iv_poster_main)
    ImageView mIvPosterMain;
    @BindView(R.id.iv_icon)
    ImageView mIvIcon;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_uid)
    TextView mTvUid;
    @BindView(R.id.iv_qr_code)
    ImageView mIvQrCode;
    private String mUrl;
    private Bitmap mQrCode;

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.invite_friends)
                .setTitleMainTextColor(Color.WHITE)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);

        titleBar.setBackgroundResource(R.color.transparent);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_invitation_poster;
    }

    @SuppressLint("CheckResult")
    @Override
    public void initView(Bundle savedInstanceState) {

        //TODO yhd 请求apk url地址生成二维码
        mUrl = "http://www.baidu.com";
        mQrCode = CodeUtils.createQRCode(mUrl, 200, null);
        mIvQrCode.setImageBitmap(mQrCode);

        ShareUtils.getInstance(this).initShareConfig();
    }

    @Override
    public void loadData() {
        super.loadData();

    }

    @OnClick({R.id.btn_wechat, R.id.btn_save, R.id.btn_wechat_friends})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_wechat:
                //分享到对话
                ShareUtils.getInstance(this).sendToWeiXin("title", "https://www.baidu.com", "des", null, SendMessageToWX.Req.WXSceneSession);
                break;

            case R.id.btn_save:
                ImageUtils.save2Album(mQrCode , Bitmap.CompressFormat.PNG);
                ToastUtils.showShort("图片已保存到相册");
                break;

            case R.id.btn_wechat_friends:
                //分享到朋友圈
                ShareUtils.getInstance(this).sendToWeiXin("title", "https://www.baidu.com", "des", null, SendMessageToWX.Req.WXSceneTimeline);
                break;
        }
    }
}
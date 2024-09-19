package com.aries.smart.module.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aries.library.fast.i.IFastRefreshView;
import com.aries.library.fast.manager.LoggerManager;
import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.retrofit.FastUploadRequestBody;
import com.aries.library.fast.retrofit.FastUploadRequestListener;
import com.aries.library.fast.util.SizeUtil;
import com.aries.smart.R;
import com.aries.smart.module.login.widget.OverScrollView;
import com.aries.smart.utils.ImagePickerHelper;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.util.StatusBarUtil;
import com.aries.ui.view.title.TitleBarView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.io.File;

import butterknife.BindView;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Author: AriesHoo on 2018/7/13 17:09
 * @E-Mail: AriesHoo@126.com
 * @Function: 我的
 * @Description:
 */
public class MineFragment extends FastTitleFragment implements IFastRefreshView {

    @BindView(R.id.sv_containerMine)
    OverScrollView mSvContainer;

    private ImageView mIvHead;
    private boolean mIsLight;
    private SmartRefreshLayout mRefreshLayout;

    private ImagePickerHelper mImagePickerHelper;
    private TitleBarViewHelper mTitleBarViewHelper;
    private static final int REQUEST_CODE_CHOOSE = 23;

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Activity 可以通过给根布局添加SmartRefreshLayout实现
     * Fragment 根布局getParent 为null无法获取父容器故需传递一个被SmartRefreshLayout包裹的View
     * 如Fragment根布局为SmartRefreshLayout 此处传递null即可
     *
     * @return
     */
    @Override
    public View getContentView() {
        return mSvContainer;
    }

    @Override
    public void setRefreshLayout(SmartRefreshLayout refreshLayout) {
        mRefreshLayout = refreshLayout;
        int statusHeight = StatusBarUtil.getStatusBarHeight() + getResources().getDimensionPixelSize(R.dimen.dp_title_height);
        LoggerManager.i("statusHeight:" + statusHeight + ";dp:" + SizeUtil.px2dp(statusHeight));
        refreshLayout.setHeaderInsetStart(SizeUtil.px2dp(statusHeight));
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.mine)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mImagePickerHelper = new ImagePickerHelper(mContext);

        mTitleBarViewHelper = new TitleBarViewHelper(mContext)
                .setTitleBarView(mTitleBar)
                .setOverScrollView(mSvContainer)
                .setShowTextEnable(true)
                .setMaxHeight(0)
                .setOnScrollListener(new TitleBarViewHelper.OnScrollListener() {
                    @Override
                    public void onScrollChange(int alpha, boolean isLightMode) {
                        mIsLight = isLightMode;
                    }
                });
        LoggerManager.i("initView_getParent:" + mContentView.getParent() + ";rootView:" + mContentView.getRootView());
    }



    private RequestBody getUploadRequestBody(File file, FastUploadRequestListener listener) {
        if (listener == null) {
            return RequestBody.create(MultipartBody.FORM, file);
        }
        return new FastUploadRequestBody(RequestBody.create(MultipartBody.FORM, file), listener);
    }



    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        if (isVisibleToUser) {
            if (mRefreshLayout != null) {
                mRefreshLayout.autoRefresh();
            }
            if (mIsLight) {
                StatusBarUtil.setStatusBarLightMode(mContext);
            } else {
                StatusBarUtil.setStatusBarDarkMode(mContext);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mImagePickerHelper != null) {
            mImagePickerHelper.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTitleBarViewHelper != null) {
            mTitleBarViewHelper.onDestroy();
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
    }

}

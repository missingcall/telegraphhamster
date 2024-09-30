package com.aries.smart.module.market;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aries.library.fast.FastManager;
import com.aries.library.fast.manager.GlideManager;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.retrofit.FastObserver;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.adapter.AccessoriesRecordsAdapter;
import com.aries.smart.module.adapter.OrchardAdapter;
import com.aries.smart.module.widget.dialog.SkinPurchaseDialog;
import com.aries.smart.retrofit.repository.AccessoriesRepository;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.smart.retrofit.request.CurrentlyUseSkinTo;
import com.aries.smart.retrofit.response.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 仓鼠果园页面
 */
public class OrchardFragment extends FastTitleRefreshLoadFragment<QueryMarketListResponse.DataBean> {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    private BaseQuickAdapter mAdapter;

    public static OrchardFragment getInstance() {
        OrchardFragment fragment = new OrchardFragment();
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_orchard;
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        //TODO yhd 皮肤和头像多了需要加载更多逻辑

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRvContentFastLib.setLayoutManager(layoutManager);


    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setVisibility(View.GONE);

    }


    @Override
    public BaseQuickAdapter<QueryMarketListResponse.DataBean, BaseViewHolder> getAdapter() {
        mAdapter = new OrchardAdapter(mContentView);

        return mAdapter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(int page) {
        AuthRepository.getInstance().queryMarketList(ApiConstant.API_HAMSTER_MARKET_TYPE_001).subscribe(queryMarketListResponse -> {
            if (StringUtils.equals(queryMarketListResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
//                mAdapter.setList(queryMarketListResponse.getData());
                FastManager
                        .getInstance()
                        .getHttpRequestControl()
                        .httpRequestSuccess(getIHttpRequestControl(),
                                queryMarketListResponse.getData() == null ? new ArrayList<>() : queryMarketListResponse.getData(),
                                null);
            }
        }, throwable -> {

        });

    }
}

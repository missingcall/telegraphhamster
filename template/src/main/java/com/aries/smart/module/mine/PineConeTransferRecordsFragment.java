package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aries.library.fast.FastManager;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.adapter.PineConeTransferRecordsAdapter;
import com.aries.smart.module.adapter.WarehouseOrchardAdapter;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

/**
 * 我的仓库-仓鼠果园/松果银行 页面
 */
public class PineConeTransferRecordsFragment extends FastTitleRefreshLoadFragment<QueryMarketListResponse.DataBean> {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    private BaseQuickAdapter mAdapter;
    //生效中的list
    List<QueryMarketListResponse.DataBean> mInEffectList = new ArrayList<>();

    private String mType = ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_ALL;

    public static PineConeTransferRecordsFragment getInstance(String type) {
        Bundle args = new Bundle();
        PineConeTransferRecordsFragment fragment = new PineConeTransferRecordsFragment();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void beforeSetContentView() {
        super.beforeSetContentView();
        mType = getArguments().getString("type");
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_pine_cone_transfer_records;
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        //TODO yhd 皮肤和头像多了需要加载更多逻辑

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRvContentFastLib.setLayoutManager(layoutManager);


    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setVisibility(View.GONE);

    }


    @Override
    public BaseQuickAdapter<QueryMarketListResponse.DataBean, BaseViewHolder> getAdapter() {
        mAdapter = new PineConeTransferRecordsAdapter(mContentView);

        return mAdapter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(int page) {
        AuthRepository.getInstance().queryColletRecordList("2024-01-01 00:00:00" ,"2025-01-01 00:00:00" , 1, 10).subscribe(queryMarketListResponse -> {
            if (StringUtils.equals(queryMarketListResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                ToastUtils.showShort("queryColletRecordList成功");
            }
        }, throwable -> {

        });

    }
}

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
import com.aries.smart.module.adapter.WarehouseOrchardAdapter;
import com.aries.smart.module.market.OrchardFragment;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
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
public class WarehouseOrchardFragment extends FastTitleRefreshLoadFragment<QueryMarketListResponse.DataBean> {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    private BaseQuickAdapter mAdapter;
    //生效中的list
    List<QueryMarketListResponse.DataBean> mInEffectList = new ArrayList<>();

    private String mType = ApiConstant.API_HAMSTER_MARKET_TYPE_001;

    public static WarehouseOrchardFragment getInstance(String type) {
        Bundle args = new Bundle();
        WarehouseOrchardFragment fragment = new WarehouseOrchardFragment();
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
        return R.layout.fragment_warehouse_orchard;
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
        mAdapter = new WarehouseOrchardAdapter(mContentView);

        return mAdapter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(int page) {
        AuthRepository.getInstance().queryMarketList(mType).subscribe(queryMarketListResponse -> {
            if (StringUtils.equals(queryMarketListResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {

                //筛选生效中的
                mInEffectList.clear();

                for (QueryMarketListResponse.DataBean bean : queryMarketListResponse.getData()) {
                    if (StringUtils.equals(bean.getGoodsStatue(), ApiConstant.GOODS_STATUE_TYPE_005)) {
                        mInEffectList.add(bean);
                    }
                }

                //按照剩余天数升序排列
                Collections.sort(mInEffectList, new Comparator<QueryMarketListResponse.DataBean>() {
                    @Override
                    public int compare(QueryMarketListResponse.DataBean dataBean, QueryMarketListResponse.DataBean t1) {
                        return dataBean.getTimeLimit() - t1.getTimeLimit();
                    }
                });

                LogUtils.d(mInEffectList);
                FastManager
                        .getInstance()
                        .getHttpRequestControl()
                        .httpRequestSuccess(getIHttpRequestControl(),
                                queryMarketListResponse.getData() == null ? new ArrayList<>() : mInEffectList,
                                null);
            }
        }, throwable -> {

        });

    }
}

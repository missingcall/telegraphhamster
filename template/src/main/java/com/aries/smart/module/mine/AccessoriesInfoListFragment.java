package com.aries.smart.module.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;


import com.aries.library.fast.FastManager;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.retrofit.FastObserver;
import com.aries.smart.R;
import com.aries.smart.module.adapter.AccessoriesRecordsAdapter;
import com.aries.smart.module.entity.AccessoriesInfoListResponse;
import com.aries.smart.module.entity.RecordsResponse;
import com.aries.smart.retrofit.repository.AccessoriesRepository;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class AccessoriesInfoListFragment extends FastTitleRefreshLoadFragment<RecordsResponse> {
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.guideline_horizontal)
    Guideline mGuidelineHorizontal;
    @BindView(R.id.guideline_vertical)
    Guideline mGuidelineVertical;
    @BindView(R.id.iv_image_display)
    ImageView mIvImageDisplay;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_describe)
    TextView mTvDescribe;
    @BindView(R.id.tv_unlock_cost)
    TextView mTvUnlockCost;
    @BindView(R.id.btn_unlock)
    Button mBtnUnlock;
    @BindView(R.id.ll_describe)
    LinearLayout mLlDescribe;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;

    private BaseQuickAdapter mAdapter;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_skin;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
/*        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //获取最后一个可见view的位置
                LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                int lastPosition = linearManager.findLastVisibleItemPosition();
                // 如果滑动到倒数第三条数据，就自动加载下一页数据
                if (lastPosition >= layoutManager.getItemCount() - 5) {
                    onLoadMore();
                }

            }
        });*/
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {

    }

    @OnClick({R.id.btn_unlock})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_unlock:

                break;
        }
    }

    @Override
    public void onItemClicked(BaseQuickAdapter<RecordsResponse, BaseViewHolder> adapter, View view, int position) {
        super.onItemClicked(adapter, view, position);
        ToastUtils.showShort("点击了 position " + position);
    }

    @Override
    public BaseQuickAdapter<RecordsResponse, BaseViewHolder> getAdapter() {
        mAdapter = new AccessoriesRecordsAdapter();
        return mAdapter;
    }

    @Override
    public void loadData(int page) {
        AccessoriesInfoListTo accessoriesInfoListTo = new AccessoriesInfoListTo();
        accessoriesInfoListTo.setPageNum(page * mDefaultPage);
        accessoriesInfoListTo.setPageSize(mDefaultPageSize);
        accessoriesInfoListTo.setType("001");

        mDefaultPageSize = 10;
        AccessoriesRepository.getInstance().infoList(accessoriesInfoListTo)
                .subscribe(new FastObserver<AccessoriesInfoListResponse>(getIHttpRequestControl()) {
                    @Override
                    public void _onNext(AccessoriesInfoListResponse entity) {
                        mStatusManager.showSuccessLayout();
                        FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), entity == null || entity.getRecords() == null ? new ArrayList<>() : entity.getRecords(), null);
                    }
                });
    }

}

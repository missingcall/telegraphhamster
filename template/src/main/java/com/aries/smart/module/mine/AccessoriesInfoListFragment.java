package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
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
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.retrofit.FastObserver;
import com.aries.smart.R;
import com.aries.smart.module.adapter.AccessoriesRecordsAdapter;
import com.aries.smart.module.entity.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.repository.AccessoriesRepository;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人形象页面
 */
public class AccessoriesInfoListFragment extends FastTitleRefreshLoadFragment<AccessoriesInfoListResponse.DataBean.RecordsBean> {
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
        return R.layout.fragment_accessories_info;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //TODO yhd 皮肤和头像多了需要加载更多逻辑
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

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRvContentFastLib.setLayoutManager(layoutManager);

        //TODO yhd unlockMethod unlockParameters 购买
        SpannableString spannableString = new SpannableString("解锁花费 200");
        ImageSpan image = new ImageSpan(getActivity(), R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableString.setSpan(image, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvUnlockCost.setText(spannableString);
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
    public void onItemClicked(BaseQuickAdapter<AccessoriesInfoListResponse.DataBean.RecordsBean, BaseViewHolder> adapter, View view, int position) {
        super.onItemClicked(adapter, view, position);
        ToastUtils.showShort("点击了 position " + position);
    }

    @Override
    public BaseQuickAdapter<AccessoriesInfoListResponse.DataBean.RecordsBean, BaseViewHolder> getAdapter() {
        mAdapter = new AccessoriesRecordsAdapter();
        return mAdapter;
    }

    @SuppressLint("CheckResult")
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
                        LogUtils.d(entity);
                        LogUtils.d(entity.getData().getRecords());
                        mStatusManager.showSuccessLayout();
                        //测试数据
                        entity.getData().getRecords().addAll(entity.getData().getRecords());
                        entity.getData().getRecords().addAll(entity.getData().getRecords());
                        FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), entity == null || entity.getData().getRecords() == null ? new ArrayList<>() : entity.getData().getRecords(), null);
                    }
                });

/*        AccessoriesRepository.getInstance().infoList(accessoriesInfoListTo).subscribe(accessoriesInfoListResponse -> {
            mStatusManager.showSuccessLayout();
            LogUtils.d(accessoriesInfoListResponse);
            LogUtils.d(accessoriesInfoListResponse.getData().getRecords());
        },throwable -> {
            ToastUtils.showShort("失败");
        });*/
    }

}

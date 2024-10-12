package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aries.library.fast.FastManager;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.retrofit.FastObserver;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.adapter.PineConeTransferRecordsAdapter;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.response.QueryColletRecordListResponse;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.github.gzuliyujiang.calendarpicker.CalendarPicker;
import com.github.gzuliyujiang.calendarpicker.OnRangeDatePickListener;
import com.github.gzuliyujiang.calendarpicker.OnSingleDatePickListener;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.trello.rxlifecycle3.android.FragmentEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的仓库-仓鼠果园/松果银行 页面
 */
public class PineConeTransferRecordsFragment extends FastTitleRefreshLoadFragment<QueryColletRecordListResponse.DataBean> {

    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    @BindView(R.id.btn_date_start)
    Button mBtnDateStart;
    @BindView(R.id.btn_date_end)
    Button mBtnDateEnd;
    @BindView(R.id.btn_date_select)
    Button mBtnDateSelect;
    private BaseQuickAdapter mAdapter;
    //生效中的list
    List<QueryMarketListResponse.DataBean> mInEffectList = new ArrayList<>();

    private String mType = ApiConstant.API_HAMSTER_MARKET_RECORD_LIST_TYPE_ALL;
    private long mStartTimeLong;
    private long mEndTimeLong;
    private String mStartTime;
    private String mEndTime;

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRvContentFastLib.setLayoutManager(layoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        });
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setVisibility(View.GONE);

    }


    @Override
    public BaseQuickAdapter<QueryColletRecordListResponse.DataBean, BaseViewHolder> getAdapter() {
        mAdapter = new PineConeTransferRecordsAdapter(mContentView);

        return mAdapter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(int page) {
        AuthRepository.getInstance().queryColletRecordList(mStartTime, mEndTime, page, 10)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new FastObserver<QueryColletRecordListResponse>(getIHttpRequestControl()) {
                    @Override
                    public void _onNext(QueryColletRecordListResponse queryColletRecordListResponse) {
                        if (StringUtils.equals(queryColletRecordListResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                            mStatusManager.showSuccessLayout();
                            //假数据
                            queryColletRecordListResponse.getData().getRecords().addAll(queryColletRecordListResponse.getData().getRecords());
                            queryColletRecordListResponse.getData().getRecords().addAll(queryColletRecordListResponse.getData().getRecords());
                            queryColletRecordListResponse.getData().getRecords().addAll(queryColletRecordListResponse.getData().getRecords());
                            queryColletRecordListResponse.getData().getRecords().addAll(queryColletRecordListResponse.getData().getRecords());
                            queryColletRecordListResponse.getData().getRecords().addAll(queryColletRecordListResponse.getData().getRecords());
                            queryColletRecordListResponse.getData().getRecords().addAll(queryColletRecordListResponse.getData().getRecords());
                            FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), queryColletRecordListResponse.getData().getRecords() == null ? new ArrayList<>() : queryColletRecordListResponse.getData().getRecords(), null);
                        }
                    }
                });
    }

    @OnClick({R.id.btn_date_start, R.id.btn_date_end, R.id.btn_date_select})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_date_end:
            case R.id.btn_date_start:
                CalendarPicker picker = new CalendarPicker(getActivity());
                //默认前后一年
//                picker.setRangeDate(TimeUtils.string2Date(ApiConstant.DATE_START_TIME) , TimeUtils.string2Date(ApiConstant.DATE_END_TIME));
                if (mStartTimeLong == 0) {
                    mStartTimeLong = System.currentTimeMillis();
                }
                picker.setSelectedDate(mStartTimeLong);
                picker.setOnSingleDatePickListener(new OnSingleDatePickListener() {
                    @Override
                    public void onSingleDatePicked(@NonNull Date date) {

                    }
                });
                picker.setOnRangeDatePickListener(new OnRangeDatePickListener() {
                    @Override
                    public void onRangeDatePicked(@NonNull Date startDate, @NonNull Date endDate) {
                        android.text.format.DateFormat dateFormat = new android.text.format.DateFormat();
                        mStartTime = dateFormat.format("yyyy-MM-dd HH:mm:ss", startDate).toString();
                        mEndTime = dateFormat.format("yyyy-MM-dd HH:mm:ss", endDate).toString();

                        mBtnDateStart.setText(mStartTime);
                        mBtnDateEnd.setText(mEndTime);
                    }
                });
                picker.show();
                break;

            case R.id.btn_date_select:
                loadData(mDefaultPage);
                break;
        }
    }
}

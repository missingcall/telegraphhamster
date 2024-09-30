package com.aries.smart.module.mine;

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
import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.library.fast.retrofit.FastObserver;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.adapter.AccessoriesRecordsAdapter;
import com.aries.smart.module.widget.dialog.SkinPurchaseDialog;
import com.aries.smart.retrofit.repository.AccessoriesRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.smart.retrofit.request.CurrentlyUseSkinTo;
import com.aries.smart.retrofit.response.AccessoriesInfoListResponse;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AvatarFragment extends FastTitleRefreshLoadFragment<AccessoriesInfoListResponse.DataBean.RecordsBean> {


    public int mUnlockButtonStatus = 0;
    public static int UNLOCK_BUTTON_STATE_UNLOCK_NOW = 0;
    public static int UNLOCK_BUTTON_STATE_UNLOCKED = 1;
    public static int UNLOCK_BUTTON_STATE_USE_NOW = 2;
    public static int UNLOCK_BUTTON_STATE_ALREADY_USED = 3;

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

    public int mPosition;
    AccessoriesInfoListResponse.DataBean.RecordsBean mRecordsBean;


    @Override
    public int getContentLayout() {
        return R.layout.fragment_avatar;
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        //TODO yhd 皮肤和头像多了需要加载更多逻辑

        getInfoList(mDefaultPage);

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
        titleBar.setStatusBarLightMode(false);

    }

    @SuppressLint("CheckResult")
    @OnClick({R.id.btn_unlock})
    void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.btn_unlock:

                if (StringUtils.equals(mBtnUnlock.getText(), "立即解锁")) {
                    //（2）点击【购买】按钮，将底部拉起购买确认弹窗，
                    // 在弹窗中需要展示皮肤、昵称、说明，点击【购买】按钮需要判断用户持有的松果是否大于消耗的松果数量，
                    // 若用户持有的松果数量小于消耗数量，则toast提示“松果不足”，反之toast提示“购买成功”并关闭底部弹窗
                    SkinPurchaseDialog skinPurchaseDialog = new SkinPurchaseDialog(getActivity() ,mRecordsBean);
                    skinPurchaseDialog.show();

                } else if (StringUtils.equals(mBtnUnlock.getText(), "立即使用")) {
                    //设置当前显示头像
                    CurrentlyUseSkinTo currentlyUseSkinTo = new CurrentlyUseSkinTo();
                    currentlyUseSkinTo.setType("002");
                    AccessoriesRepository.getInstance().currentlyUseSkin(currentlyUseSkinTo).subscribe(currentlyUseSkinResponse -> {
                        if (StringUtils.equals(currentlyUseSkinResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                            //使用成功 刷新列表 同时设置左边状态
                            ToastUtils.showShort("使用成功");
                            mBtnUnlock.setText("已使用");
                            mBtnUnlock.setEnabled(false);

                            loadData(mDefaultPage);
//                            mRecyclerView.smoothScrollToPosition(mPosition);
                            LogUtils.d(currentlyUseSkinResponse);
                        }
                    }, throwable -> {

                    });
                }
                break;
        }
    }

    @Override
    public void onItemClicked(BaseQuickAdapter<AccessoriesInfoListResponse.DataBean.RecordsBean, BaseViewHolder> adapter, View view, int position) {
        super.onItemClicked(adapter, view, position);
        //记录当前点击信息
        mPosition = position;
        ToastUtils.showShort(mPosition);
        //点击右边列表左边显示具体信息
        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean = (AccessoriesInfoListResponse.DataBean.RecordsBean) adapter.getData().get(position);
        //显示点击选中的皮肤
        GlideManager.loadCircleImg(recordsBean.getIcon(), mIvImageDisplay);
        mTvName.setText(recordsBean.getName());
        mTvDescribe.setText(recordsBean.getRemark());

        if (recordsBean.isUnlockStatus()) {
            //已解锁
            mTvUnlockCost.setText("已解锁");
            mTvUnlockCost.setTextColor(getResources().getColor(R.color.green_light));
            //是否佩戴
            if (recordsBean.isWearStatus()) {
                //已佩戴
                mBtnUnlock.setText("已使用");
                mBtnUnlock.setEnabled(false);
            } else {
                mBtnUnlock.setText("立即使用");
                mBtnUnlock.setEnabled(true);
            }

        } else {
            //未解锁
            mTvUnlockCost.setTextColor(getResources().getColor(R.color.red));
            //解锁方式为购买 则显示解锁参数 这里解锁只会花费松果
            if (StringUtils.equals(recordsBean.getUnlockMethod(), "001")) {
                SpannableString spannableString = new SpannableString("解锁花费 " + recordsBean.getUnlockParameters().toString());
                ImageSpan image = new ImageSpan(getActivity(), R.drawable.unlock_pinecone, DynamicDrawableSpan.ALIGN_BOTTOM);
                spannableString.setSpan(image, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mTvUnlockCost.setText(spannableString);
                mBtnUnlock.setText("立即解锁");
                mBtnUnlock.setEnabled(true);
            } else {
                //	解锁方式（001 购买 002 成就 003 升级） 如果是成就和升级 则显示解锁参数
                mTvUnlockCost.setText(recordsBean.getUnlockParameters().toString());
                mBtnUnlock.setText("立即解锁");
                mBtnUnlock.setEnabled(true);
            }
        }


    }

    @Override
    public BaseQuickAdapter<AccessoriesInfoListResponse.DataBean.RecordsBean, BaseViewHolder> getAdapter() {

        mAdapter = new AccessoriesRecordsAdapter();
        return mAdapter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(int page) {

        //重新请求接口刷新列表数据
        AccessoriesInfoListTo accessoriesInfoListTo = new AccessoriesInfoListTo();
        accessoriesInfoListTo.setPageNum(page * mDefaultPage);
        accessoriesInfoListTo.setPageSize(mDefaultPageSize);
        accessoriesInfoListTo.setType("002");

        AccessoriesRepository.getInstance().infoList(accessoriesInfoListTo)
                .subscribe(accessoriesInfoListResponse -> {
                    if (StringUtils.equals(accessoriesInfoListResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {
                        //测试数据
                        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean1 = new AccessoriesInfoListResponse.DataBean.RecordsBean();
                        recordsBean1.setIcon("https://fastly.picsum.photos/id/562/200/200.jpg?hmac=F4ylYRNFPH6rDzYo48_NUieJXXI2yaMl9ElwGeFQHZo");
                        recordsBean1.setName("test1");
                        recordsBean1.setType("002");
                        recordsBean1.setUnlockMethod("001");
                        recordsBean1.setUnlockStatus(false);
                        recordsBean1.setWearStatus(false);
                        recordsBean1.setUnlockParameters("2000");
                        recordsBean1.setRemark("miaoshu1miaoshu1miaoshu1miaoshu1miaoshu1miaoshu1miaoshu1");


                        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean2 = new AccessoriesInfoListResponse.DataBean.RecordsBean();
                        recordsBean2.setIcon("https://fastly.picsum.photos/id/452/200/200.jpg?hmac=f5vORXpRW2GF7jaYrCkzX3EwDowO7OXgUaVYM2NNRXY");
                        recordsBean2.setName("test2");
                        recordsBean2.setType("002");
                        recordsBean2.setUnlockMethod("002");
                        recordsBean2.setUnlockStatus(true);
                        recordsBean2.setWearStatus(false);
                        recordsBean2.setUnlockParameters("3000");
                        recordsBean2.setRemark("miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2");


                        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean3 = new AccessoriesInfoListResponse.DataBean.RecordsBean();
                        recordsBean3.setIcon("https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");
                        recordsBean3.setName("test3");
                        recordsBean3.setType("002");
                        recordsBean3.setUnlockMethod("003");
                        recordsBean3.setUnlockStatus(true);
                        recordsBean3.setWearStatus(true);
                        recordsBean3.setUnlockParameters("4000");
                        recordsBean3.setRemark("miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3");


                        List<AccessoriesInfoListResponse.DataBean.RecordsBean> list = new ArrayList<>();
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);

                        accessoriesInfoListResponse.getData().getRecords().addAll(list);

                        mAdapter.setList(accessoriesInfoListResponse.getData().getRecords());
                        mAdapter.notifyDataSetChanged();
                    }
                }, throwable -> {

                });

    }

    //第一次请求
    private void getInfoList(int page) {
        AccessoriesInfoListTo accessoriesInfoListTo = new AccessoriesInfoListTo();
        accessoriesInfoListTo.setPageNum(page * mDefaultPage);
        accessoriesInfoListTo.setPageSize(mDefaultPageSize);
        accessoriesInfoListTo.setType("002");

        mDefaultPageSize = 10;
        AccessoriesRepository.getInstance().infoList(accessoriesInfoListTo)
                .subscribe(new FastObserver<AccessoriesInfoListResponse>(getIHttpRequestControl()) {
                    @Override
                    public void _onError(Throwable e) {
                        //TODO yhd 测试数据
                        ToastUtils.showShort("获取数据失败");
                        mStatusManager.showSuccessLayout();
                    }

                    @Override
                    public void _onNext(AccessoriesInfoListResponse entity) {

                        mStatusManager.showSuccessLayout();
                        //测试数据
                        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean1 = new AccessoriesInfoListResponse.DataBean.RecordsBean();
                        recordsBean1.setIcon("https://fastly.picsum.photos/id/562/200/200.jpg?hmac=F4ylYRNFPH6rDzYo48_NUieJXXI2yaMl9ElwGeFQHZo");
                        recordsBean1.setName("test1");
                        recordsBean1.setType("002");
                        recordsBean1.setUnlockMethod("001");
                        recordsBean1.setUnlockStatus(false);
                        recordsBean1.setWearStatus(false);
                        recordsBean1.setUnlockParameters("2000");
                        recordsBean1.setRemark("miaoshu1miaoshu1miaoshu1miaoshu1miaoshu1miaoshu1miaoshu1");


                        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean2 = new AccessoriesInfoListResponse.DataBean.RecordsBean();
                        recordsBean2.setIcon("https://fastly.picsum.photos/id/452/200/200.jpg?hmac=f5vORXpRW2GF7jaYrCkzX3EwDowO7OXgUaVYM2NNRXY");
                        recordsBean2.setName("test2");
                        recordsBean2.setType("002");
                        recordsBean2.setUnlockMethod("002");
                        recordsBean2.setUnlockStatus(true);
                        recordsBean2.setWearStatus(false);
                        recordsBean2.setUnlockParameters("3000");
                        recordsBean2.setRemark("miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2miaoshu2");


                        AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean3 = new AccessoriesInfoListResponse.DataBean.RecordsBean();
                        recordsBean3.setIcon("https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");
                        recordsBean3.setName("test3");
                        recordsBean3.setType("002");
                        recordsBean3.setUnlockMethod("003");
                        recordsBean3.setUnlockStatus(true);
                        recordsBean3.setWearStatus(true);
                        recordsBean3.setUnlockParameters("4000");
                        recordsBean3.setRemark("miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3miaoshu3");


                        List<AccessoriesInfoListResponse.DataBean.RecordsBean> list = new ArrayList<>();
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);
                        list.add(recordsBean1);
                        list.add(recordsBean2);
                        list.add(recordsBean3);

                        entity.getData().getRecords().addAll(list);

                        LogUtils.d("entity : " + entity);
                        LogUtils.d("getRecords : " + entity.getData().getRecords());




                        FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), entity == null || entity.getData().getRecords() == null ? new ArrayList<>() : entity.getData().getRecords(), null);

                        //设置当前皮肤
                        for (AccessoriesInfoListResponse.DataBean.RecordsBean recordsBean : entity.getData().getRecords()) {
                            //当前为佩戴状态
                            if (recordsBean.isWearStatus()) {
                                GlideManager.loadCircleImg(recordsBean.getIcon(), mIvImageDisplay);
                            }
                        }
                    }
                });
    }

}

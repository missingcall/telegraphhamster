package com.aries.smart.module.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.allen.library.SuperTextView;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.smart.R;
import com.aries.smart.module.adapter.SkinAvatarAdapter;
import com.aries.smart.module.adapter.AchievementDisplayAdapter;
import com.aries.smart.module.entity.AchievementDisplayEntity;
import com.aries.smart.module.mine.AvatarFragment;
import com.aries.smart.module.mine.AccessoriesInfoListFragment;
import com.aries.smart.utils.TitleBarViewHelper;
import com.aries.ui.view.tab.SegmentTabLayout;
import com.aries.ui.view.tab.listener.OnTabSelectListener;
import com.aries.ui.view.title.TitleBarView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**

 * Function:
 * Description:个人形象
 */
public class PersonalImageFragment extends FastTitleRefreshLoadFragment<AchievementDisplayEntity> {

    List<AchievementDisplayEntity> list = new ArrayList<>();
    @BindView(R.id.titleBar_headFastLib)
    TitleBarView mTitleBarHeadFastLib;
    @BindView(R.id.stv_person_info)
    SuperTextView mStvPersonInfo;
    @BindView(R.id.stv_achievement)
    SuperTextView mStvAchievement;
    @BindView(R.id.rv_contentFastLib)
    RecyclerView mRvContentFastLib;
    @BindView(R.id.smartLayout_rootFastLib)
    SmartRefreshLayout mSmartLayoutRootFastLib;
    @BindView(R.id.ll_achievement)
    LinearLayout mLlAchievement;
    @BindView(R.id.tv_skin_avatar)
    TextView mTvSkinAvatar;
    @BindView(R.id.stl_skin_avatar)
    SegmentTabLayout mStlSkinAvatar;
    @BindView(R.id.ll_avatar_skin)
    LinearLayout mLlAvatarSkin;
    @BindView(R.id.vp_contentFastLib)
    ViewPager mVpContentFastLib;


    private TitleBarViewHelper mTitleBarViewHelper;

    private String[] mTitles = {"皮肤", "头像"};
    private Fragment[] fragments;

    public static PersonalImageFragment newInstance() {
        Bundle args = new Bundle();
        PersonalImageFragment fragment = new PersonalImageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.personal_image)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_personal_image;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        mRecyclerView.setLayoutManager(layoutManager);

        mTitleBarViewHelper = new TitleBarViewHelper(mContext)
                .setTitleBarView(mTitleBar)
                .setRecyclerView(mRecyclerView)
                .setMinHeight(0);

        fragments = new Fragment[mTitles.length];
        fragments[0] = new AccessoriesInfoListFragment();
        fragments[1] = new AvatarFragment();

        SkinAvatarAdapter skinAvatarAdapter = new SkinAvatarAdapter(getChildFragmentManager(), fragments, mTitles, getActivity());
        mVpContentFastLib.setAdapter(skinAvatarAdapter);

        mStlSkinAvatar.setTabData(mTitles);
        mStlSkinAvatar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //切换文字 , 改变下面fragment页面
                if (position == 0) {
                    mTvSkinAvatar.setText(R.string.skin);

                } else {
                    mTvSkinAvatar.setText(R.string.avatar);

                }
                mVpContentFastLib.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mStatusManager.showSuccessLayout();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTitleBarViewHelper != null) {
            mTitleBarViewHelper.onDestroy();
        }
    }

    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        //Fragment 可见性变化回调


    }

    @Override
    public boolean isLoadMoreEnable() {
        return false;
    }

    @Override
    public boolean isRefreshEnable() {
        return false;
    }


    private BaseQuickAdapter mAdapter;

    @Override
    public BaseQuickAdapter getAdapter() {
        mAdapter = new AchievementDisplayAdapter();
        return mAdapter;
    }

    @Override
    public void loadData(int page) {
        AchievementDisplayEntity achievementDisplayEntity1 = new AchievementDisplayEntity(true, "最佳新人1", "https://fastly.picsum.photos/id/452/200/200.jpg?hmac=f5vORXpRW2GF7jaYrCkzX3EwDowO7OXgUaVYM2NNRXY");
        AchievementDisplayEntity achievementDisplayEntity2 = new AchievementDisplayEntity(false, "最佳新人2", "https://fastly.picsum.photos/id/562/200/200.jpg?hmac=F4ylYRNFPH6rDzYo48_NUieJXXI2yaMl9ElwGeFQHZo");
        AchievementDisplayEntity achievementDisplayEntity3 = new AchievementDisplayEntity(true, "最佳新人3", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");
        AchievementDisplayEntity achievementDisplayEntity4 = new AchievementDisplayEntity(true, "最佳新人3", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");


        list.add(achievementDisplayEntity1);
        list.add(achievementDisplayEntity2);
        list.add(achievementDisplayEntity3);
        list.add(achievementDisplayEntity4);

        mAdapter.addData(list);
        mStatusManager.showSuccessLayout();

        //TODO yhd 成就接口待替换 要重新写一下list 最多加4个
/*        RxJavaManager.getInstance().getDelayObservable(list, 2, TimeUnit.MILLISECONDS)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new FastObserver<List<WidgetEntity>>() {
                    @Override
                    public void _onNext(List<WidgetEntity> entity) {
                        FastManager.getInstance().getHttpRequestControl().httpRequestSuccess(getIHttpRequestControl(), entity, null);
                    }
                });*/
    }
}

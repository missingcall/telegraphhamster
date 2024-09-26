package com.aries.smart.module.game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.library.fast.module.fragment.FastTitleRefreshLoadFragment;
import com.aries.smart.R;
import com.aries.smart.module.adapter.GameCenterAdapter;
import com.aries.smart.module.adapter.QuickJumpAdapter;
import com.aries.smart.retrofit.response.GameCenterResponse;
import com.aries.ui.view.title.TitleBarView;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AriesHoo on 2018/8/10 12:22
 * @E-Mail: AriesHoo@126.com
 * Function: 主页演示
 * Description:
 */
public class GameFragment extends FastTitleRefreshLoadFragment<GameCenterResponse> {

    protected final static String LENOVO_PACKAGE_NAME = "com.lenovo.browser.hd";
    protected final static String GOOGLE_PACKAGE_NAME = "com.android.chrome";
    private BaseQuickAdapter mAdapter;
    List<GameCenterResponse> list = new ArrayList<>();

    public static GameFragment newInstance() {
        Bundle args = new Bundle();
        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar
//                .setLeftTextDrawable(R.drawable.btn_left_white_m)
                .setTitleMainText(R.string.game_center)
                .setTitleMainTextColor(Color.WHITE)
                .setBgColor(0)
                .setStatusBarLightMode(false)
                .setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_game;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        //Fragment 可见性变化回调


    }

    public boolean isAppInstall(String packageName) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
        return launchIntent != null;
    }


    @Override
    public BaseQuickAdapter getAdapter() {
        mAdapter = new GameCenterAdapter();
        return mAdapter;
    }

    @Override
    public void loadData(int page) {
        //刷新游戏接口重新获取游戏

        GameCenterResponse achievementDisplayEntity1 = new GameCenterResponse(true, "游戏1", "");
        GameCenterResponse achievementDisplayEntity2 = new GameCenterResponse(false, "游戏2", "https://fastly.picsum.photos/id/562/200/200.jpg?hmac=F4ylYRNFPH6rDzYo48_NUieJXXI2yaMl9ElwGeFQHZo");
        GameCenterResponse achievementDisplayEntity3 = new GameCenterResponse(true, "游戏3", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");
        GameCenterResponse achievementDisplayEntity4 = new GameCenterResponse(true, "游戏4", "https://fastly.picsum.photos/id/668/200/200.jpg?hmac=mVqr1fc4nHFre2QMZp5cuqUKLIRSafUtWt2vwlA9jG0");


        list.add(achievementDisplayEntity1);
        list.add(achievementDisplayEntity2);
        list.add(achievementDisplayEntity3);
        list.add(achievementDisplayEntity4);

        mAdapter.addData(list);
        mStatusManager.showSuccessLayout();
    }
}

package com.aries.smart.module.mine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;
import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.repository.AuthRepository;
import com.aries.smart.retrofit.repository.BaseRepository;
import com.aries.ui.view.title.TitleBarView;
import com.blankj.utilcode.util.StringUtils;

public class RankActivity extends FastTitleActivity {

    @Override
    public int getContentLayout() {
        return R.layout.activity_rank;
    }

    @SuppressLint("CheckResult")
    @Override
    public void initView(Bundle savedInstanceState) {
        //获取当前用户排行
        AuthRepository.getInstance().getLevelRank().subscribe(getLevelRankResponse -> {
            if (StringUtils.equals(getLevelRankResponse.getResponseCode(), ApiConstant.RESPONSE_OK)) {


            }
        }, throwable -> {

        });
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {

    }
}

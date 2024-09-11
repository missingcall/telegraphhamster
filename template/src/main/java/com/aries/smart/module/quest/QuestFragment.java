package com.aries.smart.module.quest;

import android.graphics.Color;
import android.os.Bundle;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.smart.R;
import com.aries.ui.view.title.TitleBarView;

/**
 * @Author: AriesHoo on 2018/7/13 17:09
 * @E-Mail: AriesHoo@126.com
 * @Function: 我的
 * @Description:
 */
public class QuestFragment extends FastTitleFragment {

    public static QuestFragment newInstance() {
        Bundle args = new Bundle();
        QuestFragment fragment = new QuestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setBgColor(Color.WHITE)
                .setTitleMainText(R.string.mine);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
    }

    @Override
    protected void onVisibleChanged(boolean isVisibleToUser) {
        super.onVisibleChanged(isVisibleToUser);
        //Fragment 可见性变化回调
    }
}

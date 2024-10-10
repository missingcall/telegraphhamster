package com.aries.smart;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;

import com.aries.library.fast.entity.FastTabEntity;
import com.aries.library.fast.manager.LoggerManager;
import com.aries.library.fast.module.activity.FastMainActivity;
import com.aries.library.fast.util.FastUtil;
import com.aries.library.fast.util.SizeUtil;
import com.aries.smart.constant.ConstantUtils;
import com.aries.smart.constant.Event;
import com.aries.smart.module.game.GameFragment;
import com.aries.smart.module.login.LoginActivity;
import com.aries.smart.module.main.HomeFragment;

import com.aries.smart.module.market.MarketFragment;
import com.aries.smart.module.mine.MineFragment;
import com.aries.smart.module.quest.QuestFragment;
import com.aries.ui.view.tab.CommonTabLayout;
import com.blankj.utilcode.util.SPUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Function: 主页面
 * Description:
 */
public class MainActivity extends FastMainActivity {

    @BindView(R.id.tabLayout_commonFastLib)
    CommonTabLayout mTabLayout;
    private ArrayList<FastTabEntity> mTabEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean isSwipeEnable() {
        return false;
    }

    @Override
    public List<FastTabEntity> getTabList() {
        mTabEntities = new ArrayList<>();
        //图文分开
//        mTabEntities.add(new FastTabEntity(R.string.home, R.drawable.tab_main_default, R.drawable.tab_main_selected, HomeFragment.newInstance()));
//        mTabEntities.add(new FastTabEntity(R.string.market, R.drawable.tab_market_default, R.drawable.tab_market_selected, MineFragment.newInstance()));
//        mTabEntities.add(new FastTabEntity(R.string.game, R.drawable.tab_game_default, R.drawable.tab_game_selected, MineFragment.newInstance()));
//        mTabEntities.add(new FastTabEntity(R.string.quest, R.drawable.tab_quest_default, R.drawable.tab_quest_selected, MineFragment.newInstance()));
//        mTabEntities.add(new FastTabEntity(R.string.mine, R.drawable.tab_mine_default, R.drawable.tab_mine_selected, MineFragment.newInstance()));
        //图文合并
        mTabEntities.add(new FastTabEntity(R.drawable.tab_main_unselected, R.drawable.tab_main_selected, HomeFragment.newInstance()));
        mTabEntities.add(new FastTabEntity(R.drawable.tab_market_unselected, R.drawable.tab_market_selected, MarketFragment.newInstance()));
        mTabEntities.add(new FastTabEntity(R.drawable.tab_game_unselected, R.drawable.tab_game_selected, GameFragment.newInstance()));
        mTabEntities.add(new FastTabEntity(R.drawable.tab_quest_unselected, R.drawable.tab_quest_selected, QuestFragment.newInstance()));
        mTabEntities.add(new FastTabEntity(R.drawable.tab_mine_unselected, R.drawable.tab_mine_selected, MineFragment.newInstance()));
        return mTabEntities;
    }

    @Override
    public void setTabLayout(CommonTabLayout tabLayout) {
        tabLayout.setBackgroundColor(getResources().getColor(R.color.tab_main_bg));
        tabLayout.getDelegate().setIconHeight(SizeUtil.dp2px(50));
        tabLayout.getDelegate().setIconWidth(SizeUtil.dp2px(50));
        tabLayout.getDelegate().setIconGravity(Gravity.CENTER);

//        tabLayout.getDelegate().setTextUnSelectColor(getResources().getColor(R.color.tab_text_unselected));
//        tabLayout.getDelegate().setTextSelectColor(getResources().getColor(R.color.tab_text_selected));
//        tabLayout.getDelegate().setTextSize(getResources().getDimension(R.dimen.text_size_micro));
//        tabLayout.getDelegate().setTextSelectSize(getResources().getDimension(R.dimen.text_size_micro));
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTabLayout.getDelegate().setUnderlineHeight(0);
    }

    @Override
    public void onTabSelect(int position) {
        LoggerManager.d("OnTabSelectListener:onTabSelect:" + position);
    }

    @Override
    public void onTabReselect(int position) {
        LoggerManager.d("OnTabSelectListener:onTabReselect:" + position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoggerManager.i(TAG, "onDestroy");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Event.LogOutEvent event) {
        SPUtils.getInstance().remove(ConstantUtils.AUTHORIZATION_TOKEN);
        SPUtils.getInstance().remove(ConstantUtils.TOKEN_HEAD);
        SPUtils.getInstance().remove(ConstantUtils.IS_AGREE_PROTOCOL);
        FastUtil.startActivity(this, LoginActivity.class);
        //退出登录
        finish();
    }

}

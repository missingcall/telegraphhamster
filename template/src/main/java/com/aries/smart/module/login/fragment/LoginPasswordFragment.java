package com.aries.smart.module.login.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.aries.library.fast.module.fragment.FastTitleFragment;
import com.aries.smart.R;
import com.aries.ui.view.title.TitleBarView;

public class LoginPasswordFragment extends FastTitleFragment {

    @Override
    public int getContentLayout() {
        return R.layout.fragment_login_password;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setTitleMainText(R.string.login_password);
    }
}

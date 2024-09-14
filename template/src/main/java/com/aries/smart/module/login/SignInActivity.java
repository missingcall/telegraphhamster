package com.aries.smart.module.login;

import android.os.Bundle;
import android.view.View;

import com.aries.library.fast.module.activity.FastTitleActivity;
import com.aries.smart.R;
import com.aries.smart.module.widget.dialog.LoginDialog;
import com.aries.ui.view.title.TitleBarView;

@Deprecated
public class SignInActivity extends FastTitleActivity {
    @Override
    public int getContentLayout() {
        return R.layout.activity_sign_in;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        /*LoginDialog loginDialog = new LoginDialog(this, R.style.tran_dialog);
        loginDialog.show();*/
    }

    @Override
    public void setTitleBar(TitleBarView titleBar) {
        titleBar.setStatusBarLightMode(false)
                .setVisibility(View.GONE);
    }
}

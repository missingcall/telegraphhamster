package com.aries.smart.module.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aries.smart.retrofit.response.GetMyMoneyBagResponse;

public class WalletModel extends ViewModel {
    private final MutableLiveData<GetMyMoneyBagResponse.DataBean> dataBeanMutableLiveData = new MutableLiveData<GetMyMoneyBagResponse.DataBean>();

    public void setDataBean(GetMyMoneyBagResponse.DataBean moneyBean){
        dataBeanMutableLiveData.setValue(moneyBean);
    }

    public LiveData<GetMyMoneyBagResponse.DataBean> getDataBean() {
        return dataBeanMutableLiveData;
    }
}


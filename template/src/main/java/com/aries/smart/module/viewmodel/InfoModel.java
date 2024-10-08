package com.aries.smart.module.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aries.smart.retrofit.response.GetMyMoneyBagResponse;
import com.aries.smart.retrofit.response.InfoResponse;

public class InfoModel extends ViewModel {
    private final MutableLiveData<InfoResponse.DataBean> dataBeanMutableLiveData = new MutableLiveData<InfoResponse.DataBean>();

    public void setDataBean(InfoResponse.DataBean infoBean){
        dataBeanMutableLiveData.setValue(infoBean);
    }

    public LiveData<InfoResponse.DataBean> getDataBean() {
        return dataBeanMutableLiveData;
    }
}


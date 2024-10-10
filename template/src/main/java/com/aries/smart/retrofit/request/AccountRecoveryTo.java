package com.aries.smart.retrofit.request;

public class AccountRecoveryTo {

    /**
     * mobile :
     * smsCode :
     */

    private String mobile;
    private String smsCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}

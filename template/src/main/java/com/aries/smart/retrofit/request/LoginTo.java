package com.aries.smart.retrofit.request;

public class LoginTo {


    /**
     * accessFlags :
     * appleId :
     * deviceId :
     * machineCode :
     * mobile :
     * smsCode :
     */

    private String accessFlags;
    private String appleId;
    private String deviceId; //三方的 不用传
    private String machineCode;
    private String mobile;
    private String smsCode;

    public String getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(String accessFlags) {
        this.accessFlags = accessFlags;
    }

    public String getAppleId() {
        return appleId;
    }

    public void setAppleId(String appleId) {
        this.appleId = appleId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

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

    @Override
    public String toString() {
        return "LoginTo{" +
                "accessFlags='" + accessFlags + '\'' +
                ", appleId='" + appleId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", machineCode='" + machineCode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';
    }
}

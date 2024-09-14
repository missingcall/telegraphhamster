package com.aries.smart.retrofit.request;

public class AccountCreateTo {

    /**
     * accessFlags :    访问标识 0：代表Android；1：代表IOS；可为空
     * appleId :	    苹果ID
     * inviteCode :     邀请码；用户UID
     * machineCode :	机器码
     * password :	    密码
     * phone :	        手机号
     * smsCode :        短信验证码
     */

    private String accessFlags;
    private String appleId;
    private String inviteCode;
    private String machineCode;
    private String password;
    private String phone;
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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    @Override
    public String toString() {
        return "AccountCreateTo{" +
                "accessFlags='" + accessFlags + '\'' +
                ", appleId='" + appleId + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", machineCode='" + machineCode + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';
    }
}

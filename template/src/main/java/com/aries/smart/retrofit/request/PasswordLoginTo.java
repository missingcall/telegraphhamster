package com.aries.smart.retrofit.request;

public class PasswordLoginTo {

    /**
     * machineCode :
     * mobile :
     * password :
     */

    private String machineCode;
    private String mobile;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PasswordLoginTo{" +
                "machineCode='" + machineCode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

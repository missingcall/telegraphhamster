package com.aries.smart.retrofit.request;

public class ResetUserLoginPasswordTo {

    /**
     * password :
     */

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ResetUserLoginPasswordTo{" +
                "password='" + password + '\'' +
                '}';
    }
}

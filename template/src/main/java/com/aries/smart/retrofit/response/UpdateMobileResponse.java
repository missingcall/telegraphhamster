package com.aries.smart.retrofit.response;

public class UpdateMobileResponse {


    /**
     * data : true
     * responseCode :
     * responseMessage :
     */

    private boolean data;
    private String responseCode;
    private String responseMessage;

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}

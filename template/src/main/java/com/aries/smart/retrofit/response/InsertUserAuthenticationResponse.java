package com.aries.smart.retrofit.response;

public class InsertUserAuthenticationResponse {

    @Override
    public String toString() {
        return "InsertUserAuthenticationResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : true
     */



    private String responseCode;
    private String responseMessage;
    private boolean data;

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

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}

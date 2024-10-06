package com.aries.smart.retrofit.response;

public class QueryWaitPineconeResponse {

    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : 0
     */

    private String responseCode;
    private String responseMessage;
    private int data;

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

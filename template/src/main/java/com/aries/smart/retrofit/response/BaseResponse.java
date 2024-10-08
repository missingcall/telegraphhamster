package com.aries.smart.retrofit.response;

/**
 * @Author: AriesHoo on 2019/7/11 22:00
 * @E-Mail: AriesHoo@126.com
 * @Function:
 * @Description:
 */
public class BaseResponse {
    /**
     *
     * responseCode :   200 OK
     *                  401 Unauthorized
     *                  403 Forbidden
     *                  404 Not Found
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

    @Override
    public String toString() {
        return "BaseResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", data=" + data +
                '}';
    }
}

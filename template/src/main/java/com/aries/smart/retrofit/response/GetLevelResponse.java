package com.aries.smart.retrofit.response;

public class GetLevelResponse {


    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : {"userId":"66ee9fbfe4b06a941df52a20","totalAmount":0,"level":null}
     */

    private String responseCode;
    private String responseMessage;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : 66ee9fbfe4b06a941df52a20
         * totalAmount : 0
         * level : null
         */

        private String userId;
        private int totalAmount;
        private Object level;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Object getLevel() {
            return level;
        }

        public void setLevel(Object level) {
            this.level = level;
        }
    }
}

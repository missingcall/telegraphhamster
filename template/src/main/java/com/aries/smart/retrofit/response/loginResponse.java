package com.aries.smart.retrofit.response;

/**
 * @Author: AriesHoo on 2019/7/11 22:00
 * @E-Mail: AriesHoo@126.com
 * @Function:
 * @Description:
 */
public class LoginResponse {

    /**
     * data : {"accId":"","destroy":true,"destroyDate":"","expiresIn":"","information":true,"loginState":"","netEaseToken":"","newUser":true,"refreshToken":"","token":"","tokenHead":"","userId":""}
     * responseCode :
     * responseMessage :
     */

    private DataBean data;
    private String responseCode;
    private String responseMessage;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    @Override
    public String toString() {
        return "LoginResponse{" +
                "data=" + data +
                ", responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }

    public static class DataBean {
        /**
         * accId :
         * destroy : true
         * destroyDate :
         * expiresIn :
         * information : true
         * loginState :
         * netEaseToken :
         * newUser : true
         * refreshToken :
         * token :
         * tokenHead :
         * userId :
         */

        private String accId;
        private boolean destroy;
        private String destroyDate;
        private String expiresIn;
        private boolean information;
        private String loginState;
        private String netEaseToken;
        private boolean newUser;
        private String refreshToken;
        private String token;
        private String tokenHead;
        private String userId;

        public String getAccId() {
            return accId;
        }

        public void setAccId(String accId) {
            this.accId = accId;
        }

        public boolean isDestroy() {
            return destroy;
        }

        public void setDestroy(boolean destroy) {
            this.destroy = destroy;
        }

        public String getDestroyDate() {
            return destroyDate;
        }

        public void setDestroyDate(String destroyDate) {
            this.destroyDate = destroyDate;
        }

        public String getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
        }

        public boolean isInformation() {
            return information;
        }

        public void setInformation(boolean information) {
            this.information = information;
        }

        public String getLoginState() {
            return loginState;
        }

        public void setLoginState(String loginState) {
            this.loginState = loginState;
        }

        public String getNetEaseToken() {
            return netEaseToken;
        }

        public void setNetEaseToken(String netEaseToken) {
            this.netEaseToken = netEaseToken;
        }

        public boolean isNewUser() {
            return newUser;
        }

        public void setNewUser(boolean newUser) {
            this.newUser = newUser;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTokenHead() {
            return tokenHead;
        }

        public void setTokenHead(String tokenHead) {
            this.tokenHead = tokenHead;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "accId='" + accId + '\'' +
                    ", destroy=" + destroy +
                    ", destroyDate='" + destroyDate + '\'' +
                    ", expiresIn='" + expiresIn + '\'' +
                    ", information=" + information +
                    ", loginState='" + loginState + '\'' +
                    ", netEaseToken='" + netEaseToken + '\'' +
                    ", newUser=" + newUser +
                    ", refreshToken='" + refreshToken + '\'' +
                    ", token='" + token + '\'' +
                    ", tokenHead='" + tokenHead + '\'' +
                    ", userId='" + userId + '\'' +
                    '}';
        }
    }
}

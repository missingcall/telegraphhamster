package com.aries.smart.retrofit.response;

/**
 * @Author: AriesHoo on 2019/7/11 22:00
 * @E-Mail: AriesHoo@126.com
 * @Function:
 * @Description:
 */
public class PasswordLoginResponse {


    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : {"token":"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI3MTE2NjkzNiIsInNjb3BlIjpbImFsbCJdLCJpcCI6bnVsbCwicm9sZXMiOlt7ImF1dGhvcml0eSI6IuWJjeWPsOS8muWRmCJ9XSwiaWQiOiI2NmUyOGNhZmU0YjA0MjMwODg1ZWY1ZmMiLCJwYWNrYWdlTmFtZSI6bnVsbCwiZXhwIjoxNzI2OTA5MjQ2LCJhdXRob3JpdGllcyI6WyLliY3lj7DkvJrlkZgiXSwianRpIjoiNzcyOGIxNDEtNjJmNS00MGIzLTgyNzgtMGU3YWRmNTk3MGM1IiwiY2xpZW50X2lkIjoiZGpzb3VsLWFwcCJ9.Wx48xA3sbC2E6xETKfa7f1cZYUROysU3Sgq8OPLl9lFzyzGQi2dHQftGJKQcPjpCQjAhT3s4y1MVypc1BYUlLB8WcVKsc7tuf82w2VC0Fdb7VBwemLCKNbi4vFEmooo8M78AgS8jsKh2oE725L-3NKSPa_vfp8coeEC34-nDmkc","refreshToken":"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI3MTE2NjkzNiIsInNjb3BlIjpbImFsbCJdLCJpcCI6bnVsbCwicm9sZXMiOlt7ImF1dGhvcml0eSI6IuWJjeWPsOS8muWRmCJ9XSwiYXRpIjoiNzcyOGIxNDEtNjJmNS00MGIzLTgyNzgtMGU3YWRmNTk3MGM1IiwiaWQiOiI2NmUyOGNhZmU0YjA0MjMwODg1ZWY1ZmMiLCJwYWNrYWdlTmFtZSI6bnVsbCwiZXhwIjoxNzI2OTA4MzM2LCJhdXRob3JpdGllcyI6WyLliY3lj7DkvJrlkZgiXSwianRpIjoiMDgzODVmNTEtY2YxNC00Nzg0LWIwMjYtZjA5NmNkZTljNzI3IiwiY2xpZW50X2lkIjoiZGpzb3VsLWFwcCJ9.VVMAktdq2GB3vtwhO4Vkd8dDzpz6FuDYoBHHxvX3ck7BuLb9eBY1O88xk5M78a69SDh0LW7UG13b9j1C0LbgFgDjVjy8GWRH8Ce-cu8jYpYaHYmoWKSgAlB1_jUT-wRvHN5smHyl1eFYljGc44sqCLGbKPJ1ArqQoPSLStSqeGY","tokenHead":"Bearer ","expiresIn":"604799","newUser":false,"netEaseToken":"94824df2f4dd0d7dd0d097f596e351fe","accId":"djs66e28cafe4b04230885ef5fc","information":false,"loginState":null,"userId":"66e28cafe4b04230885ef5fc","destroyDate":null,"destroy":false}
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
         * token : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI3MTE2NjkzNiIsInNjb3BlIjpbImFsbCJdLCJpcCI6bnVsbCwicm9sZXMiOlt7ImF1dGhvcml0eSI6IuWJjeWPsOS8muWRmCJ9XSwiaWQiOiI2NmUyOGNhZmU0YjA0MjMwODg1ZWY1ZmMiLCJwYWNrYWdlTmFtZSI6bnVsbCwiZXhwIjoxNzI2OTA5MjQ2LCJhdXRob3JpdGllcyI6WyLliY3lj7DkvJrlkZgiXSwianRpIjoiNzcyOGIxNDEtNjJmNS00MGIzLTgyNzgtMGU3YWRmNTk3MGM1IiwiY2xpZW50X2lkIjoiZGpzb3VsLWFwcCJ9.Wx48xA3sbC2E6xETKfa7f1cZYUROysU3Sgq8OPLl9lFzyzGQi2dHQftGJKQcPjpCQjAhT3s4y1MVypc1BYUlLB8WcVKsc7tuf82w2VC0Fdb7VBwemLCKNbi4vFEmooo8M78AgS8jsKh2oE725L-3NKSPa_vfp8coeEC34-nDmkc
         * refreshToken : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI3MTE2NjkzNiIsInNjb3BlIjpbImFsbCJdLCJpcCI6bnVsbCwicm9sZXMiOlt7ImF1dGhvcml0eSI6IuWJjeWPsOS8muWRmCJ9XSwiYXRpIjoiNzcyOGIxNDEtNjJmNS00MGIzLTgyNzgtMGU3YWRmNTk3MGM1IiwiaWQiOiI2NmUyOGNhZmU0YjA0MjMwODg1ZWY1ZmMiLCJwYWNrYWdlTmFtZSI6bnVsbCwiZXhwIjoxNzI2OTA4MzM2LCJhdXRob3JpdGllcyI6WyLliY3lj7DkvJrlkZgiXSwianRpIjoiMDgzODVmNTEtY2YxNC00Nzg0LWIwMjYtZjA5NmNkZTljNzI3IiwiY2xpZW50X2lkIjoiZGpzb3VsLWFwcCJ9.VVMAktdq2GB3vtwhO4Vkd8dDzpz6FuDYoBHHxvX3ck7BuLb9eBY1O88xk5M78a69SDh0LW7UG13b9j1C0LbgFgDjVjy8GWRH8Ce-cu8jYpYaHYmoWKSgAlB1_jUT-wRvHN5smHyl1eFYljGc44sqCLGbKPJ1ArqQoPSLStSqeGY
         * tokenHead : Bearer
         * expiresIn : 604799
         * newUser : false
         * netEaseToken : 94824df2f4dd0d7dd0d097f596e351fe
         * accId : djs66e28cafe4b04230885ef5fc
         * information : false
         * loginState : null
         * userId : 66e28cafe4b04230885ef5fc
         * destroyDate : null
         * destroy : false
         */

        private String token;
        private String refreshToken;
        private String tokenHead;
        private String expiresIn;
        private boolean newUser;
        private String netEaseToken;
        private String accId;
        private boolean information;
        private Object loginState;
        private String userId;
        private Object destroyDate;
        private boolean destroy;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getTokenHead() {
            return tokenHead;
        }

        public void setTokenHead(String tokenHead) {
            this.tokenHead = tokenHead;
        }

        public String getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
        }

        public boolean isNewUser() {
            return newUser;
        }

        public void setNewUser(boolean newUser) {
            this.newUser = newUser;
        }

        public String getNetEaseToken() {
            return netEaseToken;
        }

        public void setNetEaseToken(String netEaseToken) {
            this.netEaseToken = netEaseToken;
        }

        public String getAccId() {
            return accId;
        }

        public void setAccId(String accId) {
            this.accId = accId;
        }

        public boolean isInformation() {
            return information;
        }

        public void setInformation(boolean information) {
            this.information = information;
        }

        public Object getLoginState() {
            return loginState;
        }

        public void setLoginState(Object loginState) {
            this.loginState = loginState;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getDestroyDate() {
            return destroyDate;
        }

        public void setDestroyDate(Object destroyDate) {
            this.destroyDate = destroyDate;
        }

        public boolean isDestroy() {
            return destroy;
        }

        public void setDestroy(boolean destroy) {
            this.destroy = destroy;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "token='" + token + '\'' +
                    ", refreshToken='" + refreshToken + '\'' +
                    ", tokenHead='" + tokenHead + '\'' +
                    ", expiresIn='" + expiresIn + '\'' +
                    ", newUser=" + newUser +
                    ", netEaseToken='" + netEaseToken + '\'' +
                    ", accId='" + accId + '\'' +
                    ", information=" + information +
                    ", loginState=" + loginState +
                    ", userId='" + userId + '\'' +
                    ", destroyDate=" + destroyDate +
                    ", destroy=" + destroy +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PasswordLoginResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", data=" + data +
                '}';
    }
}


package com.aries.smart.retrofit.response;

public class GetLevelRankResponse {
    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : {"self":null,"levelConfig":null,"rankList":null}
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
         * self : null
         * levelConfig : null
         * rankList : null
         */

        private Object self;
        private Object levelConfig;
        private Object rankList;

        public Object getSelf() {
            return self;
        }

        public void setSelf(Object self) {
            this.self = self;
        }

        public Object getLevelConfig() {
            return levelConfig;
        }

        public void setLevelConfig(Object levelConfig) {
            this.levelConfig = levelConfig;
        }

        public Object getRankList() {
            return rankList;
        }

        public void setRankList(Object rankList) {
            this.rankList = rankList;
        }
    }
}

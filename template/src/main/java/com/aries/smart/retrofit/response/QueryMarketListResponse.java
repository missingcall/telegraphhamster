package com.aries.smart.retrofit.response;

import java.util.List;

/**

 * @Description:
 */
public class QueryMarketListResponse {

    /**
     * data : [{"coinPrice":0,"commodityIcon":"","commodityInfoId":"","commodityMark":"","commodityName":"","dayIncome":0,"description":"","goodsStatue":"","payType":"","preconditionsId":"","preconditionsName":"","propId":"","timeLimit":0,"totalIncome":0}]
     * responseCode :
     * responseMessage :
     */

    private String responseCode;
    private String responseMessage;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * coinPrice : 0
         * commodityIcon :
         * commodityInfoId :
         * commodityMark :
         * commodityName :
         * dayIncome : 0
         * description :
         * goodsStatue :
         * payType :
         * preconditionsId :
         * preconditionsName :
         * propId :
         * timeLimit : 0
         * totalIncome : 0
         */

        private int coinPrice;
        private String commodityIcon;
        private String commodityInfoId;
        private String commodityMark;
        private String commodityName;
        private int dayIncome;
        private String description;
        private String goodsStatue;
        private String payType;
        private String preconditionsId;
        private String preconditionsName;
        private String propId;
        private int timeLimit;
        private int totalIncome;

        public int getCoinPrice() {
            return coinPrice;
        }

        public void setCoinPrice(int coinPrice) {
            this.coinPrice = coinPrice;
        }

        public String getCommodityIcon() {
            return commodityIcon;
        }

        public void setCommodityIcon(String commodityIcon) {
            this.commodityIcon = commodityIcon;
        }

        public String getCommodityInfoId() {
            return commodityInfoId;
        }

        public void setCommodityInfoId(String commodityInfoId) {
            this.commodityInfoId = commodityInfoId;
        }

        public String getCommodityMark() {
            return commodityMark;
        }

        public void setCommodityMark(String commodityMark) {
            this.commodityMark = commodityMark;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public int getDayIncome() {
            return dayIncome;
        }

        public void setDayIncome(int dayIncome) {
            this.dayIncome = dayIncome;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getGoodsStatue() {
            return goodsStatue;
        }

        public void setGoodsStatue(String goodsStatue) {
            this.goodsStatue = goodsStatue;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPreconditionsId() {
            return preconditionsId;
        }

        public void setPreconditionsId(String preconditionsId) {
            this.preconditionsId = preconditionsId;
        }

        public String getPreconditionsName() {
            return preconditionsName;
        }

        public void setPreconditionsName(String preconditionsName) {
            this.preconditionsName = preconditionsName;
        }

        public String getPropId() {
            return propId;
        }

        public void setPropId(String propId) {
            this.propId = propId;
        }

        public int getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public int getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(int totalIncome) {
            this.totalIncome = totalIncome;
        }
    }
}

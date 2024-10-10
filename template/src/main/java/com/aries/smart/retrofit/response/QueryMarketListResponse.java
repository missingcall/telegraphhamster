package com.aries.smart.retrofit.response;

import java.util.List;

/**

 * @Description:
 */
public class QueryMarketListResponse {

    @Override
    public String toString() {
        return "QueryMarketListResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : [{"commodityInfoId":"9b711e82a4043296d3e1056eb5dad815","commodityName":"银行1","commodityIcon":"https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20240328115613-1727504522001.jpg","timeLimit":1,"dayIncome":0,"totalIncome":1,"payType":"001","coinPrice":1,"goodsStatue":"001","description":"https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20240328115613-1727504525345.jpg","propId":"","commodityMark":"","preconditionsId":"","preconditionsName":"","windInterest":1}]
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "commodityInfoId='" + commodityInfoId + '\'' +
                    ", commodityName='" + commodityName + '\'' +
                    ", commodityIcon='" + commodityIcon + '\'' +
                    ", timeLimit=" + timeLimit +
                    ", dayIncome=" + dayIncome +
                    ", totalIncome=" + totalIncome +
                    ", payType='" + payType + '\'' +
                    ", coinPrice=" + coinPrice +
                    ", goodsStatue='" + goodsStatue + '\'' +
                    ", description='" + description + '\'' +
                    ", propId='" + propId + '\'' +
                    ", commodityMark='" + commodityMark + '\'' +
                    ", preconditionsId='" + preconditionsId + '\'' +
                    ", preconditionsName='" + preconditionsName + '\'' +
                    ", windInterest=" + windInterest +
                    '}';
        }

        /**
         * commodityInfoId : 9b711e82a4043296d3e1056eb5dad815
         * commodityName : 银行1
         * commodityIcon : https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20240328115613-1727504522001.jpg
         * timeLimit : 1
         * dayIncome : 0
         * totalIncome : 1
         * payType : 001
         * coinPrice : 1
         * goodsStatue : 001
         * description : https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20240328115613-1727504525345.jpg
         * propId :
         * commodityMark :
         * preconditionsId :
         * preconditionsName :
         * windInterest : 1
         */



        private String commodityInfoId;
        private String commodityName;
        private String commodityIcon;
        private int timeLimit;
        private int dayIncome;
        private int totalIncome;
        private String payType;
        private int coinPrice;
        private String goodsStatue;
        private String description;
        private String propId;
        private String commodityMark;
        private String preconditionsId;
        private String preconditionsName;
        private int windInterest;

        public String getCommodityInfoId() {
            return commodityInfoId;
        }

        public void setCommodityInfoId(String commodityInfoId) {
            this.commodityInfoId = commodityInfoId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getCommodityIcon() {
            return commodityIcon;
        }

        public void setCommodityIcon(String commodityIcon) {
            this.commodityIcon = commodityIcon;
        }

        public int getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public int getDayIncome() {
            return dayIncome;
        }

        public void setDayIncome(int dayIncome) {
            this.dayIncome = dayIncome;
        }

        public int getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(int totalIncome) {
            this.totalIncome = totalIncome;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public int getCoinPrice() {
            return coinPrice;
        }

        public void setCoinPrice(int coinPrice) {
            this.coinPrice = coinPrice;
        }

        public String getGoodsStatue() {
            return goodsStatue;
        }

        public void setGoodsStatue(String goodsStatue) {
            this.goodsStatue = goodsStatue;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPropId() {
            return propId;
        }

        public void setPropId(String propId) {
            this.propId = propId;
        }

        public String getCommodityMark() {
            return commodityMark;
        }

        public void setCommodityMark(String commodityMark) {
            this.commodityMark = commodityMark;
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

        public int getWindInterest() {
            return windInterest;
        }

        public void setWindInterest(int windInterest) {
            this.windInterest = windInterest;
        }
    }
}

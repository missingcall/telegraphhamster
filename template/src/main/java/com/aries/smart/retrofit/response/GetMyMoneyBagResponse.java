package com.aries.smart.retrofit.response;

/**
 * @Author: AriesHoo on 2019/7/11 22:00
 * @E-Mail: AriesHoo@126.com
 * @Function:
 * @Description:
 */
public class GetMyMoneyBagResponse {

    /**
     * data : {"accountBalance":0,"coin":0,"diamond":0,"identity":"","integral":0,"isBindAliPay":true,"isBindBankCard":true}
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
        return "GetMyMoneyBagResponse{" +
                "data=" + data +
                ", responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }

    public static class DataBean {
        /**
         * accountBalance : 0
         * coin : 0
         * diamond : 0
         * identity :
         * integral : 0
         * isBindAliPay : true
         * isBindBankCard : true
         */

        private int accountBalance;
        private int coin;
        private int diamond;
        private String identity;
        private int integral;
        private boolean isBindAliPay;
        private boolean isBindBankCard;

        public int getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(int accountBalance) {
            this.accountBalance = accountBalance;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getDiamond() {
            return diamond;
        }

        public void setDiamond(int diamond) {
            this.diamond = diamond;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public boolean isIsBindAliPay() {
            return isBindAliPay;
        }

        public void setIsBindAliPay(boolean isBindAliPay) {
            this.isBindAliPay = isBindAliPay;
        }

        public boolean isIsBindBankCard() {
            return isBindBankCard;
        }

        public void setIsBindBankCard(boolean isBindBankCard) {
            this.isBindBankCard = isBindBankCard;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "accountBalance=" + accountBalance +
                    ", coin=" + coin +
                    ", diamond=" + diamond +
                    ", identity='" + identity + '\'' +
                    ", integral=" + integral +
                    ", isBindAliPay=" + isBindAliPay +
                    ", isBindBankCard=" + isBindBankCard +
                    '}';
        }
    }
}

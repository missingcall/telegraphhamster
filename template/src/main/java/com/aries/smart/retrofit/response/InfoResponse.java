package com.aries.smart.retrofit.response;

import java.util.List;

/**
 * /hamster-user/user/info
 *
 *
 *
 */
public class InfoResponse {

    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : {"userId":"66ee9fbfe4b06a941df52a20","displayId":"30809506","nickname":"用户635821","auditingNickname":null,"sex":null,"birthday":"2000-01-01","beautifulId":null,"beautifulState":null,"privilege":"001","mobile":"15222093888","profilePath":"https://yuliao-dev-oss.oss-cn-hangzhou.aliyuncs.com/admin/default/Group%201739332279.png","auditingProfilePath":null,"bgPath":null,"auditingBgPath":[],"personalSignature":"这个人很懒，什么都没有留下","auditingPersonalSignature":null,"userRightList":[],"isFrozen":"001","isDestroy":"001","machineCode":"248381df816c833cbb64435e71261929f","location":null,"info":null,"registerDate":"2024-09-21 18:28:16","editDate":null,"accId":"djs66ee9fbfe4b06a941df52a20","netEaseToken":"e2e3ff3dd53d8c984517963d4a12e686","followNum":0,"fansNum":0,"visitorNum":0,"collectionNum":0,"accountBalance":null,"coin":0,"consumeTotal":0,"consumeLevel":0,"charmTotal":0,"charmLevel":0,"diamond":0,"frozenBalance":0,"integral":0,"family":false,"headOfFamily":false,"adolescent":false,"messagePush":false,"cardNo":null,"authentication":false,"firstRecharge":false,"information":false,"fullName":null,"idNumber":null,"messageList":[],"hideWaterMessage":"001","userCarUrl":"","headwearUrl":"","waterDrop":null,"medalList":[],"isSetPassword":true,"isNoDisturbing":false}
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
         * displayId : 30809506
         * nickname : 用户635821
         * auditingNickname : null
         * sex : null
         * birthday : 2000-01-01
         * beautifulId : null
         * beautifulState : null
         * privilege : 001
         * mobile : 15222093888
         * profilePath : https://yuliao-dev-oss.oss-cn-hangzhou.aliyuncs.com/admin/default/Group%201739332279.png
         * auditingProfilePath : null
         * bgPath : null
         * auditingBgPath : []
         * personalSignature : 这个人很懒，什么都没有留下
         * auditingPersonalSignature : null
         * userRightList : []
         * isFrozen : 001
         * isDestroy : 001
         * machineCode : 248381df816c833cbb64435e71261929f
         * location : null
         * info : null
         * registerDate : 2024-09-21 18:28:16
         * editDate : null
         * accId : djs66ee9fbfe4b06a941df52a20
         * netEaseToken : e2e3ff3dd53d8c984517963d4a12e686
         * followNum : 0
         * fansNum : 0
         * visitorNum : 0
         * collectionNum : 0
         * accountBalance : null
         * coin : 0
         * consumeTotal : 0
         * consumeLevel : 0
         * charmTotal : 0
         * charmLevel : 0
         * diamond : 0
         * frozenBalance : 0
         * integral : 0
         * family : false
         * headOfFamily : false
         * adolescent : false
         * messagePush : false
         * cardNo : null
         * authentication : false
         * firstRecharge : false
         * information : false
         * fullName : null
         * idNumber : null
         * messageList : []
         * hideWaterMessage : 001
         * userCarUrl :
         * headwearUrl :
         * waterDrop : null
         * medalList : []
         * isSetPassword : true
         * isNoDisturbing : false
         */

        private String userId;
        private String displayId;
        private String nickname;
        private Object auditingNickname;
        private Object sex;
        private String birthday;
        private Object beautifulId;
        private Object beautifulState;
        private String privilege;
        private String mobile;
        private String profilePath;
        private Object auditingProfilePath;
        private Object bgPath;
        private String personalSignature;
        private Object auditingPersonalSignature;
        private String isFrozen;
        private String isDestroy;
        private String machineCode;
        private Object location;
        private Object info;
        private String registerDate;
        private Object editDate;
        private String accId;
        private String netEaseToken;
        private int followNum;
        private int fansNum;
        private int visitorNum;
        private int collectionNum;
        private Object accountBalance;
        private int coin;
        private int consumeTotal;
        private int consumeLevel;
        private int charmTotal;
        private int charmLevel;
        private int diamond;
        private int frozenBalance;
        private int integral;
        private boolean family;
        private boolean headOfFamily;
        private boolean adolescent;
        private boolean messagePush;
        private Object cardNo;
        private boolean authentication;
        private boolean firstRecharge;
        private boolean information;
        private Object fullName;
        private Object idNumber;
        private String hideWaterMessage;
        private String userCarUrl;
        private String headwearUrl;
        private Object waterDrop;
        private boolean isSetPassword;
        private boolean isNoDisturbing;
        private List<?> auditingBgPath;
        private List<?> userRightList;
        private List<?> messageList;
        private List<?> medalList;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getDisplayId() {
            return displayId;
        }

        public void setDisplayId(String displayId) {
            this.displayId = displayId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getAuditingNickname() {
            return auditingNickname;
        }

        public void setAuditingNickname(Object auditingNickname) {
            this.auditingNickname = auditingNickname;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Object getBeautifulId() {
            return beautifulId;
        }

        public void setBeautifulId(Object beautifulId) {
            this.beautifulId = beautifulId;
        }

        public Object getBeautifulState() {
            return beautifulState;
        }

        public void setBeautifulState(Object beautifulState) {
            this.beautifulState = beautifulState;
        }

        public String getPrivilege() {
            return privilege;
        }

        public void setPrivilege(String privilege) {
            this.privilege = privilege;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public Object getAuditingProfilePath() {
            return auditingProfilePath;
        }

        public void setAuditingProfilePath(Object auditingProfilePath) {
            this.auditingProfilePath = auditingProfilePath;
        }

        public Object getBgPath() {
            return bgPath;
        }

        public void setBgPath(Object bgPath) {
            this.bgPath = bgPath;
        }

        public String getPersonalSignature() {
            return personalSignature;
        }

        public void setPersonalSignature(String personalSignature) {
            this.personalSignature = personalSignature;
        }

        public Object getAuditingPersonalSignature() {
            return auditingPersonalSignature;
        }

        public void setAuditingPersonalSignature(Object auditingPersonalSignature) {
            this.auditingPersonalSignature = auditingPersonalSignature;
        }

        public String getIsFrozen() {
            return isFrozen;
        }

        public void setIsFrozen(String isFrozen) {
            this.isFrozen = isFrozen;
        }

        public String getIsDestroy() {
            return isDestroy;
        }

        public void setIsDestroy(String isDestroy) {
            this.isDestroy = isDestroy;
        }

        public String getMachineCode() {
            return machineCode;
        }

        public void setMachineCode(String machineCode) {
            this.machineCode = machineCode;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public Object getInfo() {
            return info;
        }

        public void setInfo(Object info) {
            this.info = info;
        }

        public String getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(String registerDate) {
            this.registerDate = registerDate;
        }

        public Object getEditDate() {
            return editDate;
        }

        public void setEditDate(Object editDate) {
            this.editDate = editDate;
        }

        public String getAccId() {
            return accId;
        }

        public void setAccId(String accId) {
            this.accId = accId;
        }

        public String getNetEaseToken() {
            return netEaseToken;
        }

        public void setNetEaseToken(String netEaseToken) {
            this.netEaseToken = netEaseToken;
        }

        public int getFollowNum() {
            return followNum;
        }

        public void setFollowNum(int followNum) {
            this.followNum = followNum;
        }

        public int getFansNum() {
            return fansNum;
        }

        public void setFansNum(int fansNum) {
            this.fansNum = fansNum;
        }

        public int getVisitorNum() {
            return visitorNum;
        }

        public void setVisitorNum(int visitorNum) {
            this.visitorNum = visitorNum;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public Object getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(Object accountBalance) {
            this.accountBalance = accountBalance;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getConsumeTotal() {
            return consumeTotal;
        }

        public void setConsumeTotal(int consumeTotal) {
            this.consumeTotal = consumeTotal;
        }

        public int getConsumeLevel() {
            return consumeLevel;
        }

        public void setConsumeLevel(int consumeLevel) {
            this.consumeLevel = consumeLevel;
        }

        public int getCharmTotal() {
            return charmTotal;
        }

        public void setCharmTotal(int charmTotal) {
            this.charmTotal = charmTotal;
        }

        public int getCharmLevel() {
            return charmLevel;
        }

        public void setCharmLevel(int charmLevel) {
            this.charmLevel = charmLevel;
        }

        public int getDiamond() {
            return diamond;
        }

        public void setDiamond(int diamond) {
            this.diamond = diamond;
        }

        public int getFrozenBalance() {
            return frozenBalance;
        }

        public void setFrozenBalance(int frozenBalance) {
            this.frozenBalance = frozenBalance;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public boolean isFamily() {
            return family;
        }

        public void setFamily(boolean family) {
            this.family = family;
        }

        public boolean isHeadOfFamily() {
            return headOfFamily;
        }

        public void setHeadOfFamily(boolean headOfFamily) {
            this.headOfFamily = headOfFamily;
        }

        public boolean isAdolescent() {
            return adolescent;
        }

        public void setAdolescent(boolean adolescent) {
            this.adolescent = adolescent;
        }

        public boolean isMessagePush() {
            return messagePush;
        }

        public void setMessagePush(boolean messagePush) {
            this.messagePush = messagePush;
        }

        public Object getCardNo() {
            return cardNo;
        }

        public void setCardNo(Object cardNo) {
            this.cardNo = cardNo;
        }

        public boolean isAuthentication() {
            return authentication;
        }

        public void setAuthentication(boolean authentication) {
            this.authentication = authentication;
        }

        public boolean isFirstRecharge() {
            return firstRecharge;
        }

        public void setFirstRecharge(boolean firstRecharge) {
            this.firstRecharge = firstRecharge;
        }

        public boolean isInformation() {
            return information;
        }

        public void setInformation(boolean information) {
            this.information = information;
        }

        public Object getFullName() {
            return fullName;
        }

        public void setFullName(Object fullName) {
            this.fullName = fullName;
        }

        public Object getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(Object idNumber) {
            this.idNumber = idNumber;
        }

        public String getHideWaterMessage() {
            return hideWaterMessage;
        }

        public void setHideWaterMessage(String hideWaterMessage) {
            this.hideWaterMessage = hideWaterMessage;
        }

        public String getUserCarUrl() {
            return userCarUrl;
        }

        public void setUserCarUrl(String userCarUrl) {
            this.userCarUrl = userCarUrl;
        }

        public String getHeadwearUrl() {
            return headwearUrl;
        }

        public void setHeadwearUrl(String headwearUrl) {
            this.headwearUrl = headwearUrl;
        }

        public Object getWaterDrop() {
            return waterDrop;
        }

        public void setWaterDrop(Object waterDrop) {
            this.waterDrop = waterDrop;
        }

        public boolean isIsSetPassword() {
            return isSetPassword;
        }

        public void setIsSetPassword(boolean isSetPassword) {
            this.isSetPassword = isSetPassword;
        }

        public boolean isIsNoDisturbing() {
            return isNoDisturbing;
        }

        public void setIsNoDisturbing(boolean isNoDisturbing) {
            this.isNoDisturbing = isNoDisturbing;
        }

        public List<?> getAuditingBgPath() {
            return auditingBgPath;
        }

        public void setAuditingBgPath(List<?> auditingBgPath) {
            this.auditingBgPath = auditingBgPath;
        }

        public List<?> getUserRightList() {
            return userRightList;
        }

        public void setUserRightList(List<?> userRightList) {
            this.userRightList = userRightList;
        }

        public List<?> getMessageList() {
            return messageList;
        }

        public void setMessageList(List<?> messageList) {
            this.messageList = messageList;
        }

        public List<?> getMedalList() {
            return medalList;
        }

        public void setMedalList(List<?> medalList) {
            this.medalList = medalList;
        }
    }
}

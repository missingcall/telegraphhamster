package com.aries.smart.retrofit.response;

public class AccountCreateResponse {

    /**
     * data : {"bgPath":"","birthday":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"displayId":"","info":"","isDestroy":"","isFrozen":"","location":"","loginId":"","machineCode":"","mobile":"","nickname":"","password":"","profilePath":"","registrationIcon":"","sex":"","token":"","tokenHead":"","userId":"","username":""}
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

    public static class DataBean {
        /**
         * bgPath :
         * birthday : {"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0}
         * displayId :
         * info :
         * isDestroy :
         * isFrozen :
         * location :
         * loginId :
         * machineCode :
         * mobile :
         * nickname :
         * password :
         * profilePath :
         * registrationIcon :
         * sex :
         * token :
         * tokenHead :
         * userId :
         * username :
         */

        private String bgPath;
        private BirthdayBean birthday;
        private String displayId;
        private String info;
        private String isDestroy;
        private String isFrozen;
        private String location;
        private String loginId;
        private String machineCode;
        private String mobile;
        private String nickname;
        private String password;
        private String profilePath;
        private String registrationIcon;
        private String sex;
        private String token;
        private String tokenHead;
        private String userId;
        private String username;

        public String getBgPath() {
            return bgPath;
        }

        public void setBgPath(String bgPath) {
            this.bgPath = bgPath;
        }

        public BirthdayBean getBirthday() {
            return birthday;
        }

        public void setBirthday(BirthdayBean birthday) {
            this.birthday = birthday;
        }

        public String getDisplayId() {
            return displayId;
        }

        public void setDisplayId(String displayId) {
            this.displayId = displayId;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getIsDestroy() {
            return isDestroy;
        }

        public void setIsDestroy(String isDestroy) {
            this.isDestroy = isDestroy;
        }

        public String getIsFrozen() {
            return isFrozen;
        }

        public void setIsFrozen(String isFrozen) {
            this.isFrozen = isFrozen;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getMachineCode() {
            return machineCode;
        }

        public void setMachineCode(String machineCode) {
            this.machineCode = machineCode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public String getRegistrationIcon() {
            return registrationIcon;
        }

        public void setRegistrationIcon(String registrationIcon) {
            this.registrationIcon = registrationIcon;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public static class BirthdayBean {
            /**
             * date : 0
             * day : 0
             * hours : 0
             * minutes : 0
             * month : 0
             * nanos : 0
             * seconds : 0
             * time : 0
             * timezoneOffset : 0
             * year : 0
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private int time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}

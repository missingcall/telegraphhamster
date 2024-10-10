package com.aries.smart.retrofit.response;

import java.util.List;

/**

 * @Description:
 */
public class QueryColletRecordListResponse {

    /**
     * data : {"countId":"","current":0,"hitCount":true,"maxLimit":0,"optimizeCountSql":true,"orders":[{"asc":true,"column":""}],"pages":0,"records":[{"coinNumber":"","coinType":"","createTime":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"flowKind":"","id":"","message":"","remainingGoldCoins":""}],"searchCount":true,"size":0,"total":0}
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
         * countId :
         * current : 0
         * hitCount : true
         * maxLimit : 0
         * optimizeCountSql : true
         * orders : [{"asc":true,"column":""}]
         * pages : 0
         * records : [{"coinNumber":"","coinType":"","createTime":{"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0},"flowKind":"","id":"","message":"","remainingGoldCoins":""}]
         * searchCount : true
         * size : 0
         * total : 0
         */

        private String countId;
        private int current;
        private boolean hitCount;
        private int maxLimit;
        private boolean optimizeCountSql;
        private int pages;
        private boolean searchCount;
        private int size;
        private int total;
        private List<OrdersBean> orders;
        private List<RecordsBean> records;

        public String getCountId() {
            return countId;
        }

        public void setCountId(String countId) {
            this.countId = countId;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public int getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<OrdersBean> getOrders() {
            return orders;
        }

        public void setOrders(List<OrdersBean> orders) {
            this.orders = orders;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class OrdersBean {
            /**
             * asc : true
             * column :
             */

            private boolean asc;
            private String column;

            public boolean isAsc() {
                return asc;
            }

            public void setAsc(boolean asc) {
                this.asc = asc;
            }

            public String getColumn() {
                return column;
            }

            public void setColumn(String column) {
                this.column = column;
            }
        }

        public static class RecordsBean {
            /**
             * coinNumber :
             * coinType :
             * createTime : {"date":0,"day":0,"hours":0,"minutes":0,"month":0,"nanos":0,"seconds":0,"time":0,"timezoneOffset":0,"year":0}
             * flowKind :
             * id :
             * message :
             * remainingGoldCoins :
             */

            private String coinNumber;
            private String coinType;
            private CreateTimeBean createTime;
            private String flowKind;
            private String id;
            private String message;
            private String remainingGoldCoins;

            public String getCoinNumber() {
                return coinNumber;
            }

            public void setCoinNumber(String coinNumber) {
                this.coinNumber = coinNumber;
            }

            public String getCoinType() {
                return coinType;
            }

            public void setCoinType(String coinType) {
                this.coinType = coinType;
            }

            public CreateTimeBean getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeBean createTime) {
                this.createTime = createTime;
            }

            public String getFlowKind() {
                return flowKind;
            }

            public void setFlowKind(String flowKind) {
                this.flowKind = flowKind;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getRemainingGoldCoins() {
                return remainingGoldCoins;
            }

            public void setRemainingGoldCoins(String remainingGoldCoins) {
                this.remainingGoldCoins = remainingGoldCoins;
            }

            public static class CreateTimeBean {
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
}

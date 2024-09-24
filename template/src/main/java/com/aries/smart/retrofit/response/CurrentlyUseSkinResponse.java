package com.aries.smart.retrofit.response;

import java.util.List;

/**
 * @Author: AriesHoo on 2018/11/19 14:18
 * @E-Mail: AriesHoo@126.com
 * @Function: 描述性条目实体
 * @Description:
 */
public class CurrentlyUseSkinResponse {

    /**
     * data : {"countId":"","current":0,"hitCount":true,"maxLimit":0,"optimizeCountSql":true,"orders":[{"asc":true,"column":""}],"pages":0,"records":[{"createTime":"","icon":"","id":0,"name":"","remark":"","sort":0,"status":"","type":"","unlockDescription":"","unlockMethod":"","unlockParameters":"","unlockStatus":true,"wearStatus":true}],"searchCount":true,"size":0,"total":0}
     * responseCode :
     * responseMessage :
     */

    private DataBean data;
    private String responseCode;
    private String responseMessage;

    @Override
    public String toString() {
        return "CurrentlyUseSkinResponse{" +
                "data=" + data +
                ", responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }

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
        @Override
        public String toString() {
            return "DataBean{" +
                    "countId='" + countId + '\'' +
                    ", current=" + current +
                    ", hitCount=" + hitCount +
                    ", maxLimit=" + maxLimit +
                    ", optimizeCountSql=" + optimizeCountSql +
                    ", pages=" + pages +
                    ", searchCount=" + searchCount +
                    ", size=" + size +
                    ", total=" + total +
                    ", orders=" + orders +
                    ", records=" + records +
                    '}';
        }

        /**
         * countId :
         * current : 0
         * hitCount : true
         * maxLimit : 0
         * optimizeCountSql : true
         * orders : [{"asc":true,"column":""}]
         * pages : 0
         * records : [{"createTime":"","icon":"","id":0,"name":"","remark":"","sort":0,"status":"","type":"","unlockDescription":"","unlockMethod":"","unlockParameters":"","unlockStatus":true,"wearStatus":true}]
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

            @Override
            public String toString() {
                return "RecordsBean{" +
                        "createTime='" + createTime + '\'' +
                        ", icon='" + icon + '\'' +
                        ", id=" + id +
                        ", name='" + name + '\'' +
                        ", remark='" + remark + '\'' +
                        ", sort=" + sort +
                        ", status='" + status + '\'' +
                        ", type='" + type + '\'' +
                        ", unlockDescription='" + unlockDescription + '\'' +
                        ", unlockMethod='" + unlockMethod + '\'' +
                        ", unlockParameters='" + unlockParameters + '\'' +
                        ", unlockStatus=" + unlockStatus +
                        ", wearStatus=" + wearStatus +
                        '}';
            }

            /**
             * createTime :
             * icon :
             * id : 0
             * name :
             * remark :
             * sort : 0
             * status :
             * type :
             * unlockDescription :
             * unlockMethod :
             * unlockParameters :
             * unlockStatus : true
             * wearStatus : true
             */

            private String createTime;
            private String icon;
            private int id;
            private String name;
            private String remark;
            private int sort;
            private String status;
            private String type;
            private String unlockDescription;
            private String unlockMethod;
            private String unlockParameters;
            private boolean unlockStatus;
            private boolean wearStatus;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUnlockDescription() {
                return unlockDescription;
            }

            public void setUnlockDescription(String unlockDescription) {
                this.unlockDescription = unlockDescription;
            }

            public String getUnlockMethod() {
                return unlockMethod;
            }

            public void setUnlockMethod(String unlockMethod) {
                this.unlockMethod = unlockMethod;
            }

            public String getUnlockParameters() {
                return unlockParameters;
            }

            public void setUnlockParameters(String unlockParameters) {
                this.unlockParameters = unlockParameters;
            }

            public boolean isUnlockStatus() {
                return unlockStatus;
            }

            public void setUnlockStatus(boolean unlockStatus) {
                this.unlockStatus = unlockStatus;
            }

            public boolean isWearStatus() {
                return wearStatus;
            }

            public void setWearStatus(boolean wearStatus) {
                this.wearStatus = wearStatus;
            }
        }
    }
}

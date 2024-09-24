package com.aries.smart.retrofit.response;

import java.util.List;

/**
 * @Author: AriesHoo on 2018/11/19 14:18
 * @E-Mail: AriesHoo@126.com
 * @Function: 描述性条目实体
 * @Description:
 */
public class AccessoriesInfoListResponse {


    /**
     * responseCode : 200
     * responseMessage : 操作成功
     * data : {"records":[{"id":1,"name":"test","icon":null,"status":"001","sort":1,"type":"001","unlockMethod":"001","createTime":null,"remark":"test","unlockDescription":"test","unlockParameters":null,"unlockStatus":false,"wearStatus":false},{"id":3,"name":"level1","icon":null,"status":"001","sort":1,"type":"001","unlockMethod":"003","createTime":null,"remark":"等级大于1","unlockDescription":"1","unlockParameters":"1","unlockStatus":false,"wearStatus":false},{"id":2,"name":"test1","icon":null,"status":"001","sort":2,"type":"001","unlockMethod":"001","createTime":null,"remark":"test1","unlockDescription":"test1","unlockParameters":null,"unlockStatus":false,"wearStatus":false}],"total":3,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
     */

    private String responseCode;
    private String responseMessage;
    private DataBean data;

    @Override
    public String toString() {
        return "AccessoriesInfoListResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", data=" + data +
                '}';
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "total=" + total +
                    ", size=" + size +
                    ", current=" + current +
                    ", optimizeCountSql=" + optimizeCountSql +
                    ", hitCount=" + hitCount +
                    ", countId=" + countId +
                    ", maxLimit=" + maxLimit +
                    ", searchCount=" + searchCount +
                    ", pages=" + pages +
                    ", records=" + records +
                    ", orders=" + orders +
                    '}';
        }

        /**
         * records : [{"id":1,"name":"test","icon":null,"status":"001","sort":1,"type":"001","unlockMethod":"001","createTime":null,"remark":"test","unlockDescription":"test","unlockParameters":null,"unlockStatus":false,"wearStatus":false},{"id":3,"name":"level1","icon":null,"status":"001","sort":1,"type":"001","unlockMethod":"003","createTime":null,"remark":"等级大于1","unlockDescription":"1","unlockParameters":"1","unlockStatus":false,"wearStatus":false},{"id":2,"name":"test1","icon":null,"status":"001","sort":2,"type":"001","unlockMethod":"001","createTime":null,"remark":"test1","unlockDescription":"test1","unlockParameters":null,"unlockStatus":false,"wearStatus":false}]
         * total : 3
         * size : 10
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 1
         */



        private int total;
        private int size;
        private int current;
        private boolean optimizeCountSql;
        private boolean hitCount;
        private Object countId;
        private Object maxLimit;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Object getCountId() {
            return countId;
        }

        public void setCountId(Object countId) {
            this.countId = countId;
        }

        public Object getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(Object maxLimit) {
            this.maxLimit = maxLimit;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean {

            @Override
            public String toString() {
                return "RecordsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", icon=" + icon +
                        ", status='" + status + '\'' +
                        ", sort=" + sort +
                        ", type='" + type + '\'' +
                        ", unlockMethod='" + unlockMethod + '\'' +
                        ", createTime=" + createTime +
                        ", remark='" + remark + '\'' +
                        ", unlockDescription='" + unlockDescription + '\'' +
                        ", unlockParameters=" + unlockParameters +
                        ", unlockStatus=" + unlockStatus +
                        ", wearStatus=" + wearStatus +
                        '}';
            }

            /**
             * id : 1
             * name : test
             * icon : null
             * status : 001
             * sort : 1
             * type : 001
             * unlockMethod : 001
             * createTime : null
             * remark : test
             * unlockDescription : test
             * unlockParameters : null
             * unlockStatus : false
             * wearStatus : false
             */

            private int id;
            private String name;
            private Object icon;
            private String status;
            private int sort;
            private String type;
            private String unlockMethod;
            private Object createTime;
            private String remark;
            private String unlockDescription;
            private Object unlockParameters;
            private boolean unlockStatus;
            private boolean wearStatus;

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

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUnlockMethod() {
                return unlockMethod;
            }

            public void setUnlockMethod(String unlockMethod) {
                this.unlockMethod = unlockMethod;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getUnlockDescription() {
                return unlockDescription;
            }

            public void setUnlockDescription(String unlockDescription) {
                this.unlockDescription = unlockDescription;
            }

            public Object getUnlockParameters() {
                return unlockParameters;
            }

            public void setUnlockParameters(Object unlockParameters) {
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

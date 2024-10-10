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
     * data : {"records":[{"id":28,"name":"头像13","icon":"https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/1702461992549205-1702461993386-1727334818376.jpeg","status":"001","sort":null,"type":"001","unlockMethod":"001","createTime":"2024-09-26T06:56:33.000+00:00","remark":"111","unlockDescription":"12","unlockParameters":"{\"type\":\"001\",\"amount\":\"100\"}","unlockStatus":false,"wearStatus":false},{"id":32,"name":"炫酷皮肤","icon":null,"status":"001","sort":null,"type":"001","unlockMethod":"001","createTime":"2024-10-10T03:08:14.000+00:00","remark":null,"unlockDescription":null,"unlockParameters":"{\"name\":\"松果购买解锁\",\"type\":\"001\",\"amount\":\"500\"}","unlockStatus":false,"wearStatus":false},{"id":33,"name":"炫酷皮肤2","icon":null,"status":"001","sort":null,"type":"001","unlockMethod":"003","createTime":"2024-10-10T03:09:01.000+00:00","remark":null,"unlockDescription":null,"unlockParameters":"{\"name\":\"等级2\",\"id\":\"1\"}","unlockStatus":false,"wearStatus":false},{"id":36,"name":"新头像","icon":"https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/1702461992549205-1702461993386-1728537297691.jpeg","status":"001","sort":null,"type":"001","unlockMethod":"003","createTime":"2024-10-10T05:15:04.000+00:00","remark":"11","unlockDescription":null,"unlockParameters":"{\"name\":\"等级1\",\"id\":\"0\"}","unlockStatus":false,"wearStatus":false}],"total":6,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"id":28,"name":"头像13","icon":"https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/1702461992549205-1702461993386-1727334818376.jpeg","status":"001","sort":null,"type":"001","unlockMethod":"001","createTime":"2024-09-26T06:56:33.000+00:00","remark":"111","unlockDescription":"12","unlockParameters":"{\"type\":\"001\",\"amount\":\"100\"}","unlockStatus":false,"wearStatus":false},{"id":32,"name":"炫酷皮肤","icon":null,"status":"001","sort":null,"type":"001","unlockMethod":"001","createTime":"2024-10-10T03:08:14.000+00:00","remark":null,"unlockDescription":null,"unlockParameters":"{\"name\":\"松果购买解锁\",\"type\":\"001\",\"amount\":\"500\"}","unlockStatus":false,"wearStatus":false},{"id":33,"name":"炫酷皮肤2","icon":null,"status":"001","sort":null,"type":"001","unlockMethod":"003","createTime":"2024-10-10T03:09:01.000+00:00","remark":null,"unlockDescription":null,"unlockParameters":"{\"name\":\"等级2\",\"id\":\"1\"}","unlockStatus":false,"wearStatus":false},{"id":36,"name":"新头像","icon":"https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/1702461992549205-1702461993386-1728537297691.jpeg","status":"001","sort":null,"type":"001","unlockMethod":"003","createTime":"2024-10-10T05:15:04.000+00:00","remark":"11","unlockDescription":null,"unlockParameters":"{\"name\":\"等级1\",\"id\":\"0\"}","unlockStatus":false,"wearStatus":false}]
         * total : 6
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
            /**
             * id : 28
             * name : 头像13
             * icon : https://hamster-dev.oss-cn-hangzhou.aliyuncs.com/admin/gift/images/1702461992549205-1702461993386-1727334818376.jpeg
             * status : 001
             * sort : null
             * type : 001
             * unlockMethod : 001
             * createTime : 2024-09-26T06:56:33.000+00:00
             * remark : 111
             * unlockDescription : 12
             * unlockParameters : {"type":"001","amount":"100"}
             * unlockStatus : false
             * wearStatus : false
             */

            private int id;
            private String name;
            private String icon;
            private String status;
            private Object sort;
            private String type;
            private String unlockMethod;
            private String createTime;
            private String remark;
            private String unlockDescription;
            private String unlockParameters;
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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
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

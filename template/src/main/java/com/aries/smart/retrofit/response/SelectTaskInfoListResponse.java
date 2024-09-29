package com.aries.smart.retrofit.response;

import java.util.List;

public class SelectTaskInfoListResponse {

    /**
     * data : {"dailyTaskInfoList":[{"conditional":"","createTime":"","cycle":0,"finishStatus":"","jumpLink":"","jumpType":0,"maxAcceptNum":0,"openTime":"","rewardType":"","schema":"","status":"","taskDesc":"","taskIcon":"","taskId":"","taskModel":"","taskName":"","taskType":"","updateTime":""}],"noviceTaskInfoList":[{"conditional":"","createTime":"","cycle":0,"finishStatus":"","jumpLink":"","jumpType":0,"maxAcceptNum":0,"openTime":"","rewardType":"","schema":"","status":"","taskDesc":"","taskIcon":"","taskId":"","taskModel":"","taskName":"","taskType":"","updateTime":""}]}
     * responseCode :
     * responseMessage :
     */

    private DataBean data;
    private String responseCode;
    private String responseMessage;

    @Override
    public String toString() {
        return "SelectTaskInfoListResponse{" +
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
        private List<DailyTaskInfoListBean> dailyTaskInfoList;
        private List<NoviceTaskInfoListBean> noviceTaskInfoList;

        public List<DailyTaskInfoListBean> getDailyTaskInfoList() {
            return dailyTaskInfoList;
        }

        public void setDailyTaskInfoList(List<DailyTaskInfoListBean> dailyTaskInfoList) {
            this.dailyTaskInfoList = dailyTaskInfoList;
        }

        public List<NoviceTaskInfoListBean> getNoviceTaskInfoList() {
            return noviceTaskInfoList;
        }

        public void setNoviceTaskInfoList(List<NoviceTaskInfoListBean> noviceTaskInfoList) {
            this.noviceTaskInfoList = noviceTaskInfoList;
        }

        public static class DailyTaskInfoListBean {
            @Override
            public String toString() {
                return "DailyTaskInfoListBean{" +
                        "conditional='" + conditional + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", cycle=" + cycle +
                        ", finishStatus='" + finishStatus + '\'' +
                        ", jumpLink='" + jumpLink + '\'' +
                        ", jumpType=" + jumpType +
                        ", maxAcceptNum=" + maxAcceptNum +
                        ", openTime='" + openTime + '\'' +
                        ", rewardType='" + rewardType + '\'' +
                        ", schema='" + schema + '\'' +
                        ", status='" + status + '\'' +
                        ", taskDesc='" + taskDesc + '\'' +
                        ", taskIcon='" + taskIcon + '\'' +
                        ", taskId='" + taskId + '\'' +
                        ", taskModel='" + taskModel + '\'' +
                        ", taskName='" + taskName + '\'' +
                        ", taskType='" + taskType + '\'' +
                        ", updateTime='" + updateTime + '\'' +
                        '}';
            }

            /**
             * conditional :
             * createTime :
             * cycle : 0
             * finishStatus :
             * jumpLink :
             * jumpType : 0
             * maxAcceptNum : 0
             * openTime :
             * rewardType :
             * schema :
             * status :
             * taskDesc :
             * taskIcon :
             * taskId :
             * taskModel :
             * taskName :
             * taskType :
             * updateTime :
             */



            private String conditional;
            private String createTime;
            private int cycle;
            private String finishStatus;
            private String jumpLink;
            private int jumpType;
            private int maxAcceptNum;
            private String openTime;
            private String rewardType;
            private String schema;
            private String status;
            private String taskDesc;
            private String taskIcon;
            private String taskId;
            private String taskModel;
            private String taskName;
            private String taskType;
            private String updateTime;

            public String getConditional() {
                return conditional;
            }

            public void setConditional(String conditional) {
                this.conditional = conditional;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getCycle() {
                return cycle;
            }

            public void setCycle(int cycle) {
                this.cycle = cycle;
            }

            public String getFinishStatus() {
                return finishStatus;
            }

            public void setFinishStatus(String finishStatus) {
                this.finishStatus = finishStatus;
            }

            public String getJumpLink() {
                return jumpLink;
            }

            public void setJumpLink(String jumpLink) {
                this.jumpLink = jumpLink;
            }

            public int getJumpType() {
                return jumpType;
            }

            public void setJumpType(int jumpType) {
                this.jumpType = jumpType;
            }

            public int getMaxAcceptNum() {
                return maxAcceptNum;
            }

            public void setMaxAcceptNum(int maxAcceptNum) {
                this.maxAcceptNum = maxAcceptNum;
            }

            public String getOpenTime() {
                return openTime;
            }

            public void setOpenTime(String openTime) {
                this.openTime = openTime;
            }

            public String getRewardType() {
                return rewardType;
            }

            public void setRewardType(String rewardType) {
                this.rewardType = rewardType;
            }

            public String getSchema() {
                return schema;
            }

            public void setSchema(String schema) {
                this.schema = schema;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTaskDesc() {
                return taskDesc;
            }

            public void setTaskDesc(String taskDesc) {
                this.taskDesc = taskDesc;
            }

            public String getTaskIcon() {
                return taskIcon;
            }

            public void setTaskIcon(String taskIcon) {
                this.taskIcon = taskIcon;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getTaskModel() {
                return taskModel;
            }

            public void setTaskModel(String taskModel) {
                this.taskModel = taskModel;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public String getTaskType() {
                return taskType;
            }

            public void setTaskType(String taskType) {
                this.taskType = taskType;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class NoviceTaskInfoListBean {
            @Override
            public String toString() {
                return "NoviceTaskInfoListBean{" +
                        "conditional='" + conditional + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", cycle=" + cycle +
                        ", finishStatus='" + finishStatus + '\'' +
                        ", jumpLink='" + jumpLink + '\'' +
                        ", jumpType=" + jumpType +
                        ", maxAcceptNum=" + maxAcceptNum +
                        ", openTime='" + openTime + '\'' +
                        ", rewardType='" + rewardType + '\'' +
                        ", schema='" + schema + '\'' +
                        ", status='" + status + '\'' +
                        ", taskDesc='" + taskDesc + '\'' +
                        ", taskIcon='" + taskIcon + '\'' +
                        ", taskId='" + taskId + '\'' +
                        ", taskModel='" + taskModel + '\'' +
                        ", taskName='" + taskName + '\'' +
                        ", taskType='" + taskType + '\'' +
                        ", updateTime='" + updateTime + '\'' +
                        '}';
            }

            /**
             * conditional :
             * createTime :
             * cycle : 0
             * finishStatus :
             * jumpLink :
             * jumpType : 0
             * maxAcceptNum : 0
             * openTime :
             * rewardType :
             * schema :
             * status :
             * taskDesc :
             * taskIcon :
             * taskId :
             * taskModel :
             * taskName :
             * taskType :
             * updateTime :
             */



            private String conditional;
            private String createTime;
            private int cycle;
            private String finishStatus;
            private String jumpLink;
            private int jumpType;
            private int maxAcceptNum;
            private String openTime;
            private String rewardType;
            private String schema;
            private String status;
            private String taskDesc;
            private String taskIcon;
            private String taskId;
            private String taskModel;
            private String taskName;
            private String taskType;
            private String updateTime;

            public String getConditional() {
                return conditional;
            }

            public void setConditional(String conditional) {
                this.conditional = conditional;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getCycle() {
                return cycle;
            }

            public void setCycle(int cycle) {
                this.cycle = cycle;
            }

            public String getFinishStatus() {
                return finishStatus;
            }

            public void setFinishStatus(String finishStatus) {
                this.finishStatus = finishStatus;
            }

            public String getJumpLink() {
                return jumpLink;
            }

            public void setJumpLink(String jumpLink) {
                this.jumpLink = jumpLink;
            }

            public int getJumpType() {
                return jumpType;
            }

            public void setJumpType(int jumpType) {
                this.jumpType = jumpType;
            }

            public int getMaxAcceptNum() {
                return maxAcceptNum;
            }

            public void setMaxAcceptNum(int maxAcceptNum) {
                this.maxAcceptNum = maxAcceptNum;
            }

            public String getOpenTime() {
                return openTime;
            }

            public void setOpenTime(String openTime) {
                this.openTime = openTime;
            }

            public String getRewardType() {
                return rewardType;
            }

            public void setRewardType(String rewardType) {
                this.rewardType = rewardType;
            }

            public String getSchema() {
                return schema;
            }

            public void setSchema(String schema) {
                this.schema = schema;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTaskDesc() {
                return taskDesc;
            }

            public void setTaskDesc(String taskDesc) {
                this.taskDesc = taskDesc;
            }

            public String getTaskIcon() {
                return taskIcon;
            }

            public void setTaskIcon(String taskIcon) {
                this.taskIcon = taskIcon;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getTaskModel() {
                return taskModel;
            }

            public void setTaskModel(String taskModel) {
                this.taskModel = taskModel;
            }

            public String getTaskName() {
                return taskName;
            }

            public void setTaskName(String taskName) {
                this.taskName = taskName;
            }

            public String getTaskType() {
                return taskType;
            }

            public void setTaskType(String taskType) {
                this.taskType = taskType;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}

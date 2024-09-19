package com.aries.smart.module.entity;

public class RecordsResponse {
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

package com.aries.smart.retrofit.request;

import java.io.Serializable;

public class AccessoriesInfoListTo implements Serializable {
    /**
     * accessoriesId : 0 查询的时候不用传
     * pageNum : 0
     * pageSize : 0
     * type :	类型 001 皮肤 002 头像
     */

    private int accessoriesId;
    private int pageNum;
    private int pageSize;
    private String type;

    public int getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(int accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccessoriesInfoListTo{" +
                "accessoriesId=" + accessoriesId +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", type='" + type + '\'' +
                '}';
    }
}

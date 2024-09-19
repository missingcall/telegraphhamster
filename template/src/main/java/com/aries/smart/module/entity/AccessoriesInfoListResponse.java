package com.aries.smart.module.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: AriesHoo on 2018/11/19 14:18
 * @E-Mail: AriesHoo@126.com
 * @Function: 描述性条目实体
 * @Description:
 */
public class AccessoriesInfoListResponse implements Serializable {
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
    private List<OrdersResponse> orders;
    private List<RecordsResponse> records;

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

    public List<OrdersResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersResponse> orders) {
        this.orders = orders;
    }

    public List<RecordsResponse> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsResponse> records) {
        this.records = records;
    }


    /**
     * data : {"countId":"","current":0,"hitCount":true,"maxLimit":0,"optimizeCountSql":true,"orders":[{"asc":true,"column":""}],"pages":0,"records":[{"createTime":"","icon":"","id":0,"name":"","remark":"","sort":0,"status":"","type":"","unlockDescription":"","unlockMethod":"","unlockParameters":"","unlockStatus":true,"wearStatus":true}],"searchCount":true,"size":0,"total":0}
     * responseCode :
     * responseMessage :
     */


}

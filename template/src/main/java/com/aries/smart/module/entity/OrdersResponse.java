package com.aries.smart.module.entity;

public class OrdersResponse {
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

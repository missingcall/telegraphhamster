package com.aries.smart.module.entity;

/**
 * @Author: AriesHoo on 2018/11/19 14:18
 * @E-Mail: AriesHoo@126.com
 * @Function: 描述性条目实体
 * @Description:
 */
public class AchievementDisplayEntity {

    public boolean isNew;
    public String name;
    public String picUrl;

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public AchievementDisplayEntity(boolean isNew, String name, String picUrl) {
        this.isNew = isNew;
        this.name = name;
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "WidgetEntity{" +
                "isNew=" + isNew +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}

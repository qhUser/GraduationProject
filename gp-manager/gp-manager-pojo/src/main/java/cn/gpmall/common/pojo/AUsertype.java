package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 用户类型表
 * */
public class AUsertype implements Serializable{
    private Integer id;  //类型id

    private String usertype; /*
    用户类型
    客户级别 普通用户，只能竞拍 高级用户，能竞拍和拍卖，公司账户，能竞拍和拍卖
    */

    private Integer level;

    private String description;//描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
package cn.gpmall.common.pojo;

import java.io.Serializable;
/**
 * 角色表
 * */
public class PRole implements Serializable{
    private Integer id; //角色id

    private String name; //角色名

    private String description;  //角色描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
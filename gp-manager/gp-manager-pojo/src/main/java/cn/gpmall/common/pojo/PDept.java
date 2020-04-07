package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 部门表
 * */
public class PDept implements Serializable{
    private Integer id; //部门id

    private String name; //部门名称

    private String description;//部门 描述

    private Integer parentid;  //上级部门

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

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
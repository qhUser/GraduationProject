package cn.gpmall.common.pojo;

import java.io.Serializable;
/**
 * 权限表
 * */
public class PPrivilege implements Serializable{
    private Integer id;  //

    private String name;  //权限名

    private String url;   //

    private String description; //权限描述

    private Integer parentid;   //上级权限

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
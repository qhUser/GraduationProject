package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 管理员角色表
 * */
public class PAdminRoleKey implements Serializable{
    private Integer adminid; //管理员id

    private Integer roleid;  //角色id

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 权限-角色表
 * */
public class PRolePrivilegeKey implements Serializable{
    private Integer privilegeid; //权限id

    private Integer roleid; //角色id

    public Integer getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(Integer privilegeid) {
        this.privilegeid = privilegeid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
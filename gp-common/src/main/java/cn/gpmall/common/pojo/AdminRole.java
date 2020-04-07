package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class AdminRole implements Serializable{
   private List allRole;   //所有的角色信息
   private List adminRole; //相应管理员的角色
public List getAllRole() {
	return allRole;
}
public void setAllRole(List allRole) {
	this.allRole = allRole;
}
public List getAdminRole() {
	return adminRole;
}
public void setAdminRole(List adminRole) {
	this.adminRole = adminRole;
}
   
}

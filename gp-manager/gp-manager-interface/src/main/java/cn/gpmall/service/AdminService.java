package cn.gpmall.service;

import cn.gpmall.common.pojo.AdminRole;
import cn.gpmall.common.pojo.EasyUIData;

public interface AdminService {
	EasyUIData adminList(Integer page, Integer rows);//查询所有的管理员

	AdminRole adminRole(Integer adminId);//返回角色信息

	String adminUpdate(Integer adminId, Integer[] check_val, Integer visable);//更新管理员

	EasyUIData roleList(Integer page, Integer rows);//获得角色列表

	AdminRole rolePrivilege(Integer roleId1);//返回权限信息

	String roleUpdate(Integer roleId1, Integer[] check_val);//更新角色

	String adminAdd(String addLoginName, String addPassWord, Integer[] check_val);

}

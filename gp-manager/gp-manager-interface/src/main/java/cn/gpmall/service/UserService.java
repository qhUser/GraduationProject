package cn.gpmall.service;

import java.util.List;

import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.common.pojo.PPrivilege;

public interface UserService {

	EasyUIData getUesrAdd(Integer page, Integer rows);//获得审核的用户

	void getUserAdopt(Integer id);//审核用户通过

	void getUsernoPass(Integer id);//审核用户不通过

	EasyUIData getUesrList(Integer page, Integer rows);//查找所有用户

	void getUserBan(Integer id);//对用户封号

	EasyUIData getUserListBan(Integer page, Integer rows);//所有的违规用户

	void getUserRelieve(Integer id);//对用户解封

	String getSession(String cookieValue);//根据cookie判断redis中有没有用户

	List<Integer> getRole(Integer id);//获得管理员的全部角色id

	List<Integer> getPrivilege(Integer i);//获得角色的全部权限id

	PPrivilege getPrivilegeById(Integer j);//根据权限id，找到权限

	
   
}

package cn.gpmall.common.mapper;

import java.util.List;

import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.pojo.PPrivilege;
import cn.gpmall.common.pojo.PRole;
import cn.gpmall.common.pojo.Page;

public interface AdminDao {

	List<PAdmin> adminList(Page p);//根据分页信息，查询管理员

	Integer getSumAdmin();     //查询所有管理员

	List<PRole> getAllRole();   //获得所有角色

	List<Integer> getadminRole(Integer adminid);//获得对于管理员的角色id

	void updateAdmin(Integer adminId, Integer visable);//更新管理员

	void deleteRole(Integer adminId);   //将所有角色都删除

	void addRole(Integer adminId, Integer roleId);  //根据用户id插入角色

	List<PRole> roleList(Page p);//分页查询角色

	Integer getSumRole();//获得角色总数

	List<PPrivilege> getAllPrivilege();//获得所有权限

	List<Integer> rolePrivilege(Integer roleId1);//获得对于角色的权限id

	void deletePrivilege(Integer roleId1);//将所有权限都删除

	void addPrivilege(Integer roleId1, Integer privilegeId);//根据角色id插入权限

	void adminAdd(PAdmin admin);//添加管理员，返回id

}

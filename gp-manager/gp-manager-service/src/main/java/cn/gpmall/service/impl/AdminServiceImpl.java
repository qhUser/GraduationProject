package cn.gpmall.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.gpmall.common.mapper.AdminDao;
import cn.gpmall.common.pojo.AdminRole;
import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.pojo.PPrivilege;
import cn.gpmall.common.pojo.PRole;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
	@Override   //添加管理员
	public EasyUIData adminList(Integer page, Integer rows) {
		Page p=new Page(page,rows);
		//第一步,根据分页信息，查询管理员信息
		List<PAdmin> list=adminDao.adminList(p);
		//第二步,查询所有的管理员
		Integer sum=adminDao.getSumAdmin();
		EasyUIData result=new EasyUIData();
		result.setRows(list);
		result.setTotal(sum);
		return result;
	}
	@Override
	public AdminRole adminRole(Integer adminid) {
		AdminRole adminRole=new AdminRole();
		//返回应包含：1.所有角色id，2.管理员拥有的角色id 3.所有角色名
		  //第一步，查询出所有的角色，
		List<PRole> allRole= adminDao.getAllRole();
		//第二步，查询出该管理员的角色
		List<Integer> adminrole= adminDao.getadminRole(adminid);
		adminRole.setAdminRole(adminrole);
		adminRole.setAllRole(allRole);
		return adminRole;
	}
	@Override
	public String adminUpdate(Integer adminId, Integer[] check_val, Integer visable) {
		try {
			//第一步,找到管理员，将管理员id更新
			adminDao.updateAdmin(adminId,visable);
			//第二步，找到该管理员，将所有有关的权限都删除
			adminDao.deleteRole(adminId);
			//第三步，将更新后的权限插入数据库
			for(Integer roleId:check_val) {
				adminDao.addRole(adminId,roleId);
			}
			return "OK";
		} catch (Exception e) {
			return "fail";
		}
		
		
	}
	@Override//获得角色列表
	public EasyUIData roleList(Integer page, Integer rows) {
		Page p=new Page(page,rows);
		//第一步,根据分页信息，查询角色信息
		List<PRole> list=adminDao.roleList(p);
		//第二步,查询所有的角色
		Integer sum=adminDao.getSumRole();
		EasyUIData result=new EasyUIData();
		result.setRows(list);
		result.setTotal(sum);
		return result;
	}
	@Override
	public AdminRole rolePrivilege(Integer roleId1) {
		AdminRole adminRole=new AdminRole();
		//返回应包含：1.所有角色id，2.管理员拥有的角色id 3.所有角色名
		  //第一步，查询出所有的权限，
		List<PPrivilege> allPrivilege= adminDao.getAllPrivilege();
		//第二步，查询出该角色的权限
		List<Integer> rolePrivilege= adminDao.rolePrivilege(roleId1);
		adminRole.setAdminRole(rolePrivilege);
		adminRole.setAllRole(allPrivilege);
		return adminRole;
	}
	@Override
	public String roleUpdate(Integer roleId1, Integer[] check_val) {
					
			//第一步，找到该角色，将所有有关的权限都删除
			adminDao.deletePrivilege(roleId1);
			//第二步，将更新后的权限插入数据库
			for(Integer privilegeId:check_val) {
				System.out.println(roleId1+":"+privilegeId);
				adminDao.addPrivilege(roleId1,privilegeId);
			}
			return "OK";
		
	}
	@Override
	public String adminAdd(String addLoginName, String addPassWord, Integer[] check_val) {
		
		
			PAdmin admin=new PAdmin();
			admin.setLoginname(addLoginName);
			admin.setPassword(addPassWord);
			//第一步，添加管理员
			adminDao.adminAdd(admin);//返回管理员id
			System.out.println(admin.getId());
			//第二步，为管理员添加角色
			for(Integer roleId:check_val) {
				adminDao.addRole(admin.getId(), roleId);
			}			
			return "OK";
	
		
	}



}

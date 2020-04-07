package cn.gpmall.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.common.pojo.AdminRole;
import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.service.AdminService;

@Controller
public class AdminController {
  @Autowired
  AdminService adminService;
  @RequestMapping("/checkAdmin")
  public String checkAdmin() {
	  return "admin-list";
  }
  @RequestMapping("/allocationRole")
  public String allocationRole() {
	  return "admin-role";
  }
  @RequestMapping("/addAdmin")
  public String addAdmin() {
	  return "admin-add";
  }
  
  @RequestMapping("/admin/list")
  @ResponseBody   //查询所有的管理员
  public EasyUIData adminList(Integer page, Integer rows) {
	  EasyUIData result=adminService.adminList(page,rows);
	  return result;
  }
  @RequestMapping("/admin/role")
  @ResponseBody   //查询管理员的所有角色
  public AdminRole adminRole(@RequestParam(defaultValue="1")Integer adminId) {	 
	  AdminRole result=adminService.adminRole(adminId);
	  return result;
  }
  @RequestMapping("/admin/update")
  @ResponseBody   //更新管理员权限
  public String adminUpdate(Integer adminId,Integer[] check_val,Integer visable) {		 
	  adminService.adminUpdate(adminId,check_val,visable);
	  return "OK";
  }
  @RequestMapping("/role/list")
  @ResponseBody   //获得角色列表
  public EasyUIData roleList(Integer page, Integer rows) {
	  EasyUIData result=adminService.roleList(page,rows);
	  return result;
  }
  @RequestMapping("/role/privilege")
  @ResponseBody   //查询管理员的所有角色
  public AdminRole rolePrivilege(Integer roleId1) {	  
	  AdminRole result=adminService.rolePrivilege(roleId1);
	  return result;
  }
  @RequestMapping("/role/update")
  @ResponseBody   //更新管理员权限
  public String roleUpdate(Integer roleId1,Integer[] check_val) {
	  adminService.roleUpdate(roleId1,check_val);
	  return "OK";
  }
  @RequestMapping("/admin/add")
  @ResponseBody   //更新管理员权限
  public String adminAdd(String addLoginName,String addPassWord,Integer[] check_val) {
	  String mess= adminService.adminAdd(addLoginName,addPassWord,check_val);
	  return mess;
  }
}

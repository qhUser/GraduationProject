package cn.gpmall.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.pojo.PPrivilege;
import cn.gpmall.service.UserService;

/**
 * 页面跳转Cotroller
 * */
@Controller
public class PageController {
	@Autowired
	UserService userService;
   @RequestMapping("/")
	public String showIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
	   //获得登录用户
	   PAdmin admin=(PAdmin) request.getAttribute("admin");	  
	   //第一步，查询用户所有角色
	   List<Integer> list=userService.getRole(admin.getId());
	   //第二步,遍历角色，查询所有权限
	   List<PPrivilege> privilegeList=new ArrayList<PPrivilege>();//将所有权限放入list中
	   int sum=0;
	   Iterator it=list.iterator();
	   while(it.hasNext()) {		  
		   Integer  i=(Integer) it.next();//获得角色id
		  //根据角色id，查询权限id
		   List<Integer> p=userService.getPrivilege(i);//获得角色的全部权限id   
		   for(Integer j:p) {
			   //第三步，遍历所有的权限，获得相对于的权限表
			   if(j<=2) {
				   if(sum==0) 
				sum=1;
			   }			   
			   if(j>=3&&j<=5) {
				   if(sum==0) {
					   sum=2; 
				   }if(sum==1) {
					   sum=3;
				   }
			   } 
			   if(j>5) 
			   sum=4;
			   
			   PPrivilege privilege=userService.getPrivilegeById(j);//根据权限id，找到权限
			   //判定权限有没有重复
			   boolean b=true;
			   for(PPrivilege privi:privilegeList) {
				   if(privi.getId()==privilege.getId()) {//如果已经有该权限
					   b=false;
				   }
			   }
			   if(b)
			   privilegeList.add(privilege);
		   }
		   
	   }
	   model.addAttribute("sum", sum);
	   model.addAttribute("privilege", privilegeList);
	   return "index";
   } 	
   
   @RequestMapping("/{pages}")
   public String showPage(@PathVariable String pages) {
	   return pages;
   }
}

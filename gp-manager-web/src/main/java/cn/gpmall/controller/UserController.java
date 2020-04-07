package cn.gpmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
   @RequestMapping("/addUser") //查询未审核的用户页面
   public String addUser() {
	   return "user-add";
   }
   @RequestMapping("/user") //查询所有用户页面
   public String User() {
	   return "user-list";
   }
   @RequestMapping("/userBan") //查询所有违规用户页面
   public String UserBan() {
	   return "user-ban";
   }
   @RequestMapping("/user/list")//获得所有的用户
   @ResponseBody
   public EasyUIData getUserList(Integer page, Integer rows) {
	   EasyUIData result=userService.getUesrList(page, rows);
	   return result;
   }
   @RequestMapping("/user/list/ban")//获得所有的违规用户
   @ResponseBody
   public EasyUIData getUserListBan(Integer page, Integer rows) {
	   EasyUIData result=userService.getUserListBan(page, rows);
	   return result;
   }
   
   @RequestMapping("/user/add")//获得所有的为审核企业用户
   @ResponseBody
   public EasyUIData getUserAdd(Integer page, Integer rows) {
	   EasyUIData result=userService.getUesrAdd(page, rows);
	   return result;
   }
   @RequestMapping("/user/adopt")//企业用户审核通过
   @ResponseBody
   public String getUserAdopt(Integer id) {
	   userService.getUserAdopt(id);
	   
	   return "ok";
   }
   @RequestMapping("/user/noPass")//企业用户审核不通过
   @ResponseBody
   public String getUsernoPass(Integer id) {
	   userService.getUsernoPass(id);
	   
	   return "ok";
   }
   @RequestMapping("/user/ban")//对用户封号
   @ResponseBody
   public String getUserBan(Integer id) {
	   userService.getUserBan(id);
	   return "ok";
   }
   @RequestMapping("/user/relieve")//对用户解封
   @ResponseBody
   public String getUserRelieve(Integer id) {
	   userService.getUserRelieve(id);
	   return "ok";
   }
}

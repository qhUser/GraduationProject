package cn.gpmall.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.utils.CookieUtils;
import cn.gpmall.common.utils.JsonUtils;
import cn.gpmall.sso.service.LoginEnterService;

@Controller
public class LoginEnter {
	@Autowired
	LoginEnterService loginService;
	@RequestMapping("/")
	public String show() {
		return "login";
	}
	@RequestMapping("/admin")
	public String showAdmin() {
		return "adminLogin";
	}
    @RequestMapping("/login")  //用户登录
    @ResponseBody
	public String loginEnter(String username,String password,HttpServletRequest request,HttpServletResponse response,Model model) {
    	try {
    		 String mess= loginService.loginEnter(username, password);
    	        //登录失败
    	        if(mess==null||mess.equals("fail")) {
    	         model.addAttribute("mess","fail");
    	         return "fail";
    	        }else {
    	        	CookieUtils.setCookie(request, response,"token", mess);
    	        	model.addAttribute("mess","success");
    	        	return "success";
    	        }
		} catch (Exception e) {
			return "exception";
		}
       
        
    }
    @RequestMapping("/adminLogin")  //管理员登录
    @ResponseBody
	public String adminLoginEnter(String username,String password,HttpServletRequest request,HttpServletResponse response,Model model) {
    	try {
    		String mess= loginService.adminLoginEnter(username, password);
            //登录失败
            if(mess==null||mess.equals("fail")) {
             model.addAttribute("mess","fail");
             return "fail";
            }else {
            	CookieUtils.setCookie(request, response,"token", mess);
            	model.addAttribute("mess","success");
            	return "success";
            }  
		} catch (Exception e) {
			return "exception";
		}
        
    }
    @RequestMapping("/drop/{token}")//用户退出登录
    public String userDrop(@PathVariable String token){
    	loginService.getdropUserToken(token);
    	return "login";
    }
    @RequestMapping("/drop/admin/{token}")//管理员退出登录
    public String adminDrop(@PathVariable String token){
    	loginService.getdropAdminToken(token);
    	return "adminLogin";
    }
    @RequestMapping("/login/token/{token}")//验证用户是否登录
    @ResponseBody
    public String getUserToken(@PathVariable String token, String callback) {
    	String json=loginService.getUserToken(token);
    	if(json.equals("obsolete")) {
    		return json;
    	}
    	AUser result= JsonUtils.jsonToPojo(json, AUser.class);
    	if (StringUtils.isNotBlank(callback)) {
			//把结果封装成一个js语句响应
			return callback + "(" + JsonUtils.objectToJson(result)  + ");";
		}
    	return JsonUtils.objectToJson(result);
    }
    
    @RequestMapping("/adminlogin/token/{token}")//验证管理员是否登录
    @ResponseBody
    public String getAdminToken(@PathVariable String token, String callback) {
    	String json=loginService.getAdminToken(token);
    	if(json.equals("obsolete")) {
    		return json;
    	}
    	PAdmin result= JsonUtils.jsonToPojo(json, PAdmin.class);
    	if (StringUtils.isNotBlank(callback)) {
			//把结果封装成一个js语句响应
			return callback + "(" + JsonUtils.objectToJson(result)  + ");";
		}
    	return JsonUtils.objectToJson(result);
    }
}

package cn.gpmall.sso.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gpmall.sso.service.RegisterService;

/**
 * 
 * 注册
 * */
@Controller
public class Register {
    @Autowired
    RegisterService register;
	@RequestMapping("/register")
	public String register1() {
		return "register";
	}
	@RequestMapping("/register2")
	public String register2() {
		
		return "register2";
	}
	@RequestMapping("/register/submit")
	public String registerSubmit1(String username,String rolename,String password,String email,String address,String phone,Model model) throws Exception {	
		try {
			String status= register.registerSubmit1(username,rolename,password,email,address,phone);
			model.addAttribute("status", status);
			return "register";
		} catch (Exception e) {
			return "exception";
		}
		
	}
	@RequestMapping("/register2/submit")
	public String registerSubmit2(String username,String rolename,String password,String email,String address,
			String phone,Model model,String organization) {	
		try {
			String status= register.registerSubmit2(username,rolename,password,email,address,phone,organization);
			model.addAttribute("status", status);
			return "register2";
		} catch (Exception e) {
			return "exception";
		}
		
	}
}

package cn.gpmall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.utils.CookieUtils;
import cn.gpmall.common.utils.JsonUtils;
import cn.gpmall.service.UserService;
@Controller
public class Interceptor implements HandlerInterceptor{
    @Autowired
    UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO 方法前
		String cookieValue = CookieUtils.getCookieValue(request, "token");
		String json=userService.getSession(cookieValue);		
		if(json==null||json.equals("")) {
			return false;
		}
		PAdmin admin=JsonUtils.jsonToPojo(json,PAdmin.class);
		request.setAttribute("admin", admin);
		if(admin.getId()==1) {//超级管理员直接放行
			return true;
		}else if(admin.getId()>1){			
			return true;
		}
		return false;
		
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO方法后
		
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 页面渲染后
		
	}

	



}

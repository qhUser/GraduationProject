package cn.gpmall.sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.gpmall.common.mapper.AUserDao;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.sso.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
     AUserDao userDao;
	
	@Override
	public String registerSubmit1(String username, String rolename, String password, String email, String address,
			String phone) {
	    AUser user=new AUser();
	     user.setLoginname(username);
	     user.setNickname(rolename);
	     String md5password=DigestUtils.md5DigestAsHex(password.getBytes());//md5加密密码
	     user.setPassword(md5password);
	     user.setEmail(email);
	     user.setAddress(address);
	     user.setPhonenumber(phone);
	     System.out.println(user.toString());
	     try {
	    	 userDao.register1(user);
	    	 System.out.println("ok");
	 		return "ok";
		} catch (Exception e) {
			System.out.println("fail");
			return "fail";
		}
	    
	}

	@Override
	public String registerSubmit2(String username, String rolename, String password, String email, String address,
			String phone, String organization) {
		 AUser user=new AUser();
	     user.setLoginname(username);
	     user.setNickname(rolename);
	     String md5password=DigestUtils.md5DigestAsHex(password.getBytes());//md5加密密码
	     user.setPassword(md5password);
	     user.setEmail(email);
	     user.setAddress(address);
	     user.setPhonenumber(phone);
	     user.setOrganization(organization);
	     System.out.println(user.toString());
	     try {
	    	 userDao.register2(user);
	    	 System.out.println("ok");
	 		return "ok";
		} catch (Exception e) {
			System.out.println("fail");
			return "fail";
		}
	}
    
}

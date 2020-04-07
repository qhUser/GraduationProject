package cn.gpmall.sso.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.gpmall.common.jedis.JedisClient;
import cn.gpmall.common.mapper.AUserDao;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.utils.JsonUtils;
import cn.gpmall.sso.service.LoginEnterService;
@Service
public class LoginEnterServiceImpl implements LoginEnterService{
    @Autowired
    AUserDao userDao;
    @Autowired
    JedisClient jedisClient;
    @Autowired
    JedisClient jedisClient1;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;
	@Override
	/**
	 * 用户登录
	 * */
	public String loginEnter(String username, String password) {
	   AUser user=userDao.loginEnter(username);
	   String passwordMd5=DigestUtils.md5DigestAsHex(password.getBytes());
	   //用户名不正确
	   if(user==null||user.getLoginname().equals("")) {
		   return "fail";
	   }//密码不正确
	   if(!user.getPassword().equals(passwordMd5)) {
		   return "fail";
	   }
	    // 如果正确生成token。
		String token = UUID.randomUUID().toString();
		// 4、把用户信息写入redis，key：token value：用户信息
		user.setPassword(null);		
		jedisClient.set("User:" + token, JsonUtils.objectToJson(user));
		// 5、设置Session的过期时间
		jedisClient.expire("User:" + token, SESSION_EXPIRE);
		
		return token;
	}
	/**
	 * 管理员登录
	 * */
	public String adminLoginEnter(String username, String password) {
		PAdmin user=userDao.adminLoginEnter(username);
		   //用户名不正确
		   if(user==null||user.getLoginname().equals("")) {
			   return "fail";
		   }//密码不正确
		   if(!user.getPassword().equals(password)) {
			   return "fail";
		   }
		    // 如果正确生成token。
			String token = UUID.randomUUID().toString();
			// 4、把用户信息写入redis，key：token value：用户信息
			user.setPassword(null);
			jedisClient.set("Admin:" + token, JsonUtils.objectToJson(user));
			// 5、设置Session的过期时间
			jedisClient.expire("Admin:" + token, SESSION_EXPIRE);
			
			return token;
	}
	@Override//用户是否登录验证，取token
	public String getUserToken(String token) {
		
		
		//根据token到redis中取用户信息
		String json = jedisClient1.get("User:" + token);		
		
		//取不到用户信息，登录已经过期，返回登录过期
				if (StringUtils.isBlank(json)) {
					return "obsolete";
				}
				AUser user1 = JsonUtils.jsonToPojo(json,AUser.class);
				AUser user=userDao.loginEnter(user1.getLoginname());//重新查询数据库的用户信息，如果用户信息更改了可以重新赋值
				//取到用户信息更新token的过期时间
				user.setPassword(null);						
				jedisClient.set("User:" + token, JsonUtils.objectToJson(user));
				// 5、设置Session的过期时间
				jedisClient.expire("User:" + token, SESSION_EXPIRE);
				
		return json;
	}
	@Override  //管理员是否登录验证，取token
	public String getAdminToken(String token) {
		//根据token到redis中取用户信息
				String json = jedisClient1.get("Admin:" + token);
				//取不到用户信息，登录已经过期，返回登录过期
						if (StringUtils.isBlank(json)) {
							return "obsolete";
						}
						//取到用户信息更新token的过期时间
						jedisClient1.expire("Admin:" + token, SESSION_EXPIRE);
						//AUser user= JsonUtils.jsonToPojo(json, AUser.class);
				return json;
	}
	@Override //用户退出
	public void getdropUserToken(String token) {
		//取到用户信息更新token的过期时间
		jedisClient1.expire("User:" + token, 0);//将用户设置过期
		
	}
	@Override
	public void getdropAdminToken(String token) {
		//取到用户信息更新token的过期时间
				jedisClient1.expire("Admin:" + token, 0);//将用户设置过期
	}	
}

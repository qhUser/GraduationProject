package cn.gpmall.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gpmall.common.jedis.JedisClient;
import cn.gpmall.common.mapper.AUserDao;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.common.pojo.PPrivilege;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    AUserDao aUser;
    @Autowired
    JedisClient jedisClient;
	@Override
	public EasyUIData getUesrAdd(Integer page, Integer count) {
		Page pa=new Page(page,count);
		List<AUser> row=aUser.getUserAdd(pa);
		EasyUIData result=new EasyUIData();
		result.setRows(row);
		Integer sum=aUser.getUserAddSum();		
		result.setTotal(sum);
		return result;
	}

	@Override
	//审核企业用户通过
	public void getUserAdopt(Integer id) {
		aUser.getUserAdopt(id);
		
		
	}

	@Override
	public void getUsernoPass(Integer id) {
		aUser.getUsernoPass(id);
		
	}
    //查询所有的用户
	@Override
	public EasyUIData getUesrList(Integer page, Integer count) {
		Page pa=new Page(page,count);
		List<AUser> row=aUser.getUserList(pa);
		EasyUIData result=new EasyUIData();
		result.setRows(row);
		Integer sum=aUser.getUserListSum();		
		result.setTotal(sum);
		return result;
	}

	@Override//对用户封号
	public void getUserBan(Integer id) {
		
		aUser.getUserBan(id);
	}

	@Override//获得所有的违规用户
	public EasyUIData getUserListBan(Integer page, Integer count) {
		Page pa=new Page(page,count);
		List<AUser> row=aUser.getUserListBan(pa);
		EasyUIData result=new EasyUIData();
		result.setRows(row);
		Integer sum=aUser.getUserListBanSum();		
		result.setTotal(sum);
		return result;
	}

	@Override//对用户解封
	public void getUserRelieve(Integer id) {
		aUser.getUserRelieve(id);
		
	}

	@Override//根据cookie判断redis中有没有用户信息
	public String getSession(String cookieValue) {
		//根据token到redis中取用户信息
		String json = jedisClient.get("Admin:" + cookieValue);
		//取不到用户信息，登录已经过期，返回登录过期
		if (StringUtils.isBlank(json)) {
			return "";
		}		
		//取到用户信息更新token的过期时间
		jedisClient.expire("Admin:" + cookieValue, 1800);
      return json;
	}

	@Override//查询用户所有角色
	public List<Integer> getRole(Integer id) {
		List<Integer> list= aUser.getRole(id);
		
		return list;
	}

	@Override//获得角色的全部权限id   
	public List<Integer> getPrivilege(Integer i) {
		List<Integer> list=aUser.getPrivilege(i);
		return list;
	}

	@Override//根据权限id，找到权限
	public PPrivilege getPrivilegeById(Integer j) {
		PPrivilege privilege=aUser.getPrivilegeById(j);
		return privilege;
	}
    
	
}

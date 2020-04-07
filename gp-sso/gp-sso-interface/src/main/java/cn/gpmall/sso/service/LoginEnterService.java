package cn.gpmall.sso.service;

public interface LoginEnterService {
   String loginEnter(String username,String password);//用户登录
   String adminLoginEnter(String username, String password);//管理员登录
String getUserToken(String token);//用户去token
String getAdminToken(String token);//管理员token
void getdropUserToken(String token);//用户退出，清楚缓存
void getdropAdminToken(String token);//管理员退出


}

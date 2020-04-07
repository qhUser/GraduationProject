package cn.gpmall.sso.service;

public interface RegisterService {

	String registerSubmit1(String username, String rolename, String password, String email, String address, String phone);

	String registerSubmit2(String username, String rolename, String password, String email, String address,
			String phone, String organization);
   
}

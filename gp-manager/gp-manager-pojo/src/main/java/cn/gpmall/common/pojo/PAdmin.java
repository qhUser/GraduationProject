package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 管理员表
 * */
public class PAdmin implements Serializable {
    private Integer id;  //管理员id

    private String loginname;  //登录名

    private String nickname;   //昵称

    private String password;   //密码

    private String email;      //邮箱

    private String phonenumber; //电话

    private Integer gender;   //性别

    private String description;  //描述

    private Boolean visable;  //部门id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Boolean getVisable() {
		return visable;
	}

	public void setVisable(Boolean visable) {
		this.visable = visable;
	}
    
 
}
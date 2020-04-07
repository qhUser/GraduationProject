package cn.gpmall.common.pojo;

import java.io.Serializable;

public class UserBalance implements Serializable{
   private Integer id;
   private Double money;    //金额
   private String password; //密码
   
public UserBalance(Integer id, Double money) {
	this.id = id;
	this.money = money;
}

public UserBalance(Integer id, String password) {
	this.id = id;
	this.password = password;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Double getMoney() {
	return money;
}
public void setMoney(Double money) {
	this.money = money;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   

}

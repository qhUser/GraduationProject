package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class UserComment implements Serializable{
   private String averager;   //平均分
   private String userName;   //卖家名
   private List list;         //所有评价内容
  
public String getAverager() {
	return averager;
}
public void setAverager(String averager) {
	this.averager = averager;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
public String getUserName() {
	if(this.userName==null) {
		return "0";
	}
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
   
}

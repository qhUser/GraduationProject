package cn.gpmall.common.pojo;

import java.io.Serializable;

public class AEvaluate implements Serializable{
   private Integer id;
   private Integer mark;
   private String comment;
   private Integer userId;
   private boolean visable;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getMark() {
	return mark;
}
public void setMark(Integer mark) {
	this.mark = mark;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public boolean isVisable() {
	return visable;
}
public void setVisable(boolean visable) {
	this.visable = visable;
}
   
}

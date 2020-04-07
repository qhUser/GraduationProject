<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>

  <div id="Max"> 
  <div style="width:30%;height:100%;float:left;"></div>
    <div id="Min"><input type="hidden" value="${status}" id="status">
    <h2>用户注册</h2>
    <a href="/register2">企业用户注册</a>
    <form action="/register/submit" method="post">
    <div style="width:30%;height:100%;text-align:right;float:left;">
        <p>用户名:</p>
        <p>真实姓名:</p>
        <p>密码:</p>
        <p>确认密码:</p>
        <p>电子邮箱:</p>
        <p>地址:</p>
        <p>联系电话:</p>
    </div>
    <div style="width:25%;height:100%;text-align:left;float:left;">
    <input type="text" placeholder="请输入" name="username">
    <input type="text" placeholder="请输入"name="rolename">
    <input type="password" name="password">
    <input type="password" >
    <input type="text" placeholder="请输入"name="email">
    <input type="text" placeholder="请输入"name="address">
    <input type="text" placeholder="请输入"name="phone">
    </div>
    <div style="width:40%;height:100%;text-align:left;float:left;">
    <p>*</p>
     <p>*</p>
      <p>*</p>
       <p>*</p>
        <p>*</p>
         <p>*</p>
          <p>*</p>
    </div>
    <div style="width:100%"><input type="submit" value="注册" > </div>
    </form>
    </div>
  </div>

</body>
<style>
  input,p{
  margin-top:16px;
  }
   
   #Max{
  background:url(../../img/timg.jpg) no-repeat ;
  background-size:cover;
   text-align:center;
   width:100%;
   height:1024px;
   }
   #Min{
   background-color:rgba(255,255,255,0.4);
   width:40%;
   height:70%;
   float:left;
   }
</style>
<script type="text/javascript">
$(function(){
	var status=$("#status").val();
	if(status=="ok"){
		alert("注册成功");
		location.href="http://localhost:8082";
	}
	if(status=="fail"){
		alert("注册异常,请重新注册");
	}
});
</script>
</html>

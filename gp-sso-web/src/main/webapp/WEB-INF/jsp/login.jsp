<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" ></link>
<link rel="stylesheet" type="text/css" href="../../css/mycss.css"></link>
<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div id="Max"> 
  <div style="width:30%;height:100%;float:left;"></div>
    <div id="Min">
    <h2>用户登录</h2>
    
    <div style="width:30%;height:100%;text-align:right;float:left;">
        <p>登录名: </p>
        <p> 密码:</p>
    </div>
    <div style="width:25%;height:100%;text-align:left;float:left;">
      <input type="text"  id="loginname">
       <input type="password"  id="password">
        <input type="submit" value="登录" onclick="login();"><span id="mess">${mess}</span>
    </div>
    <div style="width:40%;height:100%;text-align:left;float:left;">
    <p>*</p>
     <p>*</p> 
    </div>
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
  function login(){
	 var loginname=$("#loginname").val();	 
	 var password=$("#password").val();
	 var mess=$("#mess");
	  $.post("/login",
			  {"username":loginname,"password":password},
			  function(data){
		       if(data=="success"){
		    	   location.href="http://localhost:8082";
		       }else{
		    	   mess.css("color","red");
		    	   mess.text("用户名或密码错误");
		       }
	          }		  
	  );
	  
  }
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" ></link>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap-theme.css" ></link>
<link rel="stylesheet" type="text/css" href="../../css/mycss.css" ></link>
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/gpmall.js"></script>
<script type="text/javascript" src="../../js/jquery.cookie.js"></script>
</head>
<body>
 <jsp:include page="head.jsp"></jsp:include>

 
  
   <!--
	
	描述：轮播区域
-->
<div class="row">
<div class="col-md-2">

</div>
  <div class="col-md-1">
  <form action="http://localhost:8085/list">
  <input type="hidden" name="keyword" id="keyword">
    <div style="width:110%;background-color: #041656;color:#fff;height:30px;">商品分类</div>
    <div class="type"onclick="type(this);">饰品</div>
    <div class="type"onclick="type(this);">手表</div>
    <div class="type"onclick="type(this);">电脑</div>
    <div class="type"onclick="type(this);">手机</div>
    <div class="type"onclick="type(this);">收藏品</div>
    <div class="type"onclick="type(this);">艺术品</div>
    <div class="type"onclick="type(this);">书本</div>
    <div class="type"onclick="type(this);">杂志</div>
    <div class="type"onclick="type(this);">衣物</div>
    <div class="type"onclick="type(this);">包包</div>
    <div class="type"onclick="type(this);">其他</div>
  </form>
  </div>
   <div id="myCarousel" class="carousel slide col-md-7" >
	<ol class="carousel-indicators">
		<li data-target="#myCarousel"  data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active" style="height:600px;">
			<img src="../img/h1.jpg" alt="第一张">
		</div>
		<div class="item" style="height:600px;">
			<img src="../img/h2.jpg" alt="第二张">
		</div>
		<div class="item" style="height:600px;">
			<img src="../img/h3.jpg" alt="第三张">
		</div>

	</div>
	<a href="#myCarousel" data-slide="prev" class="carousel-control left">		
	</a>
	<a href="#myCarousel" data-slide="next" class="carousel-control right">		
	</a>
	
</div>

<div class="col-md-2"></div>
</div><!-- 轮播区域 -->
<div class="row">
<div class="col-md-2"></div>
<div class="col-md-2">
<h3>最新拍卖信息</h3>
</div>

</div>

<!-- 最新商品区域 -->
  <div class="row"  id="newCom" >
    
  </div><!-- 最新商品区域 -->
</body>

<script type="text/javascript">
 $(function(){
	 loadon();
 });
   function loadon(){	 
	   //加载新添加的商品
	   var html=$("#newCom").html();
	 
	   $.post(
		"/list/new",
		{},
		function(data){
			
			 for(var i=1;i<=data.length;i++){	
				 
				 if(i%4==1){
					 html+="<div class='col-md-2'></div>";
				 }				
					 html+="<div class='col-md-2 thumbnail'>";
					 html+="<img src='"+data[i-1].photoUrl+"' alt='...' class='img-thumbnail' style='width:90%;height:200px;'>";
					 html+="<div class='caption'>";
					 html+="<h3>"+data[i-1].commodityname+"</h3>";
					 html+="<textarea row='30'   style='border-style:none;background-color:#fff;overflow:hidden; resize:none;' disabled='disabled'>"+data[i-1].description+"</textarea>";
					 html+="<p><a href='#' class='btn btn-primary' role='button'>了解详情</a></div></div>";
				 if(i%4==0){
					 html+="<div class='col-md-2' style='height:400px;'></div>";
					 
				 }
				 
			 } 
			
			 $("#newCom").html(html); //注意function 里面相当于一个java方法,方法里面改变值,外面不改变
			
		},"json"
		 );
}
   function type(name){
	   var keyword=$("#keyword");
	   keyword.val($(name).text());  
	   $(location).attr("href","http://localhost:8085/list?keyword="+keyword.val());
   }
   
   
 //轮播自动播放
	$('#myCarousel').carousel({
		//自动4秒播放
		interval : 3000,
	});
   $(".nav li").click(function(){
   	$(this).addClass("active").siblings().removeClass("active");
   	$("html,body").animate({scrollTop:'650px'},800);
   })

	
</script>

</html>
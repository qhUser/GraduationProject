<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>Insert title here</title>
<link href="../../css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" ></link>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap-theme.min.css" ></link>
<link rel="stylesheet" type="text/css" href="../../css/mycss.css"></link>

<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
    <script src="../../js/moment-with-locales(1).js"></script>
    <script src="../../js/bootstrap-datetimepicker.min.js"></script>
    <script src="../../js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/gpmall.js"></script>
<script type="text/javascript" src="../../js/jquery.cookie.js"></script>
</head>

<body>
<jsp:include page="head2.jsp"></jsp:include>
<form action="/picture" method="post" enctype="multipart/form-data">
 <div class="row"> 
 <div style="height:50px;text-align:center;font-size:24px;font-weight:bold;line-height:50px;" id="title"></div>
 <div class="col-md-3" style="height:600px;"></div> 
 <div class='col-md-6'><div class='col-md-4 deupte'>商品名称:</div><div class='col-md-8 deupte1' ><input type="text" name="comName"></div></div>
 <div class='col-md-6'><div class='col-md-4 deupte'>商品分类:</div><div class='col-md-8 deupte1'>
 <div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" >
    <span id="swit" >请选择</span>
   <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" id="dpdown">  
  <li></li>
  </ul>
</div></div></div>
 <div class='col-md-6'><div class='col-md-4 deupte'>开拍时间:</div><div class='col-md-8 deupte1'>
   <a class='input-group date' id='datetimepicker1' style="float: left; ">
  <input type='text' class="form-control" id='nowdate' style="width: 150px; height: 30px;"name="startDate" />
   <span class="input-group-addon" style="float: left; width: 50px; height: 30px;">
   <span class="glyphicon glyphicon-calendar"></span>
  
   </span> 
  </a>
  <span style="float: left; ">&nbsp;至&nbsp;</span>
  <a class='input-group date' id='datetimepicker2' style="float: left; ">
  <input type='text' class="form-control " id='nowdate2' style="width: 150px; height: 30px;" name="endDate"/>
   <span class="input-group-addon" style="float: left; width: 50px; height: 30px;">
   <span class="glyphicon glyphicon-calendar"></span>
   </span>
   </a>
   
   </div></div>
 <div class='col-md-6'><div class='col-md-4 deupte'>起拍价:</div><div class='col-md-8 deupte1'><input type="text" name="lastprice"></div></div>
  <div class='col-md-6'><div class='col-md-4 deupte'>数量:</div><div class='col-md-8 deupte1'><input type="text" name="count"></div></div>
  <div class='col-md-6'><div class='col-md-4 deupte'>上传图片：</div><div class='col-md-8 deupte1'>
  <input type="file" name="pictureFile" id="picture"></div></div>
 <div class='col-md-6'><div class='col-md-4 deupte'>商品描述：</div><div class='col-md-8 deupte1'>
 <textarea rows="6" cols="50" name="descript"></textarea></div></div>
 <div class='col-md-6'><div class='col-md-4 deupte'></div><div class='col-md-8 deupte1'>

<button class="btn btn-danger" type="submit">发布委托</button><c:if test="${key=='ok'}"><span style="color:red;">发布成功</span></c:if>
 </div></div>
 </div>
</form>
<c:if test="${level==3}">
<jsp:include page="accept.jsp"></jsp:include>
</c:if>
</body>
<script type="text/javascript">
$(function(){
	switchitem();
	Datetime();//起始日期
	Datetime2();//结束日期
	
	
});
/*接受委托*/
function accept(){
	  var suppid=$(".userId").val();
	  alert(suppid);
	  var comid=$("#comid").text();
	  $.post("/acceptCom",
			  {"comid":comid,"suppid":suppid},
			  function(data){
				  alert("已成功委托该商品");
				  
			  })
}
function switchitem(){
	var html=$("#dpdown").html();
	var swit=$("#swit");
	var level=$(".userlevel");	
	if(level==1){
		$("#title").text("");
		$("#title").text("发布商品拍卖委托");
	}else{
		$("#title").text("");
		$("#title").text("发布商品拍卖");
	}
	$.post("/switchitem",
			{},
			function(data){
				
				for(var i=0;i<data.list.length;i++){
					html+="<li><a style='cursor: pointer;'>"+data.list[i].typename+"</a><input type='hidden'   value='"+data.list[i].id+"'></li>";
				}
				
				$("#dpdown").html(html);
				
				$("#dpdown li ").click(function(){
					var text=$(this).text();					
					swit.text("");
					swit.text(text);
					var val=$(this).find("input").val();	
					var userId=$(".userId").val();
					var userlevel=$(".userlevel").val();
					$("form").attr("action","/picture?swit="+val+"&id="+userId+"&level="+userlevel);//发布商品 默认委托方id为1，有时间在修改
				});
			});
	
}


function Datetime() {
    $('#datetimepicker1').datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式
        minView: "month",//设置只显示到月份
        initialDate: new Date(),
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        locale: moment.locale('zh-cn')
    });
    //默认获取当前日期
    var today = new Date();
    var nowdate = (today.getFullYear()) + "-" + (today.getMonth() + 1) + "-" + today.getDate();
    //对日期格式进行处理
    var date = new Date(nowdate);
    var mon = date.getMonth() + 1;
    var day = date.getDate();
    var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
    document.getElementById("nowdate").value = mydate;
}
function Datetime2() {
    $('#datetimepicker2').datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式
        minView: "month",//设置只显示到月份
        initialDate: new Date(),
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        locale: moment.locale('zh-cn')
    });
    //默认获取当前日期
    var today = new Date();
    var nowdate = (today.getFullYear()) + "-" + (today.getMonth() + 1) + "-" + today.getDate();
    //对日期格式进行处理
    var date = new Date(nowdate);
    var mon = date.getMonth() + 1;
    var day = date.getDate();
    var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
    document.getElementById("nowdate2").value = mydate;
}
</script>
</html>
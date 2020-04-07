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
<script type="text/javascript" src="../../js/gpmall.js"></script>
<script type="text/javascript" src="../../js/jquery.cookie.js"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div  style="height:50px;width:100%;"></div>
<div class="row" style="background-color:#fafafa; height:700px; border-top:3px solid #000;">
<div class="col-md-2" style="height:700px;"></div>
<div class="col-md-10"style="height:30px;color:#666;line-height:30px;">当前位置:首页->商品详情</div>
<div class="col-md-8" style="background-color:#fff;border:1px solid #ebebeb;padding:15px;">
<div class="col-md-4" style="margin-top:80px;">
<img src="${item.photoUrl}" alt="..." class="img-thumbnail"style="height:280px;">
 <div class="l0">
  <div  class="l1">卖家信息</div>
  <div style="text-align: center;">卖家:<span id="sellerId"></span></div>
  <div style="margin-top:10px;text-align: center;">综合评分:&nbsp;<span id="mark"></span>分</div>
  <div style="margin-top:10px;text-align: center;">共:&nbsp;<span id="count"></span>条评论</div>
  <div style="margin-top:10px;text-align: center;"><span id="checkcomment">
  <button type='button' class='btn btn-link ' data-toggle='modal' data-target='#my2Modal'>查看评论</button>
  </span></div>
  </div>
</div>
  <div class="col-md-7"style="margin:10px;font-size:20px;text-align:center;">
  ${item.commodityname}
  </div>
  <div class="col-md-7" style="margin:0px 10px;color:#666;" >
  商品编号：<span id="itemid">${item.id}</span>
  </div>
  <div class="col-md-7 l3" >
  参与竞拍商品时，请认真阅读有关条款，为您带来不便敬请原谅！
  </div>
  <div class="l2">
  <div  class="l1">温馨提示</div>
  参与竞拍商品时，请认真阅读有关条款，为您带来不便敬请原谅！
  参与竞拍商品时，请认真阅读有关条款，为您带来不便敬请原谅！
  参与竞拍商品时，请认真阅读有关条款，为您带来不便敬请原谅！
  </div>
  <div  class="l4">
  <div >
   当前价&nbsp;:&nbsp;RMB<span style="font-size:40px;color:red">${item.nowprice}</span>
   <span style="background-color: #223066;color:#fff;font-size:15px;">加价单位:${item.addPrice}</span>
  </div>
  <div>
  出价:<span style="color:red">${item.addCount}</span>次
  </div>
  <div style="height:50px;"></div>
  <div style="background-color:#fafafa;width:100%;height:70px;line-height:70px;color:#666;font-size:20px;position:relative;">
  <div style="float:left;"> <span style="margin-top:35px;"><img alt="..." src="../../img/timg.jpg"style="width:30px;height:30px;margin-left:10px;margin-right:10px;"></span>剩余:</div>
  <input type="hidden" id="time" value="${date}">
  <div class="l5" id="d1"></div><div class="l5"id="d2"></div><div style="float:left;">天</div>
  <div class="l5"id="h1"></div><div class="l5"id="h2"></div><div style="float:left;">时</div>
  <div class="l5"id="m1"></div><div class="l5"id="m2"></div><div style="float:left;">分</div>
  <div class="l5"id="s1"></div><div class="l5"id="s2"></div><div style="float:left;">秒</div>
  <div style="float:left;"></div>
  </div>
  </div>
  
  <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">出价竞拍</h4>
      </div>
      <div class="modal-body">
        <div>本商品现在价格:<span id="oldPrice">${item.nowprice}</span>元</div>
        <div>最低加价不得低于:<span id="addPrice">${item.addPrice}</span>元</div>
        
        <div style="margin-top:20px;">出价金额:<input type="text" id="nowprice" onmouseout="che();">
        <span id="mess"></span>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="addprice();">确认报价</button>
      </div>
    </div>
  </div>
</div>
  
  <div class="col-md-12" style="text-align: center;">
  
   <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="checkstatus();">报价</button>
  </div>
</div>  


   <!-- Modal -->
<div class="modal fade" id="my2Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >评价内容</h4>
      </div>
      <div class="modal-body" id="modelBody">
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</div>
</body>
<script type="text/javascript">
var timer1=null;
$(function(){  //页面加载后，加载商家信息
	var itemid=$("#itemid").text();
	var sellerId
	$.post(     //获得商品供应商信誉
		"/usercomment",
		{"itemid":itemid},
		function(data){
			$("#sellerId").html(data.userName);
			$("#mark").html(data.averager);
			$("#count").html(data.list.length);
			$("#my2ModalLabel").html(data.userName);
			var html=$("#modelBody").html();
			for(var i=0;i<data.list.length;i++){
				html+="<p>买家"+eval(i+1)+"："+data.list[i].comment+"</p>"
			}
			$("#modelBody").html(html);
		}
	)
	
	start();//定时器
})
   //定时器
  function start(){
	var s=$("#time").val();
	function fn(){
		var unixTimestamp = new Date(s*1) ;
		commonTime = unixTimestamp.toLocaleString();
		var array=commonTime.split(".");
		var tt=[];
		for(var i=0;i<array.length;i++){
			tt.push(parseInt(array[i]));
		}
		var ar=null;
		
		ar=(tt[0]+"").split("");		
		if(ar.length==2){			
				$("#d1").html(ar[0]);$("#d2").html(ar[1]);
		}else{
			$("#d1").html("0");$("#d2").html(ar[0]);
		}
		
		ar=(tt[1]+"").split("");		
		if(ar.length==2){			
				$("#h1").html(ar[0]);$("#h2").html(ar[1]);
		}else{
			$("#h1").html("0");$("#h2").html(ar[0]);
		}
		
		ar=(tt[2]+"").split("");		
		if(ar.length==2){			
				$("#m1").html(ar[0]);$("#m2").html(ar[1]);
		}else{
			$("#m1").html("0");$("#m2").html(ar[0]);
		}
		
		ar=(tt[3]+"").split("");		
		if(ar.length==2){			
				$("#s1").html(ar[0]);$("#s2").html(ar[1]);
		}else{
			$("#s1").html("0");$("#s2").html(ar[0]);
		}
		
		
		s-=1000;
	}
	timer1=setInterval(fn,1000);
	
}
Date.prototype.toLocaleString = function() {
    return this.getDate() + "." + this.getHours() + "." + this.getMinutes() + "." + this.getSeconds() ;
};
function addprice(){
	var id=$("#userId").val();
	var bail=$("#bail").val();
	
	if(id==""){
		alert("请您先登录!")
		// location.href="http://localhost:8090";	
		return;
	}
	var falg;
	var falg1;
    if(bail==null||bail==0){
    	falg=confirm("您未缴纳保证金，是否现在缴纳保证金？")
    	if(falg){
    		falg1=confirm("保证金为200元，您确定缴纳么?")
    	}else{
    		return;
    	}
    	if(falg1){
    		$.ajax({
                url:"/bail",
    			async : false,
    			type : "POST",
    			data:{"id":id},
    			 success:function(data){
    				if(data=="OK"){
    					alert("缴纳保证金成功")
    					location.href="/list";
    					return;
    				}else{
    					alert("缴纳失败，账户余额不足，请充值")
    					return;
    				}
    			}
    		}
    			
    				);
    	}else{
    		return;
    	}		
    } 
	
	
	var itemid=$("#itemid").text();
	var userid=$("#userId").val();
	var nowprice=$("#nowprice").val();
	var oldprice=$("#oldPrice").text();
	var addPrice=$("#addPrice").text();
	var mess=$("#mess");
	var falg2=((parseInt(nowprice)-parseInt(oldprice))>=parseInt(addPrice));
	var flag3=false;
	if(falg2){
		 flag3=confirm("您确定以"+nowprice+"元竞拍该商品?");
	}	
	if(flag3){
		$.post("/addprice",
				{"itemid":itemid,"userid":userid,"nowprice":nowprice},
				function(data){
					alert("竞拍成功");
					var itemid=$("#itemid").text();
					location.href="/details?id="+itemid;
				});
	}	
}
function che(){  //报价是否符合规范，符合规范报价成功
	var nowprice=$("#nowprice").val();
	var oldprice=$("#oldPrice").text();
	var addPrice=$("#addPrice").text();
	var mess=$("#mess");
	var falg=((parseInt(nowprice)-parseInt(oldprice))>=parseInt(addPrice))
	
	if(falg){
		mess.css("color","green");
		mess.text("报价符合规范");
		
	}else{
		mess.css("color","red");
		mess.text("报价不符合规范");
	}
}
function checkstatus(){//判定用户是否登录
	
}
</script>
</html>
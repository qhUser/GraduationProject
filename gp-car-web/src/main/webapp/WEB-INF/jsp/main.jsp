<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <div class="row">
 <div style="height:50px;"></div>
 <div class="col-md-2"></div> 
 
   <div class="col-md-1">
   <h5>当前位置->我的信息</h5>
   <div style="width:100%; height:450px;border:1px solid #ccc;" class="Itemlist">
    <div class="headtitle">账户中心</div>   
    <div class="itemtitle"><a>账户信息</a></div> 
    <div class="itemtitle"><a>账户充值</a></div>
    <div class="itemtitle"><a>修改密码</a></div>
    <div class="headtitle">订单管理</div> 
    <div class="itemtitle"><a>我的订单</a></div>
    <div class="headtitle">信息管理</div> 
    <div class="itemtitle"><a>我的信息</a></div>
    <div class="itemtitle"><a>我参与的</a></div>
    <div class="itemtitle"><a>我的收藏</a></div>
    </div>
    </div>
   <div class="col-md-7" id="element">
 
  </div> 
   <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >订单编号:<span id="myModalLabel"></span></h4>
      </div>
      <div class="modal-body">
      <p> 请输入1~5评分:<input type="text" id="rate"></p>
      <p>评价内容:</p>
      <div>      
      <textarea rows="6" cols="80" id="txt"></textarea>
      </div> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="comment();">确认评价</button>
      </div>
    </div>
  </div>
</div>

 </div>
</body>
<script type="text/javascript">
   $(function(){
	  
	   $(".itemtitle a").click(function(){
				     
		   var text=$(this).text();
		   
		   if(text=="账户信息")
			{ $("#element").html(""); //将html页面清空
			   var html=$("#element").html(); 
			   var id=$(".userId").val();  
			   $.post(
					"/list1",
					{"id":id},
					function(data){				
html+="<div  class='list'>账户信息</div> <div style='border-top:2px solid #ccc;'></div> ";					
html+="<div class='kk col-md-2'><ul><li>账户:</li><li>真实姓名</li><li>账户余额</li><li>手机:</li><li>邮箱:</li><li>账户类型:</li><li>地址:</li></ul></div>";
html+="<div class='kk2 col-md-6'><ul><li>"+data.loginname+"</li><li>"+data.nickname+"</li><li>"+data.balance+"</li><li>"+data.phonenumber+"</li><li>"+data.email+"</li><li>"+data.userType.usertype+"</li><li>"+data.address+"</li></ul></div>";
html+="<div class='col-md-3'><img src='../../img/default.gif' alt='...' class='img-thumbnail'></div>";
html+="<div class='col-md-12' style='text-align:center;'><button type='button' class='btn btn-danger'>修改信息</button></div>";
$("#element").html(html);

					}
			   );
			  
			}
		   if(text=="账户充值"){
			   $("#element").html("");
			   var html=$("#element").html();
			   html+="<div  class='list'>账户充值</div> <div style='border-top:2px solid #ccc;'></div> ";
			   html+="<div class='kk col-md-2'></div>";
			   html+="<div class=' col-md-6'>输入充值金额:<input type='text' id='money'></div>";
			   html+="<div ><button type='button' class='btn btn-danger' onclick='recharge(); '>充值</button></div>";
			   $("#element").html(html);		 }
		   if(text=="修改密码"){
			   $("#element").html("");
			   var html=$("#element").html();
			   html+="<div  class='list'>修改密码</div> <div style='border-top:2px solid #ccc;'></div> ";
			   html+="<div class='kk col-md-2'></div>";
			   html+="<div class=' col-md-6'><div style='margin-top:30px'>请输入新密码:<input type='password' id='pas1'></div>"
			   html+="<div style='margin-top:30px'>请确认新密码:<input type='password' id='pas2' onmouseout='re()'><span  id='test'></span></div>";
			   html+="<div style='margin-top:30px'><button type='button' class='btn btn-danger' onclick='revise(); '>确认修改</button><span  id='test1'></span></div>";
			   $("#element").html(html);
			   }
		   if(text=="我的订单"){			   
			   $("#element").html("");
			   var html=$("#element").html();
			   html+="<div  class='list'>我的订单</div> <div style='border-top:2px solid #ccc;'></div> ";	
			   html+="<div class='col-md-12' style='height:40px'></div>"
			   html+="<div class='col-md-2 orderlist' ><span>订单编号</span></div>"
			   html+="<div class='col-md-2 orderlist' ><span>商品名称</span></div>"			   		   
			   html+="<div class='col-md-2 orderlist' ><span>成交金额</span></div>"
			   html+="<div class='col-md-2 orderlist' ><span>成交时间</span></div>"
			   html+="<div class='col-md-2 orderlist' ><span>订单状态</span></div>"
			   html+="<div class='col-md-2 orderlist' ><span>操作</span></div>"
				   $("#element").html(html);  
			   var id=$(".userId").val();
		
			   $.post("/list4",
					   {"id":id},
					   function(data){
						  
						   for(var i=0;i<data.list.length;i++){
							       html+="<div class='col-md-2 orderlist1' ><span>"+data.list[i].id+"</span></div>"  
							       html+="<div class='col-md-2 orderlist1' ><span>"+data.list[i].aCom.commodityname+"</span></div>"							  
								   html+="<div class='col-md-2 orderlist1' ><span>"+data.list[i].price+"</span></div>"
								   html+="<div class='col-md-2 orderlist1' ><span>"+data.list[i].aOrderlist.newcreatedate+"</span></div>"
								   html+="<div class='col-md-2 orderlist1' ><span>"+data.list[i].aOrderlist.status+"</span></div>"
								   if(data.list[i].aOrderlist.isok==1)
								html+="<div class='col-md-2 orderlist1' ><span>未结束</span></div>"
								   if(data.list[i].aOrderlist.isok==2)
								   html+="<div class='col-md-2 orderlist1' ><span><a onclick='payment("+data.list[i].id+");'>去付款</a></span></div>"
								   if(data.list[i].aOrderlist.isok==3)
									   html+="<div class='col-md-2 orderlist1' ><span><a onclick='receiving("+data.list[i].id+");'>收货</a></span></div>"
								if(data.list[i].aOrderlist.isok==4)
html+="<div class='col-md-2 orderlist1' ><span><button type='button' class='btn btn-link ' data-toggle='modal' data-target='#myModal' onclick='openModel("+data.list[i].id+");'>评价</button></span></div>"
							    if(data.list[i].aOrderlist.isok==5)
								    html+="<div class='col-md-2 orderlist1' ><span><a></a></span></div>"
							
						   }
						   html+="<div class='col-md-5  style='text-align:center;'><a>上一页&nbsp;&nbsp;</a><a>下一页</a></div>"
						   $("#element").html(html);
						  
					   },
					   "json");
			   
			   
		   }
               
   });
   });
   function comment(orderid){
	   var orderid=$("#myModalLabel").text();
	   var rate=$("#rate").val();
	   var txt=$("#txt").val();
	    $.post("/comment",
	    		 {"orderid":orderid,"rate":rate,"txt":txt},
	    		 function(data){
	    			 if(data=="OK"){
	    				 alert("评价成功") 
	    			 }else{
	    				 alert("评价失败")
	    			 }   			 
	    	 });	
   }
   
   
   function payment(orderid){//付款
	   var userid=$(".userId").val();//获得用户id	  
	   var flag=confirm("确定付款么？");
	   if(flag){
		   $.post("/payment",
		    		 {"userid":userid,"orderid":orderid},
		    		 function(data){
		    			 if(data=="OK"){
		    				 alert("付款成功")
		    				 location.href="/";
		    			 }else if(data=="NO"){
		    				 alert("付款失败,余额不足")
		    			 }else{
		    				 alert("付款失败")
		    			 }
		    			 
		    		 });
	   }
	    
	   }
   function receiving(orderid){//收货
	   var userid=$(".userId").val();//获得用户id	  
	   var flag=confirm("确定收货么？");
	   if(flag){	   
		   $.post("/receiving",
		    		 {"userid":userid,"orderid":orderid},
		    		 function(data){
		    			 if(data=="OK"){
		    				 alert("操作成功")
		    				 location.href="/";
		    			 }else{
		    				 alert("操作失败")
		    			 }
		    			 
		    		 });
	   }
	   }
   function openModel(orderid){//评论
	   var userid=$(".userId").val();//获得用户id	  
	   $("#myModalLabel").html(orderid);
		    
   }
 
   
  function recharge(){//充值
	  var money=$("#money").val();
	  var html=$("#element").html();
	  var id=$(".userId").val();
	  var flag=confirm("确定充值"+money+"元吗?")
	  if(flag){
		  $.post(
					"/list2",
					{"id":id,"money":money},
					function(data){
						html+="<div style='color:#5cb85c'>充值成功</div>";
						$("#element").html(html);
					}
				   );
	  }
	 
  }
  function re(){ //修改密码验证
	  var pas1=$("#pas1").val();var pas2=$("#pas2").val();
	   var test=$("#test");
      if(pas1==pas2){
    	  test.css("color","#5cb85c");
    	  test.html("通过");
      }else{
    	  test.css("color","red");
    	  test.html("两次密码不一致");
      }   
  }
  function revise(){//修改密码
	  var password=$("#pas1").val();
	  var test1=$("#test1");
	  var id=$(".userId").val();
	  $.post(
		  "/list3",
		  {"id":id,"password":password},
		  function(data){
			 test1.css("color","#5cb85c");
			  test1.html("密码修改成功");
		  }
		  
	  );
  }
</script>
</html>
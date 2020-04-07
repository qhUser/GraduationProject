<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="addadminTable">
<thead></thead>
</table>
<div style="height:600px;width:100%"> 
<div style="height:600px;width:30%;float:left;"></div>
<div style="height:50px;width:70%;float:left;"></div>
<div style="height:600px;width:60%;float:left;">
<p style="font-size:20px;font-weight:bold;">添加管理员</p>
         <p>登录名:<input type="text" id="addLoginName"></p>   
         <p>密码:&nbsp;&nbsp;&nbsp;<input type="password" id="addPassWord"></p> 
         <p style="font-size:14px;font-weight:bold;">选择角色</p>
         <div style="border:1px solid;width:60%;height:200px;text-align:left;float:left;" id="checkRole"> </div> 
         <div style="width:60%;margin-left:30%;float:left;"><button onclick="add()">添加</button></div>
</div>

<script type="text/javascript">
  $(function(){
   checkRole();
  });
  function add(){
	  obj=document.getElementsByName("rolecheck");
	  check_val=[];
	  for(i in obj){
		  if(obj[i].checked){
			  check_val.push(obj[i].value);
		  }
	  }
     var addLoginName=$("#addLoginName").val();
     var addPassWord=$("#addPassWord").val();
     $.ajax({
    	 type:"post",
    	 url:"/admin/add",
    	 data:{"addLoginName":addLoginName,"addPassWord":addPassWord,"check_val":check_val},
    	 traditional:true,
    	 success:function(data){
    		if(data=="OK")
    			{alert("添加成功")}
    		else{
    			alert("添加失败")
    		}
    		
    	 }
    	 
     });
  }
  function checkRole(){
	  var html=$("#checkRole").html();
	  html="";
	  $.post("/admin/role",
			  {},
			  function(data){
				  for(var i=0;i<data.allRole.length;i++){
     html+="<input type='checkbox'style='margin-left:-40px;'value='"+data.allRole[i].id
     +"' name='rolecheck'><span style='margin-left:-60px;'>"+data.allRole[i].name+"</span>";
				  }
				  $("#checkRole").html(html)  
			  })
  }
  
</script>



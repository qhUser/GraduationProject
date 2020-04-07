$(function(){
	checklogin();
});

function checklogin(){
	
	var _ticket = $.cookie("token");
	
	if(!_ticket){
		alert("null")
		return ;
	}
	$.ajax({
		url : "http://localhost:8090/adminlogin/token/" + _ticket,
		dataType : "jsonp",
		type : "GET",
		success : function(data){
			if(data=="obsolete"){
				alert("错误");
			}else{				
				var username =data.loginname;//改变登录状态				
				var html = username + " 你好! 欢迎来到后台管理系统！ 角色：超级管理员<a href=\"http://localhost:8090/drop/admin/"+_ticket+"\" class=\"link-logout\">[退出]</a>";
				$("#loginbar").html(html);							
			}
		}
	});
}


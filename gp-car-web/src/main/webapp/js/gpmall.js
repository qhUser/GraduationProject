$(function(){
	
	checklogin();
});

function checklogin(){
	var _ticket = $.cookie("token");
	if(!_ticket){
		return ;
	}
	$.ajax({
		url : "http://localhost:8090/login/token/" + _ticket,
		dataType : "jsonp",
		type : "GET",
		success : function(data){
			if(data=="obsolete"){
				alert("错误");
				
			}else{
				var username =data.loginname;//改变登录状态
				var html =username + " 你好! 欢迎来到酷拍网！<a href=\"http://localhost:8090/drop/"+_ticket+"\" class=\"link-logout\">[退出]</a>";
				$("#loginbar").html(html);				
				var deupte=$("#deupte");//改变拍卖委托地址
				deupte.attr("href","http://localhost:8087/deupte?id="+data.level);
				$(".userlevel").val(data.level);//给隐藏域添加用户级别,默认为空串			
				$(".userId").val(data.id);//给隐藏域添加用户id,默认为空串
			
			}
		}
	});
}
//判断是否登录
function checkNow(){
	if($(".userlevel").val()==""){
		alert("请先登录!");
	}
}
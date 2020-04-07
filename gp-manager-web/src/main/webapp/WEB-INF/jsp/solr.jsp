<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="button" onclick="clicka();" value="导入索引库">
<script type="text/javascript">
 function clicka(){

	 $.post("/searchItem",
			 {},
			 function(data){
				 if(data=="ok"){
					 alert("添加成功") 
				 }else{
					 alert("添加失败");
				 }
					
			 });
 }
</script>
</html>
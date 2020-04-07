<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="roleTable">
<thead></thead>
</table>
<div id="roleEditWindow" class="easyui-window" title="查看管理员" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:50%;height:50%;padding:10px;">
   <form action="" method="post">
       <div style="height:380px; float:left;width:100%;">
         <span style="font-size:18px; margin-left:10%">角色编号:</span><span id="roleId1" style="font-size:24px; margin: auto"></span><br> 
         <br>
          <span style="font-size:18px; margin-left:10%">角色名:</span><span id="roleName" style="font-size:24px; margin: auto"></span>
          <br>
           <br>
          <span style="font-size:18px; margin-left:10%">角色拥有的权限:</span>
          <div style="float:left;width:20%;height:200px;"></div>
         <div style="border:1px solid;width:60%;height:200px;text-align:left;float:left;" id="privelegebox">      
         </div> 
       </div>
      <div style="height:30%;float:left;width:100%;">
       <a id="roleBtn1" class="easyui-linkbutton" style="margin-left:70%" onclick="roleBtn1()">更新</a>&nbsp;&nbsp;
       <a id="roleBtn2" class="easyui-linkbutton" onclick="roleBtn2()">关闭</a>
      </div>      
   </form>
</div>
   <!-- 方式三：使用easyUI提供的API创建datagrid -->
	<script type="text/javascript">
		$(function(){
			loadon();
		});
		function check(){
			//var colName=$('#mytable').parent().find('table.datagrid-htable td:eq(0)').attr('field');//得到第一列的名称
			var itemList=$("#roleTable");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个管理员");
				return;
			}		

			var roleId1=$("#roleId1");var loginName=$("#roleName");var visable=$("#visable");	
			var html=$("#privelegebox").html();
			html="";
			$("#roleEditWindow").window("open");			
			roleId1.html(rows[0]['id']);	
			loginName.html(rows[0]['name']);			
			$.post("/role/privilege",//查询角色权限
					{"roleId1":roleId1.text()},
					function(data){   
						var len=data.adminRole.length;
						for(var i=0;i<data.allRole.length;i++){		
							var che=false;
							for(var j=0;j<len;j++){
								if(data.allRole[i].id==data.adminRole[j]){//如果管理员有该角色id						
									che=true;
								}
							}
                 html+="<input type='checkbox'style='margin-left:-40px;'value='"+data.allRole[i].id+"' name='rolecheck'";
               if(che){
            	   html+="checked";
               }
                   html+="><span style='margin-left:-60px;'>"+data.allRole[i].name+"</span>";
						}
						
						$("#privelegebox").html(html);
					}); 
		}
		
		function roleBtn1(){  //更新
			 obj=document.getElementsByName("rolecheck");  //获得选中的checkBox 的值
			 check_val=[];
			 
			 for(k in obj){
				 if(obj[k].checked)
					 check_val.push(obj[k].value)
			 }
			var visable= $("#visable").val();
			var flag=confirm("您确定更新该账号么？");
			var roleId1=$("#roleId1");
			if(flag){
				$.ajax(
					 {  type:"post",
						url: "/role/update",
						data:{"roleId1":roleId1.text(),"check_val":check_val},
						traditional:true,
						 success: function(data){
								alert("更新成功");
							} 
					 }	
																
				);		
				$("#roleEditWindow").window("close");
				loadon();
				
			}
		}
		function roleBtn2(){				
				$("#roleEditWindow").window("close");
				loadon();
			}
		
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#roleTable").datagrid({
				//定义标题行所有的列
				columns:[[
				          {width: 200,title:'id',field:'id',checkbox:true},
				          {width: 60,title:'角色名',field:'name'},
				          {title:'描述',field:'description',width:60}				          
				          ]],
				//指定数据表格发送ajax请求的地址
				url:"/role/list",
				rownumbers:true,
				singleSelect:true,
				//定义工具栏
				toolbar:[			         
				         {text:'选择操作',iconCls:'icon-edit',
				        	 handler:function(){
				        		 check();
				        	 }
				         }],
				//显示分页条
				pagination:true
			});
		
		}

	</script>





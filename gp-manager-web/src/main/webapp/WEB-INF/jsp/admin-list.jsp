<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="adminTable">
<thead></thead>
</table>
<div id="adminEditWindow" class="easyui-window" title="查看管理员" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:50%;height:50%;padding:10px;">
   <form action="" method="post">
       <div style="height:380px; float:left;width:100%;">
         <span style="font-size:18px; margin-left:10%">管理员编号:</span><span id="adminid" style="font-size:24px; margin: auto"></span><br> 
         <br>
          <span style="font-size:18px; margin-left:10%">管理员名:</span><span id="adminName" style="font-size:24px; margin: auto"></span>
          <span style="font-size:18px; margin-left:10%">管理状态:</span><select id="visable">
          <option value ="volvo">开启</option>
          <option value ="volvo">关闭</option>
          </select>
          <br>
           <br>
          <span style="font-size:18px; margin-left:10%">管理员所属角色:</span>
          <div style="float:left;width:20%;height:200px;"></div>
         <div style="border:1px solid;width:60%;height:200px;text-align:left;float:left;" id="rolecheckbox">      
         </div> 
       </div>
      <div style="height:30%;float:left;width:100%;">
       <a id="adminBtn1" class="easyui-linkbutton" style="margin-left:70%" onclick="adminBtn1()">更新</a>&nbsp;&nbsp;
       <a id="adminBtn2" class="easyui-linkbutton" onclick="adminBtn2()">关闭</a>
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
			var itemList=$("#adminTable");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个管理员");
				return;
			}		

			var adminid=$("#adminid");var loginName=$("#adminName");var visable=$("#visable");	
			var html=$("#rolecheckbox").html();
			html="";
			$("#adminEditWindow").window("open");			
			adminid.html(rows[0]['id']);	
			loginName.html(rows[0]['loginname']);
			if(rows[0]['visable']){
				visable.html("<option value ='1'>开启</option><option value ='0'>关闭</option>");
			}else{
				visable.html("<option value ='0'>关闭</option><option value ='1'>开启</option>");
			}
			$.post("/admin/role",//查询用户角色
					{"adminId":adminid.text()},
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
						
						$("#rolecheckbox").html(html);
					}); 
		}
		
		function adminBtn1(){  //更新
			 obj=document.getElementsByName("rolecheck");  //获得选中的checkBox 的值
			 check_val=[];
			 for(k in obj){
				 if(obj[k].checked)
					 check_val.push(obj[k].value)
			 }
			var visable= $("#visable").val();
			var flag=confirm("您确定更新该账号么？");
			var adminid=$("#adminid");
			if(flag){
				$.ajax(
					 {  type:"post",
						url: "/admin/update",
						data:{"adminId":adminid.text(),"check_val":check_val,"visable":visable},
						traditional:true,
						 success: function(data){
								alert("更新成功");
							} 
					 }	
																
				);		
				$("#adminEditWindow").window("close");
				loadon();
				
			}
		}
		function adminBtn2(){				
				$("#adminEditWindow").window("close");
				loadon();
			}
		
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#adminTable").datagrid({
				//定义标题行所有的列
				columns:[[
				          {width: 200,title:'id',field:'id',checkbox:true},
				          {width: 60,title:'管理员名',field:'loginname'},
				          {title:'真实姓名',field:'nickname',width: 60},				         
				          {title:'电子邮箱',field:'email',width: 200},
				          {title:'手机号码',field:'phonenumber',width:60},
				          {title:'描述',field:'description',width:60}				          
				          ]],
				//指定数据表格发送ajax请求的地址
				url:"/admin/list",
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





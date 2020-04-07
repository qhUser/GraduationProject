<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="mytable3">
<thead></thead>
</table>
<div id="itemEditWindow3" class="easyui-window" title="审核企业" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:20%;height:20%;padding:10px;">
   <form action="" method="post">
       <div style="height:30%;">
         <span style="font-size:18px; margin-left:40%">用户编号:</span><span id="cid3" style="font-size:24px; margin: auto"></span><br> 
         <br>
          <span style="font-size:18px; margin-left:40%">用户名:</span><span id="loginName3" style="font-size:24px; margin: auto"></span><br>
       </div>
      
       <a id="btn5" class="easyui-linkbutton" style="margin-left:32%" onclick="btn5()">封号处理</a>&nbsp;&nbsp;
       <a id="btn6" class="easyui-linkbutton" onclick="btn6()">关闭</a>
   </form>
</div>
   <!-- 方式三：使用easyUI提供的API创建datagrid -->
	<script type="text/javascript">
		$(function(){
			loadon();
		});
		function check(){
			//var colName=$('#mytable').parent().find('table.datagrid-htable td:eq(0)').attr('field');//得到第一列的名称
			var itemList=$("#mytable3");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个用户");
				return;
			}		

			var cid=$("#cid3");var loginName=$("#loginName");		
			$("#itemEditWindow3").window("open");			
			cid.html(rows[0]['id']);	
			loginName.html(rows[0]['loginname']);
		}
		
		function btn5(){
			var flag=confirm("您确定封其账户么？");
			var cid=$("#cid3").text();
			
			if(flag){
				$.post("/user/ban",
					{"id":cid},
					function(data){
						alert("操作成功");
					}											
				);		
				$("#itemEditWindow3").window("close");
				loadon();
				
			}
		}
		function btn6(){		
				$("#itemEditWindow3").window("close");
				loadon();
			}
		
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#mytable3").datagrid({
				//定义标题行所有的列
				columns:[[
				          {width: 200,title:'id',field:'id',checkbox:true},
				          {width: 60,title:'登录名',field:'loginname'},
				          {title:'真实姓名',field:'nickname',width: 60},				         
				          {title:'电子邮箱',field:'email',width: 200},
				          {title:'手机号码',field:'phonenumber',width:60},
				          {title:'地址',field:'address',width:60},
				          {title:'公司名称',field:'organization',width:150},
				          {title:'用户类型',field:'Type',width:60},
				          {title:'信誉值',field:'honesty',width:60}
				          ]],
				//指定数据表格发送ajax请求的地址
				url:"/user/list",
				rownumbers:true,
				singleSelect:true,
				//定义工具栏
				toolbar:[			         
				         {text:'封号处理',iconCls:'icon-edit',
				        	 handler:function(){
				        		 check();
				        	 }
				         }],
				//显示分页条
				pagination:true
			});
		
		}

	</script>





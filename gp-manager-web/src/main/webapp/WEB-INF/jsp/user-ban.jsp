<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="mytable4">
<thead></thead>
</table>
<div id="itemEditWindow4" class="easyui-window" title="审核企业" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:20%;height:20%;padding:10px;">
   <form action="" method="post">
       <div style="height:30%;">
         <span style="font-size:18px; margin-left:40%">用户编号:</span><span id="cid4" style="font-size:24px; margin: auto"></span><br> 
         <br>
          <span style="font-size:18px; margin-left:40%">用户名:</span><span id="loginName4" style="font-size:24px; margin: auto"></span><br>
       </div>
      
       <a id="btn7" class="easyui-linkbutton" style="margin-left:32%" onclick="btn7()">解封处理</a>&nbsp;&nbsp;
       <a id="btn8" class="easyui-linkbutton" onclick="btn8()">关闭</a>
   </form>
</div>
   <!-- 方式三：使用easyUI提供的API创建datagrid -->
	<script type="text/javascript">
		$(function(){
			loadon();
		});
		function check(){
			//var colName=$('#mytable').parent().find('table.datagrid-htable td:eq(0)').attr('field');//得到第一列的名称
			var itemList=$("#mytable4");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个用户");
				return;
			}		

			var cid=$("#cid4");var loginName=$("#loginName");		
			$("#itemEditWindow4").window("open");			
			cid.html(rows[0]['id']);	
			loginName.html(rows[0]['loginname']);
		}
		
		function btn7(){
			var flag=confirm("您确定解封该账户么？");
			var cid=$("#cid4").text();
			if(flag){
				$.post("/user/relieve",
					{"id":cid},
					function(data){
						alert("操作成功");
					}											
				);		
				$("#itemEditWindow4").window("close");
				loadon();
				
			}
		}
		function btn8(){		
				$("#itemEditWindow4").window("close");
				loadon();
			}
		
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#mytable4").datagrid({
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
				url:"/user/list/ban",
				rownumbers:true,
				singleSelect:true,
				//定义工具栏
				toolbar:[			         
				         {text:'解封处理',iconCls:'icon-edit',
				        	 handler:function(){
				        		 check();
				        	 }
				         }
				         ],
				//显示分页条
				pagination:true
			});
		
		}

	</script>





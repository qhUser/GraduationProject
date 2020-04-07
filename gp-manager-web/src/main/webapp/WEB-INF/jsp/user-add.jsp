<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="mytable2">
<thead></thead>
</table>
<div id="itemEditWindow2" class="easyui-window" title="审核企业" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:20%;height:20%;padding:10px;">
   <form action="" method="post">
       <div style="height:30%;">
         <span style="font-size:18px; margin-left:40%">审核企业</span><span id="cid2" style="font-size:24px; margin: auto"></span><br> 
         <br>
         <br>    
         <br> 
         <br>   
       </div>
      
       <a id="btn3" class="easyui-linkbutton" style="margin-left:32%" onclick="btn3()">审核通过</a>&nbsp;&nbsp;
       <a id="btn4" class="easyui-linkbutton" onclick="btn4()">审核不通过</a>
   </form>
</div>
   <!-- 方式三：使用easyUI提供的API创建datagrid -->
	<script type="text/javascript">
		$(function(){
			loadon();
		});
		function check(){
			//var colName=$('#mytable').parent().find('table.datagrid-htable td:eq(0)').attr('field');//得到第一列的名称
			var itemList=$("#mytable2");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个商品");
				return;
			}		

			var cid=$("#cid2");
			//var ids = [];
			//ids.push(rows[0]['id']);			
			//alert(ids.join('n'));		
			$("#itemEditWindow2").window("open");			
			cid.html(rows[0]['id']);							
		}
		
		function btn3(){
			var flag=confirm("您确定让通过吗？");
			var cid=$("#cid2").text();
			
			if(flag){
				$.post("/user/adopt",
					{"id":cid},
					function(data){
						alert("操作成功");
					}											
				);		
				$("#itemEditWindow2").window("close");
				loadon();
				
			}
		}
		function btn4(){
			var flage=confirm("您确定不让通过吗？");
			var cid=$("#cid2").text();
			
			if(flage){
				$.post("/user/noPass",
				{"id":cid},
				function(data){
					alert("操作成功");
				}
				);
				$("#itemEditWindow2").window("close");
				loadon();
			}
		}
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#mytable2").datagrid({
				//定义标题行所有的列
				columns:[[
				          {width: 200,title:'id',field:'id',checkbox:true},
				          {width: 60,title:'登录名',field:'loginname'},
				          {title:'真实姓名',field:'nickname',width: 60},				         
				          {title:'电子邮箱',field:'email',width: 200},
				          {title:'手机号码',field:'phonenumber',width:60},
				          {title:'地址',field:'address',width:60},
				          {title:'公司名称',field:'organization',width:150}	          
				          ]],
				//指定数据表格发送ajax请求的地址
				url:"/user/add",
				rownumbers:true,
				singleSelect:true,
				//定义工具栏
				toolbar:[
				         {text:'添加',iconCls:'icon-add',
				        	 //为按钮绑定单击事件
				        	 handler:function(){
				        	 	alert('add...');
				         	 }
				         },
				         {text:'删除',iconCls:'icon-remove'},
				         {text:'进行审核',iconCls:'icon-edit',
				        	 handler:function(){
				        		 check();
				        	 }
				         },
				         {text:'查询',iconCls:'icon-search'}
				         ],
				//显示分页条
				pagination:true
			});
		
		}

	</script>





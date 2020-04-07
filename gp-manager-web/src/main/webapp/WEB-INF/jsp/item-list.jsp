<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="easyui-datagrid" id="mytable1">
<thead></thead>
	</table>
	<div id="itemEditWindow1" class="easyui-window" title="编辑商品" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:60%;height:80%;padding:10px;">
   <form action="" method="post">
       <div style="height:30%;">
         <span style="font-size:24px; margin-left:40%">审查商品编号:</span><span id="cid1" style="font-size:24px; margin: auto"></span><br> 
         <br>
         <br>    
         <br> 
         <br>   
       </div>
       <div id="mydiv1" style="width:50%;float:left;"> 
         <span class="mydiv1" id="cname1">商品名称：</span>
         <p class="mydiv1"id="cprice1">起拍价：</p>
         <p class="mydiv1"id="csum1">数量：</p>
         <p class="mydiv1">商品介绍：</p>        
       </div>
        <div id="mydiv1" style="width:48%;float:left;">    
         <p class="mydiv1"id="cstart1">开拍时间：</p>
         <p class="mydiv1"id="cend1">结束时间：</p>
         <p class="mydiv1"id="status1">状态：</p>     
       </div>
       <div>
         <textarea rows="10" cols="20" id="mytext1" ></textarea>
       </div>
       
   </form>
</div>
   <!-- 方式三：使用easyUI提供的API创建datagrid -->
	<script type="text/javascript">
		$(function(){
			loadon();
		});
		function check(){
			//var colName=$('#mytable1').parent().find('table.datagrid-htable td:eq(0)').attr('field');//得到第一列的名称
			var itemList=$("#mytable1");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个商品");
				return;
			}		
			mydiv1();
			var cid1=$("#cid1");var cname1=$("#cname1");var cprice1=$("#cprice1");var csum1=$("#csum1");var mytext1=$("#mytext1");var cstart1=$("#cstart1");
			var cend1=$("#cend1"); var status1=$("#status1");
			//var ids = [];
			//ids.push(rows[0]['id']);			
			//alert(ids.join('n'));		
			$("#itemEditWindow1").window("open");			
			cid1.html(rows[0]['id']);
			mytext1.val("       "+rows[0]['description']);
			cname1.html("商品名称:"+rows[0]['commodityname']);
			cprice1.html("起拍价:"+rows[0]['lowestprice']);
			csum1.html("数量:"+rows[0]['count']);			
			cstart1.html("开拍时间:"+rows[0]['newsatrtdate']);
			cend1.html("结束时间:"+rows[0]['newenddate']);
			status1.html("状态:"+rows[0]['status']);						
		}
		function mydiv1(){
			var mydiv1=$(".mydiv1");
			var mytext1=$("#mytext1");
			mydiv1.css("font-size","22px");
			mydiv1.css("margin-top","30px");
			mydiv1.css("margin-left","50px");
			mytext1.css("width","80%");
			mytext1.css("height","200px");
			mytext1.css("margin-left","120px");
			mytext1.css("background-color","#fff");
			mytext1.css("font-size","18px");
		}
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#mytable1").datagrid({
				//定义标题行所有的列
				columns:[[
				          {title:'编号',field:'id',checkbox:true},
				          {title:'商品名称',field:'commodityname'},
				          {title:'起拍价',field:'lowestprice'},
				          {title:'当前价格',field:'nowprice'},
				          {title:'商品描述',field:'description',hidden:true},
				          {title:'数量',field:'count'},
				          {title:'状态',field:'status'},
				          {title:'开拍时间',field:'newsatrtdate'},
				          {title:'结束时间',field:'newenddate'}			          
				          ]],
				//指定数据表格发送ajax请求的地址
				url:"/item/list",
				rownumbers:true,				
				//定义工具栏
				toolbar:[
				     
				         {text:'删除',iconCls:'icon-remove'},
				         {text:'修改',iconCls:'icon-edit'},
				         {text:'查看',iconCls:'icon-search'
				        	 , handler:function(){
				        		 check();
				        	 }}
				         ],
				//显示分页条
				pagination:true
			});
		}
	</script>





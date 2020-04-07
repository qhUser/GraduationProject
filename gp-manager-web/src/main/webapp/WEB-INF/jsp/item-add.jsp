<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="mytable">
<thead></thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" 
data-options="modal:true,closed:true,iconCls:'icon-save'" 
style="width:60%;height:80%;padding:10px;">
   <form action="" method="post">
       <div style="height:30%;">
         <span style="font-size:24px; margin-left:40%">审查商品编号:</span><span id="cid" style="font-size:24px; margin: auto"></span><br> 
         <br>
         <br>    
         <br> 
         <br>   
       </div>
       <div id="mydiv" style="width:50%;float:left;"> 
         <span class="mydiv" id="cname">商品名称：</span>
         <p class="mydiv"id="cprice">起拍价：</p>
         <p class="mydiv"id="csum">数量：</p>
         <p class="mydiv">商品介绍：</p>        
       </div>
        <div id="mydiv" style="width:48%;float:left;">    
         <p class="mydiv"id="cstart">开拍时间：</p>
         <p class="mydiv"id="cend">结束时间：</p>
         <p class="mydiv"id="status">状态：</p>     
       </div>
       <div>
         <textarea rows="10" cols="20" id="mytext" ></textarea>
       </div>
       <a id="btn1" class="easyui-linkbutton" style="margin-left:44%" onclick="btn1()">审核通过</a>&nbsp;&nbsp;
       <a id="btn2" class="easyui-linkbutton" onclick="btn2()">审核不通过</a>
   </form>
</div>
   <!-- 方式三：使用easyUI提供的API创建datagrid -->
	<script type="text/javascript">
		$(function(){
			loadon();
		});
		function check(){
			//var colName=$('#mytable').parent().find('table.datagrid-htable td:eq(0)').attr('field');//得到第一列的名称
			var itemList=$("#mytable");
			var rows=itemList.datagrid("getSelections");
			if(rows.length==0){
				alert("必须选择一个商品");
				return;
			}		
			myDiv();
			var cid=$("#cid");var cname=$("#cname");var cprice=$("#cprice");var csum=$("#csum");var mytext=$("#mytext");var cstart=$("#cstart");
			var cend=$("#cend"); var status=$("#status");
			//var ids = [];
			//ids.push(rows[0]['id']);			
			//alert(ids.join('n'));		
			$("#itemEditWindow").window("open");			
			cid.html(rows[0]['id']);
			mytext.val("       "+rows[0]['description']);
			cname.html("商品名称:"+rows[0]['commodityname']);
			cprice.html("起拍价:"+rows[0]['lowestprice']);
			csum.html("数量:"+rows[0]['count']);			
			cstart.html("开拍时间:"+rows[0]['newsatrtdate']);
			cend.html("结束时间："+rows[0]['newenddate']);
			status.html("状态:"+rows[0]['status']);						
		}
		function myDiv(){
			var mydiv=$(".mydiv");
			var mytext=$("#mytext");
			mydiv.css("font-size","22px");
			mydiv.css("margin-top","30px");
			mydiv.css("margin-left","50px");
			mytext.css("width","80%");
			mytext.css("height","200px");
			mytext.css("margin-left","120px");
			mytext.css("background-color","#fff");
			mytext.css("font-size","18px");
		}
		function btn1(){
			var flag=confirm("您确定让通过吗？");
			var cid=$("#cid").text();
			
			if(flag){
				$.post("/item/adopt",
					{"id":cid},
					function(data){
						alert("操作成功");
					}											
				);		
				$("#itemEditWindow").window("close");
				loadon();
				
			}
		}
		function btn2(){
			var flage=confirm("您确定不让通过吗？");
			var cid=$("#cid").text();
			
			if(flage){
				$.post("/item/noPass",
				{"id":cid},
				function(data){
					alert("操作成功");
				}
				);
				$("#itemEditWindow").window("close");
				loadon();
			}
		}
		function loadon(){
			//页面加载完成后，创建数据表格datagrid
			$("#mytable").datagrid({
				//定义标题行所有的列
				columns:[[
				          {width: 200,title:'编号',field:'id',checkbox:true},
				          {width: 60,title:'商品名称',field:'commodityname'},
				          {title:'起拍价',field:'lowestprice',width: 60},				         
				          {title:'商品描述',field:'description',width: 200},
				          {title:'数量',field:'count',width:60},
				          {title:'状态',field:'status',width:60},
				          {title:'开拍时间',field:'newsatrtdate',width:150},
				          {title:'结束时间',field:'newenddate',width:150}			          
				          ]],
				//指定数据表格发送ajax请求的地址
				url:"/item/add",
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
			//mydatagrid();
		}
		//function mydatagrid(){
			//$("#mytable").datagrid('hideColumn','a');//a表示列名，隐藏此列

			//var dg = $('#mytable');//table表id

			//var col = dg.datagrid('getColumnOption','description');//获得该列属性

			//col.width = auto;//调整该列宽度

			//dg.datagrid();
		//}
	</script>





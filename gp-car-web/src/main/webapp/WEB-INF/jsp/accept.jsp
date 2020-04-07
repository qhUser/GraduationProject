<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<div style="font-size:23px;;text-align:center;"></div>
<div class="row">
  <div class="col-md-2" style="height:600px;"></div>
  <div class="col-md-8" id="acceptlist">
  <div  class='list'>当前委托拍卖的商品</div> <div style='border-top:2px solid #ccc;'></div> 
			   <div class='col-md-12' style='height:40px'></div>
			   <div class='col-md-2 orderlist' ><span>商品名称</span></div>
			   <div class='col-md-2 orderlist' ><span>商品类型</span></div>
			   <div class='col-md-2 orderlist' ><span>委托方</span></div>
			   <div class='col-md-2 orderlist' ><span>拍卖底价</span></div>
			   <div class='col-md-2 orderlist' ><span>拍卖日期</span></div>
			   <div class='col-md-2 orderlist' ><span>操作</span></div>
			   
			    
  </div>
  <div class="col-md-12">
  <!-- 分页 
   思路：跳转到该页面后，查询出委托商品的总数量，作出分页量。ajax根据分页查询相应分页商品信息
  -->
  <div style="text-align:center;">
      <nav aria-label="Page navigation">
  <ul class="pagination">
       <c:if test="${itemList.page==1}">
      <li class="disabled"><span><span aria-hidden="true">&laquo;</span></span>
      </c:if>
      <c:if test="${itemList.page!=1}">
      <li><a href="/deupte?page=1&id=3" onclick="Page(1)"><span aria-hidden="true">&laquo;</span></a></li>
      </c:if>
      <c:forEach var="i" begin="1" end="${itemList.sumPage}" step="1">   
        <c:choose >
        <c:when test="${i==itemList.page}">
        <li class=" active">  <!--添加点选样式-->
        <span id="now">${i}<span class="sr-only"></span></span>
        </c:when>
        <c:otherwise>
        <li><a href="/deupte?page=${i}&id=3" onclick="Page(${i})">${i}</a></li>
        </c:otherwise>
      </c:choose>
      
      <c:if test="${i==itemList.sumPage&&itemList.page==itemList.sumPage}">
       <li class="disabled"><span><span aria-hidden="true">&raquo;</span></span>
      </c:if>
      <c:if test="${i==itemList.sumPage&&itemList.page!=itemList.sumPage}">
        <li><a href="/deupte?page=${itemList.sumPage}&id=3" onclick="Page(${itemList.sumPage})"><span aria-hidden="true">&raquo;</span></a></li>
      </c:if>
      </c:forEach>
      </ul>
      </nav>
  </div>
</div>
</div>

<!-- 委托商品详情模态框 -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">委托商品详情</h4>
      </div>
      <div class="modal-body" style="height:600px;">
               <div class='col-md-12 orderlist2' id="list0"><span>商品编号:</span><span id="comid"></span></div>
               <div class='col-md-2 orderlist' ><span>商品名称</span></div>
			   <div class='col-md-2 orderlist' ><span>商品类型</span></div>
			   <div class='col-md-2 orderlist' ><span>委托方</span></div>
			   <div class='col-md-2 orderlist' ><span>拍卖底价</span></div>
			   <div class='col-md-2 orderlist' ><span>拍卖日期</span></div>
			   <div class='col-md-2 orderlist' ><span>结束日期</span></div>
			   
			   <div class='col-md-2 orderlist1' id="list1"><span></span></div>
			   <div class='col-md-2 orderlist1' id="list2"><span></span></div>
			   <div class='col-md-2 orderlist1' id="list3"><span></span></div>
			   <div class='col-md-2 orderlist1' id="list4"><span></span></div>
			   <div class='col-md-2 orderlist1' id="list5"><span></span></div>
			   <div class='col-md-2 orderlist1' id="list6"><span></span></div>
			   <div class="col-md-12" style="height:80px;"></div>
			   <div class="col-md-6" style="text-align: center;" id="list7">
			    <img src="" alt="..." class="img-thumbnail" style="height:300px;width:300px;">
			    <div>图片信息</div>
			   </div>
			  <div class="col-md-6" style="text-align: center;" id="list8">
			    <textarea rows="14" cols="45"></textarea>
			    <div>商品介绍</div>
			   </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="accept()">接受委托</button>
      </div>
    </div>
  </div>
</div>
</div>
<script type="text/javascript">
  $(function(){	 
	 
	  Page();	  
  });
  /*ajax获取所有委托商品信息*/
  function Page(){
	  var n=$("#now").text();
	  var html=$("#acceptlist").html();
	  $.post("/accept",
			  {"page":n},
			  function(data){
				
				  for(var i=0;i<data.comlist.list.length;i++){
					   html+="<div class='col-md-2 orderlist1' ><span>"+data.comlist.list[i].commodityname+"</span></div>"
					   html+="<div class='col-md-2 orderlist1' ><span>"+data.comlist.list[i].typeName+"</span></div>"
					   html+="<div class='col-md-2 orderlist1' ><span>"+data.comlist.list[i].userName+"</span></div>"
					   html+="<div class='col-md-2 orderlist1' ><span>"+data.comlist.list[i].lowestprice+"</span></div>"
					   html+="<div class='col-md-2 orderlist1' ><span>"+data.comlist.list[i].newsatrtdate+"</span></div>"
					   html+="<div class='col-md-2 orderlist1' ><span>"
+"<button type='button' onclick='check("+data.comlist.list[i].id+");' class='btn btn-link ' data-toggle='modal' data-target='.bs-example-modal-lg '>查看</button></div>"
				  }
				  $("#acceptlist").html(html);
				 
			  },
			  "json")
  }
  
  /*查询委托商品信息*/
  function check(id){ 
	  var list0=$("#comid");
	  var list1=$("#list1 ");
	  var list2=$("#list2");
	  var list3=$("#list3");
	  var list4=$("#list4");
	  var list5=$("#list5");
	  var list6=$("#list6");
	  var list7=$("#list7 img");
	  var list8=$("#list8 textarea");
	  $.post("/check",
			  {"id":id},
			  function(data){
				  list0.html(data.id);
				  list1.html(data.commodityname);
				  list2.html(data.typeName);
				  list3.html(data.userName);
				  list4.html(data.lowestprice);
				  list5.html(data.newsatrtdate);
				  list6.html(data.newenddate);
				  list7.attr("src",data.photoUrl);
				  list8.val(data.description);
			  });
	  
  }

</script>
</html>
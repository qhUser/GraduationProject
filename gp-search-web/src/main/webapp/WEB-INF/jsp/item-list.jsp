<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" ></link>
<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/gpmall.js"></script>
<script type="text/javascript" src="../../js/jquery.cookie.js"></script>
</head>
<body>
   <jsp:include page="head.jsp"></jsp:include>
  
   <div class="row">
   <div class="col-md-2"></div>
   <div class="col-md-2">   
  <c:if test="${itemList.keyword==''}">
  <h3>正在拍卖的商品</h3>
  </c:if>
   <c:if test="${itemList.keyword!=''}">
  <h3>查询到<span style="color:red;">'${itemList.keyword}'</span>相关共${itemList.sum}条</h3>
  </c:if>
   </div>
   </div>
<!-- 最新商品区域 -->
  <div class="row"  id="newCom" >
    <c:forEach items="${itemList.list}" varStatus="status" var="item">
     <c:if test="${status.index%4==0}">
     <div class='col-md-2'></div>
     </c:if>
     <div class='col-md-2 thumbnail'>
     <img src="${item.url}" alt="..." class="img-thumbnail" style="width:90%;height:200px;">    
     <div class='caption'>
     <div style="width:95%;height:65px;">
     <div style="width:35%;float:left"><h4>${item.commodityName}</h4></div>
      <div style=";width:62%;float:left">
      <textarea  style='border-style:none;background-color:#fff;overflow:hidden; resize:none;' disabled='disabled'>
      ${item.description}</textarea> </div>    
     </div>    
     <p><a href='/details?id=${item.id}' class='btn btn-primary' role='button'>了解详情</a></div></div>
      <c:if test="${status.index%4==3}">
      <div class='col-md-2' style='height:360px;'></div>
     </c:if>
    </c:forEach>
  </div><!-- 最新商品区域 -->

  <!-- 分页 -->
  <div style="text-align:center;">
      <nav aria-label="Page navigation">
  <ul class="pagination">
       <c:if test="${itemList.page==1}">
      <li class="disabled"><span><span aria-hidden="true">&laquo;</span></span>
      </c:if>
      <c:if test="${itemList.page!=1}">
      <li><a href="/list?keyword=${itemList.keyword}&page=1"><span aria-hidden="true">&laquo;</span></a></li>
      </c:if>
      <c:forEach var="i" begin="1" end="${itemList.sumPage}" step="1">   
        <c:choose >
        <c:when test="${i==itemList.page}">
        <li class=" active">
        <span>${i}<span class="sr-only">(current)</span></span>
        </c:when>
        <c:otherwise>
        <li><a href="/list?keyword=${itemList.keyword}&page=${i}">${i}</a></li>
        </c:otherwise>
      </c:choose>
      
      <c:if test="${i==itemList.sumPage&&itemList.page==itemList.sumPage}">
       <li class="disabled"><span><span aria-hidden="true">&raquo;</span></span>
      </c:if>
      <c:if test="${i==itemList.sumPage&&itemList.page!=itemList.sumPage}">
        <li><a href="/list?keyword=${itemList.keyword}&page=${itemList.sumPage}"><span aria-hidden="true">&raquo;</span></a></li>
      </c:if>
      </c:forEach>
    
   
   
  </ul>
</nav>
  </div>
   
</body>
</html>
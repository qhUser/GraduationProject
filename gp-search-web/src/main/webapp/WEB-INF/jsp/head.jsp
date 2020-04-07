<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="height:20px;"></div>
  <div class="row">
  <div class="col-md-2"></div>
  <div class="col-md-3">
  <ul class="nav nav-tabs">
  <li role="presentation"><a href="http://localhost:8082">商城首页</a></li>
  <li role="presentation" class="active"><a href="http://localhost:8085/list">正在拍卖</a></li>
  <li role="presentation"><a href="http://localhost:8087">我的拍卖</a></li>
  <li role="presentation"><a  id="deupte" onclick="checkNow();">拍卖委托</a></li>
  <li role="presentation"><a href="#">拍卖流程</a></li>
  </ul>
  <input type="hidden" id="userId"><!--隐藏域判定存放用户级别 以及判定用户是否登录 -->
  <input type="hidden" id="bail"><!--隐藏域判定存放用户是否缴纳保证金 -->
  </div>
  <div class="col-md-3">
  <form action="/list">
     <div class="input-group">
      <input type="text" class="form-control" placeholder="请输入查询内容" name="keyword" style="border:1px solid #269abc; text-align:5px;">
      <span class="input-group-btn">
        <button class="btn btn-info" type="submit">搜索</button>
      </span>
    </div>
  </form>
    
  </div>
  <div class="col-md-2"></div>
  <div class="col-md-2" style="font-size:14px;">
  <span id="loginbar">
   你好，欢迎来到酷拍网!
  <a href="http://localhost:8090">登录</a>&nbsp;&nbsp;<a href="http://localhost:8090/register">注册</a>
  </span>
  </div>  
</div>

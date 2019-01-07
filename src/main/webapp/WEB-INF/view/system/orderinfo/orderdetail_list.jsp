<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String filePath="F:/image/";
    String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>


</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>订单详情</li>
    </ul>
</div>

<div class="row" style="padding:15px; padding-top:0px;margin-left: 1%;margin-top: 30px">
	<table class="table  table-condensed table-striped">
    	<tr>
            <th>明细详情</th>
        	<th style="width: 10%">菜品名称</th>
            <th>菜品单价</th>
            <th>订购数量</th>

        </tr>
        <c:forEach items="${orderDetailList}" var="bean" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${bean.foodName }</td>
                <td>${bean.foodPrice}</td>
                <td>${bean.foodNum}</td>
            </tr>
        </c:forEach>
          
    </table>
</div>

<div style="margin-left: 45%; padding:3px;margin-right: 45%" >
    <form class="form-horizontal" action="orderList">

        <input type="submit"   class="btn btn-danger"   value="返回"/>
    </form>
</div>
</body>
</html>

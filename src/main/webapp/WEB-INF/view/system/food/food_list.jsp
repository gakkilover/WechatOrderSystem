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
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../../../js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../../../js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>菜品管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form action="<%=basePath %>selectFood?" class="form-horizontal">
	<div class="col-sm-2">菜品名称:</div>
    <div class="col-sm-3">
    	<input type="text" name="foodName" value="${fooeName}" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='addFoodPost'"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>菜品编号</th>
            <th>菜品名称</th>
            <th>商家名称</th>
            <%--<th>菜品状态</th>--%>
            <th>菜品描述</th>
            <th>菜品价格</th>
            <th>菜品缩略图</th>
        </tr>
        <c:forEach items="${foodLists}" var="bean" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${bean.foodName }</td>
                <td>${bean.storeName}</td>
                <%--<td>${bean.foodState }</td>--%>
                <td>${bean.foodDetail}</td>
                <td>${bean.foodPrice}</td>
                <td><img src="<%=basePath%>img/${bean.foodPic}" style="width: 30px;height: 30px"></img></td>
                <th><a href="updateFood?foodId=${bean.foodId }">修改</a> <a href="deleteFood?foodId=${bean.foodId }">删除</a></th>
            </tr>
        </c:forEach>
          
    </table>
</div>

</body>
</html>

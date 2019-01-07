<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
        <li>角色管理</li>
    </ul>
</div>
<%--<div class="row alert alert-info"  style="margin:0px; padding:3px;" >--%>
    <%--<form class="form-horizontal">--%>
        <%--<div class="col-sm-2">角色名称:</div>--%>
        <%--<div class="col-sm-3">--%>
            <%--<input type="text"  class="form-control input-sm"/>--%>
        <%--</div>--%>
        <%--<input type="button"   class="btn btn-danger"   value="查询"/>--%>
        <%--<input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='food_add.jsp'"/>--%>
    <%--</form>--%>
<%--</div>--%>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>用户编号</th>
            <th>昵称</th>
            <th>性别</th>
            <th>地址</th>
        </tr>
        <!--改成活的 -->
        <c:forEach items="${userLists}" var="bean">
            <tr>
                <td>${bean.userId }</td>
                <td>${bean.nickName }</td>
                <td>${bean.userSex=='f'?"男":"女"}</td>
                <td>${bean.userAddress }</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

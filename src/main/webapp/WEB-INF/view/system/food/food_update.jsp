<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zwk.weibo.entity.FoodEntity" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    FoodEntity food=(FoodEntity)request.getAttribute("food");
    Long genreId=food.getGenreId();
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
        <li>菜品管理</li>
        <li>修改菜品信息</li>
    </ul>
</div>

<form action="addFood" class="form-horizontal" enctype="multipart/form-data" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">菜品名称</label>
                <div class="col-sm-9">
                    <input type="hidden" name="foodId" class="form-control input-sm" value=${food.foodId}>
                	<input type="text" name="foodName" class="form-control input-sm" value=${food.foodName}>
                </div>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜品价格</label>
                <div class="col-sm-9">
                    <input type="text" name="foodPrice" class="form-control input-sm" value=${food.foodPrice}>
                </div>
            </div>
        </div>

    </div>
    <div class="row" style=" margin-bottom: 10px">
        <div class="col-sm-5" >
            <div class="form-group">
                <label class="col-sm-3 control-label">菜品种类</label>
                <div class="col-sm-9">
                    <select name="genreId" class="form-control" style="width: 100px">
                        <c:forEach items="${genreList}" var="bean">
                            <c:if test="${bean.genreId==food.genreId}">
                                <option selected value=${bean.genreId}>${bean.genreName}</option>
                            </c:if>
                            <c:if test="${bean.genreId!=food.genreId}">
                                <option  value=${bean.genreId} >${bean.genreName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜品描述</label>
                <div class="col-sm-9">
                    <input type="text" name="foodDetail" class="form-control input-sm" value=${food.foodDetail}>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜品缩略图</label>
                <div class="col-sm-9">

                    <input type="file" name="fileName"/>
                    <img src="<%=basePath%>img/${food.foodPic}" style="margin-top: 10px;width: 100px;height: 100px"></img>
                </div>
            </div>
        </div>

    </div>


   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>

</body>
</html>

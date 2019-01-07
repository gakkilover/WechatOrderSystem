<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
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
<script src="<%=basePath %>js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath %>js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>菜品管理</li>
        <li>添加菜品信息</li>
    </ul>
</div>

<form action="<%=basePath %>addFood" enctype="multipart/form-data" method="post">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row" style="margin-bottom: 10px">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">菜品名称</label>
                <div class="col-sm-9">
                	<input type="text" name="foodName" class="form-control input-sm" placeholder="请输入菜品名称"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-bottom: 10px">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜品类别</label>
                <div class="col-sm-9">
                    <input type="text" name="foodState" class="form-control input-sm" placeholder="请输入菜品类别"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style=" margin-bottom: 10px">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜品价格</label>
                <div class="col-sm-9">
                    <input type="text" name="foodPrice" class="form-control input-sm" placeholder="请输入菜品价格"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style=" margin-bottom: 10px">
        <div class="col-sm-5" >
            <div class="form-group">
                <label class="col-sm-3 control-label">种类名称</label>
                <div class="col-sm-9">
                    <select name="genreId" class="form-control" style="width: 100px">
                        <c:forEach items="${genreList}" var="bean">
                            <option  value=${bean.genreId}>${bean.genreName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-bottom: 10px">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">缩略图</label>
                <div class="col-sm-9">
                    <input type="file" name="fileName"/>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;margin-top: 20px">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea name="foodDetail"  class="form-control" ></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row" style="margin-top: 10px">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>
<script>
    function  addGenre() {
        $.ajax({
            url: '<%=basePath %>addGenre',
            type: 'POST',
            data: JSON.stringify({"genreName":"qwert","genreDescription":"时反而预付款月女"}),
            dataType: 'json',
            contentType: "application/json",
            success: function () {

            },
            error: function(){

            }
        });
    }
</script>
</body>
</html>

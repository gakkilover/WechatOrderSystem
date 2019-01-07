<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String filePath = "F:/image/";
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../../js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li><a href="#">系统管理</a></li>
        <li>订单管理</li>
        <li>修改订单</li>
    </ul>
</div>

<form action="updateOrderPost" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">订单编号</label>
                <div class="col-sm-9">
                    <input type="text" value="${order.orderId}" name="orderId" class="form-control input-sm"
                           placeholder="请输入订单编号"/>
                </div>
            </div>

        </div>

    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户ID</label>
                <div class="col-sm-9">
                    <input type="text" value="${order.userId}" name="userId" class="form-control input-sm"
                           placeholder="请输入姓名"/>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">订单状态</label>
                <div class="col-sm-4">

                    <select class="form-control input-sm">

                        <c:if test="${order.status=='1101'}">
                            <option value="1101" selected="selected">接受</option>
                            <option value="1102">拒绝</option>
                        </c:if>
                        <c:if test="${order.status=='1102'}">
                            <option value="1101">接受</option>
                            <option value="1102" selected="selected">拒绝</option>
                        </c:if>

                    </select>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">订单总价</label>
                <div class="col-sm-5">
                    <input type="text" value="${order.totalPrice}" name="totalPrice" class="form-control input-sm"
                           placeholder="请输入年龄"/>
                </div>
            </div>

        </div>

    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">是否打包</label>
                <div class="col-sm-6">
                    <input type="text" name="isPacked" value="${order.isPacked}" class="form-control input-sm"
                           placeholder="请输入籍贯"/>
                </div>
            </div>

        </div>
    </div>
    <div class="row">

        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">店铺</label>
                <div class="col-sm-9">
                    <input type="text" name="storeId" value="${order.storeId}" class="form-control input-sm"
                           placeholder="请输入身份证号码"/>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input type="submit" class="btn btn-success" value="保存"/>
            <input type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>

</body>
</html>

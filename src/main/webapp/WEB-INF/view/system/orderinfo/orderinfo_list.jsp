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
        <li>订单管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal" action="orderList">
	<div class="col-sm-1" >条件:</div>
    <div class="col-sm-3">
    	<input type="text" name="userId" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px;margin-left: 1% ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>订单编号</th>
            <th>用户ID</th>
            <th>订单总价</th>
            <th>订单状态</th>
            <th>配送地址</th>
             <th>操作</th>
            <th>详情</th>
        </tr>
        <c:forEach items="${orderLists}" var="bean" varStatus="index">
            <tr>
                <td>${bean.orderNumber}</td>
                <td>${bean.userId }</td>
                <td>${bean.totalPrice}</td>
                <c:if test="${bean.status=='1100'}">
                    <td>已支付</td>
                </c:if>
                <c:if test="${bean.status=='1101'}">
                    <td>待支付</td>
                </c:if>
                <c:if test="${bean.status=='1102'}">
                    <td>拒绝单</td>
                </c:if>
                <c:if test="${bean.status=='1104'}">
                    <td>待收货</td>
                </c:if>
                <c:if test="${bean.status=='1105'}">
                    <td>已送达</td>
                </c:if>
                <c:if test="${bean.status=='1106'}">
                    <td>待配送</td>
                </c:if>
                <c:if test="${bean.status=='1103'}">
                    <td>无效单</td>
                </c:if>
                <td>${bean.completeAddress}</td>
                <th>
                    <a href="deleteOrder?orderId=${bean.orderId }">删除</a>
                    <c:if test="${bean.status=='1100'}">
                        <a href="#" onclick="refuseOrder(${bean.orderId })">拒单</a>
                        <a href="#" onclick="acceptOrder(${bean.orderId })">接单</a>
                        <a href="#}" onclick="false" style="color: grey">配送</a>
                    </c:if>
                    <c:if test="${bean.status=='1101'}">
                        <a href="#" onclick="refuseOrder(${bean.orderId })">拒单</a>
                        <a href="#" onclick="false" style="color: grey">接单</a>
                        <a href="#}" onclick="false" style="color: grey">配送</a>
                    </c:if>
                    <c:if test="${bean.status=='1106'}">
                        <a href="#" onclick="false" style="color: grey">拒单</a>
                        <a href="#" onclick="false" style="color: grey">接单</a>
                        <a href="#" onclick="dispatch(${bean.orderId })" >配送</a>
                    </c:if>
                    <c:if test="${bean.status=='1105'||bean.status=='1104'||bean.status=='1102'||bean.status=='1103'}">
                        <a href="#" onclick="false" style="color: grey">拒单</a>
                        <a href="#" onclick="false" style="color: grey">接单</a>
                        <a href="#" onclick="false" style="color: grey">配送</a>
                    </c:if>

                </th>
                <th><a href="orderDetail?orderId=${bean.orderId }">详情</a></th>

            </tr>
        </c:forEach>
          
    </table>
</div>
<script>
    function acceptOrder(orderId) {
        if(confirm("确认接单？")){
            window.location.href="acceptOrder?orderId="+orderId;
        }
    }
    function refuseOrder(orderId) {
        if(confirm("确认拒单？钱都不要赚的吗？")){
            window.location.href="refuseOrder?orderId="+orderId;
        }
    }
    function dispatch(orderId) {
        if(confirm("确认配送？")){
            window.location.href="dispatch?orderId="+orderId;
        }
    }
</script>
</body>
</html>

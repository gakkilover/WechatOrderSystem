<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
</head>
<script>
    function validate_required(field,alerttxt)
    {
        with (field)
        {
            if (value==null||value=="")
            {alert(alerttxt);return false}
            else {return true}
        }
    }

    function check(thisform)
    {
        with (thisform)
        {
            if (validate_required(nickName,"用户名不能为空")==false)
            {nickName.focus();return false}
            if (validate_required(password,"密码不能为空")==false)
            {password.focus();return false}
        }
    }
    function sendCode() {
        var userTel=document.getElementById("userTel").value;
        var nickName=document.getElementById("nickName").value;
        var password=document.getElementById("password").value;
		window.location="sendCode?userTel="+userTel+"&nickName="+nickName+"&password="+password;
    }
</script>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i>  <span
									class="white">双元教育实训管理平台</span>
							</h1>
							<h4 class="blue">烟台实训</h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的账号和密码
										</h4>

										<div class="space-6"></div>
										<form action="registerUser" method="post" onsubmit="return check(this)">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="nickName"
														name="nickName" type="text" class="form-control"
														placeholder="请输入账号" value= ${nickName}> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="password"
														name="password" type="password" class="form-control"
														placeholder="请输入密码" value= ${password}> <i class="icon-lock"></i>
												</span>
												</label>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userTel"
													name="userTel" type="text" class="form-control" placeholder="请输入手机号码" value= ${userTel}>
												</span>
											</label>
												<div class="clearfix">
												<span class="block input-icon input-icon-right">
													<input id="code" name="code" type="text" class="required" style="width: 150px"/>
													<button type="button"
														class="width-40 pull-right btn btn-sm btn-primary" onclick="sendCode()">
														<i class="icon-key"></i> 发送验证码
													</button>
													</span>
												</div>
												<div class="clearfix" style="margin-top: 10px">
													<button type="submit"
														class="width-35 pull-left btn btn-sm btn-primary" style="margin-left: 100px">
														<i class="icon-key"></i> 注册
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>

								</div>

							</div>


					</div>

				</div>
			</div>

		</div>
</div>
	</div>
</body>
</html>

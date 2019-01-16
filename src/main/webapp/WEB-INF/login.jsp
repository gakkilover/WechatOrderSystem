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
<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" type="text/css" href="css/verify.css">
</head>
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/verify.js" ></script>
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
										<form action="loginValidate" method="post" onsubmit="return check(this)">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="nickName"
														name="nickName" type="text" class="form-control"
														placeholder="请输入账号" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="password"
														name="password" type="password" class="form-control"
														placeholder="请输入密码"/> <i class="icon-lock"></i>
												</span>
												</label>


											<span>
												<div id="mpanel2" >
												</div>

                                            </span>

												<div class="clearfix" >


													<button type="submit" id="check-btn" class="verify-btn" style="width: 100px;height: 40px">登录</button>
													<button type="button"
															class="width-35 pull-right btn btn-sm btn-primary" style="margin-top: 10px;;height: 40px" onclick="register()">
														<i class="icon-key"></i> 立即注册
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
<script>
	function register() {
		window.location.href="registerPost";
    }
    function loginValidate() {
	    var nickName=document.getElementById("nickName").value();
        var password=document.getElementById("password").value();
        window.location.href="loginValidate?nickName="+nickName+"&password="+password;
    }
    $('#mpanel2').codeVerify({
        type : 1,
        width : '150px',
        height : '33px',
        fontSize : '25px',
        codeLength : 6,
        btnId : 'check-btn',
        ready : function() {
        },
        success : function() {
            //this.document.form().submit();
            var j$ = jQuery.noConflict();//注册jQuery
            j$.ajax({
                type:"post",
                url:"user/loginValidate",
                data:{
                    nickName : j$("#nickName").val(),
                    password : j$("#password").val()
                },
            success:function(){
                 //   alert("suceee!!!");
                // if(ret == 1) {
                //     alert("提交审核成功!");
                //     }else{
                //     alert(ret);
                //
                //     }
                // window.returnValue=true;
                // window.close();
                }
            });
        },
        error : function() {
            alert('验证码不正确！');
        }
    });

</script>
</html>

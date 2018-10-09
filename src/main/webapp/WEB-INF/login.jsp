<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/animate.css" rel="stylesheet">
    <link href="<%=path %>/css/style.css" rel="stylesheet">
    <link href="<%=path %>/css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
        $(function(){
        	$("#login").click(function(){
				var name = $("#name").val();
				var password = $("#password").val();
				<!--前端没加验证，大佬们手下留情-->
					$.ajax({
						url:"/check",	
						type:"post",
						data:{"name":name,"password":password},
						success: function(data){
								if(data!='error'){
									location.href="/main/index";
						}
				}
			})
        });
        })
    </script>
</head>
<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>【鱼望未忘】</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>那年秋天 <strong>高中毕业了</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 大一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 大二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 大三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 大四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 工作</li>
                    </ul>
                    <strong>还没有账号？ <a href="/regist">点击注册&raquo;</a></strong>
                </div>
            </div>
            <div style="left:20%" class="col-sm-5">
                <form method="post" action="index.html">
                    <h4 class="no-margins">Access：</h4>
                    <p class="m-t-md">想看看这里有什么东西么？快点登录吧~</p>
                    <input type="text" class="form-control uname" id = "name" required="" placeholder="用户名" />
                    <input type="password" class="form-control pword m-b" id = "password" required="" placeholder="密码" />
                    <a href="javascript:void(#)">忘记密码了？不存在的</a>
                    <input type="button" class="btn btn-success btn-block" id="login" value="登录"/>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2018 03 25 始. H+
            </div>
        </div>
    </div>
</body>
</html>
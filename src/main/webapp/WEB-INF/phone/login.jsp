<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
<title>登录</title>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width">
<meta name="viewport" media="(device-height: 568px)" content="initial-scale=1.0,user-scalable=no,maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="<%=path %>/phone/css/gongyong.css">
<script src="<%=path %>/phone/js/login.js" type="text/javascript"></script>
</head>
<body>
<div class="head">
<span class="head_lf"><a href="/phone/login">返回</a></span>

用户登录

<span class="head_rg"><a href="/phone/regist">注册</a></span>
</div>

<div class="login">
	<div class="text name"><input type="text" id="userid" placeholder="请输入账号"></div>
    <div class="text pwd"><input type="password" id="password" placeholder="请输入密码"></div>
   	<h5 style="color:red;display:none;" id="tipinfo">用户名或密码错误</h5>
    <div class="tip"><a href="mailto:shaoyanghui_dh@163.com">忘记密码？</a></div>
    <div class="btndl"><input type="button" id="checklogin" value="登 录"></div>
</div>

<!-- <div class="foot">
	<a href="index.html" class="now">
    <span><img src="images/sy.png"></span>
    首页
    </a>
    <a href="#">
    <span><img src="images/sousuo.png"></span>
    小区
    </a>
    <a href="#">
    <span><img src="images/sousuo.png"></span>
    关注
    </a>
    <a href="#">
    <span><img src="images/sousuo.png"></span>
    我的
    </a>
    <a href="#">
    <span><img src="images/sousuo.png"></span>
    更多
    </a>

</div> -->

</body>
</html>

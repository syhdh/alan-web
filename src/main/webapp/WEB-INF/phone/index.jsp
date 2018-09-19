<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
<title>注册</title>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width">
<meta name="viewport" media="(device-height: 568px)" content="initial-scale=1.0,user-scalable=no,maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="<%=path %>/phone/css/gongyong.css">
<script src="<%=path %>/phone/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=path %>/phone/js/login.js" type="text/javascript"></script>

</head>

<body>

<div class="head">
<span class="head_lf"><a href="/phone/regist">返回</a></span>

用户注册

<span class="head_rg"><a href="/phone/login">登录</a></span>
</div>

<div class="zhuce">
	<div class="text">
        <span>账号</span>
        <input type="text" id="userid" placeholder="手机号/QQ号/微信/邮箱" class="input"><span style="color:red;display:none" id="nameinfo"></span>
    </div>
    <div class="text">
        <span>昵 称</span>
        <input type="text" id="name" placeholder="请输入昵称" class="input">
    </div>
    <div class="text">
    	<h5 color="red" style="display:none;" id="passcheck1">密码不一致</h5>
        <span>密 码</span>
        <input type="text" id="password1" placeholder="请输入密码" class="input">
    </div>
    <div class="text">
   		<h5 color="red" style="display:none;" id="passcheck2">密码不一致</h5>
        <span>确认密码</span>
        <input type="text" id="password2" placeholder="请输入确认密码" class="input">
    </div>
    <div class="btndl"><input type="button" id="regist111" value="注 册"></div>
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

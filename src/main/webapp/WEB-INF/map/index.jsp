<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>地图开发--基于高德地图API</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
    <script src="http://webapi.amap.com/maps?v=1.3&key=c93e1e293e5b1c3dc581f3ff633144d3&plugin=AMap.Autocomplete,AMap.PlaceSearch,AMap.Walking,AMap.Riding"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <link rel="stylesheet" href="<%=path %>/map/style.css">
    <script></script>
</head>
<body>
<div id="myPageTop">
    <a href="javascript:void(0);" id="show">
        点击试试———搜索（展开/收缩）
    </a>
    <div class="pageShow">
        <h3>搜索地址</h3>
        <input id="tipinput" placeholder="模糊地址搜索">
        <h3>搜索行车路径</h3>
        <input id="star" placeholder="行车开始地址">
        <span>—&nbsp;—</span>
        <input id="end" placeholder="行车结束地址">
        <span>—&nbsp;—</span>
        <a id="car" href="javascript:void(0);">
            点击搜索
        </a>
       
    </div>
</div>
<div id="container"></div>
<div id="panel"></div>
<script src="main.js"></script>
</body>
</html>
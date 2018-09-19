<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>资料填写</title>
<link rel="stylesheet" href="../../table/css/style.css" media="screen" type="text/css" />
<link rel="shortcut icon" href="favicon.ico"> <link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="<%=path %>/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="<%=path %>/css/animate.css" rel="stylesheet">
<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
  <script src="<%=path %>/laydate/laydate.js"></script> <!-- 改成你的路径 -->
    <script>
    lay('#version').html('-v'+ laydate.v);

    //执行一个laydate实例
    //常规用法
    laydate.render({
      elem: '#test1' //指定元素
    });
    //国际版
    laydate.render({
      elem: '#test1-1'
      ,lang: 'en'
    }); 
    //年选择器
    laydate.render({
      elem: '#test2'
      ,type: 'year'
    });
    //年月选择器
    laydate.render({
      elem: '#test3'
      ,type: 'month'
    });
    //时间选择器
    laydate.render({
      elem: '#test4'
      ,type: 'time'
    });
    //时间选择器
    laydate.render({
      elem: '#test5'
      ,type: 'datetime'
    });
    //日期范围
    laydate.render({
      elem: '#test6'
      ,range: true
    });
    //年范围
    laydate.render({
      elem: '#test7'
      ,type: 'year'
      ,range: true
    });
    //年月范围
    laydate.render({
      elem: '#test8'
      ,type: 'month'
      ,range: true
    });
    //时间范围
    laydate.render({
      elem: '#test9'
      ,type: 'time'
      ,range: true
    });
    //日期时间范围
    laydate.render({
      elem: '#test10'
      ,type: 'datetime'
      ,range: true
    }); 
    //墨绿主题
    laydate.render({
      elem: '#test29'
      ,theme: 'molv'
    });
    //自定义颜色
    laydate.render({
      elem: '#test30'
      ,theme: '#393D49'
    });
    //格子主题
    laydate.render({
      elem: '#test31'
      ,theme: 'grid'
    });

    </script>
  <style>
  body{padding: 20px;}
  .demo-input{padding-left: 10px; height: 38px; min-width: 262px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
  </style>
</head>
<body>
<section class='container'>
	<form>
		<fieldset class='alpha'>
			<legend><b>1.</b>个人信息</legend>
			<span color="red" id="infomation1" style="display:none;">!请填写完整</span>
			<h5 style="color:black;margin-buttom:2px;">发件人名称 *</h5>
			<div class='frow'><input class='item' id="sendUser" placeholder='发件人名称(必填)' type='text' required='required'></div>
			<h5 style="color:black;margin-buttom:2px;">收件人名称 *</h5>
			<div class='frow'><input class='item' id= "reciveUser" placeholder='收件人名称(必填)' type='text' required='required'></div>
			<div class='frow'><a class='next-step' href='#'>下一步!</a></div>
		</fieldset>
		
		<fieldset class='beta'>
			<legend><b>2.</b>社交信息</legend>
			<span><h5><span style="color:red">*</span>发件邮箱为第三方邮箱，不是发件人邮箱，发件人邮箱仅仅接收生成的数据信息</h5> </span>
			<span color="blue" id="infomation2" style="display:none;">邮箱格式有误</span>
			<h5 style="color:black;margin-buttom:2px;">发件人邮箱 *</h5>
			<div class='frow'><input class='item' id="sendEmail" placeholder='你的邮箱(必填)' required='required' type='email'></div>
			<h5 style="color:black;margin-buttom:2px;">收件人邮箱</h5>
			<div class='frow'><input class='item' id="reciveEmail" placeholder='收件人邮箱(选填)'  type='email'></div>
			
			<h5 style="color:black;margin-buttom:2px;">相识于</h5>
            <input type="text" style="width:35px;margin:2px;padding:3px;" class="item demo-input " placeholder="你们相识于" id="test1">
			<div class='frow'>
			<span><h6 color="red"><span style="color:red" style="margin:2px; padding:2px">*</span>填写你想说的话，点完成生成结果会自动发送到以上邮箱中</h6></span>
			<textarea rows="7" cols="40px;" id="content"></textarea></div>
			<div class='frow'><a class='prev-step' href='#'>上一步</a></div>
			<div class='frow'><input class='submit' type='button' value="生成结果并发送到邮箱" ></div>
		</fieldset>
		
		<fieldset class='charlie'>
			<legend><b>3.</b>完成</legend>
			<div class='frow'><div id="result" color="red"></div><p>您的信息已经填写完整，相关内容已发送到填写的邮箱，请注意查收！<br>
			如有更好的建议请发送到: <a href="mailto:shaoyanghui_dh@163.com">shaoyanghui_dh@163.com</a>，谢谢</p></div>
		</fieldset>
	</form>
</section>
<script type="text/javascript" src='<%=path %>/table/js/jquery.js'></script>
<script type="text/javascript" src="<%=path %>/table/js/script.js"></script>
 <!-- 全局js -->
<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=path %>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=path %>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=path %>/js/plugins/layer/layer.min.js"></script>
<!-- 自定义js -->
<script src="<%=path %>/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=path %>/js/contabs.js"></script>

<!-- 第三方插件 -->
<script src="<%=path %>/js/plugins/pace/pace.min.js"></script>
</body>
</html>
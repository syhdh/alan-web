<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<link rel="stylesheet" type="text/css" href="<%=path %>/phone/orderstyle/css/style.css"/>
<script type="text/javascript" src="<%=path %>/phone/orderstyle/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var oFocus=$('#focus'),
		oRight=oFocus.find('.right'),
		oLeft=oFocus.find('.left'),
		aRLi=oRight.find('li'),
		aLLi=oLeft.find('li'),
		index=0,
		timer = null;
	aRLi.click(function(){
		index=$(this).index()
		$(this).addClass('active').siblings().removeClass();
		aLLi.eq(index).addClass('active').siblings().removeClass();
		aLLi.eq(index).stop().animate({'opacity':1},300).siblings().stop().animate({'opacity':0},300);
		stopFoucs();
	})
	oLeft.mouseenter(function(){
		stopFoucs();
	}).mouseleave(function(){		
		startFocus();
	});
	timer = setInterval(function(){
		startFocus();
	},20000);
	function startFocus(){
		index++;
		index = index > aRLi.size()-1 ? 0 :index;

		aLLi.eq(index).addClass('active').siblings().removeClass();
		aLLi.eq(index).stop().animate({'opacity':1},300).siblings().stop().animate({'opacity':0},300);
		aRLi.eq(index).addClass('active').siblings().removeClass();
	}
	function stopFoucs(){
		clearInterval(timer);
		
	}
})

</script>

<div class="focus" id="focus">
	<div class="left" id="bo">
		<ul>
			<li  class="active" style="opacity:1; filter:alpha(opacity=100);"><p>diyByu</p><iframe src="http://www.17sucai.com/preview/27774/2014-03-19/jQuery+Html5实现唯美表白动画代码/index.html" style="width:80%;height:100%;" id="myiframe1" scrolling="no" frameborder="0"></iframe></li>
			<li><p>3d相册1</p><iframe src="https://www.html5tricks.com/demo/jiaoben2329/index2.html" id="myiframe2" scrolling="no" style="width:80%;height:100%;" frameborder="0"></iframe></li>
			<li><p>3d相册2</p><iframe src="http://www.17sucai.com/preview/11507/2013-07-12/3种不同风格3D照片效果/index.html" id="myiframe3" scrolling="no" style="width:80%;height:100%;" frameborder="0"></iframe></li>
			<li><p>未完待续</p><iframe src="http://other.zaojv.com/simage/542/4334542.jpg" id="myiframe3" scrolling="no" style="width:80%;height:100%;" frameborder="0"></iframe></li>
		</ul>
	</div>
	<div class="right">
		<ul>
			<li class="active"><i class="i4"></i>diy</li>
			<li><i class="i3"></i>3d相册1</li>
			<li><i class="i3"></i>3d相册2</li>
			<li><i class="i1"></i>未完待续...</li>
		</ul>
	</div>
</div>
<div>
&nbsp;&nbsp;<input type="button" value="定制diy给TA" onclick="javascript:location.href='/sendCode/table'" style="width:10%;height:30px;"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="定制3d相册1" onclick="javascript:location.href='/info/imgupload'" style="width:10%;height:30px;"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="定制3d相册2" onclick="javascript:location.href='/info/imgupload'" style="width:10%;height:30px;"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="意见或建议" onclick="javascript:location.href='/info/email?mail=shaoyanghui_dh@163.com'" style="width:10%;height:30px;"/>
&nbsp;&nbsp;
</div>
</body>
</html>

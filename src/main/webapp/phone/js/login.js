$(function(){
	var flag;
	//注册
	$("#regist111").click(function(){
		var userid = $("#userid").val();
		var nickname = $("#name").val();
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if(password1==password2){
			
		}else{
			document.getElementsByClassName("passcheck").style.cssText = "display:block;"
			return;
		}
		if (flag==false) {
			$("#nameinfo").html("已存在!");
			document.getElementById("nameinfo").style.cssText = "display:block;color:red";
			return;
		}
		$.ajax({
			url:"/addUser",
			type:"post",
			data:{"userid":userid,"nickname":nickname,"password":password1},
			async:false, 
			success:function(data){//tipinfo
				if(data.code==0){
					location.href="/phone/login";
				}else{
					confirm("注册失败！");
					location.href="/phone/regist";
				}
			}
		})
	});
	
	//登录
	$("#checklogin").click(function(){
		var userid = $("#userid").val();
		var password = $("#password").val();
		$.ajax({
			url:"/phoneuser",
			type:"post",
			data:{"id":userid,"password":password},
			async:false, 
			success:function(data){//tipinfo
				if(data=='y'){
					location.href = "/phone/order";
				}
				if(data=='n'){
					document.getElementById("tipinfo").style.cssText = "display:block;color:red";
				}
			}
		})
	})
	
	/**
	 * 验证密码是否一致
	 */
	$("#password2").blur(function(){
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if(password1===password2){
			document.getElementById("passcheck1").style.cssText = "display:none;"
			document.getElementById("passcheck2").style.cssText = "display:none;"
			return;
		}
		document.getElementById("passcheck1").style.cssText = "display:block;"
		document.getElementById("passcheck2").style.cssText = "display:block;"
	});
	
	$("#password1").blur(function(){
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if(password1===password2){
			document.getElementById("passcheck1").style.cssText = "display:none;"
			document.getElementById("passcheck2").style.cssText = "display:none;"
			return;
		}
		document.getElementById("passcheck1").style.cssText = "display:block;"
		document.getElementById("passcheck2").style.cssText = "display:block;"
	});

	
	$("#userid").blur(function(){
		var userid = $("#userid").val();
		$.ajax({
			url:"/checkid",
			type:"post",
			data:{"userid":userid},
			async:false, 
			success:function(data){
				if (data=='n') {//账号已被注册  
					$("#nameinfo").html("已存在!");
					document.getElementById("nameinfo").style.cssText = "display:block;color:red";
					flag = false;
				}
				if (data=='y') {//账号未注册
					$("#nameinfo").html("√");
					document.getElementById("nameinfo").style.cssText = "display:block;color:green";
					flag = true;
				}
			}
		})
	});
})
jQuery(document).ready(function(){
	
	
	//生成代码方法
	function generatorCode(){
		//获取发件人名称
		var sendUser = $("#sendUser").val();
		//收件人名称
		var reciveUser = $("#reciveUser").val();
		//收件人邮箱
		var reciveEmail = $("#reciveEmail").val();
		//获取发件人邮箱
		var sendEmail = $("#sendEmail").val();
		//获取真言
		var content = $("#content").text();
		//请求数据
		$.ajax({
			url:"",
			type:"post",
			data:{},
			success:function(data){
				
				
			}
		})
	}
})
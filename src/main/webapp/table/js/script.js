jQuery(document).ready(function(){
  function doStep(){
    // Next Button
    $('a.next-step').click(function(event){
    	//获取发件人名称
		var sendUser = $("#sendUser").val();
		//收件人名称
		var reciveUser = $("#reciveUser").val();
		var str = reciveUser.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		var str1 = sendUser.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
	    if (str == '' || str == undefined || str == null) {
	    	//显示提示信息
	    	document.getElementById("infomation1").style.cssText = "display:block;"
	           return;
	    }
	    if (str1 == '' || str1 == undefined || str1 == null) {
	    	//显示提示信息
	    	document.getElementById("infomation1").style.cssText = "display:block;"
	           return;
	    }
	  document.getElementById("infomation1").style.cssText = "display:none;"  
      event.preventDefault();
      // Part 1
      if($('.alpha').hasClass("in")) {
        $('.alpha').removeClass("in");
      }
      $('.alpha').addClass("out");
      // Part 2
      if($('.beta').hasClass("out")) {
        $('.beta').removeClass("out");
      }
      $('.beta').addClass("in");
    });
    
    // Previous Button
    $('a.prev-step').click(function(event){
      event.preventDefault(); 
      $('.alpha').removeClass("out").addClass("in");
      $('.beta').removeClass("in").addClass("out");
    });
    
    // Submit & Complete
    $('.submit').click(function(event){
    	//获取发件人邮箱
		var sendEmail = $("#sendEmail").val();
		//收件人邮箱
		var reciveEmail = $("#reciveEmail").val();
		var str = sendEmail.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //邮箱验证
		 if (str == '' || str == undefined || str == null) {
		    	//显示提示信息
			 document.getElementById("infomation2").style.cssText = "display:block;"
		           return;
		 }
		 var str1 = reciveEmail.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		 if (str1 != '' || str1 != undefined || str1 != null) {
		    	//显示提示信息
			 if (!reg.test(reciveEmail)) {
				 if (!reg.test(sendEmail)) {
					    document.getElementById("infomation2").style.cssText = "display:block;"
					    return;
				}
			}
		 }
		 if (!reg.test(sendEmail)) {
		    document.getElementById("infomation2").style.cssText = "display:block;"
		    return;
		}
		 document.getElementById("infomation2").style.cssText = "display:none;"
     if(confirm('是否生成结果？')){
    	//获取发件人名称
 		var sendUser = $("#sendUser").val();
 		//收件人名称
 		var reciveUser = $("#reciveUser").val();
 		//收件人邮箱
 		var reciveEmail = $("#reciveEmail").val();
 		//获取发件人邮箱
 		var sendEmail = $("#sendEmail").val();
 		//获取真言
 		var content = $("#content").val();
 		//时间
 		var eventid = $("#test1").val();
 		//请求数据
 		$.ajax({
 			url:"/sendCode/add",//接收地址
 			type:"post",
 			async:false, 
 			data:{"senduser":sendUser,"reciveuser":reciveUser,"sendemail":sendEmail,"reciveemail":reciveEmail,"content":content,"eventid":eventid},//请求数据
 			success:function(data){
 				if(data.code==0){
 					$("#result").html("对不起，出错了，请点此刷新<a href='javascript:location.reload()'>重试</a>，或联系管理员qq:1032624544");
 				}
 				event.preventDefault();
 		         // Part 1
 		         if($('.beta').hasClass("in")) {
 		           $('.beta').removeClass("in");
 		         }
 		         $('.beta').addClass("out");
 		         // Part 2
 		         if($('.charlie').hasClass("out")) {
 		           $('.charlie').removeClass("out");
 		         }
 		         $('.charlie').addClass("in");
 			}
 		})
     }
    });
  }
  // Active Functions
  doStep();
});
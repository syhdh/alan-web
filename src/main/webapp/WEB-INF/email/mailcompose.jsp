<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>写信</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="<%=path %>/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.css" rel="stylesheet">
    <link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">
                    <div class="pull-right tooltip-demo">
                       <!--  <a href="mailbox.html" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="存为草稿"><i class="fa fa-pencil"></i> 存为草稿</a> -->
                        <a href="mailbox.html" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top" title="放弃"><i class="fa fa-times"></i> 放弃</a>
                    </div>
                    <h2>
                    写信
                </h2>
                </div>
                <div class="mail-box">
                    <div class="mail-body">
                        <form class="form-horizontal" method="get">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">发送到：</label>

                                <div class="col-sm-10">
                                    <input type="text" id="recevice" class="form-control" value="${mail }" placeholder="ex:example@domain.com">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主题：</label>

                                <div class="col-sm-10">
                                    <input type="text" id="issume" class="form-control" value="" placeholder="topic">
                                </div>
                            </div>
                        </form>

                    </div>

                    <div class="mail-text h-200" id = "content">
						<br>
						<h2>邮件内容....</h2>
                        <div class="summernote" >
						
							<br>
							<br>
							<br>
                        </div>
                    </div>
                    <h2>添加附件:</h2>
                    	 <br>
                    	 <div id = "showprogress" style="display:none;">
                    	 	 <progress id="progressBar" value="0" max="100" style="width: 300px;"></progress>
							<span id="percentage"></span><span id="time"></span>
						</div>
							<input type="file" id="file" name="myfile" style="margin:10px;"/>
							<!-- <input type="button" onclick="UpladFile()" value="上传"  style="margin:10px;" /> -->
                       		<!-- <input type="button" onclick="cancleUploadFile()" value="取消" style="margin:10px;" /> -->
                        <div class="clearfix"></div>
                    <div class="mail-body text-right tooltip-demo">
                        <a href="javascript:sendEmail()" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send"><i class="fa fa-reply"></i>发送</a>
                        <a href="javascript:void(#)" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Discard email"><i class="fa fa-times"></i> 放弃</a>
                        <!-- <a href="mailbox.html" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to draft folder"><i class="fa fa-pencil"></i> 存为草稿</a> -->
                    </div>
                    <div class="clearfix"></div>

					<input type="hidden" id= "filepath" value=""/>

                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="<%=path %>/js/content.js?v=1.0.0"></script>


    <!-- iCheck -->
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>

    <!-- SUMMERNOTE -->
    <script src="<%=path %>/js/plugins/summernote/summernote.min.js"></script>
    <script src="<%=path %>/js/plugins/summernote/summernote-zh-CN.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });


            $('.summernote').summernote({
                lang: 'zh-CN'
            });
            

        });
        var edit = function () {
            $('.click2edit').summernote({
                focus: true
            });
        };
        var save = function () {
            var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
            $('.click2edit').destroy();
        };
    </script>
	<script type="text/javascript">
	function sendEmail(){
			UpladFile();
			setTimeout(sendCheck,300);
		}
	function sendCheck(){
		var recevice = $("#recevice").val();
		var issume = $("#issume").val();
		var content = $(".note-editable").text();
		$.ajax({
			url:"/info/sendEmail",
			type:"post",
			data:{"receive":recevice,"subject":issume,"msg":content},
			success:function(data){
						alert("发送成功！");
				}
			});
		}
        //图片上传
        var xhr;
        //上传文件方法
        function UpladFile() {
			document.getElementById("showprogress").style.cssText = 'height: 20px !important';
            var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
            var url =  "/info/fileupload"; // 接收上传文件的后台地址
            var form = new FormData(); // FormData 对象
            var recevice = $("#recevice").val();
			var issume = $("#issume").val();
			var content = $(".note-editable").text();
			form.append("receive",recevice);
			form.append("subject",issume);
            form.append("file", fileObj); // 文件对象
            xhr = new XMLHttpRequest();  // XMLHttpRequest 对象
            xhr.open("post", url, true); //post方式，url为服务器请求地址，true 该参数规定请求是否异步处理。
            xhr.onload = uploadComplete; //请求完成
            xhr.onerror =  uploadFailed; //请求失败
            xhr.upload.onprogress = progressFunction;//【上传进度调用方法实现】
            xhr.upload.onloadstart = function(){//上传开始执行方法
                ot = new Date().getTime();   //设置上传开始时间
                oloaded = 0;//设置上传开始时，以上传的文件大小为0
            };
            xhr.send(form); //开始上传，发送form数据
        }

        //上传成功响应
        function uploadComplete(evt) {
            //服务断接收完文件返回的结果
           alert("上传成功!");
        }
        //上传失败
        function uploadFailed(evt) {
            alert("上传失败！");
        }
        //取消上传
        function cancleUploadFile(){
            xhr.abort();
        }
        //上传进度实现方法，上传过程中会频繁调用该方法
        function progressFunction(evt) {
            var progressBar = document.getElementById("progressBar");
            var percentageDiv = document.getElementById("percentage");
            // event.total是需要传输的总字节，event.loaded是已经传输的字节。如果event.lengthComputable不为真，则event.total等于0
            if (evt.lengthComputable) {//
                progressBar.max = evt.total;
                progressBar.value = evt.loaded;
                percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
            }
            var time = document.getElementById("time");
            var nt = new Date().getTime();//获取当前时间
            var pertime = (nt-ot)/1000; //计算出上次调用该方法时到现在的时间差，单位为s
            ot = new Date().getTime(); //重新赋值时间，用于下次计算
            var perload = evt.loaded - oloaded; //计算该分段上传的文件大小，单位b
            oloaded = evt.loaded;//重新赋值已上传文件大小，用以下次计算
            //上传速度计算
            var speed = perload/pertime;//单位b/s
            var bspeed = speed;
            var units = 'b/s';//单位名称
            if(speed/1024>1){
                speed = speed/1024;
                units = 'k/s';
            }
            if(speed/1024>1){
                speed = speed/1024;
                units = 'M/s';
            }
            speed = speed.toFixed(1);
            //剩余时间
            var resttime = ((evt.total-evt.loaded)/bspeed).toFixed(1);
            time.innerHTML = '，速度：'+speed+units+'，剩余时间：'+resttime+'s';
            if(bspeed==0) time.innerHTML = '上传已取消';
        }
    </script>
</body>

</html>

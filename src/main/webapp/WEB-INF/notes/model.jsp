<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>简历</title>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">    
<link rel="shortcut icon" href="">  
<link href='https://fonts.googleapis.com/css?family=Roboto:400,500,400italic,300italic,300,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- Global CSS -->
<link rel="stylesheet" href="<%=path %>/personnalinfo/plugins/bootstrap/css/bootstrap.min.css">   
<!-- Plugins CSS -->
<link rel="stylesheet" href="<%=path %>/personnalinfo/plugins/font-awesome/css/font-awesome.css">

<!-- Theme CSS -->  
<link id="theme-style" rel="stylesheet" href="<%=path %>/personnalinfo/css/styles.css">
</head> 
<body>
<header class="header">
	<div class="top-bar container-fluid">
		<div class="actions">
			<a class="btn hidden-xs" href="mailto:someone@example.com"><i class="fa fa-paper-plane" aria-hidden="true"></i><img src = "<%=path %>/img/email.jpg" style="height:20px;weight:22px;"/></a>
			<a class="btn" href="https://np-alan.oss-cn-hangzhou.aliyuncs.com/%E4%B8%AA%E4%BA%BA%E8%B5%84%E6%96%99/%E9%82%B5%E6%9D%A8%E8%BE%89-java%E5%90%8E%E7%AB%AF-1%E5%B9%B4.pdf"><i class="fa fa-download" aria-hidden="true"></i>我的简历</a>
		</div><!--//actions-->
		<ul class="social list-inline">
			<li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
			<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
			<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
			<li><a href="#"><i class="fa fa-github-alt" aria-hidden="true"></i></a></li>
			<li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
		</ul><!--//social-->
	</div><!--//top-bar-->
	
	<div class="intro">
		<div class="container text-center">
			<img class="profile-image" src="https://np-alan.oss-cn-hangzhou.aliyuncs.com/jpg/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180917113119.png" alt="">
			<h1 class="name">邵&nbsp;杨&nbsp;辉</h1>
			<div class="title">Java Developer</div>
			<div class="profile">
				<p>勤奋踏实，工作认真负责，自学能力强，喜欢学习新技术;性格开朗，容易与人相处，注重团队协作精神，且能承受较大压力。</p>
			</div><!--//profile-->
		</div><!--//container-->
	</div><!--//intro-->
	
	<div class="contact-info">
		<div class="container text-center">
			<ul class="list-inline">
				<li class="email"><i class="fa fa-envelope"></i><a href="mailto:shaoyanghui_dh@163.com">shaoyanghui_dh@163.com</a></li>
				<li><i class="fa fa-phone"></i> <a href="tel: 17681337003">17681337003</a></li>
				<li class="website"><i class="fa fa-globe"></i><a href="https://my.oschina.net/73114dh" target="_blank">博客(oschina)</a></li>
			</ul>
		</div><!--//container-->
	</div><!--//contact-info-->
	
	<div class="page-nav-space-holder hidden-xs">
		<div id="page-nav-wrapper" class="page-nav-wrapper text-center">
			<div class="container">
				<ul id="page-nav" class="nav page-nav list-inline">
					<li><a class="scrollto" href="#experiences-section">工作经历</a></li>
					<li><a class="scrollto" href="#eudcation-section">教育经历</a></li>
					<li><a class="scrollto" href="#skills-section">技术栈</a></li>
					<li><a class="scrollto" href="#testimonials-section">工作感悟</a></li>
					<li><a class="scrollto" href="#portfolio-section">作品展示</a></li>
					<li><a class="scrollto" href="#contact-section">联系我</a></li>
				</ul><!--//page-nav-->
			</div>
		</div><!--//page-nav-wrapper-->
	</div>
	
</header><!--//header-->

<div class="wrapper container">
	<section id="experiences-section" class="experiences-section section">
		<h2 class="section-title">工&nbsp;作&nbsp;经&nbsp;历</h2>
		<div class="timeline">
			<div class="item">
				<div class="work-place">
					<h3 class="place">富金通金融信息服务（上海）有限公司</h3>
					<div class="location"><i class="fa fa-map-marker" aria-hidden="true"></i>上海</div>
				</div>
				<div class="job-meta">
					<div class="title">初级软件工程师</div>
					<div class="time">2017年9月 &nbsp;至&nbsp;2018年7月</div>
				</div><!--//job-meta-->
				<div class="job-desc">
					<p>负责<strong>富盾供应链金融管控系统</strong>一期部分维护，二期新系统开发；该系统为供应链上下游企业的融资租赁，再保理等业务提供了技术支持；为业务人员提供技术支持；</p> 
					<ul>
						<li>编写需求技术分析文档，进行可行性分析与讨论</li>
						<li>按计划完成季度任务开发与系统维护</li>
						<li>对业务及需求部门提供技术支持与技术解决方案</li>
					</ul>
				</div><!--//job-desc-->
			</div><!--//item-->
			
			<div class="item">
				<div class="work-place">
					<h3 class="place">新丽华企业集团</h3>
					<div class="location"><i class="fa fa-map-marker" aria-hidden="true"></i>南京</div>
				</div>
				<div class="job-meta">
					<div class="title">软件工程师</div>
					<div class="time">2018年7月&nbsp;至今</div>
				</div><!--//job-meta-->
				<div class="job-desc">
					<p>完成公司互联网项目<strong>米筑网</strong>系统重构，使用java对原有php系统进行重新开发与性能优化，针对难点提出技术解决方案并负责实现</p> 
					<ul>
						<li>实现新系统第一步数据支撑与oss文件系统，设计并实现mysql到couchbase数据迁移方案</li>
						<li>帮助原有php开发工程师逐步转移到java开发，进行定期技术分享并在初期提供java技术支持</li>
						<li>编写API接口开发文档，与前段工程师完成功能联调</li>
						<li>学习并熟悉couchabse数据库特性，结合其特性设计数据结构及关联</li>
					</ul>
				</div><!--//job-desc-->
			</div><!--//item-->
		</div><!--//timeline-->
	</section><!--//section-->
	<section id="eudcation-section" class="education-section section" style="padding:0px;margin-bottom:15px;">
		<br>
		<div class="row" style="margin:0px;padding:0px;">
			<br>
			<h3 style="text-align:center;"><span>毕业院校</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span>专业</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span>在校时间</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span>学位</span>
			</h3>
			<h4 style="text-align:center;">
			<span style="color:black">合肥工业大学(211)</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="color:black">制药工程</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="color:black">2013.09~2017.07</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="color:black">工学学士</span>
			</h4>
			<br>
		</div><!--//row-->
	</section><!--//section-->
	
	
	<section id="skills-section" class="skills-section section text-center">
		<h2 class="section-title">技术栈</h2>
		<div class="top-skills">
			<h3 class="subtitle">主要技能</h3>
			<div class="row">
				<div class="item col-xs-12 col-sm-4">
					<div class="item-inner">
						<div class="chart-easy-pie text-center">
							<div class="chart-theme-1 chart" data-percent="70"><span>70</span>%</div>
						</div>
						<h4 class="skill-name">Java </h4>
						<div class="level">developer, 1 year</div>
						<div class="desc">
							掌握Java基础，熟悉常用设计模式；熟悉常用后台框架，spring、spring-boot、spring-cloud等；有dubbo+zookeeper分布式使用经验，熟悉微服务开发;掌握项目管理工具SVN、GIT、MAVEN的使用；
						</div>
					</div><!--//item-inner-->
				</div><!--//item-->
				<div class="item col-xs-12 col-sm-4">
					<div class="item-inner">
						<div class="chart-easy-pie text-center">
							<div class="chart-theme-1 chart" data-percent="50"><span>50</span>%</div>
						</div>
						<h4 class="skill-name">HTML&amp;CSS&amp;JavaScript</h4>
						<div class="level">learner, 1 year</div>
						<div class="desc">
							熟悉常用javascript、css及前端插件jquery、bootstrap等
						</div>
					</div><!--//item-inner-->
				</div><!--//item-->
				<div class="item col-xs-12 col-sm-4">
					<div class="item-inner">
						<div class="chart-easy-pie text-center">
							<div class="chart-theme-1 chart" data-percent="40"><span>40</span>%</div>
						</div>
						<h4 class="skill-name">DB &amp; Angular</h4>
						<div class="level">learner, 1 year</div>
						<div class="desc">
							熟悉关系型数据库Mysql，熟悉非关系型数据库Couchabse、redis、Mongodb；熟悉常用sql性能调优；熟悉Linux系统，掌握常用命令，熟悉阿里系列相关服务
						</div>
					</div><!--//item-inner-->
				</div><!--//item-->
			</div><!--//row-->
		</div><!--//top-skills-->
		
		<div class="other-skills">
			<h3 class="subtitle">技能标签</h3>
			<div class="misc-skills">
				<span class="skill-tag">Java</span>
				<span class="skill-tag">HTML&amp;CSS&amp;JavaScript</span>
				<span class="skill-tag">微服务</span>
				<span class="skill-tag">Git</span>
				<span class="skill-tag">Maven&amp;SVN</span>
				<br>
				<span class="skill-tag">Python</span>
				<span class="skill-tag">Markdown</span>
				<span class="skill-tag">UML</span>
				<span class="skill-tag">数据库</span>
				<span class="skill-tag">爬虫</span>
			</div>
		</div><!--//other-skills-->
		
	</section><!--//skills-section-->
	
	<section id="testimonials-section" class="testimonials-section section">
		<h2 class="section-title">工作感悟</h2>
		
		<div id="testimonials-carousel" class="testimonials-carousel carousel slide" data-interval="8000">
			
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#testimonials-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#testimonials-carousel" data-slide-to="1"></li>
				<!-- <li data-target="#testimonials-carousel" data-slide-to="2"></li> -->
			</ol>
			
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<blockquote class="quote">      
						<i class="fa fa-quote-left"></i>                            
						<p>感谢我的项目经理和小组长对我的关照，项目经理对项目管理的严格要求是我这份工作中收获最大的，直至此时，我任清晰的记得我的领导在每一次code review时所说的，同时小组长在技术上不遗余力的指导我，开发团队的氛围很轻松，但关键之处丝毫不见马虎，感谢这段在富金通的日子，感谢遇见你们</p>
					</blockquote>    
					<div class="source">
						<div class="name">富金通金融信息服务(上海)有限公司</div>
						<div class="position">初级软件工程师</div>
					</div><!--//source-->   
				</div><!--//item-->
				<div class="item">
					<blockquote class="quote">
						<p><i class="fa fa-quote-left"></i>
						在离职之初也没想过自己会来南京，当时首先拿到的是烽火的邀请，但经过仔细考虑之后，还是选择了新丽华，公司虽然是家传统行业的企业，但正走在互联网转型的路上，领导们都很亲切，能力很强，尤其是阿里技术顾问（也是我选择这家公司的初衷），在项目开发及系统设计过程中的指导将是我提升自身的最大的支持</p>
					</blockquote>
					<div class="source">
						<div class="name">新丽华企业集团</div>
						<div class="position">软件工程师</div>
					</div><!--//source-->   
				</div><!--//item-->
				<!-- <div class="item">
					<blockquote class="quote">
						<p><i class="fa fa-quote-left"></i>
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes</p>
					</blockquote>       
					<div class="source">
						<div class="name">Austin Ward</div>
						<div class="position">CEO, Startup Hub</div>
					</div>//source          
				</div> --><!--//item-->
				
			</div><!--//carousel-inner-->
		</div><!--//testimonials-carousel-->
		
	</section><!--//section-->
	
	
	<section id="portfolio-section" class="portfolio-section section">
		<h2 class="section-title">Portfolio（未完善，请勿点击）</h2>
		<ul id="filters" class="filters clearfix">
			<li class="type active" data-filter="*">All</li>
			<li class="type" data-filter=".backend">Back-end</li>
			<li class="type" data-filter=".frontend">Front-end</li>
		</ul><!--//filters-->
		<div class="items-wrapper isotope row">
			<div class="item frontend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-1.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">AngularJS</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			<div class="item backend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-2.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">Django</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			<div class="item backend frontend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-3.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">Django/JavaScript</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			<div class="item frontend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-4.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">ReactJS</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			<div class="item backend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-5.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">Python</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			<div class="item backend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-6.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">JavaScript</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			
			<div class="item frontend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-7.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">HTML/AngularJS</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			
			<div class="item frontend backend col-md-3 col-xs-6 ">
				<div class="item-inner">
					<figure class="figure">
						<img class="img-responsive" src="<%=path %>/personnalinfo/images/portfolio/portfolio-8.jpg" alt="" />
					</figure>
					<div class="content text-left">
						<h3 class="sub-title"><a href="#">Project Lorem Ipsum</a></h3>
						<div class="meta">Python/AngularJS</div>
						<div class="action"><a href="#">View on Github</a></div>
					</div><!--//content-->    
					<a class="link-mask" href="#"></a>              
				</div><!--//item-inner-->
			</div><!--//item-->
			
		</div><!--//item-wrapper-->
		
	</section><!--//section-->
	
	<section id="contact-section" class="contact-section section">
		<h2 class="section-title">Get in Touch</h2>
		<div class="intro">
			<img class="profile-image" src="https://np-alan.oss-cn-hangzhou.aliyuncs.com/jpg/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180917113119.png" alt="">
			<div class="dialog">
				<p>目前就职于 南京新丽华企业集团-互联网新业务公司-研发部</p>
				<p><strong>工作内容:</strong></p>
				<ul class="list-unstyled service-list">
					<li><i class="fa fa-check" aria-hidden="true"></i> 主要负责米筑网php项目重构</li>
					<li><i class="fa fa-check" aria-hidden="true"></i> 基于couchbase进行java项目开发，同时明确couchbase的优缺点，提出解决方案</li>
					<li><i class="fa fa-check" aria-hidden="true"></i> 帮助php工程师转型</li>
					<li><i class="fa fa-check" aria-hidden="true"></i> 参与系统设计</li>
				</ul>
				<p>联系邮箱 <a href="mailto:shaoyanghui_dh@163.com">shaoyanghui_dh@163.com</a>  &nbsp;&nbsp;&nbsp;联系电话 <a href="tel:17681337003">17681337003</a></p>
				<ul class="social list-inline">
					<li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-github-alt" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
				</ul><!--//social-->
			</div><!--//diaplog-->
		</div><!--//intro-->

	</section><!--//section-->
	
</div><!--//wrapper-->


<!-- Javascript -->          
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/bootstrap/js/bootstrap.min.js"></script>  
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/back-to-top.js"></script>
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/jquery-scrollTo/jquery.scrollTo.min.js"></script> 
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/imagesloaded.pkgd.min.js"></script> 
<script type="text/javascript" src="<%=path %>/personnalinfo/plugins/isotope.pkgd.min.js"></script>  

<!-- custom js -->
<script type="text/javascript" src="<%=path %>/personnalinfo/js/main.js"></script>

<!-- Style Switcher (REMOVE ON YOUR PRODUCTION SITE) -->
<script src="<%=path %>/personnalinfo/js/demo/style-switcher.js"></script>     

</body>
</html>
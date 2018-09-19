<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ page isELIgnored="false" %>  
<%@page import="java.util.Date"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();  
%>  
<%  
String path = request.getContextPath(); 
%> 

<c:set var="basePath" value="<%=basePath %>"  scope="session"/>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"/>  
<c:set var="imagesPath" value="${basePath}/img"  scope="session"/>  
<c:set var="stylesPath" value="${basePath}/css"  scope="session"/>  
<c:set var="scriptsPath" value="${basePath}/js/"  scope="session"/>  
  
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->  
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->  
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->  
<!--[if lt IE 9]>  
    <script src="${scriptsPath}/browser-compatibility-js/html5shiv.min.js?now=${timestamp}"></script>  
    <script src="${scriptsPath}/browser-compatibility-js/respond.min.js?now=${timestamp}"></script>  
<![endif]-->  
  
<!-- constants variable -->  
<script type="text/javascript">  
    var path = '${contextPath}';  
    var contextPath = '${contextPath}';  
    var image = '${imagesPath}';  
    var css = '${stylesPath}';  
    var js = '${scriptsPath}';  
</script>  
<script type="text/javascript" src="<%=path %>/js/jquery.js" charset="utf-8"></script>  

  
<span style="color:#ff6666;"><!-- 新 Bootstrap 核心 CSS 文件 -->  
<%-- <link rel="stylesheet" href="${js}/bootstrap/css/bootstrap.min.css">   --%>
<!-- 可选的Bootstrap主题文件（一般不用引入） -->  
<%-- <link rel="stylesheet" href="${js}/bootstrap/css/bootstrap-theme.min.css">   --%>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->  
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
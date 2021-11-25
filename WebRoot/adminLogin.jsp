<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" href="css/adminLogin.css">
  <body background="img/bg-img.jpg">
        <div class="header">
        <img src="logo/logo_20210916_20504.uugai.com-1631796971894.png" class="logo">
        <div class="title">子非我博客</div>
        </div>

    <div class="admin">
        <form action="adminLogin" method="post">
            管理员账号：<input type="text" name="userName"><br>
            管理员密码：<input type="password" name="password"><br><br>
            <div>${errorMessage1}</div><div>${errMessage1}</div>
            <button type="submit" style="float: right;font-size: 20px;">登录</button>
        </form>   
    </div>
             
    <%@ include file="include/footer1.jsp" %>
  </body>
</html>

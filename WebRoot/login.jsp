<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  </head>
    <link rel="stylesheet" href="css/manager.css">
    <link rel="stylesheet" href="css/index.css">
  <body background="img/bg-img.jpg">
  
  <div class="headerindex">
        <img src="logo/logo_20210916_20504.uugai.com-1631796971894.png" class="logoindex">
        <div class="title1">子非我博客</div>
  </div>
    <div class="recommend">
	博客的介绍：*******<br>
	当前用户数：*******<br>
	当前文章数：*******<br>
                <div style="font-size:20px">访客入口: <a href="visitor">浏览进入</a></div>
    </div>
        <div class="content">
       
        <form action="login" method="post">
            <br>
            <span>用 户 名&nbsp; : &nbsp;</span><br><input style="width:100%;" type="text" name="userName" ><br>
                    
            <span>登录密码：</span><br><input style="width:100%;" type="password" name="password" ><br>
            
             <span>验 证 码&nbsp; : &nbsp;</span><br>
             <input style="width:100%;" type='text' name='verifyCode' ><br><br> 
        <img src='${pageContext.request.contextPath}/VerifyCode'>
            <br><div class="confont">${errorMessage}</div><div class="confont">${errMessage}</div>

            
            <button type="submit" class="submitButton">登录</button>
            <br>
        </form>
        <br>

        <a href="register">没有账号？点击注册</a>
    </div>
     <div class="admin">
        <a href="adminLogin">[管理员入口]</a>
    </div>
    
        <%@ include file="include/footer1.jsp" %>
  </body>
</html>

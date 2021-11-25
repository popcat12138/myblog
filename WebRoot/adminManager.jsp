<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.bistu.entity.Blog" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminManager.jsp' starting page</title>
    
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

  <body background="img/bg-img.jpg">
<%@ include file="include/header.jsp" %>

    <div>
        <ul class="nav">
        	<li class="hLi"><a href="adminManager" class="a">主页面</a></li>
            <li class="hLi"><a href="logSearch" class="a">查看日志</a></li>
            <li class="hLi"><a href="listUser" class="a">管理用户</a></li>
            <li class="hLi"><a href="main" class="a">博客主页</a></li>
            
        </ul>
    </div>
        <div class="welcome">
        
    <form method="post" action="logout">
  	  欢迎！${name}<br>
  	  
  	   <button style="float: right;" type="submit">注销</button>
    </form>               
    </div>
                <div class="left">
    
            <a href="adminManager#top" class="navy">返回顶层</a>
            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  
    <div class="right">
<table style="width: 100%;">
  <tr>
    <th>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</th>
    <th style="font-size:30px">#最新文章#</th>
    <th>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</th>
  </tr>
  
   <c:forEach items="${listBlog}" var="blog">
  <tr>
    <td rowspan="2"></td>
    <td style="text-align: center; font-size: larger;"><div><a href="DisplayArticalById?blogId=${blog.blogId}&userName=${blog.userName}">《${blog.title}》</a></div></td>
    <td rowspan="2"></td>
  </tr>
<tr>
  <td rowspan="1">&nbsp; &nbsp;<p>
${blog.content}</p> 
 <br>
</td>
</tr>
<tr>
  <td></td>
  <td>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
  <div style="text-align: center; font-size: 16px; color:orange">作者：${blog.userName} &nbsp; 类型：${blog.blogType} &nbsp; 时间：${blog.createTime}</div>

  
    <hr width="70%" style="margin: auto;"></td>
  <td></td>
</tr>
 </c:forEach>

</table>  
    
<%@ include file="include/footer.jsp" %>
   </div>
     
  </body>
</html>

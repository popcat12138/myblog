<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.bistu.entity.User" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listArticle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <link rel="stylesheet" href="css/listArticle.css">
  <link rel="stylesheet" href="css/manager.css">
  <body background="img/bg-img.jpg">
    <div class="body">
<%@ include file="include/header.jsp" %>

    <div>
        <ul class="nav">
            <li class="hLi"><a href="main" class="a">博客首页</a></li>
            <li class="hLi"><a href="BlogManager" class="a">个人文章管理</a></li>
            <li class="hLi"><a href="DisplayUserDetail" class="a">个人信息管理</a></li>
            <li class="hLi"><a href="SearchArticle" class="a">搜索信息</a></li>
        </ul>
    </div>
    <br>

        <div class="left">
                    功能栏
            <br>
            
            <a href="SearchArticle" class="navy">查询文章</a><br>
            <!-- 锚标记 -->
            <a href="SearchUser" class="navy">查询用户</a><br>
            <a href="SearchUser#top" class="navy">回到顶层</a><br>
            <a href="SearchArticle#down" class="navy">到达底层</a>

    <br>
            </div>
        </div>
         

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  

    <div class="right">
        <div class="container"  style="width:100%; text-align:center;">
        
        <form action="SearchUser" method="post">
            <input name="key" style="font-size:22px" type="text" placeholder="例如：开心">
            <button class="smallButton" type="submit">按用户名/描述信息模糊查询</button>
        </form>
        <br>   

<span style="font-size:20;color:green;">${result}</span>
    <table class="userListTable">
    <tr>
  		<th style="width:15%;">头像</th>
	    <th style="width:20%;">用户名</th>
	    <th style="width:5%;">性别</th>
	    <th style="width:10%;">角色</th>
	    <th style="width:40%;">个性签名</th>
	 </tr>
    	 <c:forEach items="${listUser}" var="user">
	  <tr>
	  	<td>
	  	<div style="padding:10px;"><img src="${user.imgPath}" class="listImg" style="border:1px solid #e4e4e4;"></div>
	  	</td>
	  	<td>
	  	<span><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></span>
	  	</td>
	  	<td>
	  	<span>${user.sex}</span>
	  	</td>
	  	<td>  	
		<span>${user.isAdmin}</span>
	  	</td>
	  	<td>
	  	<span>${user.myWords}</span>
	  	</td>
	  </tr>

    	 </c:forEach>
    </table>



<%@ include file="include/footer.jsp" %>
</div>

</div>

  </body>
</html>

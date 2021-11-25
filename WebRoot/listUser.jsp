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
    
    <title>My JSP 'UserManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
th,td{
	margain:0px;
	height:35px;
	border:1px solid #c0c0c0;
}
</style>
  </head>
   <link rel="stylesheet" href="css/manager.css">
  <body background="img/bg-img.jpg">
    <!-- 修改普通用户或其他管理员的密码 -->
    <!-- 禁用登录 -->
<%@ include file="include/header.jsp" %>
   <div>
        <ul class="nav">
        	<li class="hLi"><a href="adminManager" class="a">主页面</a></li>
            <li class="hLi"><a href="logSearch" class="a">查看日志</a></li>
            <li class="hLi"><a href="listUser" class="a">管理用户</a></li>
            <li class="hLi"><a href="main" class="a">博客主页</a></li>
            
        </ul>
    </div>
    <br>
    
                <div class="left">

            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
     
        </div>  
    <div class="right">
<span style="color:red;font-size:20px;">${state}</span>
     <h1>用户列表</h1>
    <form action="" method="post">
    <table class="userListTable">
    <tr>
    	<th></th>
  		<th>用户名</th>
	    <th>用户全名</th>
	    <th>状态</th>
	    <th>角色</th>
	    <th>操作</th>
	 </tr>
	 <%int i=1;%>
    	 <c:forEach items="${list}" var="user">
	  <tr>
	  	<td>
	  	<input type="checkbox" name="user" value="${user.userName}">
	  	</td>
	  	<td>
	  	<span id="name">${user.userName}</span>
	  	</td>
	  	<td>
	  	${user.fullName}
	  	</td>
	  	<td>
	  	<input type="button" class="smallButton" id="state<%=i%>" value="${user.userState}" onclick="state('${user.userName}','state<%=i%>')">
	  	</td>
	  	<td>
	  	<input type="button" class="smallButton" id="role<%=i%>" value="${user.isAdmin}" onclick="role('${user.userName}','role<%=i%>')">
	  	</td>
	  	<td>
	  	<button class="smallButton" type="button" onclick="modifyPassword('${user.userName}')">修改密码</button>  	
	  	<a href="DisplayUserDetail?userName=${user.userName}" id="detail">详情</a>
	  	<a href="ModifyUserDetail?userName=${user.userName}" id="modify">修改常规消息</a>
	  	<a href="deleteUser?userName=${user.userName}" >删除</a>
	  	</td>
	  		 <%i=i+1;%>
	  </tr>

    	 </c:forEach>
    </table>
    <!-- 改密码弹出框 fixed-->
    <div class="modifyPassword" id="modifyPassword">     
     修改密码：<br>
     登 录 名：<input type="text" name="userName" id="userName" class="readonly" readonly>
<br>
      新 密 码：<input type="password" name="password" id="newPassword">
<br>
     <br>
     <div style="float: right;">
        <button type="button" class="smallButton" onclick="submitModify()">确定</button>
        <button type="button" class="smallButton" onclick="closeModify()">取消</button>
         </div>   
    </div>
    <br>


 
 
     <%@ include file="include/footer.jsp" %>
    </div>
        <script src="js/register.js">
    </script>
            <script src="js/jquery-1.12.4.js"></script>
      	<script src="js/listUser.js"></script>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displayUser.jsp' starting page</title>
    
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
  <link rel="stylesheet" href="css/blogManager.css">
  <body background="img/bg-img.jpg">
<%@ include file="include/header.jsp" %>
      <div>
        <ul class="nav">
            <li class="hLi"><a href="main" class="a">博客首页</a></li>
            <li class="hLi"><a href="BlogManager" class="a">个人文章管理</a></li>
            <li class="hLi"><a href="DisplayUserDetail" class="a">个人信息管理</a></li>
             <li class="hLi"><a href="SearchArticle" class="a">搜索信息</a></li>
        </ul>
    </div> 
            <div class="left">
            功能栏
            <br>
    <a href="DisplayUserDetail" class="navy">个人信息</a><br>
    
    <a href="AlterUserDetail" class="navy">信息修改</a><br>
    
    <a href="AlterPassword" class="navy">修改密码</a><br>
    <br>       
    <a href="DisplayUserDetail#top" class="navy">返回顶层</a>
            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  
     
     
     <div class="right1" >
<!--user.getUserName()--->
<span style="color:red;font-size:20px;">${state}</span>
<table class="tableShow">
  <tr>
    <td> 头像 ：</td>
    <td class="tdShow"><img src="${user.imgPath}" class="img" style="border:1px solid #e4e4e4"></td>
  </tr>
  <tr>
    <td> 用 户 名 ：</td>
    <td class="tdShow">${user.userName}</td>
  </tr>
  <tr>
    <td>用户全称：</td>
    <td class="tdShow">${user.fullName}</td>   
  </tr>
    <tr>
    <td>用户身份：</td>
    <td class="tdShow">${user.isAdmin}</td>   
  </tr>
    <tr>
      <td> 性 &nbsp; &nbsp; &nbsp; 别：</td>
      <td class="tdShow">${user.sex}</td>
      
      </tr>

    <tr>
      <td>出生日期：</td>
      <td class="tdShow">${user.birthday}</td>
    </tr>
    <tr>
        <td>微&nbsp;信&nbsp;号 ：</td>
        <td class="tdShow"> ${user.weiXin}</td>   
    </tr>

  <tr>
  <td>电子邮箱：</td>
  <td class="tdShow">${user.email}</td>
  
  </tr>
  <tr>
    <td>电话号码：</td>
    <td class="tdShow">${user.tel}</td>
  </tr>
  <tr>
    <td>个人签名：</td>
    <td class="tdShow">${user.myWords}</td>   
  </tr>
  <tr>
    <td>注册日期：</td>
    <td class="tdShow">${user.createTime}</td>   
  </tr>
    <tr>
    <td>修改日期：</td>
    <td class="tdShow">${user.alterTime}</td>   
  </tr>
</table>

     </div>
           <%@ include file="include/footer1.jsp" %>
  </body>
</html>

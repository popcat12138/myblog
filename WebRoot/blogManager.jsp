<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.bistu.entity.Blog" %>
<%@page import="cn.edu.bistu.entity.BlogType" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'blogManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
table,th,td{
	margain:0px;
	height:35px;
	border:1px solid #c0c0c0;
}
</style>
  </head>
  <link rel="stylesheet" href="css/manager.css">

<script src="js/blogManager.js"></script>
  <body background="img/bg-img.jpg">
<%@ include file="include/header.jsp" %>

    <div>
        <ul class="nav" >
            <li class="hLi"><a href="main" class="a">博客首页</a></li>
            <li class="hLi"><a href="BlogManager" class="a">个人文章管理</a></li>
            <li class="hLi"><a href="DisplayUserDetail" class="a">个人信息管理</a></li>
            <li class="hLi"><a href="SearchArticle" class="a">搜索信息</a></li>
        </ul>
    </div>
    <div class="left">
                  <br><br><br>
            <a href="addBlog" class="navy">发布文章</a><br>
            <!-- 锚标记 -->
            <a href="BlogManager" class="navy">添加分类</a><br>
            
            <a href="BlogManager#top" class="navy">回到顶层</a>

    <br>
           <div class="dropdown" class="navy">
            <button class="dropbtn">选择分类操作</button>
            <div class="dropdown-content">
            <a href="BlogManager?blogtype=">全部文章</a>
            <c:forEach items="${listType}" var="blogType">
            
            <a href="BlogManager?blogtype=${blogType.blogType}">${blogType.blogType}</a>
            
            </c:forEach>  

    </div>
     </div>
     </div>
    <div class="right">
 <span style="font-size:30px;color:red;">${warning}</span>   
        <form action="addBlogType" method="post">
          <span style="font-size:20px;color:red;">添加文章类型 :</span>
          <input type="text" name="blogtype" style="font-size:22px">
         <button type="submit" class="smallButton">确认添加</button>
        </form>
        <span style="color:red;font-size:20px;">${state}</span>
        
     <div>
        
    <div id="showBlog">
    <h1>博客列表</h1>
    <button type="button" class="bigButton" onclick="showType()">管理文章类型</button>
    <table width="100%">
        
    <tr>
  		<th width="30%">标题</th>
	    <th width="10%">文章类型</th>
	    <th>创作时间</th>
	    <th>修改时间</th>
	    <th>操作</th>
	 </tr>
    	 <c:forEach items="${listBlog}" var="blog">
	  <tr>
	  	<td>
	  	<span><a class="listShow" href="DisplayArticalById?blogId=${blog.blogId}">《${blog.title}》</a></span>
	  	</td>
	  	<td>
	   <a class="listShow" href="ListBlogByType?blogtype=${blog.blogType}">${blog.blogType}</a>
	  	</td>
	  	<td>
	  	${blog.createTime}
	  	</td>
	  	<td>
		${blog.alterTime}
	  	</td>
	  	<td>  	
  <a href="AlterArtical?blogId=${blog.blogId}">修改文章</a> 
  <a href="DeleteBlog?blogId=${blog.blogId}">删除文章</a>
	  	</td>
	  </tr>

    	 </c:forEach>
    </table>
    </div>
    
 <!--       ***            ***           ****                 -->   
    <div id="showType" class="blogtype">
    <h1>博客类型列表</h1>
    <button type="button" class="bigButton" onclick="showBlog()">管理文章类型</button>
    <table width="100%">
    <tr>
  		<th width="20%">类型名称</th>
	    <th>修改文章类型</th>
	    <th>删除文章类型</th>
	 </tr>
    	 <c:forEach items="${listType}" var="blogType">
	  <tr>
	  	<td>
	  	<span><a class="listShow" href="ListBlogByType?blogtype=${blogType.blogType}">${blogType.blogType}</a></span>
	  	</td>
	  	<td>
	   	<form action="AlterBlogType" method="post">
	   	<input type="text" name="blogtype" value="${blogType.blogType}" style="display:none;">
	   	<input type="text" name="newBlogtype" value="${blogType.blogType}">
	  	<button type="submit">修改类型名称</button>
	   	
	   	</form>
	  
	  	</td>

	  	<td>
  <a href="DeleteBlogType?blogType=${blogType.blogType}" class="listShow">删除类型</a>
	  	</td>
	  </tr>

    	 </c:forEach>
    </table>
    </div>
    
 <!--       ***            ***           ****                 -->      
    
    <div>${WarnMessage}</div>

      
       
        
        </div>
  
        
         <%@ include file="include/footer.jsp" %>
    </div>

  
    
    <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>        

    </div>

  </body>
</html>

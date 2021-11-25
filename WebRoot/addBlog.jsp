<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'addBlog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  .content{
        position: absolute;
        left: 15%;
        top: 30%;
        width: 70%;
        height:800px;
}
.editor{
       margin: 0%; 
    }
  </style>
  	<script src="tools/ckeditor/ckeditor.js"></script>
	<script src="tools/ckeditor/samples/js/sample.js"></script>
		<script src="js/ArticalCheck.js"></script>
	 <script src="js/jquery-1.12.4.js"></script>
	<link rel="stylesheet" href="css/manager.css">
  <body background="img/bg-img.jpg">
  <div class="body">
<%@ include file="include/header.jsp" %>
   <div>
        <ul class="nav">
            <li class="hLi"><a href="main" class="a">博客首页</a></li>
            <li class="hLi"><a href="BlogManager" class="a">个人文章管理</a></li>
            <li class="hLi"><a href="DisplayUserDetail" class="a">个人信息管理</a></li>
            <li class="hLi"><a href="ListArticle" class="a">搜索信息</a></li>
        </ul>
    </div>
    <br>
    <div class="titlee"><img src="img/addBlog.png" style="height:85px"></div>
        <form action="addBlog" class="content" method="post" onsubmit="return Blogcheck()">
        <br><br>
            <div style="text-align:center">
                题目:
                <input type="text" name="title" id="title" class="addBlogTitle">
                <br>
            </div>
            <br>
            <div style="text-align:center">
                类别:<select name="blogtype" id="" class="addBlogTitle">
             	 <c:forEach items="${list}" var="blogType">       
                
                  <option value="${blogType.blogType}">${blogType.blogType}</option>
    
                 </c:forEach>       
         </select>
                <br>
            </div><br>
            内容:
            <textarea name="content" id="editor" class="editor">
    
            
            </textarea>
            <br><span id="msg" style="color:red;font-size:26px;"></span><br>
            <button type="submit" class="bigButton">提交</button>
            
            
                <%@ include file="include/footer.jsp" %>
        </form>
    <script>
        initSample();
    </script>
    
    

    </div>
           
  </body>
</html>

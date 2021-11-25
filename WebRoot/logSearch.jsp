<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.bistu.entity.Log" %>
<%@page import="cn.edu.bistu.entity.OperLog" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logSearch.jsp' starting page</title>
    
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
  <script src="js/LogSearch.js"></script>
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
    <br>

                <div class="left">
            最近文章
            <a href="#wefw" class="navy">博客分类</a>
            <a href="#top" class="navy">返回顶层</a>
            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  
    <div class="right">
      
   
   <!-- 操作日志查询 -->
   <div id="showOperLog">
   <button onclick="showLog()" type="button" class="bigButton">显示登录日志</button>
   <br>
        <div class="container"  style="width:100%; text-align:center;">
        
        <form action="LogSearchByOper" method="post">
            <input name="userName" style="font-size:22px" type="text" placeholder="Search">
            <button class="smallButton" type="submit">执行操作人查询 </button>
        </form>
        <br>
         <form action="LogSearchByUname" method="post">
            <input name="userName" style="font-size:22px" type="text" placeholder="Search">
            <button class="smallButton" type="submit">按操作对象查询</button>
        </form>
        </div>
   
       <table class="userListTable">
    <tr>
  		<th>操作人</th>
	    <th>操作对象</th>
	    <th>详情</th>
	    <th>时间</th>
	 </tr>
	 <%int i=1;%>
    	 <c:forEach items="${operlist}" var="operlog">
	  <tr>
	  	<td>
	  	<span>${operlog.operator}</span>
	  	</td>
	  	<td>
	  	${operlog.userName}
	  	</td>
	  	<td>
	  	${operlog.logContent}
	  	</td>
	  	<td style="font-size:15px">
	  	${operlog.createTime}
	  	</td>
	  </tr>

    	 </c:forEach>
    </table>
   </div>
   
   
   <!-- 登录日志查询 -->
   <div id="showLog" style="display:none;">
   <button type="button" class="bigButton" onclick="showOperLog()">显示操作日志</button>
   <br><br>
          <table class="userListTable">
    <tr>
  		<th>用户名</th>
	    <th>登录/注册</th>
	    <th>时间</th>
	 </tr>
    	 <c:forEach items="${loglist}" var="log">
	  <tr>
	  	<td>
	  	<span>${log.userName}</span>
	  	</td>
	  	<td>
	  	${log.logContent}
	  	</td>
	  	<td style="font-size:15px">
	  	${log.createTime}
	  	</td>
	  </tr>

    	 </c:forEach>
    </table>
   </div>
   

        <%@ include file="include/footer.jsp" %>
    </div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <!-- 用不到的页面 -->
    This is my JSP page. <br>
    <div>success! 1秒后跳转主页</div>
    <br>
    
    <div>${user.userName}</div>
    <div>${user.email}</div>
    <div>${user.password}</div>
    <div>${user.fullName}</div>
    <div>${user.myWords}</div>
    <div>${user.tel}</div>
    <div>${user.birthday}</div>
    <div>${user.email}</div>
    <div>${user.password}</div>
    <div>${blog.userName}</div>
    <div>${blog.title}</div>
    <div>${blog.content}</div>
    
    <script type="text/javascript">
    

onload=function(){ 
setInterval(go, 1000); 
}; 
var x=1; //利用了全局变量来执行 
function go(){ 
x--; 
if(x>0){ 
document.getElementById("sp").innerHTML=x; //每次设置的x的值都不一样了。 
}else{ 
location.href='${pageContext.request.contextPath}/main'; 
} 
} 

    </script>
    
    
    
        <%@ include file="include/footer.jsp" %>
  </body>
</html>

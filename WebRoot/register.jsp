<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	    <link rel="stylesheet" href="css/register.css">
        <script src="js/jquery-1.12.4.js"></script>
  </head>
  
  <body background="img/bg-img.jpg">
        <div class="header">
        <img src="logo/logo_20210916_20504.uugai.com-1631796971894.png" class="logo">
        <div class="title">子非我博客</div>
        </div>

    <div  class="content">
    <br><br>
    <form action="register" class="formm" method="POST" id="form1" enctype="multipart/form-data" onsubmit="return checkform()">
       头 &nbsp; 像：<input type="file" name="img" id="img"><br>     
        登 录 名：<input type="text" name="userName" id="userName">
        <span id="msg_userId"></span><br>
        用户姓名：<input type="text"  name="fullName" id="fullName">
        <span id="msg_userName"></span><br>
        性 &nbsp; 别：<input type="text" name="sex" id="sex">
        <span id="msg_sex"></span><br>
        出生日期：<input type="text" placeholder="2000/01/01" name="birthday" id="birthday">
        <span id="msg_birth"></span><br>
        电话号码：<input type="tel" name="tel" id="tel">
        <span id="telError"></span><br>
        电子邮箱：<input type="email" name="email" id="email">
        <span id="emailError"></span><br>
        微 信 号：<input type="text" name="weiXin" id="weiXin">
        <span id="weiXinError"></span><br>
        个性签名：<textarea rows="3" cols="21" name="myWords" id="myWords" style="vertical-align:top"></textarea>
        <!-- input type="text" name="myWords" id="myWords"> -->
        <span id="myWordsError"></span><br>
        用户密码：<input type="password" name="password" id="password">
        <span id="msg_password"></span><br>
        重复密码：<input type="password" name="re-password" id="re-password">
        <span id="msg_re-password"></span><br>
     <!--     验 证 码：<input type='text' name='verifyCode'><br><img src='${pageContext.request.contextPath}/VerifyCode'><br>    

        <span id="errMsg" class="display"></span>
        <br>${errMsg}<br>
        
      -->
      ${error}
        <div style="float: right;"><button type="reset">重  置</button>
            <button type="submit" >提交注册</button></div>
    </form>
    <br><br>
    <div><a href="index.jsp">返回首页</a></div>
    


    </div>
       
       <%@ include file="include/footer1.jsp" %>
       

       
       
    <script src="js/register.js">
 

    </script>
      	<script>
  		$(function(){
  			$("#userName").blur(
  			
				function(){
					$.ajax({ 
		   				type : "POST", 
						contentType : "application/json", 
		    			url : "existUser?userName=" + $(this).val(), 
		    			dataType : 'json', 
		    			success : function(result) { 
		    				if (result.success)
		        				$("#userName").next().html("用户已经存在");
		        			else
		        			 	$("#userName").next().html("");
		    			}
		    			
					});
			});
  			
  		});
  	</script>
  </body>
</html>

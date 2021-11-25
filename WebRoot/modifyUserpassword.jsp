<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

<script src="js/jquery-1.12.4.js"></script>
   <link rel="stylesheet" href="css/manager.css">
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
    <br>
                <div class="left">
                            功能栏
            <br>
    <a href="DisplayUserDetail" class="navy">个人信息</a><br>
    
    <a href="AlterUserDetail" class="navy">信息修改</a><br>
    
    <a href="AlterPassword" class="navy">修改密码</a><br>
    <br>       
    <a href="AlterPassword#top" class="navy">返回顶层</a>
            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  
    <div class="right">
              <form action="AlterPassword" class="formm" method="POST" id="form1" onsubmit="return checkform()">
     修改常规信息：<br>
     登 录 名：<input type="text" name="userName" id="userName" class="readonly" readonly value="${user.userName}">
     <span id="msg_userId"></span><br>
     旧 密 码：<input type="password" name="oldPassword" id="oldPassword"">
     <span id="msg_oldpassword"></span><br>
      新 密 码：<input type="password" name="password" id="password">
     <span id="msg_password"></span><br>
      重复密码：<input type="password" name="re-password" id="re-password">
     <span id="msg_re-password"></span><br>
     ${error}
     <span id="errMsg" class="display"></span>
     <br><br>
     <div style="float: right;"><button type="reset">重  置</button>
        <input type="submit" value="提交">
         </div>
     </form>
   </div>
           <%@ include file="include/footer1.jsp" %>
           
         
      	<script>
  		$(function(){
  			$("#oldPassword").blur(
  			
				function(){
					$.ajax({ 
		   				type : "POST", 
						contentType : "application/json", 
		    			url : "VerifyPassword?Oldpassword=" + $(this).val(), 
		    			dataType : 'json', 
		    			success : function(result) { 
		    				if (result.success)
		        				$("#oldPassword").next().html("密码正确");
		        			else			 	
		        			 	$("#oldPassword").next().html("密码错误，请重新输入！");
		    			}
		    			
					});
			});
  			
  		});
  	</script>
  	<script>
  	function checkform() {
  	    $("#msg_re-password").html("");
  	    $("#msg_password").html("");
  	        if($("#password").val()=="") {
            $("#msg_password").html("用户密码不能为空");
            $("#msg_password").addClass("error");
            $("#password").focus();
            return false;
            }
            if ($("#password").val().length <8) {
                $("#msg_password").html("密码需大于八位");
                $("#msg_password").addClass("error");
                $("#password").focus();
                return false;
            }
            if($("#re-password").val()!=$("#password").val()) {
            $("#msg_re-password").html("密码不一致");
            $("#msg_re-password").addClass("error");
            $("#re-password").focus();
            return false;
            }
  	}
  	</script>
  	
  </body>
</html>

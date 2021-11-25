<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyUser.jsp' starting page</title>
    
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
<script src="js/jquery-1.12.4.js"></script>
<script src="js/register.js"></script>
 
  <body background="img/bg-img.jpg">
<%@ include file="include/header.jsp" %>
   <div>
        <ul class="nav">
            <li class="hLi"><a href="main" class="a">博客首页</a></li>
            <li class="hLi"><a href="blogManager" class="a">管理文章</a></li>
            <li class="hLi"><a href="DisplayUser" class="a">个人信息</a></li>
            <li class="hLi"><a href="adminManager" class="a">查看评论</a></li>
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
    <a href="AlterUserDetail#top" class="navy">返回顶层</a>
            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  
    <div class="right">
              <form action="ModifyUserDetail" class="formm" method="POST" id="form1" onsubmit="return checkform()" enctype="multipart/form-data">
     修改常规信息：<br>
              <input type="text" name="imgPath" style="display:none;" value="${user.imgPath}">
      头 &nbsp; 像：<input type="file" name="img" id="img"><br> 
         <input type="text" name="userName" style="display:none;" value="${user.userName}">
     登 录 名：<input type="text" name="newName" id="userName"  value="${user.userName}">
     <span id="msg_userId"></span><br>
     用户姓名：<input type="text" name="fullName" id="fullName" value="${user.fullName}">
     <span id="msg_userName"></span><br>
     性 &nbsp; 别：<input type="text" name="sex" id="sex" value="${user.sex}">
     <span id="msg_sex"></span><br>
     出生日期：<input type="text" name="birthday" id="birthday" value="${user.birthday}">
     <span id="msg_birth"></span><br>
     电话号码：<input type="tel" name="tel" id="tel" value="${user.tel}">
     <span id="telError"></span><br>
     电子邮箱：<input type="email" name="email" id="email" value="${user.email}">
     <span id="emailError"></span><br>
     微 信 号：<input type="text" name="weiXin" id="weiXin" value="${user.weiXin}">
     <span id="weiXinError"></span><br>
     个性签名：<textarea rows="3" cols="21" name="myWords" id="myWords" style="vertical-align:top">${user.myWords}</textarea>
   
     <span id="myWordsError"></span><br>
<br>

     <span id="errMsg" class="display"></span>
     <br><br>
     <div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<button class="smallButton" type="reset">重  置</button>
       &nbsp; &nbsp; <input type="submit" class="smallButton" value="提交">
         </div>
     </form>
         <%@ include file="include/footer.jsp" %>
   </div>
   
   
   
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

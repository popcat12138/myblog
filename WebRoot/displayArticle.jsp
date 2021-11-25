<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.bistu.entity.Comment" %>
<%@page import="cn.edu.bistu.service.CommentService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displayArticle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.showT{
border: #FFAEB9 solid 1px;

}

</style>

  </head>
<script src="js/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="css/manager.css">

<script src="js/reply.js"></script>
  <body background="img/bg-img.jpg">
    <!-- 修改密码（需要原密码）其他信息 -->
<%@ include file="include/header.jsp" %>
   <div>
        <ul class="nav">
            <li class="hLi"><a href="main" class="a">博客首页</a></li>
            <li class="hLi"><a href="BlogManager" class="a">个人文章管理</a></li>
            <li class="hLi"><a href="DisplayUserDetail" class="a">个人信息管理</a></li>
            <li class="hLi"><a href="SearchArticle" class="a">搜索信息</a></li>
        </ul>
    </div>
    <!-- 弹出的回复框 使用fixed -->
    <div class="replyDiv" id="replyDiv">
    <form method="post" action="Reply" onsubmit="return checkReply()">
<div class="replySet">
    回复：<span id="where"></span>楼 <span id="who"></span>
    <input type="text" style="display:none;" name="userNameB" id="userNameB" readonly class="readonly"><br>
    <input type="text" style="display:none;" name="parentId" id="parentId" readonly class="readonly"><br>
    <input name="blogId" readonly style="display:none;" class="readonly" value="${blog.blogId}">
</div>
<div class="replySetB">
    <textarea style="font-size:18px; width:90%; height:55%;" rows="6" cols="45" id="reply" name="reply"></textarea>
    <br><br>
    <button type="submit" class="smallButton">确定</button> &nbsp; <button type="button" class="smallButton" onclick="closeReply()">取消</button>
</div>
    </form>  
    <span id="warning" style="color:red;font-size:20px;"></span>
    </div>   
    <br>

                <div class="left">
    		<br>
            <a href="DisplayArticalById${top}#down" class="navy">到达底层</a>
            <br>
            <a href="DisplayArticalById${top}#top" class="navy">返回顶层</a>
            <br><br>
            <button id="closeC" style="display:none;text-align:center;width: 100%;"  type="button" onclick="closeCommentDetail()" class="smallButton">关闭评论详情</button>
            
        </div>      

        <div class="person">
    <div class="Imgdiv"><img src="${user.imgPath}" class="leftImg" style="border:1px solid #e4e4e4"></div> <br>
    <div class="Namediv"><a class="NameA" href="DisplayUserDetail?userName=${user.userName}">${user.userName}</a></div> <br>
    <div class="Rolediv">${user.isAdmin}</div> <br>
    <div class="Wordsdiv">${user.myWords}</div><br>

    <a href="ListArticle?userName=${user.userName}" class="Zonediv">他的博客</a>
        </div>  
<div class="right">
<h2 class="atitle">${blog.title}</h2>
<br><br><br>
<div style="text-align:center;"> 作者：${blog.userName} &nbsp; &nbsp; &nbsp; 类型：${blog.blogType} <br>发表时间：${blog.createTime}（修改时间：${blog.alterTime}）<br></div>
<br>
<div>
${blog.content}
</div>
<br><br><br>
<div> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <button id="showC" type="button" onclick="showCommentDetail()" class="smallButton">查看评论</button></div><br>
<hr width="100%" color="#D4D4D4"><br>
<div id="commentDetail" style="display:none;">
<div>
发表评论吧！<br>
<form method="post" action="Comment" onsubmit="return checkComment()">
<input name="blogId" style="display:none;" value="${blog.blogId}">
<input name="userNameB" style="display:none;" value="${blog.userName}">
<textarea  style="font-size:18px;" rows="8" cols="50" id="comment" name="content"></textarea><br>
&nbsp; &nbsp; &nbsp; <button type="submit" class="smallButton">提交</button>
&nbsp; &nbsp;<button type="reset" class="smallButton">重置</button>
</form>
<span id="warn" style="color:red;font-size:20px;"></span>
<br><hr>
</div>
<%int c=1;%>
<%		
		CommentService commentService = new CommentService();
		List<Comment> CommentList =(List<Comment>)request.getAttribute("commentList");
		String role=(String)request.getAttribute("role");
		for(Comment comment:CommentList){
%>
<!-- 这个是单篇文章下的楼层 -->
<div class="showT"><br>
<span class="commentFloor">#<%=c%>楼</span>
<span class="commentName"><%=comment.getUserName()%></span>&nbsp; &nbsp; &nbsp;
<span class="commentTime">
<%=comment.getCreateTime()%></span>
<br>

<div class="commentContent">
<%if(comment.getState().equals("正常")&&role.equals("user")){%>
<%=comment.getContent()%>
<%}if(role.equals("admin")){ %>
<%=comment.getContent()%><br>
状态：<input type="button" value="<%=comment.getState()%>" id="comment<%=comment.getCommentId()%>" onclick="commentManager('<%=comment.getCommentId()%>')">
<%}%>
<br>
<span class="temmp">*</span>
<button class="smallButton" style="float:right;" onclick="reply('<%=comment.getCommentId()%>','<%=comment.getUserName()%>','<%=c%>')">回复</button>
</div>
<br>
<%int r=1;%>
<%		
		List<Comment> replyList = commentService.findReplyByCommentId(comment.getCommentId());
		for(Comment reply:replyList){
 %>
 <!-- 这个是评论下的楼层 -->
 <span class="replyFloor">#<%=r%></span>
 <span class="replyName"><%=reply.getUserName()%></span>回复 
 <span class="replyNameB"><%=reply.getUserNameB()%></span>
 <span class="commentTime"><%=reply.getCreateTime()%></span>
<div class="replyContent">
<%if(reply.getState().equals("正常")&&role.equals("user")){%>
<%=reply.getContent()%> <br>
<%}if(role.equals("admin")){%>
<%=reply.getContent()%><br>
状态：<input type="button" value="<%=reply.getState()%>" id="comment<%=reply.getCommentId()%>" onclick="commentManager('<%=reply.getCommentId()%>')">
<%}%>
<span class="temmp">*</span>
<button class="smallButton" style="float:right;" onclick="reply('<%=comment.getCommentId()%>','<%=reply.getUserName()%>',<%=c%>)">回复</button>
</div>
<%r=r+1;%>
<%} %>
</div>
<hr width="70%" color="#FFB6C1">
<%c=c+1;%>
<%}%>


</div>

         <%@ include file="include/footer.jsp" %>
    </div>
    </body>
</html>

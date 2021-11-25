function reply(commentId,userNameB,floor){
	
	var replyDiv=document.getElementById("replyDiv");
	replyDiv.style.display="block";
	$("#parentId").val(commentId);
	$("#userNameB").val(userNameB);
	$("#where").html(floor);
	$("#who").html(userNameB);

}

function closeReply(){
	var replyDiv=document.getElementById("replyDiv");
	replyDiv.style.display="none";	
}


//检查回复不能为空
function checkReply(){
	$("#warning").html("");
	if($("#reply").val()==""){
		$("#warning").html("回复不能为空！");
		$("#reply").focus();
		return false;
	}
}

//检查评论不能为空
function checkComment(){
	$("#warn").html("");
	if($("#comment").val()==""){
		$("#warn").html("评论不能为空！");
		$("#comment").focus();
		return false;
	}
}

function closeReply(){
	var replyDiv=document.getElementById("replyDiv");
	replyDiv.style.display="none";	
}


function showCommentDetail(){
	var showDetail=document.getElementById("commentDetail");
	var showC=document.getElementById("showC");
	var closeC=document.getElementById("closeC");
	showDetail.style.display="block";
	showC.style.display="none";
	closeC.style.display="block";
}

function closeCommentDetail(){
	var showDetail=document.getElementById("commentDetail");
	var closeC=document.getElementById("showC");
	var closeC=document.getElementById("closeC");
	showDetail.style.display="none";
	showC.style.display="block";
	closeC.style.display="none";
}
//管理评论
function commentManager(id){

		$.get(
		"Comment",
		{commentId:id},
			
	function(result){
	
	if(result.success=="trueA"){
		$("#"+"comment"+id).val("禁用");
	}if(result.success=="trueB"){
		$("#"+"comment"+id).val("正常");
	}if(result.success=="false"){
		alert("错误！");
	}						
})}

















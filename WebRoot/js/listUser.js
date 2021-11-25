 function modifyPassword(userName){

	var modifyDiv=document.getElementById("modifyPassword");
	modifyDiv.style.display="block";
	$("#userName").val(userName);

}

 function closeModify(){
	 var modifyDiv=document.getElementById("modifyPassword");
		modifyDiv.style.display="none";	
	}
 
 function submitModify(){
	 var modifyDiv=document.getElementById("modifyPassword");
			$.ajax({ 
	   				type : "POST", 
					contentType : "application/json", 
	    			url : "ModifyPassword?userName=" + $("#userName").val()+"&password="+$("#newPassword").val(), 
	    			dataType : 'json', 
	    			success : function(result) { 
	    				if (result.success){
	    					modifyDiv.style.display="none";
	    					alert("修改成功");
	    				}
	        			else
	        			 	alert("修改失败");
	    			}
	    			
				});;
		};
 
		
		


      	
      	
  		function state(userName,state){

  			$.get(
  			"BanLogin",
  			{userName:userName},
					
			function(result){
			
			if(result.success=="trueA"){
			
			$("#"+state).val("禁用");
			}
			
			else if(result.success=="trueB"){
			
			$("#"+state).val("启用");
			}
			
			else if(result.success=="falseSelf"){
						
			alert("不能禁用管理员自己！");
			
			}						
			else{
			alert("未知错误！")
			}})}
			
		
			function role(userName,role){

  			$.get(
  			"ModifyRole",
  			{userName:userName},
					
			function(result){
			
			if(result.success=="trueA"){
			
			$("#"+role).val("普通用户");
			}
			
			else if(result.success=="trueB"){
			
			$("#"+role).val("管理员");
			}
			
			else if(result.success=="falseSelf"){
						
			alert("不能操作管理员自己！");
			
			}						
			else{
			alert("未知错误！")
			}})}	
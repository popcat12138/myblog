function Blogcheck() {
    $("#msg").html("");
    
    if ($("#title").val()=="") {
        $("#msg").html("文章标题不能为空");
        $("#title").focus();
        return false;
    }
    
    if ($("#title").val().length>50) {
        $("#msg").html("文章标题大于50！");
        $("#title").focus();
        return false;
    }   
    
    
}
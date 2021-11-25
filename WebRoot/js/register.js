function checkform() {
    $("#msg_userId").html("");
    $("#msg_userName").html("");
    $("#msg_password").html("");
    $("#msg_birth").html("");
    $("#msg_sex").html("");
    $("#msg_birth").html("");
    $("#telError").html("");
    $("#emailError").html("");
    $("#weiXinError").html("");
    $("#myWordsError").html("");
    $("#msg_re-password").html("");


        if ($("#userName").val()=="") {
            $("#msg_userId").html("登录名不能为空");
            $("#msg_userId").addClass("error");
            $("#userName").focus();
            return false;
        }
         if ($("#userName").val().length>10) {
                $("#msg_userId").html("登录名须小于十位");
                $("#msg_userId").addClass("error");
                $("#userName").focus();
                return false;
        }
            if ($("#fullName").val()== "") {
            $("#msg_userName").html("姓名不能为空") ;
            $("#msg_userName").addClass("error");
            $("#fullName").focus();
            return false;
            }
            if ($("#fullName").val().length >10) {
                $("#msg_userName").html("昵称需小于十位");
                $("#msg_userName").addClass("error");
                $("#fullName").focus();
                return false;
            }
            if($("#sex").val()!="男" && $("#sex").val()!="女") {
            $("#msg_sex").html("性别只能是男或女");
            $("#msg_sex").addClass("error");
            $("#sex").focus();
            return false;
            }
            var d=Date.parse($("#birthday").val());
            if(isNaN(parseInt(d))) {
            $("#msg_birth").html("出生日期格式不正确");
            $("#msg_birth").addClass("error");
            $("#birthday").focus();
            return false;
            }
            var nowy=(new Date()).getFullYear();
            var birthy=(new Date(d)).getFullYear();
            if(nowy-birthy<10) {
            $("#msg_birth").html("年龄小于十岁");
            $("#msg_birth").addClass("error");
            $("#birthday").focus();
            return false;
            }
            if (isNaN(parseInt($("#tel").val()))) {
                $("#telError").html("电话必须都是数字");
                $("#telError").addClass =("error");
                $("#tel").focus();
                return false;
            }
            if ($("#tel").val().length!=11) {
                $("#telError").html("请输入11位号码");
                $("#telError").addClass =("error");
                $("#tel").focus();
                return false;
            }
            if ($("#email").val()=="") {
                $("#emailError").html("电子邮箱不能为空或格式错误！");
                $("#emailError").addClass =("error");
                $("#email").focus();
                return false;
            }
            if($("#weiXin").val()=="") {
            $("#weiXinError").html("微信号不能为空");
            $("#weiXinError").addClass("error");
            $("#weiXin").focus();
            return false;
            }
            if($("#myWords").val()=="") {
            $("#myWordsError").html("签名不能为空");
            $("#myWordsError").addClass("error");
            $("#myWords").focus();
            return false;
            }
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
$(document).ready(function(){
    $("input").blur(function(){
        $(this).removeClass("alertcolor")
        $(this).addClass("normalcolor")
    });
    $("input").focus(function(){
        $(this).removeClass("normalcolor")
        $(this).addClass("alertcolor")
    });
});
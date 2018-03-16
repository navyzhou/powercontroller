<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatiable" content="IE=edge">
<link type="image/icon" rel="shortcut icon" href="images/yc.png"/>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function adminLogin(){
	var aid=$.trim($("#aid").val());
	var pwd=$.trim($("#pwd").val());
	
	$.post("adminLogin",{aid:aid,pwd:pwd},function(data){
		if(data.aid!=null && data!=""){
			location.href="back/loginOk";
		}else{
			alert("账号或密码错误...");
		}
	},"json");
}
</script>
</head>
<body>
<form action="" id="myform">
账号：<input type="text" id="aid">
密码：<input type="password" id="pwd">
<input type="button" value="登录" onclick="adminLogin()">
</form>
</body>
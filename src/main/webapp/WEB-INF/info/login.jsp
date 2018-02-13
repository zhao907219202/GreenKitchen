<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<script type='text/javascript' language="javascript">
	function checkValue(){
		var num1=document.login.name.value;
		var num2=document.login.password.value;
		var num3=document.login.checkcode.value;
		if(num1==""){
			window.alert("用户名不能为空");
			return false;
		}
		else if(num2==""){
			window.alert("用户密码不能为空");
			return false;
		}
		else if(num3==""){
			window.alert("验证码不能为空");
			return false;
		}
	}
	</script> 
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/public/common.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />
	
	 <div class="main_login" style="height:400px;width:1000px;margin:0 auto;background-color: #F8F8F8">
		 <img src="/GreenKitchen/images/info/loginPic.jpg" style="height:300px;width:400px;float:left;margin-left:100px;margin-top: 50px;"  />
	 
   	 	 <div style="margin-right:100px;margin-top:70px;float:right;width:300px">
		    <h3>用户登录</h3>
		    <form action="/GreenKitchen/info/login.action" method="post" name="login">
		    <table style="line-height:40px;height:230px;">
		    	<tr><td>用户名：</td><td><input type="text" name="name" style="width:140px;"/></td><td></td></tr>
		    	<tr><td>密码：</td><td><input type="password" name="password" style="width:140px;"/></td><td></td></tr>
		    	<tr><td style="width:100px;">验证码：</td><td><input type="text" name="checkcode" style="width:140px;"/></td><td><img src='/GreenKitchen/CreateCode'></td></tr>
		    	<tr><td style="text-align: center"><input type="submit" onclick="return checkValue()" value="登录"/></td><td style="text-align: center"><input type="reset" value="重新填写"/></td><td></td></tr>
		    	<tr><td colspan="3" style="text-align: center"><font style="color:red;">
		    	<c:if test="${!empty info}">${info}</c:if>
		    	</font></td></tr>
		    	<tr><td colspan="3" style="text-align: right"><a href="/GreenKitchen/info/goRegisterUi.action">注册新用户</a></td></tr>
	     	 </table>
	   		 </form>
    	 </div>
     </div>
	
	
	
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

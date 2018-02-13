<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<script type='text/javascript' language="javascript">
	function checkValue(){
		var num1=document.register.password.value;
		var num2=document.register.password1.value;
		var num3=document.register.username.value;
		var sex=document.register.sex;
		var num4=document.register.description.value;
		if(num1!=num2){window.alert("密码输入不一致");return false;}
		if(num1==""||num3==""){window.alert("用户名和密码不能为空");return false;}
		if(sex[0].checked==false&&sex[1].checked==false){window.alert("请选择性别");return false;}
		if(num4==""){window.alert("请填写自我描述");return false;}
	}
	</script> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public/common.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />
	
	 <div class="main_register" style="height:500px;width:1000px;margin:0 auto;background-color:#F8F8F8">
		
		<div style="margin-left:300px;margin-top: 50px;float:left;width:600px">
	    <h3>用户注册</h3>
	    <form action="${pageContext.request.contextPath}/info/update.action" method="post" name="register" >
	    <table style="line-height:50px">
	    	<tr><td>用户名：</td><td><input style="width:300px;height:25px;" type="text" name="username" readonly="readonly" value="${loginuser.username }"/></td><td width="150px"></td></tr>
	    	<tr><td>密码：</td><td><input  style="width:300px;height:25px;" type="password" name="password"  value="${loginuser.password }"/></td></tr>
	    	<tr><td>确认密码:</td><td><input style="width:300px;height:25px;" type="password" name="password1" value="${loginuser.password}"/></td></tr>
	    	<tr><td>性别：</td><td>
	    			<c:if test="${loginuser.sex eq '男'}">
	    			<input type="radio" name="sex"  value="男" checked='true'/>男　　
	    			<input type="radio" name="sex"  value="女"/>女
	    			</c:if>
	    			<c:if test="${loginuser.sex eq '女'}">
	    			<input type="radio" name="sex"  value="男" />男　　
	    			<input type="radio" name="sex"  value="女" checked='true'/>女
	    			</c:if>
	    	</td></tr>
	    	<tr><td>自我描述：</td><td><input style="width:300px;height:25px;" type="text" name="description" value="${loginuser.description }"/></td><td></td></tr>
	    	<tr><td>　　</td></tr>
	    	<tr><td  colspan="2" style="text-align: center"><input name="submit" type="submit" value="确认修改" onclick="return checkValue()"/></td><td></td></tr>
	    	</table>
	    </form> 
	    </div> 

	 </div>

   	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

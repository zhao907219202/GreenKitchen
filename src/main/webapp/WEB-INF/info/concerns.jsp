<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="../../css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="../../css/info/userIndex.css" />
	<script type="text/javascript" src="/js/jquery-1.3.1.js" ></script>
	<script type="text/javascript" src="/js/ajax/ajax_concern.js" ></script>
</head>

<body onload="judgeHasConcerned()">
	<jsp:include page="/WEB-INF/public/head.jsp" />
	<input type="hidden" id="hasConcerned" value="${hasConcerned}"/>
	<input type="hidden" id="user_id" value="${user.id}"/>
	
	<div class="main_index">
		<div style="width:1000px;height:30px;">
			<div style="float:right;margin-right: 20px;">
			<span class="font7">${loginuser.username},欢迎您！　　</span> 
			<a href="/issue/goIssueUi.action"><font class="font15">菜谱发布</font></a>　　
			<a href="/info/goUpdateUi.action"><font class="font15">信息修改</font></a>　　
			<a href="/info/logout.action"><font class="font15">退出登录</font></a>
			</div>
		</div>
		<div class="introduction">
			<c:if test="${user.sex eq '男' }"><img src="../../images/info/nan.jpg" class="headPic"/></c:if>
			<c:if test="${user.sex eq '女' }"><img src="../../images/info/nv.jpg"  class="headPic"/></c:if>
			<div class="user_info">
				<br/>
				<span><font class="font5">${user.username }</font></span>
				<c:if test="${user.sex eq '男' }"><img src="../../images/recipe/male.jpg" class="user_sex"/></c:if>
				<c:if test="${user.sex eq '女' }"><img src="../../images/recipe/female.jpg"  class="user_sex"/></c:if>
				<br /><br/>
				<div class="user_description"><font class="font14">${user.description}</font></div>
			</div>
			
			<div class="user_table">
				<table style="text-align: center">
					<tr style="line-height: 25px;">
						<td style="width:66px;"><a href="/info/goConcerns.action?user_id=${user.id}"><font class="font16">${concernNum}</font></a><br/><font class="font17">关注</font></td>
						<td style="width:66px;"><a href="/info/goFans.action?user_id=${user.id}"><font class="font16">${fansNum}</font></a><br/><font class="font17">粉丝</font></td>
						<td style="width:66px;"><a href="/info/goUserIndex.action?user_id=${user.id}"><font class="font16">${recipeNum}</font></a><br/><font class="font17">菜谱</font></td>
					</tr>
				</table>
			</div>
			
			<div class="user_button">
				<input id="doConcern" onclick="doConcern()" type="image" src="../../images/info/concernButton.jpg" style="width:70px;height:30px;float:left;margin-left: 30px;" />
				<input id="cancelConcern" onclick="cancelConcern()" type="image" src="../../images/info/cancelconcern.jpg" style="width:70px;height:30px;float:left;margin-left: 30px;" />
			</div>
			
			<div class="user_nav">
				<table style="text-align: center">
					<tr style="line-height: 25px;">
						<td style="width:130px;"><a href="/info/goUserIndex.action?user_id=${user.id}"><font class="font13">菜谱</font></a></td>
						<td style="width:130px;"><a href="/info/goUserCollected.action?user_id=${user.id}"><font class="font13">收藏</font></a></td>
						<td style="width:130px;"><a href="/info/goUserMessage.action?user_id=${user.id}"><font class="font13">留言</font></a></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="list">
			<div class="title"><font class="font14">${user.username} ${title}</font></div>
			<table class="list_table">
				<c:forEach items="${concerns}" var="concernee" varStatus="status">
					<tr style="height:35px;">
						<td style="width:50px;text-align: center;"><font class="font18">${status.count}</td>
						<td style="width:650px;"><a href="/info/goUserIndex.action?user_id=${concernee.id}">
						<font class="font16">${concernee.username}</font></a></td>
						<td><font class="font18">${concernee.fansnum}粉丝</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="pages">
			<c:if test="${pageNow!=1}"><a href="/info/goConcerns.action?user_id=${user.id}&pageTo=${pageNow-1}">上一页</a></c:if>
			<c:forEach begin="1" end="${pageCount}" var="i" step="1">
			<a href="/info/goConcerns.action?user_id=${user.id}&pageTo=${i}">${i}</a>
			</c:forEach>
			<c:if test="${pageNow!=pageCount}"><a href="/info/goConcerns.action?user_id=${user.id}&pageTo=${pageNow+1}">下一页</a></c:if>
		 	<font>　　当前页　${pageNow }/${pageCount }</font>
	   </div>
	
		
	
	</div>
		
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/info/userIndex.css" />
	<script type="text/javascript" src="/GreenKitchen/js/jquery-1.3.1.js" ></script>
	<script type="text/javascript" src="/GreenKitchen/js/ajax/ajax_concern.js" ></script>
</head>

<body onload="judgeHasConcerned()">
	<jsp:include page="/WEB-INF/public/head.jsp" />
	<input type="hidden" id="hasConcerned" value="${hasConcerned}"/>
	<input type="hidden" id="user_id" value="${user.id}"/>
	
	<div class="main_index">
		<div style="width:1000px;height:30px;">
			<div style="float:right;margin-right: 20px;">
			<span class="font7">${loginuser.username},欢迎您！　　</span>
			<a href="/GreenKitchen/issue/goIssueUi.action"><font class="font15">菜谱发布</font></a>　　 
			<a href="/GreenKitchen/info/goUpdateUi.action"><font class="font15">信息修改</font></a>　　  
			<a href="/GreenKitchen/info/logout.action"><font class="font15">退出登录</font></a>
			</div>
		</div>
		<div class="introduction">
			<c:if test="${user.sex eq '男' }"><img src="/GreenKitchen/images/info/nan.jpg" class="headPic"/></c:if>
			<c:if test="${user.sex eq '女' }"><img src="/GreenKitchen/images/info/nv.jpg"  class="headPic"/></c:if>
			<div class="user_info">
				<br/>
				<span><font class="font5">${user.username }</font></span>
				<c:if test="${user.sex eq '男' }"><img src="/GreenKitchen/images/recipe/male.jpg" class="user_sex"/></c:if>
				<c:if test="${user.sex eq '女' }"><img src="/GreenKitchen/images/recipe/female.jpg"  class="user_sex"/></c:if>
				<br /><br/>
				<div class="user_description"><font class="font14">${user.description}</font></div>
			</div>
			
			<div class="user_table">
				<table style="text-align: center">
					<tr style="line-height: 25px;">
						<td style="width:66px;"><a href="/GreenKitchen/info/goConcerns.action?user_id=${user.id}"><font class="font16">${concernNum}</font></a><br/><font class="font17">关注</font></td>
						<td style="width:66px;"><a href="/GreenKitchen/info/goFans.action?user_id=${user.id}"><font class="font16">${fansNum}</font></a><br/><font class="font17">粉丝</font></td>
						<td style="width:66px;"><a href="/GreenKitchen/info/goUserIndex.action?user_id=${user.id}"><font class="font16">${recipeNum}</font></a><br/><font class="font17">菜谱</font></td>
					</tr>
				</table>
			</div>
			
			<div class="user_button">
				<input id="doConcern" onclick="doConcern()" type="image" src="/GreenKitchen/images/info/concernButton.jpg" style="width:70px;height:30px;float:left;margin-left: 30px;" />	
				<input id="cancelConcern" onclick="cancelConcern()" type="image" src="/GreenKitchen/images/info/cancelconcern.jpg" style="width:70px;height:30px;float:left;margin-left: 30px;" />
			</div>
			
			<div class="user_nav">
				<table style="text-align: center">
					<tr style="line-height: 25px;">
						<td style="width:130px;"><a href="/GreenKitchen/info/goUserIndex.action?user_id=${user.id}"><font class="font13">菜谱</font></a></td>
						<td style="width:130px;"><a href="/GreenKitchen/info/goUserCollected.action?user_id=${user.id}"><font class="font13">收藏</font></a></td>
						<td style="width:130px;"><a href="/GreenKitchen/info/goUserMessage.action?user_id=${user.id}"><font class="font13">留言</font></a></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="recipes">
			<span class="title">${user.username} 收藏的菜谱</span>
			<div class="repeatee">
				<c:forEach items="${recipes}" var="recipe">
					<div class="element">
						<a href="/GreenKitchen/recipe/goRecipeDetail.action?recipe_id=${recipe.id}">
							<img style="width:221px;height:221px"
							src="/pic/recipe/${recipe.id}.jpg" />
							<div class="font2" style="margin-top: 5px">${recipe.title}</div>
						</a>
						<div class="font3" style="margin-top: 5px">
							<span style="color:gray">　${recipe.collectednum }　收藏</span>
							<span style="color:gray">　${recipe.commentednum }　评论</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="pages">
			<c:if test="${pageNow!=1}"><a href="/GreenKitchen/info/goUserCollected.action?user_id=${user.id}&pageTo=${pageNow-1}">上一页</a></c:if>
			<c:forEach begin="1" end="${pageCount}" var="i" step="1">
			<a href="/GreenKitchen/info/goUserCollected.action?user_id=${user.id}&pageTo=${i}">${i}</a>
			</c:forEach>
			<c:if test="${pageNow!=pageCount}"><a href="/GreenKitchen/info/goUserCollected.action?user_id=${user.id}&pageTo=${pageNow+1}">下一页</a></c:if>
		 	<font>　　当前页　${pageNow }/${pageCount }</font>
	   </div>
		
	
	</div>
	
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/rank/rankIndex.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />
	
	<div class="main_rank">
		<div class="hot_recipe_list">
			<div class="title"><font class="font14">热门菜谱榜</font> 
		 		<a href="/GreenKitchen/rank/goRankDetail.action?title_id=1" style="float:right;margin-right: 20px;"><font class="font16">更多>></font></a>
			</div>
			<table class="list_table">
				<c:forEach items="${recipes}" var="recipe" varStatus="status">
					<tr style="height:35px;">
						<c:if test="${status.count<=3}">
						<td style="color: red;font-weight: bold;font-size:14px;">${status.count}</td>
						</c:if>
						<c:if test="${status.count>3}">
						<td><font class="font18">${status.count}</td>
						</c:if>
						<td style="width:215px;"><a href="/GreenKitchen/recipe/goRecipeDetail.action?recipe_id=${recipe.id}"><font class="font16">${recipe.title}</font></a></td>
						<td><font class="font18">${recipe.collectednum}收藏</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="hot_user_list">
			<div class="title"><font class="font14">热门用户榜</font> 
		 		<a href="/GreenKitchen/rank/goRankUserDetail.action" style="float:right;margin-right: 20px;"><font class="font16">更多>></font></a>
			</div>
			<table class="list_table">
				<c:forEach items="${users}" var="user" varStatus="status">
					<tr style="height:35px;">
						<c:if test="${status.count<=3}">
						<td style="color: red;font-weight: bold;font-size:14px;">${status.count}</td>
						</c:if>
						<c:if test="${status.count>3}">
						<td><font class="font18">${status.count}</td>
						</c:if>
						<td style="width:215px;"><a href="/GreenKitchen/info/goUserIndex.action?user_id=${user.id }"><font class="font16">${user.username}</font></a></td>
						<td><font class="font18">${user.fansnum}粉丝</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
		<div class="hot_slim_list">
			<div class="title"><font class="font14">美容减肥榜</font> 
		 		<a href="/GreenKitchen/rank/goRankDetail.action?title_id=2" style="float:right;margin-right: 20px;"><font class="font16">更多>></font></a>
			</div>
			<table class="list_table">
				<c:forEach items="${slim_dishes}" var="recipe" varStatus="status">
					<tr style="height:35px;">
						<c:if test="${status.count<=3}">
						<td style="color: red;font-weight: bold;font-size:14px;">${status.count}</td>
						</c:if>
						<c:if test="${status.count>3}">
						<td><font class="font18">${status.count}</td>
						</c:if>
						<td style="width:215px;"><a href="/GreenKitchen/recipe/goRecipeDetail.action?recipe_id=${recipe.id}"><font class="font16">${recipe.title}</font></a></td>
						<td><font class="font18">${recipe.collectednum}收藏</font></td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
		
		<div class="hot_child_list">
			<div class="title"><font class="font14">儿童食谱榜</font> 
		 		<a href="/GreenKitchen/rank/goRankDetail.action?title_id=3" style="float:right;margin-right: 20px;"><font class="font16">更多>></font></a>
			</div>
			<table class="list_table">
				<c:forEach items="${child_dishes}" var="recipe" varStatus="status">
					<tr style="height:35px;">
						<c:if test="${status.count<=3}">
						<td style="color: red;font-weight: bold;font-size:14px;">${status.count}</td>
						</c:if>
						<c:if test="${status.count>3}">
						<td><font class="font18">${status.count}</td>
						</c:if>
						<td style="width:215px;"><a href="/GreenKitchen/recipe/goRecipeDetail.action?recipe_id=${recipe.id}"><font class="font16">${recipe.title}</font></a></td>
						<td><font class="font18">${recipe.collectednum}收藏</font></td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	
	</div>
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

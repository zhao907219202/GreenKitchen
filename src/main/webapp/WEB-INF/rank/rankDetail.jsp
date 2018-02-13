<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rank/rankDetail.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />
	
	<div class="main_detail">
		
		<div class="list">
			<div class="title"><font class="font14">${title}</font></div>
			<table class="list_table">
				<c:forEach items="${recipes}" var="recipe" varStatus="status">
					<tr style="height:35px;">
						<c:if test="${status.count<=3}">
						<td style="color: red;font-weight: bold;font-size:14px;width:50px;text-align: center;">${status.count}</td>
						</c:if>
						<c:if test="${status.count>3}">
						<td style="width:50px;text-align: center;"><font class="font18">${status.count}</td>
						</c:if>
						<td style="width:650px;"><a href="${pageContext.request.contextPath}/recipe/goRecipeDetail.action?recipe_id=${recipe.id}">
						<font class="font16">${recipe.title}</font></a>
						<span style="color:gray;font-size: 12px;">by</span>
						<a href="${pageContext.request.contextPath}/info/goUserIndex.action?user_id=${recipe.user.id}"><font class="font3">${recipe.user.username}</font></a></td>
						<td><font class="font18">${recipe.collectednum}收藏</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
			
		<div class="pages">
			<c:if test="${pageNow!=1}"><a href="${pageContext.request.contextPath}/rank/goRankDetail.action?pageTo=${pageNow-1}&title_id=${title_id}">上一页</a></c:if>
			<c:forEach begin="${(pageNow-2)>1?(pageNow-2):1}" end="${(pageNow+2)<pageCount?(pageNow+2):pageCount}" var="i" step="1">
			<a href="${pageContext.request.contextPath}/rank/goRankDetail.action?pageTo=${i}&title_id=${title_id}">${i}</a>
			</c:forEach>
			<c:if test="${pageNow!=pageCount}"><a href="${pageContext.request.contextPath}/rank/goRankDetail.action?pageTo=${pageNow+1}&title_id=${title_id}">下一页</a></c:if>
		 	<font>　　当前页　${pageNow }/${pageCount }</font>
	   </div>
		
	</div>
	
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

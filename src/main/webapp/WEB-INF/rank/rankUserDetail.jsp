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
				<c:forEach items="${users}" var="user" varStatus="status">
					<tr style="height:35px;">
						<c:if test="${status.count<=3}">
						<td style="color: red;font-weight: bold;font-size:14px;width:50px;text-align: center;">${status.count}</td>
						</c:if>
						<c:if test="${status.count>3}">
						<td style="width:50px;text-align: center;"><font class="font18">${status.count}</td>
						</c:if>
						<td style="width:650px;"><a href="${pageContext.request.contextPath}/info/goUserIndex.action?user_id=${user.id}">
						<font class="font16">${user.username}</font></a></td>
						<td><font class="font18">${user.fansnum}粉丝</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
			
		<div class="pages">
			<c:if test="${pageNow!=1}"><a href="${pageContext.request.contextPath}/rank/goRankUserDetail.action?pageTo=${pageNow-1}">上一页</a></c:if>
			<c:forEach begin="${(pageNow-2)>1?(pageNow-2):1}" end="${(pageNow+2)<pageCount?(pageNow+2):pageCount}" var="i" step="1">
			<a href="${pageContext.request.contextPath}/rank/goRankUserDetail.action?pageTo=${i}">${i}</a>
			</c:forEach>
			<c:if test="${pageNow!=pageCount}"><a href="${pageContext.request.contextPath}/rank/goRankUserDetail.action?pageTo=${pageNow+1}">下一页</a></c:if>
		 	<font>　　当前页　${pageNow }/${pageCount }</font>
	   </div>
		
	</div>
	
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

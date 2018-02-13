<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>


<title>绿色厨房</title>


<link rel="stylesheet" type="text/css" href="../../css/public/index.css" />
<link rel="stylesheet" type="text/css" href="../../css/public/common.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />
	<jsp:include page="/WEB-INF/index/images.jsp" />

	<div class="middle">
		<div class="recipes">
			<span class="recommend">每日推荐</span>
			<div class="repeatee">
				<c:forEach items="${recipes}" var="recipe">
					<div class="element">
						<a href="/recipe/goRecipeDetail.action?recipe_id=${recipe.id}">
							<img style="width:221px;height:221px"
							src="/pic/recipe/${recipe.id}.jpg" />
							<div class="font2" style="margin-top: 5px">${recipe.title}</div>
						</a>
						<div class="font3" style="margin-top: 5px">
							<span style="color:gray">by</span>
							<a href="/info/goUserIndex.action?user_id=${recipe.user.id}" class="font3">${recipe.user.username}</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="themes">
			<div class="title">
				<span class="font1"> 主题站 </span>
			</div>
			<div class="content">
				<table>
					<tr>
						<td><div class="element">
								<a href="/html/themeIndex_1.html"><img style="width:120px;height:120px"
									src="../../images/index/theme_1.jpg" />
									<div class="font4" style="margin-top: 10px">生活小窍门</div> </a>
							</div></td>
						<td><div class="element">
								<a href="/html/themeIndex_2.html"><img style="width:120px;height:120px"
									src="../../images/index/theme_2.jpg" />
									<div class="font4" style="margin-top: 10px">走到哪吃到哪</div> </a>
							</div></td>
						<td><div class="element">
								<a href="/html/themeIndex_3.html"><img style="width:120px;height:120px"
									src="../../images/index/theme_3.jpg" />
									<div class="font4" style="margin-top: 10px">食•记</div> </a>
							</div></td>
						<td><div class="element">
								<a href="/html/themeIndex_4.html"><img style="width:120px;height:120px"
									src="../../images/index/theme_4.jpg" />
									<div class="font4" style="margin-top: 10px">厨房装备研究院</div> </a>
							</div></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="list">
			<div class="title">
				<span class="font1">食神榜</span>
			</div>
			<table>
				<c:forEach items="${users}" var="user">
					<tr>
						<td style="width:120px"><a
							href="/info/goUserIndex.action?user_id=${user.id}"><font class="font">${user.username }
							</font></a></td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<div class="material">
			<div class="title">
				<span class="font1"> 时令食材 </span>
			</div>
			<table>
				<td><c:forEach items="${materials}" var="material">
						<div class="element">
							<a href="/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:70px;height:70px"
								src="/pic/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px">${material.name}</div></a>
						</div>
					</c:forEach></td>
			</table>
		</div>
	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp" />
</body>
</html>

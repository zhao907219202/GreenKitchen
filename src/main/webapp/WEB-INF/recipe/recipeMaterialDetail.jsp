<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>


<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="../../css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="../../css/recipe/recipeMaterialDetail.css" />
</head>
  
  <body>
    <div>
		<jsp:include page="/WEB-INF/public/head.jsp" />
	</div>
	
	<div class="main_detail">
		<div class="nav" style="background-color: #f8f8f8;">
			<a href="/recipe/goSelected.action"><font class="font13">精选</font></a>　　
			<a href="/recipe/goTypeIndex.action"><font class="font13">菜谱种类</font></a> 　　
			<a href="/material/goMaterialIndex.action"><font class="font13">食材分类</font></a>
		</div>
	
		<div class="introduction">
		<table>
		<tr>
			<td rowspan="5" class="picture" style="width:250px;text-align: center;">
				<img src="/pic/material/${material.pictureName}.jpg" style="height:180xp;width:180px;"/>
			</td>
			<td><font class="font5">${material.name}</font></td>
		</tr>
		<tr><td style="line-height:25px;"><font class="font17">别名：</font><font class="font18">${material.alias}</font></td></tr>
		<tr><td style="line-height:25px;"><font class="font17">热量：</font><font class="font18">${material.heat}</font></td></tr>	
		<tr><td style="line-height:25px;"><font class="font17">分类：</font>
			<a href="/material/goMaterialTypeList.action?type=${material.materialone.type}"><font class="font16">${material.materialone.type}</font></a>
			<font class="font16">,</font>
			<a href="/material/goMaterialList.action?materialone_id=${material.materialone.id}"><font class="font16">${material.materialone.name}</font></a></td>
		</tr>
		<tr><td style="line-height:25px;"><font class="font17">适宜人群：</font><font class="font18">${material.description}</font></td></tr>
		</table>
		</div>
	
		<div class="recipes">
			<span class="recommend">做法大全</span>
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
		
		<div class="pages">
			<c:if test="${pageNow!=1}"><a href="/material/goMaterialDetail.action?material_id=${material_id}&pageTo=${pageNow-1}">上一页</a></c:if>
			<c:forEach begin="1" end="${pageCount}" var="i" step="1">
			<a href="/material/goMaterialDetail.action?material_id=${material_id}&pageTo=${i}">${i}</a>
			</c:forEach>
			<c:if test="${pageNow!=pageCount}"><a href="/material/goMaterialDetail.action?material_id=${material_id}&pageTo=${pageNow+1}">下一页</a></c:if>
		 	<font>　　当前页　${pageNow }/${pageCount }</font>
	   </div>
	
	</div>
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;">
		<jsp:include page="/WEB-INF/public/foot.jsp" />
	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>


<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/recipe/recipeMaterialList.css" />
</head>
  
  <body>
    <div>
		<jsp:include page="/WEB-INF/public/head.jsp" />
	</div>
	
	<div class="main_List">
	 	<div class="nav" style="background-color: #f8f8f8;">
			<a href="/GreenKitchen/recipe/goSelected.action"><font class="font13">精选</font></a>　　
			<a href="/GreenKitchen/recipe/goTypeIndex.action"><font class="font13">菜谱种类</font></a> 　　
			<a href="/GreenKitchen/material/goMaterialIndex.action"><font class="font13">食材分类</font></a>
		</div>
		
		  <div class="type_one">
				<div class="type_title" >
					<font class="font14">${materialone.type}</font>
				</div>
				<div class="type_list">
					<div class="type_two"><a href="/GreenKitchen/material/goMaterialList.action?materialone_id=${materialtwos[0].materialone.id}"><font class="font15">${materialone.name}</font></a>
					</div> 
					<div class="elements">
					<c:forEach items="${materialtwos}" var="material">
						<div class="element">
							<a href="/GreenKitchen/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</div>
					</c:forEach>
			   	    </div>
				 </div>
			</div>
	</div>
	
	<div style="float:left;margin-top: 50px;margin-left: 400px;">
		<jsp:include page="/WEB-INF/public/foot.jsp" />
	</div>
  </body>
</html>

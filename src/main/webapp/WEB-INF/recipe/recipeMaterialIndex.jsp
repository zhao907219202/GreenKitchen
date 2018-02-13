<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>


<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css${pageContext.request.contextPath}/recipe${pageContext.request.contextPath}/recipeMaterialIndex.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public/common.css" />
</head>

<body>
	<div>
		<jsp:include page="/WEB-INF/public/head.jsp" />
	</div>

	<div class="main">
		<div class="nav" style="background-color: #f8f8f8;">
			<a href="${pageContext.request.contextPath}/recipe/goSelected.action"><font class="font13">精选</font></a>　　
			<a href="${pageContext.request.contextPath}/recipe/goTypeIndex.action"><font class="font13">菜谱种类</font></a> 　　
			<font class="font12">食材分类</font>
		</div>
		
		<div class="material_panel">
			
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=肉类"><font class="font14">肉类</font></a>
				</div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_0[0].materialone.id}"><font class="font15">猪</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_0}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_0[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_1[0].materialone.id}"><font class="font15">牛</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_1}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_2[0].materialone.id}"><font class="font15">羊</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_2}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_3[0].materialone.id}"><font class="font15">鸡</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_3}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_3[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_4[0].materialone.id}"><font class="font15">鸭</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_4}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_5[0].materialone.id}"><font class="font15">其他肉类</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_5}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    
			     <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_6[0].materialone.id}"><font class="font15">制品</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_6}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    
			    
			</div>
			
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=水果花茶坚果"><font class="font14">水果、花茶、坚果</font></a>
				</div>
			
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_7[0].materialone.id}"><font class="font15">鲜果</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_7}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_7[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_8[0].materialone.id}"><font class="font15">花</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_8}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_9[0].materialone.id}"><font class="font15">坚果干果</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_9}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_9[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			</div>
			
			
			
		
		</div>
		
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=蔬菜菌藻药食"><font class="font14">蔬菜、菌藻、药食</font></a>
				</div>
				
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_10[0].materialone.id}"><font class="font15">蔬菜类</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_10}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_10[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_11[0].materialone.id}"><font class="font15">菌藻类</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_11}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_11[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_12[0].materialone.id}"><font class="font15">药材类</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_12}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_13[0].materialone.id}"><font class="font15">酸菜腌菜</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_13}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			</div>
			
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=鱼虾蟹贝等水产"><font class="font14">鱼虾蟹贝等水产</font></a>
				</div>
				
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_14[0].materialone.id}"><font class="font15">虾</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_14}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_14[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_15[0].materialone.id}"><font class="font15">蟹</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_15}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_16[0].materialone.id}"><font class="font15">贝</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_16}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    <div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_16[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_17[0].materialone.id}"><font class="font15">鱼</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_17}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    <div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_17[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_18[0].materialone.id}"><font class="font15">其他</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_18}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    <div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_18[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			</div>
			
			
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=谷类"><font class="font14">谷类</font></a>
				</div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_19[0].materialone.id}"><font class="font15">米</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_19}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_20[0].materialone.id}"><font class="font15">面</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_20}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_20[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_21[0].materialone.id}"><font class="font15">杂粮</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_21}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_21[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_22[0].materialone.id}"><font class="font15">淀粉</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_22}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			</div>
			
			
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=豆乳蛋类及制品"><font class="font14">豆乳蛋类及制品</font></a>
				</div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_23[0].materialone.id}"><font class="font15">乳及其制品</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_23}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_24[0].materialone.id}"><font class="font15">豆及其制品</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_24}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_24[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			    
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_25[0].materialone.id}"><font class="font15">蛋及其制品</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_25}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			</div>
			
			<div class="type_one">
				<div class="type_title" >
					<a href="${pageContext.request.contextPath}/material/goMaterialTypeList.action?type=调味品"><font class="font14">调味品</font></a>
				</div>
				<div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_26[0].materialone.id}"><font class="font15">香辛料</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_26}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
					<div class="more_elements" >
					<a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_26[0].materialone.id}"><font class="font15" >更多</font></a>
					</div>
				    </div>
			    </div>
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_27[0].materialone.id}"><font class="font15">酱</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_27}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_28[0].materialone.id}"><font class="font15">油</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_28}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			    <div class="type_list">
					<div class="type_two"><a href="${pageContext.request.contextPath}/material/goMaterialList.action?materialone_id=${materialtwos_29[0].materialone.id}"><font class="font15">糖</font></a></div>
					<div class="elements">
					<c:forEach items="${materialtwos_29}" var="material">
						<span class="element">
							<a href="${pageContext.request.contextPath}/material/goMaterialDetail.action?material_id=${material.id}"><img style="width:65px;height:65px"
								src="/pic${pageContext.request.contextPath}/material/${material.pictureName }.jpg" />
								<div class="font2" style="margin-top: 5px;text-align: center;">${material.name}</div></a>
						</span>
					</c:forEach>
				    </div>
			    </div>
			</div>
			
			
		</div>
	</div>


	<div style="float:left;margin-left: 400px;margin-top: 20px;">
		<jsp:include page="/WEB-INF/public/foot.jsp" />
	</div>
</body>
</html>

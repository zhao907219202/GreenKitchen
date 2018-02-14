<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>


<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/recipe/recipeTypeIndex.css" />
	<link rel="stylesheet" type="text/css" href="/GreenKitchen/css/public/common.css" />
	<script type="text/javascript" src="/GreenKitchen/js/recipe/recipeTypeIndex.js" ></script>
</head>

<body>
	<div>
		<jsp:include page="/WEB-INF/public/head.jsp" />
	</div>

	<div class="main">
		<div class="nav" style="background-color: #f8f8f8;">
			<a href="/GreenKitchen/recipe/goSelected.action"><font class="font13">精选</font></a>　　<font class="font12">菜谱种类</font> 　　<a href="/GreenKitchen/material/goMaterialIndex.action"><font class="font13">食材分类</font></a>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">菜系</font>
			</div>
			<div class="type_body">
			<table style="width:960px">
				<c:forEach items="${styles}" var="style" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="style_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=style&value=${style}"><font class="font4">${style}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
				<tr><td colspan="8" style="width:950px;line-height: 30px;margin-right: 100px;" id="style_unfold">
					<a href="javascript:;" onclick="show_more('style_display','style')"><font style="float:right;margin-right:25px;" class="font4">↓展开更多</font>
					</a></td>
					<td colspan="8" style="width:950px;line-height: 30px;display:none;margin-right: 100px;" id="style_fold">
					<a href="javascript:;" onclick="hide_more('style_display','style')"><font style="float:right;margin-right:25px;" class="font4">↑收起</font>
					</a></td>
				</tr>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">烹饪方法</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${methods}" var="method" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="method_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=method&value=${method}"><font class="font4">${method}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
				<tr><td colspan="8" style="width:950px;line-height: 30px;margin-right: 100px;" id="method_unfold">
					<a href="javascript:;" onclick="show_more('method_display','method')"><font style="float:right;margin-right:25px;" class="font4">↓展开更多</font>
					</a></td>
					<td colspan="8" style="width:950px;line-height: 30px;display:none;margin-right: 100px;" id="method_fold">
					<a href="javascript:;" onclick="hide_more('method_display','method')"><font style="float:right;margin-right:25px;" class="font4">↑收起</font>
					</a></td>
				</tr>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">口味</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${flavors}" var="flavor" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="flavor_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=flavor&value=${flavor}"><font class="font4">${flavor}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
				<tr><td colspan="8" style="width:950px;line-height: 30px;margin-right: 100px;" id="flavor_unfold">
					<a href="javascript:;" onclick="show_more('flavor_display','flavor')"><font style="float:right;margin-right:25px;" class="font4">↓展开更多</font>
					</a></td>
					<td colspan="8" style="width:950px;line-height: 30px;display:none;margin-right: 100px;" id="flavor_fold">
					<a href="javascript:;" onclick="hide_more('flavor_display','flavor')"><font style="float:right;margin-right:25px;" class="font4">↑收起</font>
					</a></td>
				</tr>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">菜式</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${kinds}" var="kind" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="kind_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=kind&value=${kind}"><font class="font4">${kind}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
				<tr><td colspan="8" style="width:950px;line-height: 30px;margin-right: 100px;" id="kind_unfold">
					<a href="javascript:;" onclick="show_more('kind_display','kind')"><font style="float:right;margin-right:25px;" class="font4">↓展开更多</font>
					</a></td>
					<td colspan="8" style="width:950px;line-height: 30px;display:none;margin-right: 100px;" id="kind_fold">
					<a href="javascript:;" onclick="hide_more('kind_display','kind')"><font style="float:right;margin-right:25px;" class="font4">↑收起</font>
					</a></td>
				</tr>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">主食</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${stapes}" var="stape" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="stape_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=stape&value=${stape}"><font class="font4">${stape}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
				<tr><td colspan="8" style="width:950px;line-height: 30px;margin-right: 100px;" id="stape_unfold">
					<a href="javascript:;" onclick="show_more('stape_display','stape')"><font style="float:right;margin-right:25px;" class="font4">↓展开更多</font>
					</a></td>
					<td colspan="8" style="width:950px;line-height: 30px;display:none;margin-right: 100px;" id="stape_fold">
					<a href="javascript:;" onclick="hide_more('stape_display','stape')"><font style="float:right;margin-right:25px;" class="font4">↑收起</font>
					</a></td>
				</tr>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">烘焙</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${bakes}" var="bake" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="bake_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=bake&value=${bake}"><font class="font4">${bake}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">厨房工具</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${tools}" var="tool" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="tool_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=tool&value=${tool}"><font class="font4">${tool}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">场景</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${scenes}" var="scene" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="scene_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=scene&value=${scene}"><font class="font4">${scene}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">人群</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${crowds}" var="crowd" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="crowd_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=crowd&value=${crowd}"><font class="font4">${crowd}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">美容瘦身</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${slims}" var="slim" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="slim_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=slim&value=${slim}"><font class="font4">${slim}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">功效</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${effects}" var="effect" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="effect_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=effect&value=${effect}"><font class="font4">${effect}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
				<tr><td colspan="8" style="width:950px;line-height: 30px;margin-right: 100px;" id="effect_unfold">
					<a href="javascript:;" onclick="show_more('effect_display','effect')"><font style="float:right;margin-right:25px;" class="font4">↓展开更多</font>
					</a></td>
					<td colspan="8" style="width:950px;line-height: 30px;display:none;margin-right: 100px;" id="effect_fold">
					<a href="javascript:;" onclick="hide_more('effect_display','effect')"><font style="float:right;margin-right:25px;" class="font4">↑收起</font>
					</a></td>
				</tr>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">疾病料理</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${nurses}" var="nurse" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="nurse_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=nurse&value=${nurse}"><font class="font4">${nurse}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<div class="type_panel">
			<div class="type_title">
				<font class="font14">节日时令</font>
			</div>
			<div class="type_body">
			<table style="width:960px" >
				<c:forEach items="${festivals}" var="festival" varStatus="status">
					<c:if test="${ status.count == 1 || (status.count-1)%8 ==0}">
						<c:if test="${status.count<24}"><tr></c:if>
						<c:if test="${status.count>=24}"><tr id="festival_display" style="display:none;"></c:if>
					</c:if>
					<td style="line-height:25px;width:120px ">
						<a href="/GreenKitchen/recipe/goTypeDetail.action?type=festival&value=${festival}"><font class="font4">${festival}</font></a>
					</td>
					<c:if test="${status.count % 8 == 0}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
			</div>
		</div>
	
	</div>

	<div style="float:left;margin-left: 400px;margin-top: 20px;">
		<jsp:include page="/WEB-INF/public/foot.jsp" />
	</div>
</body>
</html>

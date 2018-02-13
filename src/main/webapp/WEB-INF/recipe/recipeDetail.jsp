<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/css/recipe/recipeDetail.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public/common.css" />
	<script type='text/javascript' language="javascript">
	var clicked = false;
	function submitComment(){
		if(clicked==false){
			document.comment.action="${pageContext.request.contextPath}/reply/submitComment.action";
		}
		document.comment.submit();
	}
	
	function focusComment(obj){
		document.comment.action="${pageContext.request.contextPath}/reply/submitCommentReply.action?comment_id="+obj.id;
		document.comment.recipeComment.focus();
		clicked = true;
	}
	
	</script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.1.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax/ajax_collect.js" ></script>
	
</head>

<body onload="judgeHasCollected()">
	<jsp:include page="/WEB-INF/public/head.jsp" />
	
	<div class="main">
		<div class="show">
			<img class="picture" src="/pic/recipe/${recipe.id }.jpg"/>
		</div>
		
		<div class="description">
			<div id="title" class="font5">${recipe.title}</div>
			<div id="data" class="font3">
				<span style="font-size: 28px;color:orange">${recipe.commentednum } </span>　人评论 　　
				 <span style="font-size: 28px;color:orange">${recipe.collectednum}</span>　人收藏
				 <span style="float:right;margin-right: 20px">
				 	<input type="hidden" id="recipe_id" value="${recipe.id}" />
				 	<input type="hidden" id="hasCollected" value="${hasCollected}" />
				 	<input id="doCollect" type="image" src="${pageContext.request.contextPath}/images/recipe/collectbutton.jpg"  onclick="doCollect()"/>
				 	<input id="cancelCollect" type="image" src="${pageContext.request.contextPath}/images/recipe/cancelcollect.jpg"  onclick="cancelCollect()"/>
				 </span>
			</div>
			<div id="content">
				<a href="${pageContext.request.contextPath}/info/goUserIndex.action?user_id=${recipe.user.id}"><span class="font6">${recipe.user.username}</a>
				<c:if test="${recipe.user.sex=='男'}"><img src="${pageContext.request.contextPath}/images/recipe/male.jpg"/></c:if>
				<c:if test="${recipe.user.sex=='女'}"><img src="${pageContext.request.contextPath}/images/recipe/female.jpg"/></c:if></span>
				<span style="float:right;font-size: 14px">${recipe.timestamp }</span>				
				<p style="font-size:14px;line-height:25px;">　　${recipe.description}</p>
			</div>
		</div>
		
		<div class="tip">
			<table cellpadding="0" cellspacing="0" >
				<tr><td class="left">难度：</td><td class="right">${recipe.difficulty }</td><td class="left">时间：</td><td class="right">${recipe.time}</td></tr>
			</table>
			
		</div>
		
		<div class="spice">
		 	<div class="subtitle">主料</div>
			<div class="mainspice">
				<table cellpadding="0" cellspacing="0" >
				<c:forEach items="${recipe.recipeSpices}" var="spice">
				<c:if test="${spice.ismain =='1'}">
					<td class="left">${spice.spicename }</td><td class="right">${spice.amount}</td></c:if>
				</c:forEach>
				</table>
			</div>
			<div class="subtitle">辅料</div>
			<div class="mainspice">
				<table cellpadding="0" cellspacing="0" >
				<c:forEach items="${recipe.recipeSpices}" var="spice">
				<c:if test="${spice.ismain =='0'}">
					<td class="left">${spice.spicename }</td><td class="right">${spice.amount}</td></c:if>
				</c:forEach>
				</table>
			</div>
		</div>	
		
		<div class="step">
			<div class="subtitle">${recipe.title}的做法步骤</div>
			<div class="mainstep">
				<table cellpadding="0" cellspacing="0" >
				<c:forEach items="${steps}" var="step" varStatus="i">
					<td class="left"><img src="/pic/recipe/${recipe.id}-${i.index+1}.jpg" style="display:none;width:200px;height:200px;float:left;margin-top: 10px;margin-left: 20px" onload="this.style.display=''"/></td>
					<td class="right"><p style="margin-top: 20px;float:left;line-height: 25px;">　　${i.index+1}.${step.step}</p></td>
				</c:forEach>
				</table>
			</div>
		</div>	
		
		<c:if test="${!empty recipe.note}">
		<div class="note">
			<div class="subtitle">小贴士</div>
			<div class="mainnote"><p>${recipe.note}</p></div>
		</div>	
		</c:if>
		
		<div class="type">
			<div class="subtitle">菜谱归类</div>
			<div class="maintype">
			<c:forEach items="${recipe.recipeTypes}" var="type" varStatus="i">
				<c:if test="${!empty type.style}"><span>${type.style}</span></c:if>
				<c:if test="${!empty type.method}"><span>${type.method}</span></c:if>
				<c:if test="${!empty type.flavor}"><span>${type.flavor}</span></c:if>
				<c:if test="${!empty type.kind}"><span>${type.kind}</span></c:if>
				<c:if test="${!empty type.stape}"><span>${type.stape}</span></c:if>
				<c:if test="${!empty type.bake}"><span>${type.bake}</span></c:if>
				<c:if test="${!empty type.crowd}"><span>${type.crowd}</span></c:if>
				<c:if test="${!empty type.tool}"><span>${type.tool}</span></c:if>
				<c:if test="${!empty type.scene}"><span>${type.scene}</span></c:if>
				<c:if test="${!empty type.slim}"><span>${type.slim}</span></c:if>
				<c:if test="${!empty type.effect}"><span>${type.effect}</span></c:if>
				<c:if test="${!empty type.nurse}"><span>${type.nurse}</span></c:if>
				<c:if test="${!empty type.festival}"><span>${type.festival}</span></c:if>
			</c:forEach>
			</div>
		</div>
	
		<div class="comment">
			<div class="subtitle">${recipe.title}的评论</div>
			<div class="writecomment">
				<form action="" name="comment" method="post"> 
					<input type="hidden" name="recipe_id" value="${recipe.id}"/>
					<textarea name="recipeComment" rows="8" cols="80" style="float:left;margin-left: 20px;margin-top: 10px;resize: none" >请输入评论/回复内容...</textarea>
					<br/>
					<input style="float:right;margin-left: 10px;margin-top: 10px;" type="image" src="${pageContext.request.contextPath}/images/recipe/commentbutton.jpg"  onclick="submitComment()"/>
				</form>
			</div>
			<div class="comments">
				<div style="float:left;margin-top:10px;width:600px;">
				<c:forEach items="${comments}" var="comment">
					<div style="border-bottom: 1px solid #909090;float:left;margin-top: 10px;width:600px;">
					<span><a href="${pageContext.request.contextPath}/info/goUserIndex.action?user_id=${comment.user.id}"><font class="font6">${comment.user.username }</font></a></span>
					<span><font class="font9">　　${comment.timestamp }</font></td></span>
					<span style="float:right;margin-right: 10px;"><a href="javascript:void(0)" onclick="focusComment(this)" id="${comment.id}"><font class="font9">回复</font></a></span>
					<div style="float:left;margin-bottom:5px;width:600px;"><font class="font11">　　　${comment.content}</font></div>
					
					<c:forEach items="${comment.commentreplies}" var="reply">
						<div style="float:left;margin-bottom:15px;width:600px;margin-left: 30px;">
						<span><a href="${pageContext.request.contextPath}/info/goUserIndex.action?user_id=${reply.userByWriterId.id}"><font class="font3">${reply.userByWriterId.username}　</font></a></span><span><font class="font7">回复</font></span>
						<span><a href="${pageContext.request.contextPath}/info/goUserIndex.action?user_id=${reply.userByReceiverId.id}"><font class="font3">${reply.userByReceiverId.username}</font></a></span><span><font class="font7">:</font></span>
						<span class="font7">${reply.content}</span>
						</div>
					</c:forEach>
					</div>
				</c:forEach>
				</div>
				<c:if test="${!empty comments }">
				<div class="pages" style="text-align: center;margin-top: 15px;float:left;width:600px;">
					<c:if test="${pageNow!=1}"><a href="${pageContext.request.contextPath}/recipe/goRecipeDetail.action?recipe_id=${recipe.id}&pageTo=${pageNow-1}">上一页</a></c:if>
    				<c:forEach begin="1" end="${pageCount}" var="i" step="1">
    				<a href="${pageContext.request.contextPath}/recipe/goRecipeDetail.action?recipe_id=${recipe.id}&pageTo=${i}">${i}</a>
    				</c:forEach>
    				<c:if test="${pageNow!=pageCount}"><a href="${pageContext.request.contextPath}/recipe/goRecipeDetail.action?recipe_id=${recipe.id}&pageTo=${pageNow+1}">下一页</a></c:if>
   				 	<font>　　当前页　${pageNow }/${pageCount }</font>
   			   </div>
   			   </c:if>
			</div>
		</div>
	</div>
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>

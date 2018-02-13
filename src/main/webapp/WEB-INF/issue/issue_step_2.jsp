<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>绿色厨房</title>
	<link rel="stylesheet" type="text/css" href="../../css/public/common.css" />
	<link rel="stylesheet" type="text/css" href="../../css/issue/issue_step_2.css" />
	<script type="text/javascript" src="/js/jquery-1.3.1.js" ></script>
	<script type="text/javascript" src="/js/issue/issue_step_2.js" ></script>
</head>

<body>
	<jsp:include page="/WEB-INF/public/head.jsp" />

	<div class="main_body">
		<div class="title">
			<font class="font8">创建菜谱(Step 2)</font>
			<font class="font7">从现在起，不做孤独的美食家。</font>
		</div>
		<form action="/issue/stepTwo.action" onsubmit="findStepNum()" method="post" enctype="multipart/form-data" name="issue_step_2">
			<input type="hidden" name="stepNum" id="stepNum"/>
			<input type="hidden" name="recipe_id" value="${recipe_id}"/>
			<div class="main_spice">
				<table style="line-height:30px;">
					<tr>
						<td style="width:180px"><font class="font17">主料</font></td>
						<td style="width:50px;"><font class="font17">用量</font></td>
					</tr>
					<c:forEach begin="1" end="6" varStatus="i">
					<tr>
						<td><input name="main_spice_${i.count}" style="width:160px;height:25px;"/></td>
						<td><input name="main_amount_${i.count}" style="width:80px;height:25px;"/></td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="assist_spice">
				<table style="line-height:30px;">
					<tr>
						<td style="width:180px"><font class="font17">辅料</font></td>
						<td style="width:50px;"><font class="font17">用量</font></td>
					</tr>
					<c:forEach begin="1" end="6" varStatus="i">
					<tr>
						<td><input name="assist_spice_${i.count}" style="width:160px;height:25px;"/></td>
						<td><input name="assist_amount_${i.count}" style="width:80px;height:25px;"/></td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="recipe_step">
				<table id="step_table">
					<tr>
					<td style="width:150px">
					<img id="origin_1"  onclick="imgClick(this)" src="../../images/issue/issue_step.jpg" style="width:140px;height:90px;"/>
					<img id="preview_1" style="width:140px;height:90px;display:none"/>
					<input type="file" name="files" style="display:none" id="upload_1" onchange="imgPreview(this)"/>
					</td>
					<td><textarea name="step_content_1" rows="6" cols="60" style="resize: none;"></textarea></td>
					</tr>
					
					<tr>
					<td style="width:150px">
					<img id="origin_2"  onclick="imgClick(this)" src="../../images/issue/issue_step.jpg" style="width:140px;height:90px;"/>
					<img id="preview_2" style="width:140px;height:90px;display:none"/>
					<input type="file" name="files" style="display:none" id="upload_2" onchange="imgPreview(this)"/>
					</td>
					<td><textarea name="step_content_2" rows="6" cols="60" style="resize: none;"></textarea></td>
					</tr>
					
					<tr>
					<td style="width:150px">
					<img id="origin_3"  onclick="imgClick(this)" src="../../images/issue/issue_step.jpg" style="width:140px;height:90px;"/>
					<img id="preview_3" style="width:140px;height:90px;display:none"/>
					<input type="file" name="files" style="display:none" id="upload_3" onchange="imgPreview(this)"/>
					</td>
					<td><textarea name="step_content_3" rows="6" cols="60" style="resize: none;"></textarea></td>
					</tr>
				</table>
				<a href="javascript:void(0)" onclick="addOneRow(this)" id="3" style="float:right;margin-top: 5px;"><font class="font3">添加一步</font></a>
			</div>
			
			<div class="recipe_note">
				<font class="font17">小贴士</font>
				<textarea name="note"  rows="6" cols="80" style="margin-left: 15px;margin-top: 15px;resize: none;"></textarea>
			</div>
			<div class="recipe_label">
				<font class="font17">添加标签(多个标签用空格隔开)</font>
				<input name="label" type="text" style="width:580px;height:40px;margin-top:10px;margin-left: 15px;"/>
			</div>
			<div class="submit_button">
					<input type="submit" value="点击发布菜谱" style="width:200px;height:40px;" onclick="return checkValue()"/>
			</div>
		</form>
	</div>
	
	
	<div style="float:left;margin-left: 400px;margin-top: 20px;"><jsp:include page="/WEB-INF/public/foot.jsp" /></div>
</body>
</html>
